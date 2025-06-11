package br.uema.project.project.api.request.staff;

import br.uema.project.project.entity.Staff;
import lombok.Getter;

@Getter
public class StaffCreateRequest {

    private Staff newStaff;
    private Staff adminStaff;

}
