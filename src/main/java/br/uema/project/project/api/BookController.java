package br.uema.project.project.api;

import br.uema.project.project.api.request.book.BooksCreateRequest;
import br.uema.project.project.api.request.book.BooksDeleteRequest;
import br.uema.project.project.api.request.book.BooksUpdateRequest;
import br.uema.project.project.dto.book.AuthorDTO;
import br.uema.project.project.entity.Book;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.service.BookService;
import br.uema.project.project.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private StaffService staffService;

    @GetMapping("/list-all")
    public List<Book> listAllBooks()
    {
        return service.listAllBooks();
    }

    @GetMapping("/out-of-stock/list-all")
    public List<Book> listAllOutOfStockBooks()
    {
        return service.listAllOutOfStockBooks();
    }

    @GetMapping("/author/list-all")
    public List<AuthorDTO> listAllAuthors() { return service.listAllAuthors(); }

    @GetMapping("/report")
    public List<Book> getFilteredBooks(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer minPages,
            @RequestParam(required = false) Integer maxPages,
            @RequestParam(required = false) Boolean available
    ) {
        return service.filterBooks(categoryId, author, year, minPages, maxPages, available);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BooksCreateRequest request)
    {

        Staff cataloger = request.getCataloger();
        Book newBook = request.getNewBook();

        // É necessário ser um cataloger para adicionar um livro
        if(staffService.isCataloger(cataloger).getStatusCode() == HttpStatus.OK)
        {
            return service.addNewBook(newBook);
        }

        // Caso o status code não for ok, retorna o staff service onde há as verificações
        return staffService.isCataloger(cataloger);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody BooksDeleteRequest request)
    {
        Staff cataloger = request.getCataloger();
        Long book_id = request.getBook_id();

        if(staffService.isCataloger(cataloger).getStatusCode() == HttpStatus.OK)
        {
            return service.deleteById(book_id);
        }

        // Caso o status code não for ok, retorna o staff service onde há as verificações
        return staffService.isCataloger(cataloger);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody BooksUpdateRequest request)
    {
        Staff cataloger = request.getCataloger();
        Book book = request.getBook();


        if(staffService.isCataloger(cataloger).getStatusCode() == HttpStatus.OK)
        {
            return service.updateBook(book);
        }

        // Caso o status code não for ok, retorna o staff service onde há as verificações
        return staffService.isCataloger(cataloger);
    }



}
