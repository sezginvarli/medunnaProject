package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminStaffMainPage {
    public AdminStaffMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
