package br.uema.project.project.repository;

import br.uema.project.project.dto.loan.LoanWithFineDTO;
import br.uema.project.project.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = """
    SELECT 
        l.id AS loanId,
        l.return_date AS returnDate,
        u.name AS userName,
        f.amount AS fineAmount,
        f.status AS fineStatus
    FROM loans l
    JOIN users u ON l.user_id = u.id
    LEFT JOIN fines f ON f.loan_id = l.id
    WHERE l.return_date = :returnDate
    """, nativeQuery = true)
    List<LoanWithFineDTO> findLoansWithFinesByReturnDate(@Param("returnDate") LocalDate returnDate);

}
