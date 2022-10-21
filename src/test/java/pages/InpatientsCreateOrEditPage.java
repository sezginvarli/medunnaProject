package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InpatientsCreateOrEditPage {
    public InpatientsCreateOrEditPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='id']")
    public WebElement id;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDate;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDate;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement description;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDate;

    @FindBy(xpath = "//select[@name='appointment.id']")
    public WebElement appointment;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement status;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement room;

    @FindBy(xpath = "//select[@name='patient.id']")
    public WebElement patient;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'The In Patient is updated')]")
    public WebElement inpatientEditSuccessMessage;
}
