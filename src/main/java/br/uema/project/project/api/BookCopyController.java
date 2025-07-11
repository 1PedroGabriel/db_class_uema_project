package br.uema.project.project.api;

import br.uema.project.project.entity.Book;
import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.service.BookCopyService;
import br.uema.project.project.service.BookService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/report")
    public List<BookCopy> getFilteredBooksCopy(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer minPages,
            @RequestParam(required = false) Integer maxPages,
            @RequestParam(required = false) String shelfLocation,
            @RequestParam(required = false) BookCopy.BookCopyStatus status,
            @RequestParam(required = false) String copyCode)
    {
        return service.filterBooksCopy(categoryId, author, year, minPages, maxPages, shelfLocation, status, copyCode);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BookCopy request)
    {
        try {

            // Aciona Trigger para alterar automaticamente o campo quantity e available quantity
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

    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestBody BookCopy request)
    {
        try {

            Optional<BookCopy> book = service.findById(request.getId());

            if (book.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro não foi encontrado");
            } else {
                BookCopy currentBook = book.get();
                currentBook.setStatus(request.getStatus());
                currentBook.setConditionNotes(request.getConditionNotes());

                service.updateBookCopy(currentBook);
            }

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Há algum erro na requisição!");
        }
        return ResponseEntity.ok("atualização feita com sucesso");
    }
}
