package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class RegistrationPageShouldRestrictPassword {

    Registrant registrant = new Registrant();
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Then("user chooses a four digit password from the same type of characters {string}")
    public void user_chooses_a_four_digit_password_from_the_same_type_of_characters(String password) {
        Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
        registrant.setPassword(password);
    }

    @Then("verify password at least four chars")
    public void verify_password_at_least_four_chars() {

        Driver.waitAndSendText(registrationPage.newPasswordConfirmationTextBox, "");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(registrationPage.passwordIsAtLeastFourCharText.isDisplayed());

    }

    @Then("user enters password at least as one uppercase {string}")
    public void user_enters_password_at_least_as_one_uppercase(String password) {
     Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
   registrant.setPassword(password);
    }
    @Then("verify the level chart change accordingly")
    public void verify_the_level_chart_change_accordingly() {

     Assert.assertTrue(registrationPage.passwordStrongLevel1.isDisplayed());
    }

    @Then("user enters char as special {string}")
    public void user_enters_char_as_special(String password) {
        Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
        registrant.setPassword(password);
    }
    @Then("verify the level bar change accordingly")
    public void verify_the_level_bar_change_accordingly() {
        Assert.assertTrue(registrationPage.passwordStrongLevel1.isDisplayed());
    }
    @Then("user enters char as digit {string}")
    public void user_enters_char_as_digit(String password) {
        Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
        registrant.setPassword(password);
    }
    @Then("verify the level bar level change accordingly")
    public void verify_the_level_bar_level_change_accordingly() throws IOException {
        ReusableMethods.getScreenshot("registrationPage");
        Assert.assertTrue(registrationPage.passwordStrongLevel1.isDisplayed());
    }
    @Then("user enters char at least seven digit password {string}")
    public void user_enters_char_at_least_seven_digit_password(String password) {
        Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
        registrant.setPassword(password);
    }
    @Then("verify at least {int} chars for strong password")
    public void verify_at_least_chars_for_strong_password(Integer int1) {
        Assert.assertTrue(registrationPage.passwordStrongestLevel.isDisplayed());
    }

}
