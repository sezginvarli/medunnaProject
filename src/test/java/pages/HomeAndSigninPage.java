package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeAndSigninPage {
    public HomeAndSigninPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
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
    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settingsButton;
    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameSettings;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastnameSettings;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailSettings;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButtonSettings;
}
