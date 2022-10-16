package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeAndSigninPage {
    public HomeAndSigninPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
