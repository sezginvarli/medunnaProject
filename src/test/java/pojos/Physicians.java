package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Physicians {
    /*[
        {
            "createdBy": "team71",
            "createdDate": "2022-08-02T22:09:05.513938Z",
            "id": 154259,
            "firstName": "Ayşe",
            "lastName": "Gül",
            "birthDate": "1969-12-31T23:00:00Z",
            "phone": "17087002385",
            "gender": "MALE",
            "bloodGroup": "Onegative",
            "adress": "Hollywood",
            "description": "Psychiatry",
            "user": {
                "createdBy": "anonymousUser",
                "createdDate": "2022-03-29T16:14:26.759808Z",
                "id": 43608,
                "login": "ayyse",
                "firstName": "Ayşe",
                "lastName": "Gül",
                "email": "glgungor35@gmail.com",
                "activated": true,
                "langKey": "en",
                "imageUrl": null,
                "resetDate": null,
                "ssn": "444-44-4444"
            },
            "speciality": "PSYCHIATRY",
            "appointments": null,
            "country": {
                "id": 142573,
                "name": "USAA!"
            },
            "cstate": null,
            "examFee": 500.00,
            "image": null,
            "imageContentType": null
        },
         */
    private String firstName;
    private String lastName;
    private Object appointments;
    private String birthDate;
    private String bloodGroup;
    private String phone;
    private String description;
    private String address;
    private Object user;
    private String ssn;
    private String createdBy;
    private Number examFee;
    private String gender;
    private String speciality;
    private Object country;
    private int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getAppointments() {
        return appointments;
    }

    public void setAppointments(Object appointments) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Number getExamFee() {
        return examFee;
    }

    public void setExamFee(Number examFee) {
        this.examFee = examFee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MedunnaPhysiciansPojo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", appointments=" + appointments +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", ssn='" + ssn + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", examFee=" + examFee +
                ", gender='" + gender + '\'' +
                ", speciality='" + speciality + '\'' +
                ", country=" + country +
                ", id=" + id +
                '}';
    }
}
