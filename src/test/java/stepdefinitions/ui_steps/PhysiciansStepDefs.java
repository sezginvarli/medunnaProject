package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPhysicianPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class PhysiciansStepDefs {

    AdminPhysicianPage adminPhysicianPage = new AdminPhysicianPage();
    Faker faker = new Faker();
    Select select;

    @Given("user clicks on Items&Titles button")
    public void user_clicks_on_items_titles_button() {
        Driver.waitForClickablility(adminPhysicianPage.itemsAndTitlesButton, 3).click();

        ReusableMethods.waitFor(2);
        adminPhysicianPage.physicianButton.click();

    }

    @When("user clicks on Physician button")
    public void user_clicks_on_physician_button() {


    }

    @When("user clicks on Create a new Physician button")
    public void user_clicks_on_create_a_new_physician_button() {
        adminPhysicianPage.createanewphysicianButton.click();
    }

    @When("user clicks on Use Search button")
    public void user_clicks_on_use_search_button() {
        adminPhysicianPage.useSearchButton.click();
    }

    @When("user provides valid {string} id in SSN box")
    public void user_provides_valid_id_in_ssn_box(String string) {
        adminPhysicianPage.searchSSNBox.sendKeys(faker.idNumber().ssnValid());
    }

    @When("user clicks Search User Button")
    public void user_clicks_search_user_button() {
        adminPhysicianPage.searchUserButton.click();
    }

    @Then("user views an existing registered person")
    public void user_views_an_existing_registered_person() {
        String expectedExistingSSN = "User found with search SSN";
        Assert.assertEquals(expectedExistingSSN, adminPhysicianPage.existingSSN.getText());
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

    @Given("user clicks on specialty dropdown menu")
    public void user_clicks_on_specialty_dropdown_menu() {
        adminPhysicianPage.specialityDropdownButton.click();
    }

    @When("users selects specialty")
    public void users_selects_specialty() {
        adminPhysicianPage.specialityDropdownButton.click();
        select.selectByValue("FAMILY_MEDICINE");
    }

    @Then("user verifies specialty is provided")
    public void user_verifies_specialty_is_provided() {
        adminPhysicianPage.specialityDropdownButton.isSelected();
    }

    @Given("user clicks on Choose File button")
    public void user_clicks_on_choose_file_button() {
        adminPhysicianPage.chooseFileButton.click();
    }

    @Then("user verifies folder is opened")
    public void user_verifies_folder_is_opened() {

    }

    @When("user selects a picture of doctor")
    public void user_selects_a_picture_of_doctor() {

    }

    @When("user clicks open button on folder")
    public void user_clicks_open_button_on_folder() {

    }

    @Then("user verifies picture of doctor is loaded")
    public void user_verifies_picture_of_doctor_is_loaded() {
        adminPhysicianPage.image.isDisplayed();
    }

    @Given("user clicks on User dropdown menu")
    public void user_clicks_on_user_dropdown_menu() {
        adminPhysicianPage.userDropdownButton.click();
    }

    @Given("user provides a valid {string}")
    public void user_provides_a_valid(String string) {
        adminPhysicianPage.examFeeButton.sendKeys(string);
    }

    @Then("user verifies exam fee is provided")
    public void user_verifies_exam_fee_is_provided() {
        Assert.assertTrue(adminPhysicianPage.examFeeButton.getText().length() != 0);
    }

    @When("user chooses an existing user")
    public void user_chooses_an_existing_user() {
        select.selectByVisibleText(faker.random().toString());
    }

    @Then("user verifies an existing user is choosed")
    public void user_verifies_an_existing_user_is_choosed() {
        adminPhysicianPage.userDropdownButton.isSelected();
    }


}
