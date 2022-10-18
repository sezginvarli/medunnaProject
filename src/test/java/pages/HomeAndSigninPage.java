package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeAndSigninPage {
    public HomeAndSigninPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class=\"appointment-btn scrollto\"]")
    public WebElement MakeAnAppointment;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="ssn")
    public WebElement ssn;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="appoDate")
    public WebElement appoDate;

    @FindBy(xpath="(//div[@class=\"invalid-feedback\"])[1]")
    public WebElement YourFirstNameisrequired;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[2]")
    public WebElement YourLastNameisrequired;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[3]")
    public WebElement YourSSNisrequired;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[4]")
    public WebElement YourEmailisrequired;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[5]")
    public WebElement YourNumberisrequired;

    @FindBy(id = "id=\"register-submit\"")
    public WebElement SendAndAppointmantRequest;


    @FindBy(id = "account-menu")
    public WebElement signInAccountMenu;
    @FindBy(id = "login-item")
    public WebElement signInLink;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement firstSignInButton;
    @FindBy(id = "username")
    public WebElement userNameTextArea;

    @FindBy(id = "password")
    public WebElement passwordTextArea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath = "//span[text()='Patient29 patient']")
    public WebElement signInVerifyButton;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;


}