package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {

    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="jh-create-entity")
    public WebElement createNewPhysician;
    @FindBy(xpath = "//*[text() = 'Create or edit a Physician']")
    public WebElement createOrEditPhysicianText;


    @FindBy(css = "[name = 'phone']")
    public WebElement phone;
    @FindBy(css = "[name = 'adress']")
    public WebElement address;
    @FindBy(css = "[name = 'gender']")
    public WebElement genderDropDown;
    @FindBy(css = "[name = 'speciality']")
    public WebElement specialityDropDown;
    @FindBy(css = "[name = 'bloodGroup']")
    public WebElement bloodGroupDropdown;
    @FindBy(css = "[id = 'physician-description']")
    public WebElement description;
    @FindBy(id = "file_image")
    public WebElement fileImageUpload;

    @FindBy(xpath = "(//div[@class = 'invalid-feedback'])[1]")
    public WebElement dateErrorMessage;
    @FindBy(css = "[name = 'user.id']")
    public WebElement selectUserDropDown;
    @FindBy(css = "[name = 'country.id']")
    public WebElement countryDropDown;
    @FindBy(css = "[name = 'cstate.id']")
    public WebElement cStateDropDown;
    @FindBy(id = "cancel-save")
    public WebElement backButton;

    @FindBy(xpath = "//*[text() = 'ID']")
    public WebElement visibilityOfId;
    @FindBy(css = "[class = 'Toastify__toast-body']")
    public WebElement alert;
    //*[@id="root"]/div/div/div[1]/div/div/div[1]
    @FindBy(xpath = "//*[text() = 'Created Date']")
    public WebElement createdDate;
    @FindBy(xpath = "(//td/a)[1]")
    public WebElement deleteFirstElementByCreatedBy;
    @FindBy(css = "[class = 'info jhi-item-count']")
    public WebElement totalPhysicianNumber;
    @FindBy(xpath = "//dt[. = 'SSN']")
    public WebElement viewSSNPlace;
    @FindBy(xpath = "//dt[. = 'First Name']")
    public WebElement viewFirstNamePlace;
    @FindBy(xpath = "//dt[. = 'Phone']")
    public WebElement viewPhonePlace;
    @FindBy(xpath = "//dt[. = 'Last Name']")
    public WebElement viewLastNamePlace;
    @FindBy(xpath = "//h2/b")
    public WebElement physicianIDinViewPage;
    @FindBy(id = "jhi-confirm-delete-physician")
    public WebElement deleteConfirmButton;

    public WebElement selectPhysicianById(String id){
        WebElement selectById = Driver.getDriver().findElement(By.linkText(id));
        return selectById;
    }
    public WebElement selectByLineView(int lineNumber){
        WebElement selectByLineView = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-info btn-sm'])["+lineNumber+"]"));
        return selectByLineView;
    }
    public WebElement selectByLineEdit(int lineNumber){
        WebElement selectByLineEdit = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-primary btn-sm'])["+lineNumber+"]"));
        return selectByLineEdit;
    }
    public WebElement selectByLineDelete(int lineNumber){
        WebElement selectByLineDelete = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-danger btn-sm'])["+lineNumber+"]"));
        return selectByLineDelete;
    }
    public WebElement selectByFakerFirstName(String firstName){
        WebElement selectByFakerFirstName = Driver.getDriver().findElement(By.xpath("//*[text() = '"+firstName+"']"));
        return selectByFakerFirstName;
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
