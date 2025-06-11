package br.uema.project.project.api;

import br.uema.project.project.api.request.books.BooksCreateRequest;
import br.uema.project.project.entity.Books;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.service.BooksService;
import br.uema.project.project.service.StaffService;
import br.uema.project.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService service;

    @Autowired
    private StaffService staffService;

    @GetMapping("/list-all")
    public List<Books> listAllBooks()
    {
        return service.listAllBooks();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody BooksCreateRequest request)
    {

        Staff cataloger = request.getCataloger();
        Books newBook = request.getNewBook();

        // É necessário ser um cataloger para adicionar um livro
        if(staffService.isCataloger(cataloger).getStatusCode() == HttpStatus.OK)
        {
            return service.addNewBook(newBook);
        }

        // Caso o status code não for ok, retorna o staff service onde há as verificações
        return staffService.isCataloger(cataloger);
    }
}
