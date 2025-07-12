package br.uema.project.project.api.request.reservation;

import br.uema.project.project.entity.Reservation;
import br.uema.project.project.entity.Staff;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationsCreateRequest {
    private Staff librarian; // mantido

    private Reservation reservation; // mantido, mesmo que não usado

    // ➕ Campos novos para o período de reserva
    @NotNull(message = "bookId é obrigatório")
    private Long bookId;

    @NotNull(message = "userId é obrigatório")
    private Long userId;

    @NotNull(message = "startDate é obrigatório")
    private LocalDateTime startDate;

    @NotNull(message = "endDate é obrigatório")
    private LocalDateTime endDate;
}
