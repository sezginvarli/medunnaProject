package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeAndSigninPage;

public class HomePageStepDefs {

    HomeAndSigninPage homeAndSigninPage =new HomeAndSigninPage();

    @When("user click on account menu")
    public void user_click_on_account_menu() {
        homeAndSigninPage.signInAccountMenu.click();
    }
    @Then("user can select Sign in")
    public void user_can_select_sign_in() {
        homeAndSigninPage.signInLink.click();
    }
    @Then("user click on Remember me checkbox")
    public void user_click_on_remember_me_checkbox() {


    }
    @Then("user click on Sign in")
    public void user_click_on_sign_in() {
        homeAndSigninPage.signInButton.click();


    }

    @And("user enter their password as {string}")
    public void userEnterTheirPasswordAs(String password) {
        homeAndSigninPage.passwordTextArea.sendKeys(password);
    }

    @And("user enter their username as {string}")
    public void userEnterTheirUsernameAs(String userName) {
        homeAndSigninPage.userNameTextArea.sendKeys(userName);
    }
}
