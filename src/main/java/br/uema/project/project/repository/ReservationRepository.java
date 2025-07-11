package br.uema.project.project.repository;

import br.uema.project.project.dto.PendingReservationDTO;
import br.uema.project.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Seu método antigo mantido
    List<Reservation> findByBookIdAndEndDateAfterAndStartDateBefore(
        Integer bookId,
        LocalDateTime startDate,
        LocalDateTime endDate
    );
    @Query("SELECT new br.uema.project.project.dto.PendingReservationDTO(r.user.name, r.book.title, r.reservationDate) " +
           "FROM Reservation r WHERE r.status = 'PENDENTE'")
    List<PendingReservationDTO> findPendingReservations();

    // Novo método com filtro por status
    List<Reservation> findByBookIdAndStatusInAndEndDateAfterAndStartDateBefore(
        Integer bookId,
        List<Reservation.Status> statuses,
        LocalDateTime startDate,
        LocalDateTime endDate
    );

    // Para fila cronológica
    List<Reservation> findByBookIdAndStatusOrderByRequestedAtAsc(
        Integer bookId,
        Reservation.Status status
    );
}