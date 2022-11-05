package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminUserManagementPage {
    public AdminUserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewFirst;
    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement editFirst;
    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement deleteFirst;
    @FindBy(xpath = "(//*[text()='Delete'])[21]")
    public WebElement deleteMessage;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteNegatifMessage;

    @FindBy(xpath = "//dt[*='First name']")
    public WebElement firstnameText;
    @FindBy(xpath = "//dt[*='Last name']")
    public WebElement lastnameText;
    @FindBy(xpath = "//dt[*='Email']")
    public WebElement emailText;
    @FindBy(xpath = "//dt[*='Language']")
    public WebElement languageText;
    @FindBy(xpath = "//dt[*='Modified by']")
    public WebElement modifiedByText;
    @FindBy(xpath = "//dt[*='Modified date']")
    public WebElement modifiedDateText;
    @FindBy(xpath = "//input[@id='activated']")
    public WebElement activatedCheckox;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement saveBtn;
    @FindBy(xpath ="//div[@class='Toastify__toast-body']")
    public WebElement updateMessagge;
    @FindBy (xpath = "//select[@id='authorities']")
    public WebElement roleSelect;
    @FindBy(xpath = "//option[@value='ROLE_ADMIN']")
    public WebElement adminRoleText;
    @FindBy(xpath = "//option[@value='ROLE_USER']")
    public WebElement userRoleText;
    @FindBy(xpath = "//option[@value='ROLE_PATIENT']")
    public WebElement patientRoleText;
    @FindBy(xpath = "//option[@value='ROLE_STAFF']")
    public WebElement staffRoleText;
    @FindBy(xpath = "//option[@value='ROLE_PHYSICIAN']")
    public WebElement physicianRoleText;
}
