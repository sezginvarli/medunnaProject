package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
    /*
    adress	string
    appointments	[{...}]
    birthDate	string($date-time)
    bloodGroup	string
    Enum:
    [ Apositive, Anegative, Bpositive, Bnegative, Opositive, Onegative, ABpositive, ABnegative ]
    country	Country{...}
    createdBy	string
    createdDate	string($date-time)
    cstate	CState{...}Jump to definition
    description	string
    email	string // minLength: 5 maxLength: 254
    firstName*	string
    gender	string
    Enum:
    [ MALE, FEMALE, OTHER ]
    id	integer($int64)
    inPatients	[InPatient{...}Jump to definition]
    lastName*	string
    phone*	string
    ssn*	string
    pattern: ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$
    user*	User{...}Jump to definition
     */
    private String adress;
    private Appointment[] appointments;
    private String birthDate;
    private String bloodGroup; //enum: [ Apositive, Anegative, Bpositive, Bnegative, Opositive, Onegative, ABpositive, ABnegative ]
    private Country country;
    private String createdBy;
    private String createdDate;
    private CState cstate;
    private String description;
    private String email;
    private String firstName; //required
    private String gender; //required enum: [ MALE, FEMALE, OTHER ]
    private int id;
    private InPatient[] inPatients;
    private String lastName; //required
    private String phone; //required
    private String ssn; //required
    private User user; //required

    public Patient(String adress, Appointment[] appointments, String birthDate, String bloodGroup, Country country, String createdBy, String createdDate, CState cstate, String description, String email, String firstName, String gender, int id, InPatient[] inPatients, String lastName, String phone, String ssn, User user) {
        this.adress = adress;
        this.appointments = appointments;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.country = country;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.cstate = cstate;
        this.description = description;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.inPatients = inPatients;
        this.lastName = lastName;
        this.phone = phone;
        this.ssn = ssn;
        this.user = user;
    }

    public Patient() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public CState getCstate() {
        return cstate;
    }

    public void setCstate(CState cstate) {
        this.cstate = cstate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InPatient[] getInPatients() {
        return inPatients;
    }

    public void setInPatients(InPatient[] inPatients) {
        this.inPatients = inPatients;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "address='" + adress + '\'' +
                ", appointments=" + Arrays.toString(appointments) +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", country=" + country +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", cstate=" + cstate +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", inPatients=" + Arrays.toString(inPatients) +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }
}
