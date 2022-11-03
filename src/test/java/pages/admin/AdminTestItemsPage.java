package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminTestItemsPage {
    public AdminTestItemsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "jh-create-entity")
    public WebElement createNewTestItem;
    @FindBy(css = "[name = 'id']")
    public WebElement testItemEditId;
    @FindBy(xpath = "//span[ text() = 'Created Date']")
    public WebElement mainPageCreatedDate;
    @FindBy(css = "[name = 'name']")
    public WebElement testItemName;
    @FindBy(css = "[name = 'description'][type]")
    public WebElement testItemDescription;
    @FindBy(css = "[name = 'price']")
    public WebElement testItemPrice;
    @FindBy(xpath = "//span/span[.= 'Price']")
    public WebElement viewTestItemPriceHeader;
    @FindBy(css = "[name = 'defaultValMin']")
    public WebElement testItemDefaultValMin;
    @FindBy(css = "[name = 'defaultValMax']")
    public WebElement testItemDefaultValMax;
    @FindBy(css = "[name = 'createdDate']")
    public WebElement testItemEditCreatedDate;
    @FindBy(id = "cancel-save")
    public WebElement testItemCancelSave;
    @FindBy(id = "save-entity")
    public WebElement testItemSaveEntity;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement testItemToastifyAlert;
    @FindBy(xpath = "//input[@name = 'name']/following-sibling::div[@class = 'invalid-feedback']")
    public WebElement testItemNameFieldError;
    @FindBy(xpath = "//input[@name = 'price']/following-sibling::div[@class = 'invalid-feedback']")
    public WebElement testItemPriceFieldError;
    @FindBy(xpath = "//span[contains(.,'Default Min. Value')]")
    public WebElement testItemMinValueHeader;
    @FindBy(xpath = "//span[contains(.,'Default Max. Value')]")
    public WebElement testItemMaxValueHeader;
    @FindBy(xpath = "//h2/span[contains(.,'Test Item')]")
    public WebElement testItemHeader;
    @FindBy(xpath = "//span[contains(.,'Description')]")
    public WebElement testItemDescriptionHeader;
    @FindBy(xpath = "//span[contains(.,'Date')]")
    public WebElement testItemDateHeader;
    @FindBy(xpath = "//h2/b")
    public WebElement testItemViewIdHeader;
    @FindBy(xpath = "//div[@class = 'info jhi-item-count']/span")
    public WebElement testItemTestItemCount;
    @FindBy(xpath = "//span/span[contains(.,'Name')]")
    public WebElement adminTestItemViewNameHeader;

    public boolean elementIsExistOrNot(String element){
        boolean flag = false;
        try {
            boolean exists = Driver.getDriver().findElement(By.xpath("//*[text() = '"+element+"']")).isDisplayed();
            flag = exists;
        }catch (Exception e){

        }
        return flag;
    }
    public WebElement selectTestItemId(String id){
        WebElement selectById = Driver.getDriver().findElement(By.linkText(id));
        return selectById;
    }
    public WebElement selectTestItemByLineView(int lineNumber){
        WebElement selectByLineView = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-info btn-sm'])["+lineNumber+"]"));
        return selectByLineView;
    }
    public WebElement selectTestItemByLineEdit(int lineNumber){
        WebElement selectByLineEdit = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-primary btn-sm'])["+lineNumber+"]"));
        return selectByLineEdit;
    }
    public WebElement selectTestItemByLineDelete(int lineNumber){
        WebElement selectByLineDelete = Driver.getDriver().findElement(By.xpath("(//div/a[@class = 'btn btn-danger btn-sm'])["+lineNumber+"]"));
        return selectByLineDelete;
    }
}
