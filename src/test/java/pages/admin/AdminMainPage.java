package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminMainPage {
    public AdminMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text() = 'Administration']")
    public WebElement adminMainPageText;
    @FindBy(id = "entity-menu")
    public WebElement adminMainPageItemDropdown;
    @FindBy(xpath = "//div[@class= 'dropdown-menu dropdown-menu-right show']/a[3]")
    public WebElement adminMainPageItemDropdownPhysician;
    @FindBy(css = "[class][href = '/c-test-item']")
    public WebElement getAdminMainPageTestItemDropdown;
}
