package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminPhysicianPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class PhysiciansSVStepDefinitions {
    AdminPhysicianPage adminPhysicianPage = new AdminPhysicianPage();
    Faker faker;
    Actions actions;

    @Then("user clicks on Items and Titles button")
    public void user_clicks_on_items_and_titles_button() throws InterruptedException {
        Thread.sleep(3000);
        JSUtils.clickElementByJS(adminPhysicianPage.itemsAndTitlesButton);
    }

    @Then("user clicks on Physician button")
    public void user_clicks_on_physician_button() {
        ReusableMethods.waitFor(2);
        adminPhysicianPage.physicianButton.click();
    }

    @Then("user clicks on Create a new Physician button")
    public void user_clicks_on_create_a_new_physician_button() {
        adminPhysicianPage.createanewphysicianButton.click();
    }

    @Then("user clicks on Use Search button")
    public void user_clicks_on_use_search_button() {
        adminPhysicianPage.useSearchButton.click();
    }

    @Then("user clicks Search User Button")
    public void user_clicks_search_user_button() {
        adminPhysicianPage.searchUserButton.click();

    }

    @When("user provides valid {string} id in SSN box")
    public void user_provides_valid_id_in_ssn_box(String ssn) {
        adminPhysicianPage.searchSSNBox.sendKeys(ssn);
    }

    @Then("user views an existing registered person")
    public void verify_the_appointment_is_updated_successfully() {

        String appointmentEditSuccessMessage = Driver.waitForVisibility(adminPhysicianPage.toastifyAllert, 3).getText();
        Assert.assertTrue(appointmentEditSuccessMessage.contains("User found with search SSN"));

    }

    @Then("user verifies First Name box is populated")
    public void user_verifies_first_name_box_is_populated() {
        adminPhysicianPage.firstName.isDisplayed();
    }

    @Then("user verifies Last Name box is populated")
    public void user_verifies_last_name_box_is_populated() {
        adminPhysicianPage.lastName.isDisplayed();
    }

    @Then("user verifies birthDate box is populated")
    public void user_verifies_birth_date_box_is_populated() {
        adminPhysicianPage.birthDate.isDisplayed();
    }

    @Then("user verifies Phone box is populated")
    public void user_verifies_phone_box_is_populated() {
        adminPhysicianPage.phoneBox.isDisplayed();
    }

    @Given("user selects specialty dropdown menu")
    public void user_clicks_on_specialty_dropdown_menu() {
        Select select = new Select(adminPhysicianPage.specialityDropdownButton);
        select.selectByValue("FAMILY_MEDICINE");

    }

    @Then("user verifies specialty is provided")
    public void user_verifies_specialty_is_provided() {

    }

    @Given("user clicks on Choose File button")
    public void user_clicks_on_choose_file_button() {
        //  JSUtils.clickElementByJS(adminPhysicianPage.chooseFileButton);
    }


    @When("user selects a picture of doctor")
    public void user_selects_a_picture_of_doctor() {
        String filePath = "C:\\Users\\win10\\Untitled.png";
        adminPhysicianPage.chooseFileButton.sendKeys(filePath);

    }

    @Then("user verifies picture of doctor is loaded")
    public void user_verifies_picture_of_doctor_is_loaded() {
        adminPhysicianPage.imageCheck.isDisplayed();
    }


    @Given("user provides a valid {string}")
    public void user_provides_a_valid(String exam_fee) {
        adminPhysicianPage.examFee.sendKeys(exam_fee);
        Driver.wait(2);

        String actualExamfee = adminPhysicianPage.examFee.getAttribute("value");
        Assert.assertEquals(exam_fee, actualExamfee);
    }

    @Then("user saves the records")
    public void user_saves_the_records() {
       JSUtils.clickElementByJS(adminPhysicianPage.saveButton);

    }

}