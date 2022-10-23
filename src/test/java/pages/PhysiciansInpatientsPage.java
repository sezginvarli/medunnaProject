package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PhysiciansInpatientsPage {

    public PhysiciansInpatientsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table//thead")
    public WebElement inPatientsTableHeaders;

    @FindBy(xpath = "//table//tbody")
    public WebElement inPatientsTableBody;

    @FindAll
    (@FindBy(xpath = "//table/tbody//a[contains(@href,'/in-patient/')]"))
    public List<WebElement> inPatientsEditButtons;

    @FindAll
    (@FindBy(xpath = "//table/tbody/tr"))
    public List<WebElement> inPatientsTableBodyRows;
}
