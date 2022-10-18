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
    @FindBy(xpath = "//a[@href='logout']")
    public WebElement signOutButton;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement register;



}