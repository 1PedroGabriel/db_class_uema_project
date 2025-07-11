package br.uema.project.project.repository;

import br.uema.project.project.dto.PendingReservationDTO;
import br.uema.project.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT new br.uema.project.project.dto.PendingReservationDTO(r.user.name, r.book.title, r.reservationDate) " +
           "FROM Reservation r WHERE r.status = 'PENDENTE'")
    List<PendingReservationDTO> findPendingReservations();
}
