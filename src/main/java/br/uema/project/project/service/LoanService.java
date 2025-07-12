package br.uema.project.project.service;

import br.uema.project.project.dto.loan.LoanWithFineDTO;
import br.uema.project.project.entity.Loan;
import br.uema.project.project.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan> listAllLoans()
    {
        return repository.findAll();
    }

    public Optional<Loan> findById(Long loanId){
        return repository.findById(loanId);
    }
    public void addNewLoan(Loan request)
    {
        repository.save(request);
    }

    public void finishLoan(Long loanId) throws Exception {
        Optional<Loan> loan = this.findById(loanId);

        if(loan.isPresent())
        {
            Loan finishedLoan = loan.get();
            finishedLoan.setStatus(Loan.LoanStatus.returned);
            repository.save(finishedLoan);
        } else {
            throw new Exception();
        }
    }

    public List<LoanWithFineDTO> devolutionReportByPeriod(LocalDate maxPeriod){

        return repository.findLoansWithFinesByReturnDate(maxPeriod);
    }

    // Deveria ser adicionado um método para criar automaticamente as fines utilizando uma fineService, Com o arquivo de inserts será possível utilizar esses métodos já que não será necessário criar.
}
