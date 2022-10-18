package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminMainPage {
    public AdminMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
