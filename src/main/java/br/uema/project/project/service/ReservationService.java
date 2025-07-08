package br.uema.project.project.service;


import br.uema.project.project.api.request.reservation.ReservationsCreateRequest;
import br.uema.project.project.entity.Reservation;
import br.uema.project.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> listAllReservations()
    {
        return repository.findAll();
    }

    public ResponseEntity<String> makeReservation(Reservation reservation)
    {
        try {
            repository.save(reservation);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Reservado com sucesso");
    }

    public ResponseEntity<String> deleteById(Long reservation_id)
    {
        try {
            repository.deleteById(reservation_id);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Reserva removida com sucesso");
    }

    public ResponseEntity<String> updateReservation(Reservation reservation)
    {
        if(repository.existsById(reservation.getId()))
        {
            return this.makeReservation(reservation);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado!");
    }


}
