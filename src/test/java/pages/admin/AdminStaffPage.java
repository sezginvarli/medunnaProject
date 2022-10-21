package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminStaffPage {
    public AdminStaffPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
