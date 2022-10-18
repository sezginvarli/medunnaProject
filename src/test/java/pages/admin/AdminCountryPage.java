package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminCountryPage {
    public AdminCountryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
