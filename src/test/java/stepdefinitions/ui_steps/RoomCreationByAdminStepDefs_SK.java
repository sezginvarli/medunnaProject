package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminMainPage;
import pages.admin.AdminRoomPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class RoomCreationByAdminStepDefs_SK {
    AdminRoomPage adminRoomPage = new AdminRoomPage();
    AdminMainPage adminMainPage = new AdminMainPage();

    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());

    @Given("admin clicks on Items&Titles button")
    public void admin_clicks_on_items_titles_button() {
        Driver.waitAndClick(adminMainPage.itemsAndTitles);
    }
    @When("admin clicks on Room button")
    public void admin_clicks_on_room_button() {
        Driver.waitAndClick(adminMainPage.roomDropDown);
    }
    @Then("admin clicks on create a new room button")
    public void admin_clicks_on_create_a_new_room_button() {
        Driver.waitAndClick(adminRoomPage.createNewRoom);
    }
    @Then("admin verify that Create or edit Room is visible")
    public void admin_verify_that_create_or_edit_room_is_visible() {
        Assert.assertTrue(adminRoomPage.createEditRoom.isDisplayed());
    }

    @Then("admin enters a unique number")
    public void admin_enters_a_unique_number() {
        adminRoomPage.roomNumberBox.click();
        String number = ""+ faker.number().numberBetween(119283,9999999);
        adminRoomPage.roomNumberBox.sendKeys(number);

    }
    @Then("admin verify that room number is required")
    public void admin_verify_that_room_number_is_required() {
       adminRoomPage.roomNumberBox.clear();
       adminRoomPage.roomNumberBox.sendKeys(Keys.ENTER);
       Assert.assertTrue(adminRoomPage.verifyThisFieldIsRequired.isDisplayed());
    }
    @Then("admin clicks on room type")
    public void admin_clicks_on_room_type() {
        adminRoomPage.roomNumberBox.sendKeys("678768");
        adminRoomPage.roomTypeDropDown.click();

    }
    @Then("admin verifies exist room types")
    public void admin_verifies_exist_room_types() throws InterruptedException {
        Thread.sleep(3000);
        WebElement roomTypes = adminRoomPage.roomTypeDropDown;
        Assert.assertTrue(adminRoomPage.roomTypeDropDown.isDisplayed());
        System.out.println(roomTypes.getText());
    }
    @Then("admin select the room type")
    public void admin_select_the_room_type() {
        ReusableMethods.waitFor(3);
        Select select = new Select(adminRoomPage.roomTypeDropDown);
        select.selectByVisibleText("SUITE");
        List<WebElement> allRooms = select.getOptions();
        for(WebElement each: allRooms){
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }
    }
    @Then("admin verifies that room type is required")
    public void admin_verifies_that_room_type_is_required() {
        Assert.assertTrue(adminRoomPage.roomTypeDropDown.isDisplayed());
    }
    @Then("admin clicks on status button")
    public void admin_clicks_on_status_button() throws InterruptedException {
        ReusableMethods.waitFor(2);
        String number = ""+ faker.number().numberBetween(119283,9999999);
        adminRoomPage.roomNumberBox.sendKeys(number);
        adminRoomPage.roomTypeDropDown.sendKeys("DELUXE");
        adminRoomPage.roomStatus.click();
        adminRoomPage.roomPrice.sendKeys(Faker.instance().numerify("1600"));
        adminRoomPage.roomDescription.click();
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(2);
        adminRoomPage.saveButton.click();
        Thread.sleep(3000);

    }
    @Then("admin verifies that status is full")
    public void admin_verifies_that_status_is_full() throws InterruptedException {
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        adminRoomPage.lastPage.click();
        Thread.sleep(3000);
        Assert.assertTrue(adminRoomPage.full.isDisplayed());
    }
    @Then("admin do not clicks on status button")
    public void admin_do_not_clicks_on_status_button() throws InterruptedException {
        adminRoomPage.createNewRoom.click();
        ReusableMethods.waitFor(2);
        String number = ""+ faker.number().numberBetween(119283,9999999);
        adminRoomPage.roomNumberBox.sendKeys(number);
        adminRoomPage.roomTypeDropDown.sendKeys("DELUXE");
        adminRoomPage.roomStatus.sendKeys(Keys.TAB);
        adminRoomPage.roomPrice.sendKeys(Faker.instance().numerify("1600"));
        adminRoomPage.roomDescription.click();
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(2);
        adminRoomPage.saveButton.click();
        Thread.sleep(3000);

    }
    @Then("admin verifies that status is available")
    public void admin_verifies_that_status_is_available() throws InterruptedException {
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        adminRoomPage.lastPage.click();
        Thread.sleep(3000);
        Assert.assertTrue(adminRoomPage.Available.isDisplayed());
    }
    @Then("admin clicks on price button")
    public void admin_clicks_on_price_button() {

        ReusableMethods.waitFor(2);
        adminRoomPage.roomPrice.click();

    }
    @Then("admin enters a valid price")
    public void admin_enters_a_valid_price() throws InterruptedException {
        String price = ""+ faker.number().numberBetween(1000,9999);
        adminRoomPage.roomPrice.sendKeys(price);
        Thread.sleep(3000);

    }
    @Then("admin verifies that price is required")
    public void admin_verifies_that_price_is_required() throws InterruptedException {
        adminRoomPage.roomPrice.clear();
        ReusableMethods.waitFor(3);
        adminRoomPage.roomPrice.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertTrue(adminRoomPage.verifyThisFieldIsRequired.isDisplayed());

    }
    @Then("admin clicks on description button")
    public void admin_clicks_on_description_button() {
        ReusableMethods.waitFor(2);
        String number = ""+ faker.number().numberBetween(119283,9999999);
        adminRoomPage.roomNumberBox.sendKeys(number);
        adminRoomPage.roomTypeDropDown.sendKeys("SUITE");
        adminRoomPage.roomStatus.click();
        adminRoomPage.roomPrice.sendKeys(Faker.instance().numerify("1600"));
        adminRoomPage.roomDescription.click();
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);
        adminRoomPage.createDate.sendKeys(Keys.TAB);

    }
    @Then("admin clicks on save button")
    public void admin_clicks_on_save_button() {
        ReusableMethods.waitFor(2);
        adminRoomPage.saveButton.click();
    }
    @Then("admin verifies that it is not required")
    public void admin_verifies_that_it_is_not_required() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(adminRoomPage.roomIsCreated.isDisplayed());
    }

    @Then("admin clicks on the date button")
    public void admin_clicks_on_the_date_button() {
        //Driver.waitAndClick(adminRoomPage.createDate);
    }

    @Then("admin verifies that date should be current")
    public void admin_verifies_that_date_should_be_current() {

        Driver.waitAndClick(adminRoomPage.createDate);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        adminRoomPage.createDate.sendKeys(sdf.format(date));

    }

    @Then("admin enters a passed date")
    public void admin_enters_a_passed_date() throws InterruptedException {
        ReusableMethods.waitFor(2);
        String number = ""+ faker.number().numberBetween(119283,9999999);
        adminRoomPage.roomNumberBox.sendKeys(number);
        adminRoomPage.roomTypeDropDown.sendKeys("SUITE");
        adminRoomPage.roomStatus.click();
        adminRoomPage.roomPrice.sendKeys(Faker.instance().numerify("1600"));
        adminRoomPage.roomDescription.click();
        Driver.waitAndClick(adminRoomPage.createDate);
//        Select selectDate= new Select(adminRoomPage.createDate);
//        selectDate.selectByValue("10/01/2022");
        adminRoomPage.createDate.sendKeys("09.11.2022");
        Thread.sleep(3000);
        Driver.waitAndClick(adminRoomPage.saveButton);
        Thread.sleep(3000);
        Assert.assertFalse(adminRoomPage.roomIsCreated.isDisplayed());

    }

    @Then("admin can see list of room type")
    public void admin_can_see_list_of_room_type() throws InterruptedException {
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        Driver.waitAndClick(adminRoomPage.lastPage);
        Driver.waitAndClick(adminRoomPage.roomTypeList);
        Assert.assertTrue(adminRoomPage.daycare.isDisplayed());
        Driver.waitAndClick(adminRoomPage.roomTypeList);
        Assert.assertTrue(adminRoomPage.twin.isDisplayed());
    }
    @Then("admin selects a room and clicks edit button")
    public void admin_selects_a_room_and_clicks_edit_button() throws InterruptedException {
        Thread.sleep(3000);
        adminRoomPage.edit.click();
    }
    @Then("admin verifies that a room can be update")
    public void admin_verifies_that_a_room_can_be_update() throws InterruptedException {
        Thread.sleep(3000);
        Driver.waitAndClick(adminRoomPage.saveButton);
        Thread.sleep(3000);
        Assert.assertTrue(adminRoomPage.roomIsCreated.isDisplayed());
    }

}
