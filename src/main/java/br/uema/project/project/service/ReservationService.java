package br.uema.project.project.service;

import br.uema.project.project.api.request.reservation.ReservationsCreateRequest;
import br.uema.project.project.dto.reservation.PendingReservationDTO;
import br.uema.project.project.entity.Reservation;
import br.uema.project.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> listAllReservations() {
        return repository.findAll();
    }

    public ResponseEntity<String> makeReservation(Reservation reservation) {
        try {
            repository.save(reservation);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Reservado com sucesso");
    }

    public ResponseEntity<String> deleteById(Long reservation_id) {
        try {
            repository.deleteById(reservation_id);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Reserva removida com sucesso");
    }

    public ResponseEntity<String> updateReservation(Reservation reservation) {
        if (repository.existsById(reservation.getId())) {
            return this.makeReservation(reservation);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado!");
    }

    // ➕ Novo método aprimorado para criar reserva com validações
    public ResponseEntity<String> createReservation(ReservationsCreateRequest request) {

        // Verifica se livro está indisponível no período
        if (isBookAvailable(request.getBookId(), request.getStartDate(), request.getEndDate())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Livro está disponível no período, não pode ser reservado.");
        }

        // Verifica conflitos com status pending ou fulfilled
        var conflicts = repository.findByBookIdAndStatusInAndEndDateAfterAndStartDateBefore(
                request.getBookId(),
                List.of(Reservation.Status.pending, Reservation.Status.fulfilled),
                request.getStartDate(),
                request.getEndDate()
        );

        if (!conflicts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Livro já reservado nesse período!");
        }

        // Monta objeto Reservation para salvar
        Reservation reservation = new Reservation();
        reservation.setBookId(request.getBookId());
        reservation.setUserId(request.getUserId());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setRequestedAt(LocalDateTime.now());
        reservation.setStatus(Reservation.Status.pending);
        reservation.setCreatedAt(LocalDateTime.now());

        try {
            repository.save(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body("Reserva criada com sucesso!");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar reserva!");
        }
    }

    public List<PendingReservationDTO> getPendingReservationsReport() {
        return repository.findPendingReservations();
    }
    // Mantém seu método antigo (exemplo simples)
    private boolean isBookAvailable(Integer bookId, LocalDateTime start, LocalDateTime end) {
        // TODO: implemente a lógica real
        return false; // falso para simular indisponibilidade e permitir reserva
    }
}