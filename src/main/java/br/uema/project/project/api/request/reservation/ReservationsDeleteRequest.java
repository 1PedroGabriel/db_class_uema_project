package br.uema.project.project.api.request.reservation;

import br.uema.project.project.entity.Staff;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReservationsDeleteRequest {
    private Staff librarian; // mantido

    @NotNull(message = "reservation_id é obrigatório")
    private Long reservation_id; // mantido nome original
}