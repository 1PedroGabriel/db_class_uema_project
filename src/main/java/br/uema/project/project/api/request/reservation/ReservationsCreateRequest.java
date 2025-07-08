package br.uema.project.project.api.request.reservation;

import br.uema.project.project.entity.Reservation;
import br.uema.project.project.entity.Staff;

import lombok.Getter;

@Getter
public class ReservationsCreateRequest {

    private Staff librarian;
    private Reservation reservation;

}
