package br.uema.project.project.api;

import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/book-copy")
public class BookCopyController {

    @Autowired
    BookCopyService service;

    @GetMapping("/list-all")
    public List<BookCopy> listAllBookCopies()
    {
        return service.listAllBookCopy();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BookCopy request)
    {
        try {
            service.addNewBookCopy(request);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Há algum erro na requisição!");
        }

        return ResponseEntity.ok("Livro adicionado com sucesso");

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody BookCopy request)
    {
        try {
            service.removeBookCopy(request);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Há algum erro na requisição!");
        }

        return ResponseEntity.ok("Livro removido com sucesso");
    }
}
