package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPageByStaff {
    public AppointmentPageByStaff(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[contains(@href,'appointment-update')])[1]")
    public WebElement firstEditButton;

    public WebElement findEditButtonByAppointmentId (int id){
        return Driver.getDriver().findElement(By.xpath("//a[@href='/appointment-update/"+id+"']"));
    }
}
