package br.uema.project.project.api;

import br.uema.project.project.api.request.staff.StaffCreateRequest;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.repository.StaffRepository;
import br.uema.project.project.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    @Autowired
    private StaffRepository repository;

    @GetMapping("/login")
    public Optional<Staff> login(@RequestBody Staff staff)
    {
        return service.login(staff.getEmail(), staff.getPasswordHash());
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StaffCreateRequest request)
    {
        Staff new_staff = request.getNewStaff();
        Staff admin_staff = request.getAdminStaff();

        Optional<Staff> staff = this.login(admin_staff);
        if(staff.isPresent() && Objects.equals(staff.get().getRole(), "Admin")) {

            if(repository.findByEmail(new_staff.getEmail()).isPresent())
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe!");
            }

            service.register(new_staff.getName(), new_staff.getEmail(), new_staff.getRole(), new_staff.getPasswordHash());

            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais Inválidas!");
    }

}
