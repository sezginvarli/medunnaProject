package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomeAndSigninPage;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.TXTWriter.saveUiRegistrantsData;

public class RegistrationShouldBeSuccessfulWithUsingEmailAndUsernameStepDefsUI {

    HomeAndSigninPage homePage=new HomeAndSigninPage();
    RegistrationPage registrationPage=new RegistrationPage();
    Registrant registrant=new Registrant();

    @Given("user goes to the url")
    public void user_goes_to_the_url() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));

    }

    @When("user clicks on the register section at the dropdown")
    public void user_clicks_on_the_register_section_at_the_dropdown() {
        homePage.signInAccountMenu.click();
        homePage.register.click();
    }
    @Then("user verifies the registration page")
    public void user_verifies_the_registration_page() {
        Assert.assertTrue(registrationPage.registrationText.isDisplayed());
    }

    @And("user closes the browser")
    public void userClosesTheBrowser() {
        Driver.closeDriver();
    }

    @Then("user verifies Registration Saved message")
    public void userVerifiesRegistrationSavedMessage() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
    }
    @Then("user clicks register button and saves the records")
    public void userClicksRegisterButtonAndSavesTheRecords() {
        ReusableMethods.waitFor(2);
        registrationPage.registerButton2.click();
        saveUiRegistrantsData(registrant);
    }

    @Then("user hit the enter")
    public void userHitTheEnter() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }

    @And("user verifies Your username is required message")
    public void userVerifiesYourUsernameIsRequiredMessage() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.YourUserNameIsRequired.isDisplayed());
    }

    @And("user verifies Your username is invalid message")
    public void userVerifiesYourUsernameIsInvalidMessage() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.YourUsernameIsInvalid.isDisplayed());
    }

    @When("user enters their username as {string}")
    public void userEnterTheirUsernameAs(String username) {
        registrationPage.usernameTextBox.sendKeys(username);
    }

    @Then("user verifies there is no any error message for username")
    public void user_verifies_there_is_no_any_error_message_for_username() {

        Assert.assertTrue(registrationPage.validUsername.isDisplayed());

    }
    @Then("user verifies there is no any error message for email")
    public void user_verifies_there_is_no_any_error_message_for_email() {

        ReusableMethods.waitFor(1);
        Assert.assertTrue(registrationPage.noEmailError.isDisplayed());

    }

    @When("user enters their email as {string}")
    public void userEntersTheirEmailAs(String email) {
        registrationPage.emailTextBox.sendKeys(email);
    }

    @Then("user verifies This field is invalid message")
    public void userVerifiesThisFieldIsInvalidMessage() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(registrationPage.thisFieldIsInvalid.isDisplayed());
    }

    @And("user verifies Your email is required message")
    public void userVerifiesYourEmailIsRequiredMessage() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(registrationPage.YourUserEmailIsRequired.isDisplayed());
    }
}

