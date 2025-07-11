package br.uema.project.project.service;

import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookCopyService {

    @Autowired
    BookCopyRepository repository;

    public Optional<BookCopy> findById(Long id)
    {
        return repository.findById(id);
    }

    public List<BookCopy> listAllBookCopy()
    {
        return repository.findAll();
    }

    public List<BookCopy> filterBooksCopy( Long categoryId,
                                           String author,
                                           Integer year,
                                           Integer minPages,
                                           Integer maxPages,
                                           String shelfLocation,
                                           BookCopy.BookCopyStatus status,
                                           String copyCode)
    {
        return repository.findByFilters(categoryId, author, year, minPages, maxPages, shelfLocation, status, copyCode);
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

        repository.updateFields(request.getId(), request.getStatus(), request.getShelfLocation());
    }




}
