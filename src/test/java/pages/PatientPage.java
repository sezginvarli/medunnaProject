package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPage {
    public PatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "//a[@href='/patient-appointment']")
    public WebElement myAppointmentsButton;

    @FindBy(xpath = "//a[@href='/make-appointment']")
    public WebElement makeAnAppointmentButton;


}
