package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminUserManagementPage {
    public AdminUserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}