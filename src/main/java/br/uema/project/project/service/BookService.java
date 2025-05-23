package br.uema.project.project.service;

import br.uema.project.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    @Autowired
    private BookRepository repository;

}
