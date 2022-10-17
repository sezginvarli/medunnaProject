package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment {
    /*
    anamnesis	string
    createdBy	string
    createdDate	string($date-time)
    ctests	[CTest{...}Jump to definition]
    description	string
    diagnosis	string
    endDate*	string($date-time)
    id	integer($int64)
    patient	Patient{...}Jump to definition
    physician	Physician{...}Jump to definition
    prescription	string
    startDate*	string($date-time)
    status*	string
        Enum:
        [ UNAPPROVED, COMPLETED, PENDING, CANCELLED ]
    treatment	string
     */
    private String anamnesis;
    private String createdBy;
    private String createdDate;
    private CTest[] ctests;
    private String description;
    private String diagnosis;
    private String endDate;//required
    private int id;
    private Patient patient;
    private Physician physician;
    private String prescription;
    private String startDate;//required
    private String status;//required enum: [ UNAPPROVED, COMPLETED, PENDING, CANCELLED ]
    private String treatment;

    public Appointment(String anamnesis, String createdBy, String createdDate, CTest[] ctests, String description, String diagnosis, String endDate, int id, Patient patient, Physician physician, String prescription, String startDate, String status, String treatment) {
        this.anamnesis = anamnesis;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctests = ctests;
        this.description = description;
        this.diagnosis = diagnosis;
        this.endDate = endDate;
        this.id = id;
        this.patient = patient;
        this.physician = physician;
        this.prescription = prescription;
        this.startDate = startDate;
        this.status = status;
        this.treatment = treatment;
    }

    public Appointment() {
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
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

    public CTest[] getCtests() {
        return ctests;
    }

    public void setCtests(CTest[] ctests) {
        this.ctests = ctests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
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

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "anamnesis='" + anamnesis + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctests=" + Arrays.toString(ctests) +
                ", description='" + description + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id=" + id +
                ", patient=" + patient +
                ", physician=" + physician +
                ", prescription='" + prescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
