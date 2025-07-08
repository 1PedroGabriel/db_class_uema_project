package br.uema.project.project.api.request.reservation;

import br.uema.project.project.entity.Staff;
import lombok.Getter;

@Getter
public class ReservationsDeleteRequest {
    private Staff librarian;
    private Long reservation_id;

}
