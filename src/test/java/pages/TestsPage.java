package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestsPage {
    public TestsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[contains(@href,'/testresult/test/')]")
    public WebElement firstViewResultButton;
    @FindBy(xpath = "//*[.='No Tests found']")
    public WebElement noTestFoundMessage;
}
