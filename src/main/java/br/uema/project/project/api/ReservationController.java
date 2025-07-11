package br.uema.project.project.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uema.project.project.dto.PendingReservationDTO;
import br.uema.project.project.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/pending")
    public List<PendingReservationDTO> getPendingReservations() {
        return reservationService.getPendingReservationsReport();
    }
}
