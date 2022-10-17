package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomeAndSigninPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePageStepDefs {

    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    @Given("user navigates to URL {string}")
    public void user_navigates_to_url(String string) {
        Driver.getDriver().get(string);
    }
    @Given("User clicks on account drop-down-menu button")
    public void user_clicks_on_account_drop_down_menu_button() {
        ReusableMethods.waitForClickablility(homeAndSigninPage.signInAccountMenu,3).click();
    }
    @When("User clicks on sign-in button")
    public void user_clicks_on_sign_in_button() {
        homeAndSigninPage.signInLink.click();
    }
    @When("user clicks on username input box")
    public void user_clicks_on_username_input_box() {
        homeAndSigninPage.userNameTextArea.click();
    }
    @Then("user enters a valid {string} username")
    public void user_enters_a_valid_username(String username) {
        homeAndSigninPage.userNameTextArea.sendKeys(username);
    }
    @Then("user clicks on password input box")
    public void user_clicks_on_password_input_box() {
        homeAndSigninPage.passwordTextArea.click();
    }
    @Then("user enters a valid {string} password")
    public void user_enters_a_valid_password(String password) {
        homeAndSigninPage.passwordTextArea.sendKeys(password);
    }
    @Then("user clicks on second sign-in button")
    public void user_clicks_on_second_sign_in_button() {
        homeAndSigninPage.signInButton.click();
    }
    @When("user verifies that signed-in {string} is done successfully")
    public void user_verifies_that_signed_in_is_done_successfully(String signedInUserName) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(homeAndSigninPage.signInVerifyButton.isDisplayed());
    }
    @Then("user close the application")
    public void user_close_the_application() {

    }
}




