package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPatientPage {
    public AdminPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
