package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansMainPage {
    // general issues related to the physician
    // patients page do not include interactive staff. Let's not create a separate page for that & use here
    // Edit Inpatient page can be created if we need later
    public PhysiciansMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //@FindBy(id = "account-menu")
    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement userAccountMenu;

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPages;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement dropdownElementMyAppointments;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement dropdownElementMyPatients;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement dropdownElementMyInpatients;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[4]")
    public WebElement physicianAccountSettings;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[5]")
    public WebElement physicianAccountPassword;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[6]")
    public WebElement physicianAccountSignOut;



}
