package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    /*
        "activated": true,
        "createdBy": "string",
        "createdDate": "2022-10-16T09:57:56.834Z",
        "email": "string",
        "firstName": "string",
        "id": 0,
        "imageUrl": "string",
        "langKey": "string",
        "lastName": "string",
        "login": "string",
        "resetDate": "2022-10-16T09:57:56.834Z",
        "ssn": "556-68-7103"
     */

    public User(boolean activated, String createdBy, String createdDate, String email, String firstName, int id, String imageUrl, String langKey, String lastName, String login, String resetDate, String ssn) {
        this.activated = activated;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.imageUrl = imageUrl;
        this.langKey = langKey;
        this.lastName = lastName;
        this.login = login;
        this.resetDate = resetDate;
        this.ssn = ssn;
    }

    public User() {
    }

    private boolean activated;//required
    private String createdBy;
    private String createdDate;
    private String email;
    private String firstName;
    private int id;
    private String imageUrl;
    private String langKey;
    private String lastName;
    private String login;//required
    private String resetDate;
    private String ssn;//required

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getResetDate() {
        return resetDate;
    }

    public void setResetDate(String resetDate) {
        this.resetDate = resetDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "activated=" + activated +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", langKey='" + langKey + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", resetDate='" + resetDate + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
