package br.uema.project.project.service;

import br.uema.project.project.entity.Staff;
import br.uema.project.project.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<String> register(Staff staff) {
        if (repository.findByEmail(staff.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Funcionário já cadastrado!");
        }

        staff.setPasswordHash(passwordEncoder.encode(staff.getPasswordHash()));
        staff.setActive(true);
        staff.setCreatedAt(LocalDateTime.now());
        staff.setUpdatedAt(LocalDateTime.now());

        repository.save(staff);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }

    public Optional<Staff> login(String institutionalEmail, String rawPassword) {
        Optional<Staff> staffOpt = repository.findByEmail(institutionalEmail);

        if (staffOpt.isPresent()) {
            Staff staff = staffOpt.get();
            if (passwordEncoder.matches(rawPassword, staff.getPasswordHash())) {
                return Optional.of(staff);
            }
        }
        return Optional.empty();
    }

    public boolean hasRole(String email, String password, String expectedRole) {
        Optional<Staff> staff = login(email, password);
        return staff.map(s -> expectedRole.equalsIgnoreCase(s.getRole())).orElse(false);
    }

    public ResponseEntity<String> isLibrarian(Staff staff) {
        return hasRole(staff.getEmail(), staff.getPasswordHash(), "Librarian")
                ? ResponseEntity.ok("Usuário autorizado como Bibliotecário.")
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado: função necessária 'Bibliotecário'.");
    }

    public ResponseEntity<String> isCataloger(Staff staff) {
        return hasRole(staff.getEmail(), staff.getPasswordHash(), "Cataloger")
                ? ResponseEntity.ok("Usuário autorizado como Catalogador.")
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado: função necessária 'Catalogador'.");
    }
}
