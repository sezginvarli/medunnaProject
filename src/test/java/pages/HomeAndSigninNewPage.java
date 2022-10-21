package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomeAndSigninNewPage {

    public HomeAndSigninNewPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

   // @FindBy(xpath = "(/a[@class='appointment-btn scrollto']")
    @FindBy(xpath = "(//a[@href='#appointment'])[1]")
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

    @FindBy(xpath="(//div[@class='invalid-feedback'])[1]")
    public WebElement YourFirstNameisrequired;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement YourLastNameisrequired;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    public WebElement YourSSNisrequired;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement YourEmailisrequired;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement YourNumberisrequired;

    @FindBy(xpath ="//button[@class='btn btn-primary']")
    public WebElement SendAndAppointmantRequest;

    @FindBy(xpath = "(//a[@href='#'])[1]")
    public WebElement signInButton1;
    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement signInTab;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//span[.='MY PAGES(PATIENT)']")
    public WebElement myPagesPatient;

    @FindBy(xpath = "//span[.='My Appointments']")
    public WebElement myAppointment;

    @FindBy(xpath = "(//span[.='Show Tests'])[1]")
    public WebElement showTestElement;

    @FindBy(xpath = "//table/tbody/tr/td[6]")
    public List<WebElement> createdDate;

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
    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckBox;
    @FindBy(xpath = "//div[@class='alert alert-warning fade show']")
    public WebElement forgetYourPassword;
    @FindBy(xpath = "//span[text()='Reset your password']")
    public WebElement resetYourPassword;
    @FindBy(id = "email")
    public WebElement emailTextArea;
    @FindBy(xpath = "//span[text()='Reset password']")
    public WebElement resetPassword;
    @FindBy(xpath = "(//div[@role='alert'])[1]")
    public WebElement checkYourEmail;
    @FindBy(xpath = "(//div[@class='alert alert-warning fade show'])[2]")
    public WebElement noAccount;
    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerNewAccount;
    @FindBy(xpath = "//span[text()='Registration']")
    public WebElement registrationPage;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signinHeaderVisible;
    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement cancel;
    @FindBy(xpath = "//strong[text()='Failed to sign in!']")
    public WebElement authentication;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement register;
    @FindBy(xpath = "(//*[text()='Sign in'])[2]")
    public WebElement signInText;
    @FindBy(partialLinkText = "Password")
    public WebElement passwordDropdown;
}


