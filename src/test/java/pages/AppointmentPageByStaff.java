package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AppointmentPageByStaff {
    public AppointmentPageByStaff(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[contains(@href,'appointment-update')])[1]")
    public WebElement firstEditButton;

    public WebElement findEditButtonByAppointmentId (int id){
        return Driver.getDriver().findElement(By.xpath("//a[@href='/appointment-update/"+id+"']"));
    }

    public WebElement findShowTestButtonByAppointmentId (int id){
        return Driver.getDriver().findElement(By.xpath("//a[@href='/tests/appointment/"+id+"']"));
    }

    @FindAll(
            @FindBy(tagName = "a")
    )
    public List<WebElement> allButtons;

    @FindBy(xpath = "//*[.='You are not authorized to access this page.']")
    public WebElement authorizationDeniedMessage;
}
