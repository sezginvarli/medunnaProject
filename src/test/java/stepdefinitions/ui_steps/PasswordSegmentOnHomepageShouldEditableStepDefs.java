package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomeAndSigninPage;
import pages.RegistrationPage;
import pojos.PasswordChange;
import utilities.ReusableMethods;

public class PasswordSegmentOnHomepageShouldEditableStepDefs {
    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    RegistrationPage registrationPage=new RegistrationPage();
    Faker faker=new Faker();
    PasswordChange passwordChange=new PasswordChange();


    @When("user clicks on the signIn section at the dropdown")
    public void user_clicks_on_the_sign_in_section_at_the_dropdown() {
        homeAndSigninPage.signInAccountMenu.click();
        homeAndSigninPage.signInLink.click();
    }
    @Then("user verifies the Sign in page")
    public void user_verifies_the_sign_in_page() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homeAndSigninPage.signInText.isDisplayed());
    }
    @When("user enters their credentials for signIn and clicks")
    public void user_enters_their_credentials_for_sign_in_and_clicks() {

        homeAndSigninPage.userNameTextArea.sendKeys("erty");
        homeAndSigninPage.passwordTextArea.sendKeys("erty");
        homeAndSigninPage.signInButton.click();
    }
    @Then("user clicks on the Password section at the dropdown")
    public void user_clicks_on_the_password_section_at_the_dropdown() {
        ReusableMethods.waitFor(2);
        homeAndSigninPage.signInAccountMenu.click();
        homeAndSigninPage.passwordDropdown.click();
    }

    @Given("user verifies Password for page")
    public void userVerifiesPasswordForPage() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.passwordText.isDisplayed());
    }
    @Then("user enter their current password as {string}")
    public void user_enter_their_current_password_as(String currentPsw) {
        registrationPage.currentPassword.sendKeys(currentPsw);
    }
    @Then("user enter their new password as {string}")
    public void user_enter_their_new_password_as(String newPsw) {
        //newPsw=faker.internet().password(9,15,true,true,true);
        registrationPage.newPassword.sendKeys(newPsw);

    }
    @Then("user enter their confirmation password as {string}")
    public void user_enter_their_confirmation_password_as(String confirmPsw) {
//        newPsw=confirmPsw;
        registrationPage.confirmPassword.sendKeys(confirmPsw);
    }
    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        registrationPage.saveButton.click();
    }

    @And("user verifies Password changed! pop-up")
    public void userVerifiesPasswordChangedPopUp() {
        ReusableMethods.waitFor(3);
        Assert.assertEquals("Password changed!",registrationPage.passwordChanged.getText());

    }
    @Then("user verifies there is no any error message for confirmation")
    public void userVerifiesThereIsNoAnyErrorMessageForConfirmation() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(registrationPage.noConfirmError.isDisplayed());

    }
    @Then("user verifies The password and its confirmation do not match! error message")
    public void userVerifiesThePasswordAndItsConfirmationDoNotMatchErrorMessage() {
        registrationPage.saveButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertEquals("The password and its confirmation do not match!",registrationPage.confirmNotMatch.getText());
    }

    @Then("user should see one {int} bar in the password strength")
    public void userShouldSeeOneBarInThePasswordStrength(int barNum) {
        ReusableMethods.waitFor(3);
       int totalBarNums= (registrationPage.totalBarNums).size();
       int emptyBars= (registrationPage.emptyBars).size();
        System.out.println(totalBarNums);
        System.out.println(emptyBars);
       Assert.assertTrue((totalBarNums-emptyBars)==barNum);
    }

    @When("user add {string} after the newPassword")
    public void userAddAfterTheNewPassword(String ch) {
        registrationPage.newPassword.click();
        registrationPage.newPassword.sendKeys(ch);
    }

    @And("user should not see Password changed! pop-up")
    public void userShouldNotSeePasswordChangedPopUp() {
        ReusableMethods.waitFor(3);
        Assert.assertFalse((registrationPage.passwordChanged.getText()).equals("Password changed!"));
    }

    @And("user enter their new password as {string} which includes all necessities")
    public void userEnterTheirNewPasswordAsWhichIncludesAllNecessities(String newPsw) {
        registrationPage.newPassword.sendKeys(newPsw);
    }
    @And("user enter their confirmation password as {string} which includes all necessities")
    public void userEnterTheirConfirmationPasswordAsWhichIncludesAllNecessities(String confirmPsw) {
        registrationPage.confirmPassword.sendKeys(confirmPsw);
    }
    @Then("user clears the text box")
    public void userClearsTheTextBox() {
        registrationPage.newPasswordTextBox.clear();
    }
    @Then("user should not see more than {int} bar")
    public void userShouldNotSeeMoreThanBar(int barNum) {
        ReusableMethods.waitFor(3);
        int totalBarNums= (registrationPage.totalBarNums).size();
        int emptyBars= (registrationPage.emptyBars).size();
        System.out.println(totalBarNums);
        System.out.println(emptyBars);
        Assert.assertFalse((totalBarNums-emptyBars)>barNum);

    }
}
