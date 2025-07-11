package br.uema.project.project.repository;

import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

    @Query(value = """
    SELECT bc.*
    FROM book_copies bc
    JOIN books b ON bc.book_id = b.id
    WHERE (:categoryId IS NULL OR b.category_id = :categoryId)
      AND (:author IS NULL OR LOWER(b.authors) LIKE LOWER(CONCAT('%', :author, '%')))
      AND (:year IS NULL OR b.publication_year = :year)
      AND (:minPages IS NULL OR b.pages >= :minPages)
      AND (:maxPages IS NULL OR b.pages <= :maxPages)
      AND (:shelfLocation IS NULL OR LOWER(bc.shelf_location) LIKE LOWER(CONCAT('%', :shelfLocation, '%')))
      AND (:status IS NULL OR bc.status = :status)
      AND (:copyCode IS NULL OR LOWER(bc.copy_code) LIKE LOWER(CONCAT('%', :copyCode, '%')))
    """, nativeQuery = true)
    List<BookCopy> findByFilters(
            @Param("categoryId") Long categoryId,
            @Param("author") String author,
            @Param("year") Integer year,
            @Param("minPages") Integer minPages,
            @Param("maxPages") Integer maxPages,
            @Param("shelfLocation") String shelfLocation,
            @Param("status") BookCopy.BookCopyStatus status,
            @Param("copyCode") String copyCode
    );

}
