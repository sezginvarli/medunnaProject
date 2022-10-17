package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysiciansInpatientsPage {

    public PhysiciansInpatientsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table/thead")
    public WebElement inPatientsTableHeaders;

    @FindBy(xpath = "//table/tbody")
    public WebElement inPatientsTableBody;
}
