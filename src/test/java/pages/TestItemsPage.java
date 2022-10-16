package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestItemsPage {
    public TestItemsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
