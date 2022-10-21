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
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement searchPatientButton;

    // Patient Searching With SSN (Text Area)
    @FindBy(name = "ssn")
    public WebElement searchPatientWithSsn;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButtonAfterSearchingPatient;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButtonAfterSearchingPatientPage;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
    public WebElement showAppointmentsButtonAfterSearchingPatientPage;

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

    @FindBy(xpath = "//*[@id='app-view-container']")
    public WebElement viewPortal;

    @FindBy(id = "ssn")
    public WebElement ssnInfoTitle;

    @FindBy(id = "firstName")
    public WebElement firstNameInfoTitle;

    @FindBy(id = "lastName")
    public WebElement lastNameInfoTitle;

    @FindBy(id = "birthDate")
    public WebElement birthDateInfoTitle;

    @FindBy(id = "phone")
    public WebElement phoneInfoTitle;

    @FindBy(id = "email")
    public WebElement emailInfoTitle;

    @FindBy(id = "gender")
    public WebElement genderInfoTitle;

    @FindBy(id = "bloodGroup")
    public WebElement bloodGroupInfoTitle;

    @FindBy(id = "adress")
    public WebElement adressInfoTitle;

    @FindBy(id = "description")
    public WebElement descriptionInfoTitle;

    @FindBy(id = "description")
    public WebElement createdDateInfoTitle;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/dl/dt[12]/span")
    public WebElement userInfoTitle;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/dl/dt[13]/span")
    public WebElement countryInfoTitle;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/dl/dt[14]/span")
    public WebElement stateCityInfoTitle;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement showTestsButton;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//input[@id='c-test-result-result']")
    public WebElement testResultBox;

    @FindBy(xpath = "//input[@id='c-test-result-description']")
    public WebElement testResultDescriptionBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement testResultSaveButton;

    @FindBy(xpath = "//*[starts-with(.,'A Test Result is updated')]")
    //a[starts-with(@href, "mylink")]
    public WebElement testResultUpdatedMessage;


}
