package br.uema.project.project.service;

import br.uema.project.project.dto.book.AuthorDTO;
import br.uema.project.project.entity.Book;
import br.uema.project.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> listAllBooks()
    {
        return repository.findAll();
    }

    public List<AuthorDTO> listAllAuthors() { return repository.findAllAuthors(); }

    public ResponseEntity<String> addNewBook(Book newBook)
    {
        try {
            repository.save(newBook);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível adicionar o pois a requisição não foi bem feita!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Livro adicionado com sucesso");

    }
}
