package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CountryPage {
    public CountryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
