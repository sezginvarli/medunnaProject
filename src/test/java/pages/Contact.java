package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Contact {

    public Contact() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath="//*[text()='CONTACT']")
    public WebElement contactSection;
    @FindBy (xpath = "//*[text()='Contact']")
    public WebElement contactVerify;
    @FindBy (name = "name")
    public WebElement nameTextBox;
    @FindBy (name = "email")
    public WebElement emailTextBox;
    @FindBy (name = "subject")
    public WebElement subjectTextBox;
    @FindBy (name = "message")
    public WebElement messageTextBox;
    @FindBy (id = "register-submit")
    public WebElement sendButton;
    @FindBy (xpath = "//*[text()='Name is required.']")
    public WebElement nameIsRequired;
    @FindBy (xpath = "//*[text()='Your email is required.']")
    public WebElement emailIsRequired;
    @FindBy (xpath = "//*[text()='This field is required.']")
    public WebElement fieldIsRequired;
    @FindBy (xpath = "//*[text()='This field is invalid']")
    public WebElement fieldIsInvalidEmail;
    @FindBy(xpath = "//*[contains(text(),'Your message has been received')]")
    public WebElement successMessageToastContainer;
    @FindBy (xpath = "//textarea[@class='is-touched is-dirty av-valid form-control']")
    public WebElement noErrorMessage;

}
