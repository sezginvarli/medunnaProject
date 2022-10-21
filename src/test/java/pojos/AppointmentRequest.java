package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentRequest {
    /*
    appoSpeciality	string
    birthDate	string($date-time)
    email	string
    firstName	string
    gender	string
    lastName	string
    phone	string
    snumber	string
    ssn	string
    startDate	string($date)
     */
    private String appoSpeciality;
    private String birthDate;
    private String email;
    private String firstName;
    private String gender;
    private String lastName;
    private String phone;
    private String snumber;
    private String ssn;
    private String startDate;

    public AppointmentRequest(String appoSpeciality, String birthDate, String email, String firstName, String gender, String lastName, String phone, String snumber, String ssn, String startDate) {
        this.appoSpeciality = appoSpeciality;
        this.birthDate = birthDate;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.phone = phone;
        this.snumber = snumber;
        this.ssn = ssn;
        this.startDate = startDate;
    }

    public AppointmentRequest() {
    }

    public String getAppoSpeciality() {
        return appoSpeciality;
    }

    public void setAppoSpeciality(String appoSpeciality) {
        this.appoSpeciality = appoSpeciality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "appoSpeciality='" + appoSpeciality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", snumber='" + snumber + '\'' +
                ", ssn='" + ssn + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
