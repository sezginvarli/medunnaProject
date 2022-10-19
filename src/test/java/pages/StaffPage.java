package pages;

import groovy.transform.Final;
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

    @FindBy(xpath = "(//a[starts-with(@href,'/patient-detail/')])[1]")
    public WebElement viewButtonAfterSearchingPatient;

    @FindBy(xpath = "(//a[starts-with(@href,'/patient-update/')])[1]")
    public WebElement editButtonAfterSearchingPatientPage;

    @FindBy(xpath = "(//a[starts-with(@href,'/patient-appointments/')])[1]")
    public WebElement showAppointmentsButtonAfterSearchingPatientPage;

    @FindBy(id = "patient-id")
    public WebElement patientIdBox;

    @FindBy(id = "patient-firstName")
    public WebElement patientFirstNameBox;

    @FindBy(id = "patient-lastName")
    public WebElement patientLastNameBox;

    @FindBy(id = "patient-birthDate")
    public WebElement patientBirthDateBox;

    @FindBy(id = "email")
    public WebElement patientEmailBox;

    @FindBy(id = "patient-phone")
    public WebElement patientPhoneBox;

    @FindBy(id = "patient-gender")
    public WebElement patientGenderDropDown;

    @FindBy(id = "patient-bloodGroup")
    public WebElement patientBloodGroupDropDown;

    @FindBy(id = "patient-adress")
    public WebElement patientAdressBox;

    @FindBy(id = "patient-description")
    public WebElement patientDescriptionBox;

    @FindBy(id = "patient-user")
    public WebElement patientUserDropDown;

    @FindBy(id = "patient-country")
    public WebElement patientCountryDropDown;

    @FindBy(id = "patient-cstate")
    public WebElement patientCityStateDropDown;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[.='A new Patient is created with identifier']")
    public WebElement newPatientCreatedMessage;


















}
