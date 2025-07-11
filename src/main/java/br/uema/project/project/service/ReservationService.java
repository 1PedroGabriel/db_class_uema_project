package br.uema.project.project.service;

import br.uema.project.project.dto.PendingReservationDTO;
import br.uema.project.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<PendingReservationDTO> getPendingReservationsReport() {
        return reservationRepository.findPendingReservations();
    }
}
