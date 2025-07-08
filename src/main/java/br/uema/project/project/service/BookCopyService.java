package br.uema.project.project.service;

import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookCopyService {

    @Autowired
    BookCopyRepository repository;

    public List<BookCopy> listAllBookCopy()
    {
        return repository.findAll();
    }

    public void addNewBookCopy(BookCopy request)
    {
        repository.save(request);
    }

    public void removeBookCopy(BookCopy request)
    {
        repository.deleteById(request.getId());
    }

    public void updateBookCopy(BookCopy request)
    {
        repository.save(request);
    }

}
