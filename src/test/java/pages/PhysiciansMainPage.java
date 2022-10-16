package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansMainPage {
    // general issues related to the physician
    // patients page do not include interactive staff. Let's not create a separate page for that & use here
    // Edit Inpatient page can be created if we need later
    public PhysiciansMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
