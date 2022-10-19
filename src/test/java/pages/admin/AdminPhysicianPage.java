package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPhysicianPage {
    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="jh-create-entity")
    public WebElement createNewPhysician;

    public WebElement selectById(String id){
        WebElement selectById = Driver.getDriver().findElement(By.linkText(id));
        return selectById;
    }









}
