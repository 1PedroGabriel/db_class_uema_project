package br.uema.project.project.repository;

import br.uema.project.project.entity.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

}
