package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestResultsPage {
    public TestResultsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "c-test-result-heading")
    public WebElement TestResultsHeader;
}
