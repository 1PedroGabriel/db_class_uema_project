package br.uema.project.project.repository;

import br.uema.project.project.dto.book.AuthorDTO;
import br.uema.project.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.id, b.authors FROM Book b")
    List<AuthorDTO> findAllAuthors();

    // Lista os livros que não estão com quantidade disponivel.
    @Query("SELECT b FROM Book b WHERE b.availableQuantity = 0")
    List<Book> listAllOutOfStock();

    @Query("SELECT b FROM Book b WHERE "
            + "(:categoryId IS NULL OR b.categoryId = :categoryId) AND "
            + "(:author IS NULL OR LOWER(b.authors) LIKE LOWER(CONCAT('%', :author, '%'))) AND "
            + "(:year IS NULL OR b.publicationYear = :year) AND "
            + "(:minPages IS NULL OR b.pages >= :minPages) AND "
            + "(:maxPages IS NULL OR b.pages <= :maxPages) AND "
            + "(:available IS NULL OR (:available = TRUE AND b.availableQuantity > 0))")
    List<Book> findByFilters(
            @Param("categoryId") Long categoryId,
            @Param("author") String author,
            @Param("year") Integer year,
            @Param("minPages") Integer minPages,
            @Param("maxPages") Integer maxPages,
            @Param("available") Boolean available
    );

}
