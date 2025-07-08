package br.uema.project.project.service;


import br.uema.project.project.entity.Staff;
import br.uema.project.project.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    @Autowired
    private StaffRepository staffRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(String name, String email, String role, String rawPassword) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setEmail(email);
        staff.setRole(role);
        staff.setPasswordHash(passwordEncoder.encode(rawPassword));
        staff.setActive(true);
        staff.setCreatedAt(LocalDateTime.now());
        staff.setUpdatedAt(LocalDateTime.now());

        repository.save(staff);
    }

    public Optional<Staff> login(String email, String rawPassword) {
        Optional<Staff> staffOpt = repository.findByEmail(email);

        if (staffOpt.isPresent()) {
            Staff staff = staffOpt.get();
            if (passwordEncoder.matches(rawPassword, staff.getPasswordHash())) {
                return Optional.of(staff);
            }
        }

        return Optional.empty(); // Ou lançar uma exceção se preferir
    }

    public ResponseEntity<String> isCataloger(Staff staff)
    {
        if(this.login(staff.getEmail(), staff.getPasswordHash()).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email e/ou senha inválido(os)!");
        }

        if(!Objects.equals(staff.getRole(), "Cataloger"))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("É necessário um Cataloger para realizar o registro!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("O usuário é um cataloger");
    }

    public ResponseEntity<String> isLibrarian(Staff staff)
    {

        if(this.login(staff.getEmail(), staff.getPasswordHash()).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email e/ou senha inválido(os)!");
        }

        if(!Objects.equals(staff.getRole(), "Librarian"))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("É necessário um Librarian para realizar o registro!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("O usuário é um Librarian");


    }

}
