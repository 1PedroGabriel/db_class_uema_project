package br.uema.project.project.api.request.reservation;

import java.time.LocalDate;

public class OpenReservationsReport {
    private String user;
    private String book;
    private LocalDate expectedDate;

    public OpenReservationsReport(String user, String book, LocalDate expectedDate) {
        this.user = user;
        this.book = book;
        this.expectedDate = expectedDate;
    }

    public String getUser() {
        return user;
    }

    public String getBook() {
        return book;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }
}
