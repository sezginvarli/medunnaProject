package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
    private Appointment appointment;
    private Patient patient;
    private Double appointmentCost;
    private CTestItem [] testItems;
    private String totalCost;
    private String ssn;
    private Integer billId;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Double getAppointmentCost() {
        return appointmentCost;
    }

    public void setAppointmentCost(Double appointmentCost) {
        this.appointmentCost = appointmentCost;
    }

    public CTestItem[] getTestItems() {
        return testItems;
    }

    public void setTestItems(CTestItem[] testItems) {
        this.testItems = testItems;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "appointment=" + appointment +
                ", patient=" + patient +
                ", appointmentCost=" + appointmentCost +
                ", testItems=" + Arrays.toString(testItems) +
                ", totalCost=" + totalCost +
                ", ssn='" + ssn + '\'' +
                ", billId=" + billId +
                '}';
    }
    /*
    {
    "appointment": {
        "createdBy": null,
        "createdDate": "2022-10-29T17:43:16.060234Z",
        "id": 289363,
        "startDate": null,
        "endDate": null,
        "status": null,
        "anamnesis": null,
        "treatment": null,
        "diagnosis": null,
        "prescription": null,
        "description": null,
        "physician": null,
        "patient": null,
        "ctests": [

        ]
    },
    "patient": {
        "createdBy": null,
        "createdDate": "2022-10-29T17:43:16.060237Z",
        "id": null,
        "firstName": "John",
        "lastName": "John",
        "birthDate": null,
        "phone": "653-987-6325",
        "gender": null,
        "bloodGroup": null,
        "adress": null,
        "email": null,
        "description": null,
        "user": null,
        "appointments": [

        ],
        "inPatients": [

        ],
        "country": null,
        "cstate": null
    },
    "appointmentCost": 1000.0,
    "lengthOfStay": null,
    "room": null,
    "testItems": [
        {
            "createdBy": null,
            "createdDate": "2022-10-29T17:43:16.065074Z",
            "id": null,
            "name": "cccs",
            "description": null,
            "price": 20.00,
            "defaultValMin": null,
            "defaultValMax": null
        },
        {
            "createdBy": null,
            "createdDate": "2022-10-29T17:43:16.068943Z",
            "id": null,
            "name": "cholestrol",
            "description": null,
            "price": 20.00,
            "defaultValMin": null,
            "defaultValMax": null
        },
        {
            "createdBy": null,
            "createdDate": "2022-10-29T17:43:16.068946Z",
            "id": null,
            "name": "InsulinT",
            "description": null,
            "price": 71.00,
            "defaultValMin": null,
            "defaultValMax": null
        },
        {
            "createdBy": null,
            "createdDate": "2022-10-29T17:43:16.072234Z",
            "id": null,
            "name": "JohnBloodTest",
            "description": null,
            "price": 250.00,
            "defaultValMin": null,
            "defaultValMax": null
        }
    ],
    "totalCost": 1361.0,
    "billId": 262925,
    "ssn": "532-65-8712"
}
     */

}
