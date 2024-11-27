package JavaBean;
import java.time.LocalDate;

public class Leave {
    private int id;
    private LocalDate application_time;
    private LocalDate approval_time;
    private String reason;
    private boolean is_approved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getApplication_time() {
        return application_time;
    }

    public void setApplication_time(LocalDate application_time) {
        this.application_time = application_time;
    }

    public LocalDate getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(LocalDate approval_time) {
        this.approval_time = approval_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isIs_approved() {
        return is_approved;
    }

    public void setIs_approved(boolean is_approved) {
        this.is_approved = is_approved;
    }

}
