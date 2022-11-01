package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientAppointment {
    public PatientAppointment() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[text()='Appointments']")
    public WebElement AppointmentsText;
    @FindBy(linkText = "Show Tests")
    public WebElement showTestsButton;
    @FindBy(linkText = "Show Invoice")
    public WebElement showInvoiceButton;
    @FindBy (xpath = "//*[text()='Tests']")
    public WebElement TestsText;
    @FindBy (xpath = "//table//thead//th//span")
    public List<WebElement> headers;
    @FindBy (linkText = "View Results")
    public WebElement viewResultsButton;
    @FindBy (xpath = "//*[text()='Test Results']")
    public WebElement testResultsText;
    @FindBy (xpath = " //span[text()='No Tests found']")
    public WebElement noTestFoundText;
    @FindBy(xpath = "(//table//tbody//tr//td)[4]")
    public WebElement statusType;
    @FindBy (xpath = " //th[text()='INVOICE']")
    public WebElement invoiceText;
    @FindBy (xpath = " //table//thead//tr//th")
    public List<WebElement> invoiceHeaders;
    @FindBy(linkText = "Show Invoice")
    public List <WebElement > numShowInvoiceButton;
    @FindBy(xpath = "//span[text()='No Appointments found']")
    public WebElement noAppointmentsFound;


}
