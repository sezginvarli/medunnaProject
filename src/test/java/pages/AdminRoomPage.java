package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminRoomPage {
    public AdminRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
