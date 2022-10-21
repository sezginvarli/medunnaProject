package stepdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class Fatih_SSNFirstnameLastnameStepDefs {

    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigReader.getProperty("registration_page_url"));
    }

    @Given("Enter a {string} number")
    public void enter_a_number(String ssn) {
        registrationPage.ssnTextBox.sendKeys(ssn);
    }

    @When("user clicks enter")
    public void user_clicks_enter() {
        ReusableMethods.waitFor(1);
        registrationPage.ssnTextBox.sendKeys(Keys.ENTER);
    }

    @Then("user does not see any error messages")
    public void user_does_not_see_any_error_messages() {
        ReusableMethods.waitFor(2);
        Assert.assertEquals(0, Driver.getDriver().findElements(By.xpath("//div[text()='Your SSN is required.']")).size());
    }

    @Then("user see any error messages")
    public void user_see_any_error_messages() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.YourSSnIsInvalid.isDisplayed());

    }

    @Then("user see an error messages")
    public void user_see_an_error_messages() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.YourSSnIsRequired.isDisplayed());

    }
    @Then("user see an error  {string}")
    public void user_see_an_error(String message) {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.YourFirstNameIsRequired.getText().contains(message));
    }
    @Then("user close the page")
    public void user_close_the_page() {
        Driver.getDriver().close();
    }
    @Given("Enter a {string} firstname")
    public void enter_a_firstname(String firstname) {
        registrationPage.firstNameTextBox.sendKeys(firstname);
    }
    @Then("user should not see any error messages")
    public void user_should_not_see_any_error_messages() {
        ReusableMethods.waitFor(2);
        Assert.assertEquals(0, Driver.getDriver().findElements(By.xpath("//div[text()='Your FirstName is required.']")).size());
    }
    @Given("Enter {string} lastname")
    public void enter_lastname(String lastname) {
        registrationPage.lastNameTextBox.sendKeys(lastname);
    }
    @When("user clicks username box")
    public void user_clicks_username_box() {
        ReusableMethods.waitFor(1);
        registrationPage.usernameTextBox.click();
    }

}


