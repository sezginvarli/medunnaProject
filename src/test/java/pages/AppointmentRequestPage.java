package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentRequestPage {
    public AppointmentRequestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "appoDate")
    public WebElement appointmentDate;

    @FindBy(xpath = "//*[contains(text(),'Appointment registration saved')]")
    public WebElement registrationSavedMessage;

    @FindBy(xpath = "//*[contains(text(),'Appointment date can not be past date!')]")
    public WebElement dateCanNotBePastDateMessage;

    @FindBy(id = "register-submit")
    public WebElement sendAppointmentRequestButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement toastifyAlertAppointmentRequestPage;
}
