package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {

    public AdminPhysicianPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='entity-menu']/a/span")
    public WebElement itemsAndTitlesButton;

    @FindBy(xpath = "//span[.='Physician']")
    public WebElement physicianButton;

    @FindBy(xpath = "//span[.='Create a new Physician']")
    public WebElement createanewphysicianButton;

    @FindBy(xpath = "//input[@id='useSSNSearch']")
    public WebElement useSearchButton;

    @FindBy(xpath = "//input[@id='searchSSN']")
    public WebElement searchSSNBox;

    @FindBy(xpath = "//button[text()=\"Search User\"]")
    public WebElement searchUserButton;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement existingSSN;

    @FindBy(id = "physician-firstName")
    public WebElement firstName;

    @FindBy(id = "physician-lastName")
    public WebElement lastName;

    @FindBy(id = "physician1-birthDate")
    public WebElement birthDate;

    @FindBy(id = "physician-phone")
    public WebElement phoneBox;

    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement specialityDropdownButton;

    @FindBy(xpath = "//input[@id='file_image']")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement toastifyAllert;

    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement specialtyButton;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public WebElement imageCheck;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement examFee;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;
}
