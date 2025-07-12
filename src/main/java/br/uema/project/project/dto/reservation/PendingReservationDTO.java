package br.uema.project.project.dto.reservation;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PendingReservationDTO {

    private Long userId;
    private Long bookId;
    private LocalDateTime startDate;

    public PendingReservationDTO(Long userId, Long bookTitle, LocalDateTime startDate) {
        this.userId = userId;
        this.bookId = bookTitle;
        this.startDate = startDate;
    }

}
