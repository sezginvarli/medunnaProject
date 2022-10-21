package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/*
{
  "currentPassword": "string",
  "newPassword": "string"
}
 */
public class PasswordChange {
    private String newPsw;
    private String currentPsw;

//    public PasswordChange() {
//    }

    public String getNewPsw() {
        return newPsw;
    }

    public void setNewPsw(String newPsw) {
        this.newPsw = newPsw;
    }

    public String getCurrentPsw() {
        return currentPsw;
    }

    public void setCurrentPsw(String currentPsw) {
        this.currentPsw = currentPsw;
    }


    @Override
    public String toString() {
        return "PasswordChange{" +
                "currentPsw='" + currentPsw + '\'' +
                ", newPsw='" + newPsw + '\'' +
                '}';
    }
}
