package br.uema.project.project.repository;

import br.uema.project.project.entity.BookCopy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE BookCopy b SET b.status = :status, b.shelfLocation = :shelfLocation, b.updatedAt = CURRENT_TIMESTAMP WHERE b.id = :id")
    void updateFields(
            @Param("id") Long id,
            @Param("status") BookCopy.BookCopyStatus status,
            @Param("shelfLocation") String shelfLocation
    );

}
