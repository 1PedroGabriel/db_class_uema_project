package br.uema.project.project.repository;

import br.uema.project.project.entity.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

    @Procedure(procedureName = "add_book_copy")
    void addBookCopy(
            @Param("p_book_id") Long bookId,
            @Param("p_copy_code") String copyCode,
            @Param("p_shelf_location") String shelfLocation,
            @Param("p_status") String status,
            @Param("p_acquisition_date") LocalDate acquisitionDate,
            @Param("p_condition_notes") String conditionNotes
    );
}
