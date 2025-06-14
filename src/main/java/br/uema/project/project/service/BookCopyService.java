package br.uema.project.project.service;

import br.uema.project.project.entity.BookCopy;
import br.uema.project.project.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookCopyService {

    @Autowired
    BookCopyRepository repository;

    public void addNewBookCopy(BookCopy request)
    {
        repository.addBookCopy(request.getBookId(), request.getCopyCode() ,request.getShelfLocation() ,request.getStatus() , request.getAcquisitionDate() , request.getConditionNotes());
    }

}
