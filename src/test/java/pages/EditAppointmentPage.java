package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditAppointmentPage {
    // appointment details here
    // Request A Test button is here for physicians / absent if staff login
    // Show Test Results button is here for physicians / absent if staff login
    // Request Inpatient button is here for physicians / absent if staff login
    // For the rest of the locates are same for physicians & staff
    public EditAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
