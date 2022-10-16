package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentsPage {
    // physician login includes only Edit
    // locates same with Admin Login
    // Admin Login have additional staff
    public AppointmentsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
