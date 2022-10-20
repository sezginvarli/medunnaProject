package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ssn")
    public WebElement ssnTextBox;
    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;
    @FindBy(id = "username")
    public WebElement usernameTextBox;
    @FindBy(id = "email")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement newPasswordTextBox;
    @FindBy(id = "secondPassword")
    public WebElement newPasswordConfirmationTextBox;
    @FindBy(id = "register-submit ")
    public WebElement registerButton;
    @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordStrength1;
    @FindBy(xpath = "(//li[@style='background-color: rgb(221, 221, 221);'])[1]")
    public WebElement passwordStrength2;
    @FindBy(xpath = "(//li[@style='background-color: rgb(221, 221, 221);'])[2]")
    public WebElement passwordStrength3;
    @FindBy(xpath = "(//li[@style='background-color: rgb(221, 221, 221);'])[3]")
    public WebElement passwordStrength4;
    @FindBy(xpath = "(//li[@style='background-color: rgb(221, 221, 221);'])[4]")
    public WebElement passwordStrength5;

    @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement YourSSnIsRequired;
    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement YourFirstNameIsRequired;
    @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement YourLastNameIsRequired;
    @FindBy(xpath = "//div[text()='Your username is required.']")
    public WebElement YourUserNameIsRequired;
    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement YourUserEmailIsRequired;


    @FindBy(xpath = "//*[text()='Registration']")
    public WebElement registrationText;

    @FindBy(xpath = "(//div[@class='form-group'])[4]")
    public WebElement noUsernameError;

    @FindBy(xpath = "(//div[@class='form-group'])[5]")
    public WebElement noEmailError;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton2;
    @FindBy(xpath = "//div[text()='Your username is invalid.']")
    public WebElement YourUsernameIsInvalid;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement thisFieldIsInvalid;

    @FindBy(xpath= "(//input[@class='is-touched is-dirty av-valid form-control'])[4]")
    public WebElement validUsername;

    @FindBy(xpath= "(//input[@class='is-touched is-dirty av-valid form-control'])[5]")
    public WebElement validEmail;
    @FindBy(xpath = "//*[text()='Password for [']")
    public WebElement passwordText;
    @FindBy(xpath="//input[@name='currentPassword']")
    public WebElement currentPassword;
    @FindBy(xpath="//input[@name='newPassword']")
    public WebElement newPassword;
    @FindBy(xpath="//input[@name='confirmPassword']")
    public WebElement confirmPassword;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(xpath="//div[@class='Toastify__toast-body']")
    public WebElement passwordChanged;
    @FindBy(xpath = "//li[@class='point']")
    public List<WebElement> totalBarNums;
    @FindBy(xpath = "//li[@style='background-color: rgb(221, 221, 221);']")
    public List<WebElement> emptyBars;
    @FindBy(xpath= "(//input[@class='is-touched is-dirty av-valid form-control'])[3]")
    public WebElement noConfirmError;
    @FindBy(xpath= "//*[text()='The password and its confirmation do not match!']")
    public WebElement confirmNotMatch;

}