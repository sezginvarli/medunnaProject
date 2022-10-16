package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RoomPage {
    public RoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
