package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminMainPage;
import pages.admin.AdminUserManagementPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

public class UserManagementByAdmin {
    AdminMainPage adminMainPage=new AdminMainPage();
    AdminUserManagementPage adminUserManagementPage=new AdminUserManagementPage();
    Actions actions = new Actions(Driver.getDriver());
    @When("User clicks on Administrations")
    public void user_clicks_on_administrations() {

    ReusableMethods.waitForClickablility(adminMainPage.adminMainPageText,3).click();
    }
    @When("User clicks on User Management")
    public void user_clicks_on_user_management() {
        ReusableMethods.waitForClickablility(adminMainPage.userManagementText,3).click();
    }
    @Then("User clicks on view button")
    public void user_clicks_on_view_button() {

        ReusableMethods.waitForClickablility(adminUserManagementPage.viewFirst,3).click();

    }
    @Then("User verifies user's information on the page")
    public void user_verifies_user_s_information_on_the_page() {
        Assert.assertTrue(adminUserManagementPage.firstnameText.isDisplayed());
        Assert.assertTrue(adminUserManagementPage.lastnameText.isDisplayed());
        Assert.assertTrue(adminUserManagementPage.emailText.isDisplayed());
        Assert.assertTrue(adminUserManagementPage.languageText.isDisplayed());
        Assert.assertTrue(adminUserManagementPage.modifiedByText.isDisplayed());
        Assert.assertTrue(adminUserManagementPage.modifiedDateText.isDisplayed());
    }
    @Then("User clicks on Edit button")
    public void user_clicks_on_edit_button() {
//        ReusableMethods.waitFor(5);
        ReusableMethods.waitForClickablility(adminUserManagementPage.editFirst,3).click();
        ReusableMethods.waitFor(3);
    }
    @Then("User selects Activated checkbox")
    public void user_selects_activated_checkbox() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        if (adminUserManagementPage.activatedCheckox.isSelected()) {
            System.out.println("it is activated");
        } else {
            System.out.println("it is not activated");
            adminUserManagementPage.activatedCheckox.click();
        }
        Assert.assertTrue(adminUserManagementPage.activatedCheckox.isDisplayed());
    }
    @Then("User cliks on Save button")
    public void user_cliks_on_save_button() {
        ReusableMethods.waitForClickablility(adminUserManagementPage.saveBtn,1).click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(adminUserManagementPage.updateMessagge.isDisplayed());
        ReusableMethods.waitFor(5);
    }
    @Then("User assigns {string} {string} to the user")
    public void user_assigns_role_to_the_user(String role,String index) {
        Select select = new Select(adminUserManagementPage.roleSelect);
        List<WebElement> roleList =select.getOptions();
        System.out.println(roleList.get(Integer.parseInt(index)).getText());
        Assert.assertTrue(roleList.get(Integer.parseInt(index)).getText().contains(role));
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForClickablility(adminUserManagementPage.adminRoleText,3).click();

    }
    @Then("User clicks on Delete")
    public void user_clicks_on_delete() {
        ReusableMethods.waitForClickablility(adminUserManagementPage.deleteFirst,3).click();
       // ReusableMethods.waitFor(3);

    }
    @Then("User clicks on Delete button in Delete message")
    public void user_clicks_on_delete_button_in_delete_message() {

        actions.moveToElement(adminUserManagementPage.deleteFirst).click();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(adminUserManagementPage.deleteMessage);
        ReusableMethods.waitFor(2);
        Assert.assertFalse("Admin could not delete user ",adminUserManagementPage.deleteNegatifMessage.isDisplayed());
    }

}
