package stepdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomeAndSigninPage;
import pages.PhysiciansMainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MyAppointmentsForPhysicianValidateAppoinmentsStepsMS {
    HomeAndSigninPage homeAndSigninPage=new HomeAndSigninPage();
    PhysiciansMainPage physiciansMainPage =new PhysiciansMainPage();
    @Given("user navigate medunna.com")
    public void user_navigate_medunna_com() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Then("user click sign drop-down button")
    public void user_click_sign_drop_down_button() {
        homeAndSigninPage.signInAccountMenu.click();

    }
    @Then("user click signin button")
    public void user_click_signin_button() {
        homeAndSigninPage.signInLink.click();
    }
    @Then("user enter Username \\(as a doctor account){string}")
    public void user_enter_username_as_a_doctor_account(String username) {
homeAndSigninPage.userNameTextArea.sendKeys(username);
    }
    @Then("user enter Password {string}")
    public void user_enter_password(String password) {
        homeAndSigninPage.passwordTextArea.sendKeys(password);
    }
    @Then("user click Sign in button")
    public void user_click_sign_in_button() {
    homeAndSigninPage.signInButton.click();
    }
    @Then("user click my pages drop-down button")
    public void user_click_my_pages_drop_down_button() {
        Driver.waitForVisibility(physiciansMainPage.myPagesDropdown,3);
        physiciansMainPage.myPagesDropdown.click();
    }
    @Then("click My Appointments")
    public void click_my_Appointments() {
physiciansMainPage.dropdownElementMyAppointments.click();
    }
    @Then("verify Appointments page")
    public void verify_Appointments_page() {
Assert.assertEquals("Appointments",physiciansMainPage.appointmentsPage.getText());

    }
    @Then("click My Patients")
    public void click_my_patients() {
        physiciansMainPage.myPatient.click();
    }
    @Then("verify Patients page")
    public void verify_patients_page() {

        Assert.assertEquals("Patients",physiciansMainPage.patientPage.getText());
    }
}
