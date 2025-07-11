package br.uema.project.project.api;

import br.uema.project.project.api.request.staff.StaffCreateRequest;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Staff staff) {
        Optional<Staff> logged = service.login(staff.getEmail(), staff.getPasswordHash());

        return logged.isPresent()
                ? ResponseEntity.ok(logged.get())
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StaffCreateRequest request) {
        Staff newStaff = request.getNewStaff();
        Staff adminStaff = request.getAdminStaff();

        if (adminStaff == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados do administrador são obrigatórios.");
        }

        if (!service.hasRole(adminStaff.getEmail(), adminStaff.getPasswordHash(), "Administrador")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Apenas administradores podem cadastrar funcionários.");
        }

        return service.register(newStaff);
    }
}
