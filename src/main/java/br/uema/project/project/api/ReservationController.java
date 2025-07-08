package br.uema.project.project.api;


import br.uema.project.project.api.request.reservation.ReservationsCreateRequest;
import br.uema.project.project.api.request.reservation.ReservationsDeleteRequest;
import br.uema.project.project.api.request.reservation.ReservationsUpdateRequest;
import br.uema.project.project.entity.Book;
import br.uema.project.project.entity.Staff;
import br.uema.project.project.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uema.project.project.entity.Reservation;
import br.uema.project.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @Autowired
    StaffService staffService;
    @GetMapping("/list-all")
    public List<Reservation> listAllReservations()
    {
        return service.listAllReservations();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ReservationsCreateRequest request)
    {
        Staff librarian = request.getLibrarian();
        Reservation reservation = request.getReservation();

        // É necessário ser um cataloger para adicionar um livro
        if(staffService.isLibrarian(librarian).getStatusCode() == HttpStatus.OK)
        {
            return service.makeReservation(reservation);
        }

        // Caso o status code não for ok, retorna o staff service onde há as verificações
        return staffService.isLibrarian(librarian);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody ReservationsDeleteRequest request)
    {
        Staff librarian = request.getLibrarian();

        if(staffService.isLibrarian(librarian).getStatusCode() == HttpStatus.OK)
        {
            return  service.deleteById(request.getReservation_id());
        }

        return staffService.isLibrarian(librarian);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ReservationsUpdateRequest request)
    {
        Staff librarian = request.getLibrarian();
        Reservation reservation = request.getReservation();

        if(staffService.isLibrarian(librarian).getStatusCode() == HttpStatus.OK)
        {
            return  service.updateReservation(reservation);
        }

        return staffService.isLibrarian(librarian);


    }
}
