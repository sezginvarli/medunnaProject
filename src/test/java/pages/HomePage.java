package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement dropdownIcon;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement signIn;

    @FindBy(id = "hospitalmsappfrontendApp.appointment.home.createOrEditLabel")
    public WebElement register;


}
