package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansTestRequestPage {
    // test list is here

    public PhysiciansTestRequestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
