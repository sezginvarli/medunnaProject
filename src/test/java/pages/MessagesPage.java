package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MessagesPage {
    public MessagesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
