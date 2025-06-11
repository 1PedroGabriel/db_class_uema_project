package br.uema.project.project.service;

import br.uema.project.project.entity.Books;
import br.uema.project.project.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public List<Books> listAllBooks()
    {
        return repository.findAll();
    }

    public ResponseEntity<String> addNewBook(Books newBook)
    {
        try {
            repository.save(newBook);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível adicionar o pois a requisição não foi bem feita!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Livro adicionado com sucesso");

    }
}
