package br.uema.project.project.repository;

import br.uema.project.project.dto.book.AuthorDTO;
import br.uema.project.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.id, b.authors FROM Book b")
    List<AuthorDTO> findAllAuthors();
}
