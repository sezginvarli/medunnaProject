package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminTestItemsPage {
    public AdminTestItemsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
