package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {
    // physician login includes only Edit
    // locates same with Admin Login
    // Admin Login have additional staff
    public AppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "appointment-heading")
    public WebElement appointmentListPageAppointmentHeading;

    @FindBy(id = "fromDate")
    public WebElement appointmentListPageDateFrom;

    @FindBy(id = "toDate")
    public WebElement appointmentListPageDateTo;

    @FindBy(xpath = "(//td[@class='text-right']/div)[1]")
    public WebElement firstEditButton;


}
