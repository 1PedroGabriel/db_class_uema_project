package br.uema.project.project.service;

import br.uema.project.project.dto.book.AuthorDTO;
import br.uema.project.project.entity.Book;
import br.uema.project.project.repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> listAllBooks()
    {
        return repository.findAll();
    }

    public List<Book> listAllOutOfStockBooks()
    {
        return repository.listAllOutOfStock();
    }
    public List<AuthorDTO> listAllAuthors() { return repository.findAllAuthors(); }

    public List<Book> filterBooks(Long categoryId,
                                  String author,
                                  Integer year,
                                  Integer minPages,
                                  Integer maxPages,
                                  Boolean available)
    {
        return repository.findByFilters(categoryId, author, year, minPages, maxPages, available);
    }

    public ResponseEntity<String> addNewBook(Book newBook)
    {
        try {
            newBook.setQuantity((short) 0);
            newBook.setAvailableQuantity((short) 0);
            repository.save(newBook);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível adicionar o pois a requisição não foi bem feita!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Livro adicionado com sucesso");

    }

    public ResponseEntity<String> deleteById(Long book_id)
    {
        try {
            repository.deleteById(book_id);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível deletar o pois a requisição não foi bem feita!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Livro removido com sucesso");

    }

    public ResponseEntity<String> updateBook(Book book)
    {
        try {
            repository.save(book);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível adicionar o pois a requisição não foi bem feita!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Livro adicionado com sucesso");
    }
}
