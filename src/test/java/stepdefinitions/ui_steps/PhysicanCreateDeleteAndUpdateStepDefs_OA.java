package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @When("user fill the required credentials")
    public void user_fill_the_required_credentials() {
        ReusableMethods.waitForVisibility(adminPhysicianPage.firstName,10);
        adminPhysicianPage.firstName.clear();
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
        select3.selectByIndex(4);
        Select select4 = new Select(adminPhysicianPage.countryDropDown);
        select4.selectByIndex(4);
        ReusableMethods.waitFor(3);
        adminPhysicianPage.backButton.click();
    }
    @When("user click on save button and should see {string}")
    public void user_click_on_save_button_and_should_see(String string) {

    }
    @Then("user refresh the page and click created date and in first place must see the created physician")
    public void user_refresh_the_page_and_click_created_date_and_in_first_place_must_see_the_created_physician() {

    }
}
