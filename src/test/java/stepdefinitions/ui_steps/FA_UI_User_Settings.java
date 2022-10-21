package stepdefinitions.ui_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomeAndSigninPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class FA_UI_User_Settings {

    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    @When("user clicks on settings button")
    public void user_clicks_on_settings_button() {
        ReusableMethods.waitFor(1);
        homeAndSigninPage.settingsButton.click();
    }
    @Then("verify {string} as firstname")
    public void verify_as_firstname(String firstname) {
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String firstnameText = js.executeScript("return document.getElementById('" + "firstName" + "').value").toString();
        Assert.assertEquals(firstname,firstnameText);
    }
    @Then("verify {string} as lastname")
    public void verify_as_lastname(String lastname) {
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String lastnameText = js.executeScript("return document.getElementById('" + "lastName" + "').value").toString();
        Assert.assertEquals(lastname,lastnameText);
    }
    @Then("verify {string} as email")
    public void verify_as_email(String email) {
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String emailText = js.executeScript("return document.getElementById('" + "email" + "').value").toString();
        Assert.assertEquals(email,emailText);
    }
    @When("user updates {string} as fatih")
    public void user_updates_as_fatih(String firstname) {
        ReusableMethods.waitFor(1);
        homeAndSigninPage.firstnameSettings.clear();
        ReusableMethods.waitFor(2);
        homeAndSigninPage.firstnameSettings.sendKeys(firstname);
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String firstnameText = js.executeScript("return document.getElementById('" + "firstName" + "').value").toString();
        Assert.assertEquals(firstname,firstnameText);

    }
    @When("user clicks on save button to update")
    public void user_clicks_on_save_button_to_update() {
        homeAndSigninPage.saveButtonSettings.click();
    }
    @When("user updates {string} as kaya")
    public void user_updates_as_kaya(String lastname) {
        ReusableMethods.waitFor(2);
        homeAndSigninPage.lastnameSettings.clear();
        ReusableMethods.waitFor(2);
        homeAndSigninPage.lastnameSettings.sendKeys(lastname);
        ReusableMethods.waitFor(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String lastnameText = js.executeScript("return document.getElementById('" + "firstName" + "').value").toString();
        Assert.assertEquals(lastname,lastnameText);
    }
}
