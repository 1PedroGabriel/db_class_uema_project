package br.uema.project.project.api;

import br.uema.project.project.dto.loan.LoanWithFineDTO;
import br.uema.project.project.entity.Loan;
import br.uema.project.project.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping("/list-all")
    public List<Loan> listAllLoans() {
        return service.listAllLoans();
    }

    @GetMapping("/returned/list-all")
    public List<LoanWithFineDTO> listAllReturnedLoans(LocalDate maxPeriod)
    {
        return service.devolutionReportByPeriod(maxPeriod);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(Loan request) {
        try {
            service.addNewLoan(request);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Há algum erro na requisição!");
        }

        return ResponseEntity.ok("Emprestimo adicionado com sucesso");
    }

    @PostMapping("/finish/{id}")
    public ResponseEntity<String> finishLoan(@PathVariable  Long loanId) {
        try {
            service.finishLoan(loanId);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Há algum erro na requisição!");
        }

        return ResponseEntity.ok("Emprestimo adicionado com sucesso");

    }
}

