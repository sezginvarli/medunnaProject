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

    @FindBy(id = "fromDate")
    public WebElement dateFrom;

    @FindBy(id = "toDate")
    public WebElement dateTo;

    @FindBy(xpath = "(//td[@class='text-right'])[1]")
    public WebElement firstEditButton;

}