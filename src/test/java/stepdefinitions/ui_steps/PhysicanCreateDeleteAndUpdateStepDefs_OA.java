package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
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
    String deletedPhysicianID = "";
    String namePhysician = "";
    String editedNamePhysician = "";
    String getDeletedPhysicianMessage = "";
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
        ReusableMethods.waitForVisibility(adminPhysicianPage.visibilityOfId,60);
        adminPhysicianPage.selectByLineEdit(3).click();
    }
    @When("user click on back button")
    public void user_click_on_back_button() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.backButton,25);
        js.executeScript("arguments[0].click()",adminPhysicianPage.backButton);
        ReusableMethods.waitFor(2);
        adminPhysicianPage.selectByLineEdit(3).click();
    }
    @When("user fill the required credentials")
    public void user_fill_the_required_credentials() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.firstName,15);
        adminPhysicianPage.firstName.clear();
//        adminPhysicianPage.firstName.sendKeys("Kane");
        String firstName = faker.name().firstName();
        adminPhysicianPage.firstName.sendKeys(firstName);
        namePhysician = firstName;
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
        select3.selectByIndex(6);
        Select select4 = new Select(adminPhysicianPage.countryDropDown);
        select4.selectByIndex(3);
        ReusableMethods.waitFor(3);
    }
    @When("user fill the required field credentials")
    public void user_fill_the_required_field_credentials() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.firstName,15);
//        adminPhysicianPage.firstName.sendKeys("Kane");
        String firstName = faker.name().firstName();
        adminPhysicianPage.firstName.sendKeys(firstName);
        editedNamePhysician = firstName;
        adminPhysicianPage.lastName.sendKeys(faker.name().lastName());
        adminPhysicianPage.birthDate.sendKeys("11.03.1990");
        adminPhysicianPage.phone.sendKeys("147-587-5050");
        adminPhysicianPage.address.sendKeys(faker.address().streetAddress());
        adminPhysicianPage.description.sendKeys("Intern Doctor");
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
        Select select3 = new Select(adminPhysicianPage.selectUserDropDown);
        select3.selectByVisibleText("orhanadmin86_87:873-56-4332");
        Select select4 = new Select(adminPhysicianPage.countryDropDown);
        select4.selectByIndex(5);
        ReusableMethods.waitFor(3);
    }
    @When("user click on save button and should see successfully created message")
    public void user_click_on_save_button_and_should_see_successfully_created_message(){
        adminPhysicianPage.saveButton.click();
        ReusableMethods.waitForVisibility(adminPhysicianPage.alert,7);
        assertTrue(adminPhysicianPage.alert.isDisplayed());
    }
    @Then("user refresh the page and click created date and in first place must see the created physician")
    public void user_refresh_the_page_and_click_created_date_and_in_first_place_must_see_the_created_physician() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        js.executeScript("arguments[0].click()",adminPhysicianPage.createdDate);
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        ReusableMethods.waitFor(7);
        System.out.println(editedNamePhysician);
        assertTrue(adminPhysicianPage.selectByFakerFirstName(editedNamePhysician).isDisplayed());
    }
    @When("user click on save button and should see successfully edited message")
    public void user_click_on_save_button_and_should_see_successfully_edited_message() {
        js.executeScript("arguments[0].click()",adminPhysicianPage.saveButton);
        ReusableMethods.waitForVisibility(adminPhysicianPage.alert,30);
        assertTrue(adminPhysicianPage.alert.isDisplayed());
    }
    @Then("user refresh the page should see edited physician")
    public void user_refresh_the_page_should_see_edited_physician() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        ReusableMethods.waitFor(5);
        assertTrue(adminPhysicianPage.selectByFakerFirstName(namePhysician).isDisplayed());
    }
    @When("user click on click on create physician button")
    public void user_click_on_click_on_create_physician_button() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,50);
        adminPhysicianPage.selectByLineEdit(2).click();
        ReusableMethods.waitForVisibility(adminPhysicianPage.backButton,20);
        js.executeScript("arguments[0].click();", adminPhysicianPage.backButton);
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,30);
        adminPhysicianPage.createNewPhysician.click();
    }
    @When("Admin should see physican in page with scroll down")
    public void admin_should_see_physican_in_page_with_scroll_down() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,20);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].scrollIntoView();", adminPhysicianPage.totalPhysicianNumber);
        ReusableMethods.waitFor(2);
        assertTrue(adminPhysicianPage.totalPhysicianNumber.isDisplayed());
    }
    @When("Admin click on random physician view button")
    public void admin_click_on_random_physician_view_button() {
        js.executeScript("arguments[0].click()",adminPhysicianPage.selectByLineEdit(3));
        ReusableMethods.waitForVisibility(adminPhysicianPage.backButton,10);
        js.executeScript("arguments[0].click()",adminPhysicianPage.backButton);
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,40);
        js.executeScript("arguments[0].click()",adminPhysicianPage.selectByLineView(2));
        ReusableMethods.waitFor(5);
    }
    @Then("Page must include \"First Name,Last Name,Birth Date,Phone,User,Exam Fee etc???")
    public void page_must_include_first_name_last_name_birth_date_phone_user_exam_fee_etc() {
        assertTrue(adminPhysicianPage.viewSSNPlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewFirstNamePlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewLastNamePlace.isDisplayed());
        assertTrue(adminPhysicianPage.viewPhonePlace.isDisplayed());
        try {
            assertFalse(Driver.getDriver().findElement(By.xpath("//*[text() = 'Exam Fee']")).isDisplayed());
            ReusableMethods.waitFor(5);
        }catch (Exception e) {
            assertFalse(false);
        }
        ReusableMethods.waitFor(2);
    }
    @When("Admin should click  {string} button which is created by admin")
    public void admin_should_click_button_which_is_created_by_admin(String string) {
        ReusableMethods.waitForVisibility(adminPhysicianPage.createdDate,20);
        ReusableMethods.waitFor(1);
        adminPhysicianPage.createdDate.click();
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForVisibility(adminPhysicianPage.totalPhysicianNumber,60);
        ReusableMethods.waitFor(5);
        deletedPhysicianID = adminPhysicianPage.deleteFirstElementByCreatedBy.getText();
        adminPhysicianPage.selectByLineDelete(1).click();
        ReusableMethods.waitFor(2);
        adminPhysicianPage.deleteConfirmButton.click();
        ReusableMethods.waitFor(2);
        getDeletedPhysicianMessage = adminPhysicianPage.alert.getText();

    }
    @Then("Admin should see deleted message")
    public void admin_should_see_deleted_message() {
        ReusableMethods.waitFor(3);
        assertEquals(getDeletedPhysicianMessage,"A Physician is deleted with identifier "+deletedPhysicianID);
    }
    @Then("when page is refreshed admin couldn't see the physician")
    public void when_page_is_refreshed_admin_couldn_t_see_the_physician() {
        try {
            assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+deletedPhysicianID+"']")).isDisplayed());
        }catch (Exception e){
            assertFalse(false);
        }
    }
    @When("Admin should click Create a new Physician button")
    public void admin_should_click_create_a_new_physician_button() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.createNewPhysician,20);
        adminPhysicianPage.createNewPhysician.click();
    }
    @Then("Admin must see {string}")
    public void admin_must_see(String string) {
        ReusableMethods.waitForVisibility(adminPhysicianPage.createOrEditPhysicianText,10);
        assertTrue(adminPhysicianPage.createOrEditPhysicianText.isDisplayed());
    }
    @When("Admin fill the required credentials except First Name")
    public void admin_fill_the_required_credentials_except_first_name() {
        adminPhysicianPage.lastName.sendKeys(faker.name().lastName());
        adminPhysicianPage.examFee.sendKeys(faker.number().digits(3));
        adminPhysicianPage.phone.sendKeys("555-555-5555");
        adminPhysicianPage.birthDate.sendKeys("12-10-1990");
    }
    @Then("Admin click on save button and should see {string}")
    public void admin_click_on_save_button_and_should_see(String string) {
        js.executeScript("arguments[0].click()",adminPhysicianPage.saveButton);
        ReusableMethods.waitFor(2);
        assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+string+"']")).isDisplayed());
    }
    @Then("Admin click on save button and should see date error message")
    public void admin_click_on_save_button_and_should_see_date_error_message() {
        js.executeScript("arguments[0].click()",adminPhysicianPage.saveButton);
        ReusableMethods.waitFor(2);
        assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+adminPhysicianPage.dateErrorMessage.getText()+"']")).isDisplayed());
    }
    @When("Admin fill the required credentials except Last Name")
    public void admin_fill_the_required_credentials_except_last_name() {
        adminPhysicianPage.firstName.sendKeys(faker.name().firstName());
        adminPhysicianPage.lastName.clear();
    }
    @When("Admin fill the required credentials except Exam Fee")
    public void admin_fill_the_required_credentials_except_exam_fee() {
        adminPhysicianPage.examFee.clear();
        adminPhysicianPage.lastName.sendKeys(faker.name().lastName());
    }
    @When("Admin fill the required credentials except Phone")
    public void admin_fill_the_required_credentials_except_phone() {
        adminPhysicianPage.phone.clear();
        adminPhysicianPage.examFee.sendKeys(faker.number().digits(3));
    }
    @When("Admin fill the required credentials but;filled date outside of the stated dates")
    public void admin_fill_the_required_credentials_but_filled_date_outside_of_the_stated_dates() {
        adminPhysicianPage.birthDate.sendKeys("12-10-2005");
    }
}
