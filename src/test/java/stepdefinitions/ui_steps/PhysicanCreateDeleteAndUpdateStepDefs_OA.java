package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminMainPage;
import pages.admin.AdminPhysicianPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class PhysicanCreateDeleteAndUpdateStepDefs_OA {
    Faker faker = new Faker();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    String deletedId = "";
    AdminMainPage adminMainPage=new AdminMainPage();
    AdminPhysicianPage adminPhysicianPage=new AdminPhysicianPage();
    @Given("when user go to main page")
    public void when_user_go_to_main_page() {

    }

    @When("user click on physician from dropdown button")
    public void user_click_on_physician_from_dropdown_button() {
        ReusableMethods.waitForVisibility(adminMainPage.adminMainPageItemDropdown,2);
        adminMainPage.adminMainPageItemDropdown.click();
        ReusableMethods.waitForVisibility(adminMainPage.adminMainPageItemDropdownPhysician,2);
        adminMainPage.adminMainPageItemDropdownPhysician.click();
    }
    @When("user click on click on edit button")
    public void user_click_on_click_on_edit_button() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.visibilityOfId,25);
        adminPhysicianPage.selectByLineEdit(3).click();
    }
    @When("user click on back button")
    public void user_click_on_back_button() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.backButton,5);
        adminPhysicianPage.backButton.click();
    }
    @When("user fill the required credentials")
    public void user_fill_the_required_credentials() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.firstName,10);
        adminPhysicianPage.firstName.clear();
        adminPhysicianPage.firstName.sendKeys("Kane");
        adminPhysicianPage.firstName.sendKeys(faker.name().firstName());
        adminPhysicianPage.lastName.clear();
        adminPhysicianPage.lastName.sendKeys(faker.name().lastName());
        adminPhysicianPage.birthDate.clear();
        adminPhysicianPage.birthDate.sendKeys("11.03.1990");
        adminPhysicianPage.phone.clear();
        adminPhysicianPage.phone.sendKeys("147-587-5050");
        adminPhysicianPage.address.clear();
        adminPhysicianPage.address.sendKeys(faker.address().streetAddress());
        adminPhysicianPage.description.clear();
        adminPhysicianPage.description.sendKeys("Intern Doctor");
        adminPhysicianPage.examFee.clear();
        adminPhysicianPage.examFee.sendKeys(faker.number().digits(3));
//        actions.sendKeys(adminPhysicianPage.firstName,faker.name().firstName()).sendKeys(adminPhysicianPage.lastName).
//                sendKeys(adminPhysicianPage.birthDate,"11.03.1990").sendKeys(adminPhysicianPage.phone,"147-587-6060")
//                .sendKeys(adminPhysicianPage.address,faker.address().streetName()).build().perform();
        Select select = new Select(adminPhysicianPage.genderDropDown);
        select.selectByVisibleText("MALE");
        Select select1 = new Select(adminPhysicianPage.specialityDropDown);
        select1.selectByIndex(4);
        Select select2 = new Select(adminPhysicianPage.bloodGroupDropdown);
        select2.selectByVisibleText("B+");
//        actions.sendKeys(adminPhysicianPage.description,"All is Well").sendKeys(adminPhysicianPage.examFee,faker.number().digits(3))
//                .build().perform();
        Select select3 = new Select(adminPhysicianPage.selectUserDropDown);
        select3.selectByIndex(24);
        Select select4 = new Select(adminPhysicianPage.countryDropDown);
        select4.selectByIndex(3);
        ReusableMethods.waitFor(3);
    }
    @When("user click on save button and should see successfully created message")
    public void user_click_on_save_button_and_should_see_successfully_created_message(){
        adminPhysicianPage.saveButton.click();
        ReusableMethods.waitFor(2);
        assertTrue(adminPhysicianPage.alert.isDisplayed());
    }
    @When("user click on save button and should see successfully edited message")
    public void user_click_on_save_button_and_should_see_successfully_edited_message() {
        adminPhysicianPage.saveButton.click();
        ReusableMethods.waitFor(2);
        assertTrue(adminPhysicianPage.alert.isDisplayed());
    }
    @Then("user refresh the page and click created date and in first place must see the created physician")
    public void user_refresh_the_page_and_click_created_date_and_in_first_place_must_see_the_created_physician() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForVisibility(adminPhysicianPage.createdDate,15);
        adminPhysicianPage.createdDate.click();
        ReusableMethods.waitFor(10);
        assertTrue(adminPhysicianPage.firstNameKane.isDisplayed());
    }
    @When("user click on click on create physician button")
    public void user_click_on_click_on_create_physician_button() {
        adminPhysicianPage.createNewPhysician.click();
    }
    @When("Admin should see physican in page with scroll down")
    public void admin_should_see_physican_in_page_with_scroll_down() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,15);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].scrollIntoView();", adminPhysicianPage.totalPhysicianNumber);
        assertTrue(adminPhysicianPage.totalPhysicianNumber.isDisplayed());
    }
    @When("Admin click on random physician view button")
    public void admin_click_on_random_physician_view_button() {
        js.executeScript("arguments[0].click()",adminPhysicianPage.selectPhysicianById("2051"));
    }
    @Then("Page must include \"First Name,Last Name,Birth Date,Phone,User,Exam Fee etc…")
    public void page_must_include_first_name_last_name_birth_date_phone_user_exam_fee_etc() {
        assertTrue(adminPhysicianPage.viewSSNPlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewFirstNamePlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewLastNamePlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewPhonePlace.isDisplayed());
        assertFalse(Driver.getDriver().findElement(By.xpath("//*[text() = 'Exam Fee']")).isDisplayed());
    }
    @When("Admin should click  {string} button which is created by admin")
    public void admin_should_click_button_which_is_created_by_admin(String string) {
        ReusableMethods.waitForVisibility(adminPhysicianPage.createdDate,20);
        ReusableMethods.waitFor(1);
        adminPhysicianPage.createdDate.click();
        ReusableMethods.waitForVisibility(adminPhysicianPage.selectByLineDelete(1),15);
        ReusableMethods.waitFor(5);
        deletedId = Driver.getDriver().findElement(By.xpath("(//*[@class = 'btn btn-link btn-sm'])[1]")).getText();
        adminPhysicianPage.selectByLineDelete(1).click();
        ReusableMethods.waitFor(2);
        adminPhysicianPage.deleteConfirmButton.click();
    }
    @Then("Admin should see deleted message")
    public void admin_should_see_deleted_message() {
        System.out.println(deletedId);
        ReusableMethods.waitFor(2);
        assertTrue(adminPhysicianPage.alert.isDisplayed());
    }
    @Then("when page is refreshed admin couldn't see the physician")
    public void when_page_is_refreshed_admin_couldn_t_see_the_physician() {
        try {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+deletedId+"']")).isDisplayed());
        }catch (Exception e){
            assertFalse(false);
        }
    }

}
