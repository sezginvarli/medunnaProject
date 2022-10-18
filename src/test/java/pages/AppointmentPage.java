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
    public WebElement dateFrom;
    @FindBy(id = "toDate")
    public WebElement dateTo;
<<<<<<< HEAD
    @FindBy(xpath = "(//td[@class='text-right'])[1]")
=======

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
>>>>>>> main
    public WebElement firstEditButton;
    @FindBy(xpath = "(//*[text()='Edit'])[2]")
    public WebElement secondEditButton;



    @FindBy(xpath = "//span[text()='Appointment']")
    public WebElement appointmentButton;

}
