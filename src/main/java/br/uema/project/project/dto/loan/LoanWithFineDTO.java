package br.uema.project.project.dto.loan;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class LoanWithFineDTO {
    private Long loanId;
    private LocalDate returnDate;
    private String userName;
    private BigDecimal fineAmount;
    private String fineStatus;

    public LoanWithFineDTO(Long loanId, LocalDate returnDate, String userName, BigDecimal fineAmount, String fineStatus) {
        this.loanId = loanId;
        this.returnDate = returnDate;
        this.userName = userName;
        this.fineAmount = fineAmount;
        this.fineStatus = fineStatus;
    }

    // Getters e Setters, se necessário
}
