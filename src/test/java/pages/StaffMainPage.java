package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffMainPage {
    public StaffMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
