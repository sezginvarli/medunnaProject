package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminMessagesPage {
    public AdminMessagesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
