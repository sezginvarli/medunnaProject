package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffPage {

    public StaffPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // My Pages Dropdown Button (In staff main page)
    @FindBy(id = "entity-menu")
    public WebElement myPagesDropdown;

    // Search Patient Button (In Dropdown Menu)
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]")
    public WebElement searchPatientButton;

    // Patient Searching With SSN (Text Area)
    @FindBy(name = "ssn")
    public WebElement searchPatientWithSsn;

    // NOTE: İf there are more than one patient with same SSN, xpath is not working !!!
    @FindBy(xpath = "//a[starts-with(@href,'/patient-detail/')]")
    public WebElement viewButtonAfterSearchingPatient;

    // NOTE: İf there are more than one patient with same SSN, xpath is not working !!!
    @FindBy(xpath = "//a[starts-with(@href,'/patient-update/')]")
    public WebElement editButtonAfterSearchingPatient;

    // NOTE: İf there are more than one patient with same SSN, xpath is not working !!!
    @FindBy(xpath = "//a[starts-with(@href,'/patient-appointments/')]")
    public WebElement showAppointmentsButtonAfterSearchingPatient;














}
