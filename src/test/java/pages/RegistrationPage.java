package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
    @FindBy(id = "register-submit")
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







}
