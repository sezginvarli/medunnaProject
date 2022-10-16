package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StateCityPage {
    public StateCityPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
