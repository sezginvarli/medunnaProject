package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminStateCityPage {
    public AdminStateCityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
