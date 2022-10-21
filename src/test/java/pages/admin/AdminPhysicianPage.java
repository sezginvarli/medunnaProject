package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {

    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='entity-menu']/a/span")
    public WebElement itemsAndTitlesButton;

    @FindBy(xpath = "//span[.='Physician']")
    public WebElement physicianButton;

    @FindBy(xpath = "//span[.='Create a new Physician']")
    public WebElement createanewphysicianButton;






}
