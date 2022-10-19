package stepdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.AdminMainPage;
import pages.admin.AdminPhysicianPage;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class PhysicanCreateDeleteAndUpdateStepDefs_OA {
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
    @When("user click on click on view button")
    public void user_click_on_click_on_view_button() {
        ReusableMethods.waitFor(15);
        adminPhysicianPage.selectByLineView(3).click();
    }
    @When("user fill the required credentials")
    public void user_fill_the_required_credentials() {

    }
    @When("user click on save button and should see {string}")
    public void user_click_on_save_button_and_should_see(String string) {

    }
    @Then("user refresh the page and click created date and in first place must see the created physician")
    public void user_refresh_the_page_and_click_created_date_and_in_first_place_must_see_the_created_physician() {

    }
}
