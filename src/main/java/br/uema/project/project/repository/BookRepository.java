package br.uema.project.project.repository;

import br.uema.project.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
