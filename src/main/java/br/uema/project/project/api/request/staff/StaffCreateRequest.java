package br.uema.project.project.api.request.staff;

import br.uema.project.project.entity.Staff;

public class StaffCreateRequest {
    private Staff newStaff;
    private Staff adminStaff;

    public Staff getNewStaff() {
        return newStaff;
    }

    public void setNewStaff(Staff newStaff) {
        this.newStaff = newStaff;
    }

    public Staff getAdminStaff() {
        return adminStaff;
    }

    public void setAdminStaff(Staff adminStaff) {
        this.adminStaff = adminStaff;
    }
}
