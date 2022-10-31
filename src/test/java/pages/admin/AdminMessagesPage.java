package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminMessagesPage {
    public AdminMessagesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Items&Titles']")
    public WebElement itemsTitlesButton;
    @FindBy(xpath = "//span[.='Messages']")
    public WebElement messagesButton;
    @FindBy(xpath = "//span[.='Name']")
    public WebElement nameColumn;
    @FindBy(xpath = "//span[.='Email']")
    public WebElement emailColumn;
    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageColumn;
    @FindBy(xpath = "//span[.='Create a new Message']")
    public WebElement createNewMessageButton;
    @FindBy(id = "c-message-name")
    public WebElement messageNameBox;
    @FindBy(id = "c-message-email")
    public WebElement messageEmailBox;
    @FindBy(id = "c-message-subject")
    public WebElement messageSubjectBox;
    @FindBy(id = "c-message-message")
    public WebElement messageMessageBox;
    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveMessageButton;
    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement  successMessageToastContainer;
    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement messageEditButton;
    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement messageDeleteButton;
    @FindBy(id = "jhi-confirm-delete-cMessage")
    public WebElement confirmDeleteButton;


}
