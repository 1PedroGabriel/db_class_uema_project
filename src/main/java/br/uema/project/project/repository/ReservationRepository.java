package br.uema.project.project.repository;

import br.uema.project.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Seu método antigo mantido
    List<Reservation> findByBookIdAndEndDateAfterAndStartDateBefore(
        Integer bookId,
        LocalDateTime startDate,
        LocalDateTime endDate
    );

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