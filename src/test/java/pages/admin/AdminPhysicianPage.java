package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {

    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsAndTitlesButton;

    @FindBy(xpath = "//span[.='Physician']")
    public WebElement physicianButton;

    @FindBy(xpath = "//span[.='Create a new Physician']")
    public WebElement createanewphysicianButton;

    @FindBy(id = "useSSNSearch")
    public WebElement useSearchButton;

    @FindBy(id = "searchSSN")
    public WebElement searchSSNBox;

    @FindBy(className = "btn btn-secondary")
    public WebElement searchUserButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement existingSSN;

    @FindBy(id = "physician-firstName")
    public WebElement firstName;

    @FindBy(id = "physician-lastName")
    public WebElement lastName;

    @FindBy(id = "physician1-birthDate")
    public WebElement birthDate;

    @FindBy(id = "physician-phone")
    public WebElement phoneBox;

    @FindBy(id = "physician-speciality")
    public WebElement specialityDropdownButton;

    @FindBy(id = "file_image")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[2]/div/form/div[11]/div/a/img")
    public WebElement image;

    @FindBy(id = "physician-user")
    public WebElement userDropdownButton;

    @FindBy(id = "physician-examFee")
    public WebElement examFeeButton;


}
