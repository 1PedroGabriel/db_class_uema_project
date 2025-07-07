package br.uema.project.project.api.request.book;

import br.uema.project.project.entity.Book;
import br.uema.project.project.entity.Staff;
import lombok.Getter;

@Getter
public class BooksDeleteRequest {
    private Staff cataloger;
    private Long book_id;
}