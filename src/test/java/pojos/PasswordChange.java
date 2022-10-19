package pojos;

public class PasswordChange {
    String newPsw;
    String currentPsw;
    String confirmPsw;

    public PasswordChange() {
    }

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

    public String getConfirmPsw() {
        return confirmPsw;
    }

    public void setConfirmPsw(String confirmPsw) {
        this.confirmPsw = confirmPsw;
    }

    @Override
    public String toString() {
        return "PasswordChange{" +
                "newPsw='" + newPsw + '\'' +
                ", currentPsw='" + currentPsw + '\'' +
                ", confirmPsw='" + confirmPsw + '\'' +
                '}';
    }
}
