package br.uema.project.project.dto.reservation;

import java.time.LocalDate;

public class PendingReservationDTO {

    private String userName;
    private String bookTitle;
    private LocalDate reservationDate;

    public PendingReservationDTO(String userName, String bookTitle, LocalDate reservationDate) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.reservationDate = reservationDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }
}
