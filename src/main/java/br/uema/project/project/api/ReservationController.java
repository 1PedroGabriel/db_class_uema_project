package br.uema.project.project.api;

import br.uema.project.project.api.request.reservation.ReservationsCreateRequest;
import br.uema.project.project.api.request.reservation.ReservationsDeleteRequest;
import br.uema.project.project.api.request.reservation.ReservationsUpdateRequest;
import br.uema.project.project.entity.Reservation;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.service.ReservationService;
import br.uema.project.project.service.StaffService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @Autowired
    StaffService staffService;

    @GetMapping("/list-all")
    public List<Reservation> listAllReservations() {
        return service.listAllReservations();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid ReservationsCreateRequest request) {

        Staff librarian = request.getLibrarian();

        if (librarian == null || !staffService.isLibrarianBoolean(librarian)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado.");
        }

        return service.createReservation(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody @Valid ReservationsDeleteRequest request) {
        Staff librarian = request.getLibrarian();

        if (librarian == null || !staffService.isLibrarianBoolean(librarian)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado.");
        }

        return service.deleteById(request.getReservation_id());
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid ReservationsUpdateRequest request) {
        Staff librarian = request.getLibrarian();
        Reservation reservation = request.getReservation();

        if (librarian == null || !staffService.isLibrarianBoolean(librarian)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado.");
        }

        return service.updateReservation(reservation);
    }
}