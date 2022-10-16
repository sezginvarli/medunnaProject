package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InPatient {
    /*
    appointment	Appointment{...}Jump to definition
    createdBy	string
    createdDate	string($date-time)
    description	string
    endDate	string($date-time)
    id	integer($int64)
    patient	Patient{...}Jump to definition
    room	Room{...}Jump to definition
    startDate*	string($date-time)
    status*	string
        Enum:
        [ UNAPPROVED, STAYING, DISCHARGED, CANCELLED ]
     */
    private Appointment appointment;
    private String createdBy;
    private String createdDate;
    private String description;
    private String endDate;
    private int id;
    private Patient patient;
    private Room room;
    private String startDate;//required
    private String status;//required enum:[ UNAPPROVED, STAYING, DISCHARGED, CANCELLED ]

    public InPatient(Appointment appointment, String createdBy, String createdDate, String description, String endDate, int id, Patient patient, Room room, String startDate, String status) {
        this.appointment = appointment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.description = description;
        this.endDate = endDate;
        this.id = id;
        this.patient = patient;
        this.room = room;
        this.startDate = startDate;
        this.status = status;
    }

    public InPatient() {
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InPatient{" +
                "appointment=" + appointment +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id=" + id +
                ", patient=" + patient +
                ", room=" + room +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
