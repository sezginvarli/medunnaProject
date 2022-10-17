package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeAndSigninPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePageStepDefs {

    HomeAndSigninPage HomeAndSigninPage =new HomeAndSigninPage();

    @When("user goto home page")
    public void user_goto_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @When("user click on account menu")
    public void user_click_on_account_menu() {

    }
    @Then("user can select Sign in")
    public void user_can_select_sign_in() {

    }
    @Then("user click on Remember me checkbox")
    public void user_click_on_remember_me_checkbox() {
    }
    @Then("user click on Sign in")
    public void user_click_on_sign_in() {


    }

}
