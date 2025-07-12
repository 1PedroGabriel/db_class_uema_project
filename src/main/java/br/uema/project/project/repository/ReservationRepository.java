package br.uema.project.project.repository;

import br.uema.project.project.api.request.reservation.OpenReservationsReport;
import br.uema.project.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT new br.uema.project.project.api.request.reservation.OpenReservationsReport(" +
           "u.name, b.title, r.expectedDate) " +
           "FROM Reservation r " +
           "JOIN User u ON r.userId = u.id " +
           "JOIN Book b ON r.bookId = b.id " +
           "WHERE r.status = 'pending'")
    List<OpenReservationsReport> findOpenReservationsReport();

}
