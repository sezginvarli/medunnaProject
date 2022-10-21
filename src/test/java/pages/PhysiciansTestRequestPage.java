package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansTestRequestPage {
    // test list is here

    public PhysiciansTestRequestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement requestTest;
    
    @FindBy(id = "c-test-item-heading")
    public WebElement testItem;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(id = "1407")
    public WebElement albumin;

    @FindBy(id = "1405")
    public WebElement potassium;

    @FindBy(id = "1408")
    public WebElement hemoglobin;

    @FindBy(id = "1406")
    public WebElement totalProtein;

    @FindBy(id = "1402")
    public WebElement urea;

    @FindBy(id = "1401")
    public WebElement glucose;

    @FindBy(id = "1404")
    public WebElement sodium;

    @FindBy(xpath = "//span[contains(.,'ID')]")
    public WebElement idHeader;

    @FindBy(xpath = "//span[contains(.,'Name')]")
    public WebElement nameHeader;

    @FindBy(xpath = "//span[contains(.,'Result')]")
    public WebElement resultHeader;

    @FindBy(xpath = "//span[contains(.,'Default Min. Value')]")
    public WebElement minValueHeader;

    @FindBy(xpath = "//span[contains(.,'Default Max. Value')]")
    public WebElement maxValueHeader;

    @FindBy(xpath = "//span[contains(.,'Test')]")
    public WebElement testHeader;

    @FindBy(xpath = "//span[contains(.,'Description')]")
    public WebElement descriptionHeader;

    @FindBy(xpath = "//span[contains(.,'Date')]")
    public WebElement dateHeader;



}
