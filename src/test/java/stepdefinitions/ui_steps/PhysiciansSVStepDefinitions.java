package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminPhysicianPage;
import utilities.ReusableMethods;

public class PhysiciansSVStepDefinitions {

    AdminPhysicianPage adminPhysicianPage= new AdminPhysicianPage();

    Faker faker;

    Select select;


    @When("user clicks on Items&Titles button")
    public void user_clicks_on_items_titles_button() {
       adminPhysicianPage.itemsAndTitlesButton.click();
    }
    @When("user clicks on Physician button")
    public void user_clicks_on_physician_button() {
        ReusableMethods.waitFor(2);
        adminPhysicianPage.physicianButton.click();
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
       String expectedExistingSSN= "User found with search SSN";
        Assert.assertEquals(expectedExistingSSN, adminPhysicianPage.existingSSN.getText());
    }

}
