package stepdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomeAndSigninPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.openqa.selenium.Keys.TAB;

public class HomePageSigninStepDefs {

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
    @Then("Verify that remember me checkbox is clickable")
    public void verify_that_remember_me_checkbox_is_clickable() {
        homeAndSigninPage.rememberMeCheckBox.click();
        Assert.assertTrue(homeAndSigninPage.rememberMeCheckBox.isSelected());
    }
    @When("User clicks on Did you forget your password? text box")
    public void user_clicks_on_did_you_forget_your_password_text_box() {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(homeAndSigninPage.userNameTextArea)
                .sendKeys(TAB).sendKeys(TAB).sendKeys(TAB).sendKeys(Keys.ENTER)
                .perform();
    }
    @Then("User verifies that Reset your password? Header is visible")
    public void user_verifies_that_reset_your_password_header_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(homeAndSigninPage.resetYourPassword.isDisplayed());
    }
    @Then("User clicks on email text box")
    public void user_clicks_on_email_text_box() {
        homeAndSigninPage.emailTextArea.click();
    }
    @Then("User enters a {string} address which was used to register")
    public void user_enters_a_address_which_was_used_to_register(String email) {
        homeAndSigninPage.emailTextArea.sendKeys(email);
    }
    @Then("User clicks on Reset password button")
    public void user_clicks_on_reset_password_button() {
        homeAndSigninPage.resetPassword.click();
    }
    @Then("Verifies that Check your emails for details on how to reset your password is visible")
    public void verifies_that_check_your_emails_for_details_on_how_to_reset_your_password_is_visible() {
        Assert.assertTrue(homeAndSigninPage.checkYourEmail.isDisplayed());
    }
    @When("User Verifies that sign-in header is visible")
    public void user_verifies_that_sign_in_header_is_visible() {
        Driver.wait(3);
        Assert.assertTrue(homeAndSigninPage.signinHeaderVisible.isEnabled());

    }
    @When("User verifies You don't have an account yet? Register a new account is visible")
    public void user_verifies_you_don_t_have_an_account_yet_register_a_new_account_is_visible() {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(homeAndSigninPage.userNameTextArea)
                .sendKeys(TAB).sendKeys(TAB).sendKeys(TAB).sendKeys(TAB)
                .perform();
        Assert.assertTrue(homeAndSigninPage.noAccount.isDisplayed());
    }
    @When("User clicks on Register a new account")
    public void user_clicks_on_register_a_new_account() {
         homeAndSigninPage.registerNewAccount.click();
         Driver.wait(3);


    }
    @Then("User verifies that Registration Page is visible")
    public void user_verifies_that_registration_page_is_visible() {
        Driver.wait(3);
       Assert.assertTrue( homeAndSigninPage.registrationPage.isEnabled());
    }
    @When("User verifies that {string} button exists on the page")
    public void user_verifies_that_button_exists_on_the_page(String string) throws InterruptedException {
        Thread.sleep(3000);
        homeAndSigninPage.cancel.click();
        Assert.assertTrue(homeAndSigninPage.cancel.isDisplayed());
    }
    @When("User clicks on username input box second")
    public void user_clicks_on_username_input_box_second() {
        homeAndSigninPage.userNameTextArea.click();
    }
    @Then("User enters a invalid {string} username")
    public void user_enters_a_invalid_username(String wusername) {
        homeAndSigninPage.userNameTextArea.sendKeys(wusername);
    }
    @Then("clicks on password input box")
    public void clicks_on_password_input_box() {
       homeAndSigninPage.passwordTextArea.click();
    }
    @Then("enters a valid {string} password")
    public void enters_a_valid_password(String password) {
      homeAndSigninPage.passwordTextArea.sendKeys(password);
    }
    @Then("clicks on sign-in button")
    public void clicks_on_sign_in_button() {
        homeAndSigninPage.signInButton.click();
    }
    @When("verifies that Authentication information not correct is displayed")
    public void verifies_that_authentication_information_not_correct_is_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(homeAndSigninPage.authentication.isDisplayed());
    }



    @Then("user close the application")
    public void user_close_the_application() {

    }


}




