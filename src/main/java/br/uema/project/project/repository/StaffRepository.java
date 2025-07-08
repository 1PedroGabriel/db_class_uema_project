package br.uema.project.project.repository;


import br.uema.project.project.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    public Optional<Staff> findByEmail(String email);
}
