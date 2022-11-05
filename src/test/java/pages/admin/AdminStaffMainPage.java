package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminStaffMainPage {
    public AdminStaffMainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Staff'])[1]")
    public WebElement staffButton;

    @FindBy(xpath = "//*[text()='Create a new Staff']")
    public WebElement createNewStaffButton;

    @FindBy(id = "staff-firstName")
    public WebElement staffFirstName;

    @FindBy(id = "staff-lastName")
    public WebElement staffLastName;

    @FindBy(id = "staff-birthDate")
    public WebElement staffBirthDate;

    @FindBy(id = "staff-phone")
    public WebElement staffPhoneBox;

    @FindBy(id = "staff-user")
    public WebElement staffUser;

}
