package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bill {
    /*
    {
    "createdBy": "johnstaff",
    "createdDate": "2022-10-26T11:11:48.063624Z",
    "id": 262925,
    "date": "2022-10-26T11:11:00Z",
    "ssn": "532-65-8712",
    "billName": "John John",
    "billDate": "2022-10-26T11:11:48.062860Z",
    "totalCost": 1361.00,
    "paymentMethod": "CREDIT_CARD",
    "description": "pay it",
    "appointment": {
        "createdBy": "john123",
        "createdDate": "2022-10-25T12:57:00.505804Z",
        "id": 289363,
        "startDate": "2022-11-17T00:00:00Z",
        "endDate": "2022-11-17T01:00:00Z",
        "status": "COMPLETED",
        "anamnesis": "cold",
        "treatment": "cold",
        "diagnosis": "cold",
        "prescription": "cold",
        "description": "cold",
        "physician": {
        ..
     */
    private Integer id;
    private String date;
    private String ssn;
    private String billName;
    private Double totalCost;
    private String paymentMethod;
    private String description;
   // private Appointment [][] appointment;

    public Bill(Integer id, String date, String ssn, String billName, Double totalCost, String paymentMethod, String description, Appointment[][] appointment) {
        this.id = id;
        this.date = date;
        this.ssn = ssn;
        this.billName = billName;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
        this.description = description;
        //this.appointment = appointment;
    }

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Appointment[][]getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(Appointment[][] appointment) {
//        this.appointment = appointment;
//    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", ssn='" + ssn + '\'' +
                ", billName='" + billName + '\'' +
                ", totalCost=" + totalCost +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", description='" + description + '\'' +
               // ", appointment=" + Arrays.toString(appointment) +
                '}';
    }
}
