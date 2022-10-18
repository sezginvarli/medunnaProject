package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant {

    /*
    {
  "activated": true,
  "authorities": [
    "string"
  ],
  "createdBy": "string",
  "createdDate": "2022-10-13T14:12:34.131Z",
  "email": "string",
  "firstName": "string",
  "id": 0,
  "imageUrl": "string",
  "langKey": "string",
  "lastModifiedBy": "string",
  "lastModifiedDate": "2022-10-13T14:12:34.132Z",
  "lastName": "string",
  "login": "string",
  "password": "string",
  "ssn": "string"
}
     */

    private String firstName;
    private String lastName;
    private String ssn;
    private String login;
    private String langKey;
    private String password;
    private String email;
   // private int id;
    private boolean activated;
    private String [] authorities;

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String[] getAuthorities() {

        return authorities;
    }

    public void setAuthorities(String[] authorities) {

        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Registrant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", login='" + login + '\'' +
                ", langKey='" + langKey + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
               // ", id=" + id +
                ", activated=" + activated +
                ", authorities=" + Arrays.toString(authorities) +
                '}';
    }

}
