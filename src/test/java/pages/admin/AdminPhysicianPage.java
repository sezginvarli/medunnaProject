package pages.admin;

import org.openqa.selenium.By;
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
    @FindBy(css = "[name = 'firstName']")
    public WebElement firstName;
    @FindBy(css = "[name = 'lastName']")
    public WebElement lastName;
    @FindBy(css = "[name = 'birthDate']")
    public WebElement birthDate;
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
    @FindBy(css = "[content= 'Description for hospitalmsappfrontend']")
    public WebElement description;
    @FindBy(id = "file_image")
    public WebElement fileImageUpload;
    @FindBy(css = "[name = 'examFee']")
    public WebElement examFee;
    @FindBy(css = "[name = 'user.id']")
    public WebElement selectUserDropDown;
    @FindBy(css = "[name = 'country.id']")
    public WebElement countryDropDown;
    @FindBy(css = "[name = 'cstate.id']")
    public WebElement cStateDropDown;
    @FindBy(id = "cancel-save")
    public WebElement backButton;
    @FindBy(id = "save-entity")
    public WebElement saveButton;


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









}
