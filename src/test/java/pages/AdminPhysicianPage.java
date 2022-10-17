package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {
    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
