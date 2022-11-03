package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminRoomPage {
    public AdminRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Create a new Room']")
    public WebElement createNewRoom;
    @FindBy(xpath = "//span[text()='Create or edit a Room']")
    public WebElement createEditRoom;
    @FindBy(name = "roomNumber")
    public WebElement roomNumberBox;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement verifyThisFieldIsRequired;

    @FindBy(id = "room-roomType")
    public WebElement roomTypeDropDown;

    @FindBy(id = "room-status")
    public WebElement roomStatus;

    @FindBy(id = "room-price")
    public WebElement roomPrice;

    @FindBy(id = "room-description")
    public WebElement roomDescription;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(name = "createdDate")
    public WebElement createDate;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement roomIsCreated;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement savedSuccessfullyText;

    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement delete;

    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement edit;

    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public  WebElement lastPage;

    @FindBy(xpath = "//td[text()='Full']")
    public WebElement full;

    @FindBy(xpath = "//*[text()='Available']")
    public WebElement Available;

    @FindBy(xpath = "//*[text()='Room Type']")
    public WebElement roomTypeList;

    @FindBy(xpath = "//tr//td[3]")
    public WebElement twin;

    @FindBy(xpath = "//tr//td[3]")
    public WebElement daycare;

    @FindBy(xpath = "//*[text()='Confirm delete operation']")
    public WebElement deleteYazisi;

    @FindBy(xpath = "(//*[text()='Delete'])[21]")
    public WebElement delete2;




}
