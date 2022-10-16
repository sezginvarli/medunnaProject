package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CTest {
    /*
        appointment	Appointment{...}Jump to definition
        createdBy	string
        createdDate	string($date-time)
        ctestResults	[CTestResult{...}Jump to definition]
        date*	string($date-time)
        description	string
        id	integer($int64)
        name	string
     */
    private Appointment appointment;
    private String createdBy;
    private String createdDate;
    private CTestResult[] ctestResults;
    private String date;//required
    private String description;
    private int id;
    private String name;

    public CTest(Appointment appointment, String createdBy, String createdDate, CTestResult[] ctestResults, String date, String description, int id, String name) {
        this.appointment = appointment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctestResults = ctestResults;
        this.date = date;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public CTest() {
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

    public CTestResult[] getCtestResults() {
        return ctestResults;
    }

    public void setCtestResults(CTestResult[] ctestResults) {
        this.ctestResults = ctestResults;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CTest{" +
                "appointment=" + appointment +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctestResults=" + Arrays.toString(ctestResults) +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
