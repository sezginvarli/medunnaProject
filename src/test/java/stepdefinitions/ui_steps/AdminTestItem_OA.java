package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.PhysiciansTestRequestPage;
import pages.admin.AdminMainPage;
import pages.admin.AdminTestItemsPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class AdminTestItem_OA {
    String itemName;
    Faker faker=new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    PhysiciansTestRequestPage physiciansTestRequestPage = new PhysiciansTestRequestPage();
    AdminMainPage adminMainPage =new AdminMainPage();
    AdminTestItemsPage adminTestItemsPage =new AdminTestItemsPage();
    @When("User click on Test Item from dropdown button")
    public void user_click_on_test_item_from_dropdown_button() {
        ReusableMethods.waitForVisibility(adminMainPage.adminMainPageItemDropdown,5);
        adminMainPage.adminMainPageItemDropdown.click();
        adminMainPage.getAdminMainPageTestItemDropdown.click();
    }
    @When("User click on Create a New Test Item")
    public void user_click_on_create_a_new_test_item() {
        adminTestItemsPage.createNewTestItem.click();
    }
    @When("User filled the credentials")
    public void user_filled_the_credentials() {
        itemName = faker.name().firstName();
        adminTestItemsPage.testItemName.sendKeys(itemName);
        adminTestItemsPage.testItemDescription.sendKeys(faker.expression("only urgent situation"));
        adminTestItemsPage.testItemPrice.sendKeys(faker.number().digits(3));
        adminTestItemsPage.testItemDefaultValMin.sendKeys(faker.number().digits(3));
        adminTestItemsPage.testItemDefaultValMax.sendKeys(faker.number().digits(3));
        ReusableMethods.waitFor(2);
    }
    @Then("User click the save button and see Test Item is Created alert.")
    public void user_click_the_save_button_and_see_test_item_is_created_alert() {
        js.executeScript("arguments[0].click()",adminTestItemsPage.testItemSaveEntity);
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemToastifyAlert,7);
        assertTrue(adminTestItemsPage.testItemToastifyAlert.getText().contains("A new Test Item is created with identifier"));
    }
    @Then("User should click Created Date and see the created Test Item")
    public void user_should_click_created_date_and_see_the_created_test_item() {
        js.executeScript("arguments[0].click()",adminTestItemsPage.mainPageCreatedDate);
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemTestItemCount,7);
        ReusableMethods.waitFor(4);
        assertTrue(adminTestItemsPage.elementIsExistOrNot(itemName));
    }
    @Then("User click back button and  should see main Test Item page")
    public void user_click_back_button_and_should_see_main_test_item_page() {
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemCancelSave,7);
        js.executeScript("arguments[0].click()",adminTestItemsPage.testItemCancelSave);
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemTestItemCount,7);
        assertTrue(adminTestItemsPage.testItemTestItemCount.isDisplayed());
    }
    @When("User should click again Create a New Test Item")
    public void user_should_click_again_create_a_new_test_item() {
        adminTestItemsPage.createNewTestItem.click();
    }
    @Then("User should see Name,Description,Price,Default Min. And Max. Value,Created Date,Back and Save Buttons")
    public void user_should_see_name_description_price_default_min_and_max_value_created_date_back_and_save_buttons() {
        boolean[] view = new boolean[8];
        view[0] = adminTestItemsPage.testItemCancelSave.isDisplayed();
        view[1] = adminTestItemsPage.testItemName.isDisplayed();
        view[2] = adminTestItemsPage.testItemDescription.isDisplayed();
        view[3] = adminTestItemsPage.testItemPrice.isDisplayed();
        view[4] = adminTestItemsPage.testItemDefaultValMin.isDisplayed();
        view[5] = adminTestItemsPage.testItemDefaultValMax.isDisplayed();
        view[6] = adminTestItemsPage.testItemEditCreatedDate.isDisplayed();
        view[7] = adminTestItemsPage.testItemSaveEntity.isDisplayed();
        for (boolean value : view){
            assertTrue(value);
        }
    }
    @Then("User should see how many test item on page and totaly how many test items are exist")
    public void user_should_see_how_many_test_item_on_page_and_totaly_how_many_test_items_are_exist() {
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemTestItemCount,7);
        js.executeScript("arguments[0].scrollIntoView();",adminTestItemsPage.testItemTestItemCount);
        assertTrue(adminTestItemsPage.testItemTestItemCount.isDisplayed());
    }
    @When("User click on random view button")
    public void user_click_on_random_view_button() {
        js.executeScript("arguments[0].click()",adminTestItemsPage.selectTestItemByLineView(faker.number().numberBetween(1,20)));
    }
    @Then("User should see all fields")
    public void user_should_see_all_fields() {
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemViewIdHeader,5);
        boolean[] viewCheck = new boolean[8];
        viewCheck[0] = adminTestItemsPage.testItemViewIdHeader.isDisplayed();
        viewCheck[1] = adminTestItemsPage.testItemHeader.isDisplayed();
        viewCheck[2] = adminTestItemsPage.testItemDateHeader.isDisplayed();
        viewCheck[3] = adminTestItemsPage.testItemMinValueHeader.isDisplayed();
        viewCheck[4] = adminTestItemsPage.testItemMaxValueHeader.isDisplayed();
        viewCheck[5] = adminTestItemsPage.testItemDescriptionHeader.isDisplayed();
        viewCheck[6] = adminTestItemsPage.adminTestItemViewNameHeader.isDisplayed();
        viewCheck[7] = adminTestItemsPage.viewTestItemPriceHeader.isDisplayed();
        for (boolean value : viewCheck) {
            assertTrue(value);
        }
    }
    @When("User should click on random edit button")
    public void user_should_click_on_random_edit_button() {
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemTestItemCount,7);
        js.executeScript("arguments[0].click()",adminTestItemsPage.selectTestItemByLineEdit(faker.number().numberBetween(1,20)));
    }
    @When("User should edit testItem credentials by using java faker")
    public void user_should_edit_test_item_credentials_by_using_java_faker() {
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemPrice,7);
        adminTestItemsPage.testItemPrice.clear();
        adminTestItemsPage.testItemPrice.sendKeys(faker.number().digits(3));
        adminTestItemsPage.testItemDescription.clear();
        adminTestItemsPage.testItemDescription.sendKeys(faker.book().title());
    }
    @Then("User click save button should see {string}")
    public void user_click_save_button_should_see(String alert) {
        String testItemId = adminTestItemsPage.testItemEditId.getAttribute("value");
        System.out.println(testItemId);
        js.executeScript("arguments[0].click()",adminTestItemsPage.testItemSaveEntity);
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemToastifyAlert,2);
        assertEquals(alert+testItemId, adminTestItemsPage.testItemToastifyAlert.getText());
    }
    @Then("User filled the credentials except name and when click save button must see {string}")
    public void user_filled_the_credentials_except_name_and_when_click_save_button_must_see(String string) {
        adminTestItemsPage.testItemName.click();
        adminTestItemsPage.testItemPrice.click();
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemNameFieldError,2);
        assertEquals(string,adminTestItemsPage.testItemNameFieldError.getText());
    }
    @Then("User filled the credentials except price must see {string}")
    public void user_filled_the_credentials_except_price_must_see(String string) {
        adminTestItemsPage.testItemDescription.click();
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemPriceFieldError,2);
        assertEquals(string,adminTestItemsPage.testItemPriceFieldError.getText());
    }
    @Then("User filled the credentials but filled price with other than numbers must see {string}")
    public void user_filled_the_credentials_but_filled_price_with_other_than_numbers_must_see(String string) {
        adminTestItemsPage.testItemPrice.sendKeys("aaa");
        ReusableMethods.waitForVisibility(adminTestItemsPage.testItemPriceFieldError,2);
        assertEquals(string,adminTestItemsPage.testItemPriceFieldError.getText());
    }
}
