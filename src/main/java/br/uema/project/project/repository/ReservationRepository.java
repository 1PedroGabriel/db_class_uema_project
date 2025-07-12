package br.uema.project.project.repository;

import br.uema.project.project.dto.reservation.PendingReservationDTO;
import br.uema.project.project.api.request.reservation.OpenReservationsReport;
import br.uema.project.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByBookIdAndEndDateAfterAndStartDateBefore(
        Integer bookId,
        LocalDateTime startDate,
        LocalDateTime endDate
    );

    @Query("SELECT r.userId, r.bookId, r.startDate " +
           "FROM Reservation r WHERE r.status = 'pending'")
    List<PendingReservationDTO> findPendingReservations();

    // Novo método com filtro por status
    List<Reservation> findByBookIdAndStatusInAndEndDateAfterAndStartDateBefore(
        Long bookId,
        List<Reservation.Status> statuses,
        LocalDateTime startDate,
        LocalDateTime endDate
    );

    @Query("SELECT new br.uema.project.project.api.request.reservation.OpenReservationsReport(" +
           "u.name, b.title, r.expectedDate) " +
           "FROM Reservation r " +
           "JOIN User u ON r.userId = u.id " +
           "JOIN Book b ON r.bookId = b.id " +
           "WHERE r.status = 'pending'")
    List<OpenReservationsReport> findOpenReservationsReport();


    // Para fila cronológica
    List<Reservation> findByBookIdAndStatusOrderByRequestedAtAsc(
        Long bookId,
        Reservation.Status status
    );
}