package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPatientPage {
    public AdminPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Items&Titles']")
    public WebElement itemsTitlesButton;

    @FindBy(xpath = "//span[.='Patient']")
    public WebElement patientButton;

    @FindBy(xpath = "//span[.='Create a new Patient']")
    public WebElement createPatientButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastnameBox;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDateBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneBox;

    @FindBy(id = "patient-gender")
    public WebElement genderDropDown;

    @FindBy(id = "patient-bloodGroup")
    public WebElement bloodDropDown;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement adressBox;

    @FindBy(id = "patient-description")
    public WebElement descriptionTextArea;

    @FindBy(id = "patient-country")
    public WebElement countryDropDown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//span[text()='SSN']")
    public WebElement ssn;

    @FindBy(xpath = "//span[text()='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//span[text()='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//span[text()='Birth Date']")
    public WebElement birthDate;

    @FindBy(xpath = "//span[text()='Phone']")
    public WebElement phone;

    @FindBy(xpath = "//span[text()='Email']")
    public WebElement email;

    @FindBy(xpath = "//span[text()='Gender']")
    public WebElement gender;

    @FindBy(xpath = "//span[text()='Blood Group']")
    public WebElement bloodGroup;

    @FindBy(xpath = "//span[text()='Address']")
    public WebElement address;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement description;

    @FindBy(xpath = "//span[text()='Created Date']")
    public WebElement createdDate;

    @FindBy(xpath = "//span[text()='User']")
    public WebElement user;

    @FindBy(xpath = "(//span[text()='Country'])[2]")
    public WebElement country;

    @FindBy(xpath = "//span[text()=' State/City']")
    public WebElement stateCity;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement patientEditButton;

    @FindBy(xpath = "//span[text()='ID']")
    public WebElement ID;

    @FindBy(id = "patient-cstate")
    public WebElement stateCityDropDown;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement firstDeleteButton;

    @FindBy(id = "jhi-confirm-delete-patient")
    public WebElement confirmDeleteButton;







}
