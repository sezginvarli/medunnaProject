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

    //@FindBy(id = "account-menu")
    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement userAccountMenu;

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPages;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement dropdownElementMyAppointments;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement myPatient;

@FindBy(xpath="//*[@id='appointment-heading']")
    public WebElement appointmentsPage;

    @FindBy(xpath="//*[@id='patient-heading']")
    public WebElement patientPage;

    public WebElement dropdownElementMyPatients;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement dropdownElementMyInpatients;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[4]")
    public WebElement physicianAccountSettings;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[5]")
    public WebElement physicianAccountPassword;

    //@FindBy(xpath = "//*[text()='Sign out']")
    @FindBy(xpath = "//*[.='Sign out']")
    public WebElement physicianAccountSignOut;

    @FindBy(xpath = "(//a[starts-with(@href,'/appointment-update/')])[1]")
    public WebElement editButtonInMyAppointmentsPage;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement showTestResultsButton;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewResultsButton;

    @FindBy(id = "c-test-result-heading")
    public WebElement testResultPageHeader;

    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    public WebElement requestInpatientButton;

    @FindBy(xpath = "//*[starts-with(.,'A new In Patient is created')]")
    public WebElement newInPatientCreatedMessage;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement myPatients;
    @FindBy(xpath = "//*[.='InPatient request already done for this appointment']")
    public WebElement inpatientAllReadyCreatedMessage;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement myAppointmentsButtonInMyPagesDropDown;

    // After Every Test, Change the index..
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButtonInMyAppointmentsPageWithChangingIndex;


    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement myInPatients;

}
