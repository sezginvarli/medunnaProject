package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansMainPage {
    // general issues related to the physician
    // patients page do not include interactive staff. Let's not create a separate page for that & use here
    // Edit Inpatient page can be created if we need later
    public PhysiciansMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement myAppointments;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement myPatient;

@FindBy(xpath="//*[@id='appointment-heading']")
    public WebElement appointmentsPage;

    @FindBy(xpath="//*[@id='patient-heading']")
    public WebElement patientPage;
}
