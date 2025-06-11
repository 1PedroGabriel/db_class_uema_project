package br.uema.project.project.api.request.books;

import br.uema.project.project.entity.Books;
import br.uema.project.project.entity.Staff;
import lombok.Getter;

@Getter
public class BooksCreateRequest {
    private Staff cataloger;
    private Books newBook;
}
