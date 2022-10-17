package pages;

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

    @FindBy(xpath = "//*[contains(text(),'A new Patient is created')]")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;




}
