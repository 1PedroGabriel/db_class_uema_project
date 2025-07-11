package br.uema.project.project.api.request.reservation;

import br.uema.project.project.entity.Reservation;
import br.uema.project.project.entity.Staff;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReservationsUpdateRequest {
    private Staff librarian; // mantido

    @NotNull(message = "reservation é obrigatório")
    private Reservation reservation;
}