package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentPage;
import pages.PhysiciansMainPage;
import pages.PhysiciansTestRequestPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class PhysicianRequestTestStepDefs_SK {
    PhysiciansTestRequestPage physiciansTestRequestPage = new PhysiciansTestRequestPage();
    PhysiciansMainPage physiciansMainPage = new PhysiciansMainPage();

    AppointmentPage appointmentPage = new AppointmentPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @When("User clicks on My PAGES button.")
    public void user_clicks_on_my_pages_button() {
        ReusableMethods.waitForClickablility(physiciansMainPage.myPages,3).click();
    }
    @Then("clicks on My Appointment button.")
    public void clicks_on_my_appointment_button() throws InterruptedException {
        Driver.wait(3);
        physiciansMainPage.myAppointments.click();

    }
    @Then("choose the patient and clicks edit button")
    public void choose_the_patient_and_clicks_edit_button() throws InterruptedException {
        Thread.sleep(5000);
        appointmentPage.secondEditButton.click();

    }
    @Then("clicks Request a test button")
    public void clicks_request_a_test_button() {
        Driver.wait(3);
        ReusableMethods.waitForClickablility(physiciansTestRequestPage.requestTest,3).click();
    }
    @When("verifies that Test Items headers is visible")
    public void verifies_that_test_items_headers_is_visible() {
        Driver.wait(3);
        Assert.assertTrue(physiciansTestRequestPage.testItem.isDisplayed());
    }
    @Then("User clicks on the right buttons which are choosen tests")
    public void user_clicks_on_the_right_buttons_which_are_choosen_tests() {
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.glucose).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.hemoglobin).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.potassium).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.urea).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.sodium).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.albumin).click();
        ReusableMethods.waitFor(2);
        actions.moveToElement(physiciansTestRequestPage.totalProtein).click();

    }
    @Then("User clicks save button")
    public void user_clicks_save_button() throws InterruptedException {

        Thread.sleep(4000);
//        JSUtils.scrollIntoViewJS(physiciansTestRequestPage.saveButton);
//        ReusableMethods.waitForClickablility(physiciansTestRequestPage.saveButton,4).click();
          js.executeScript("arguments[0].click();", physiciansTestRequestPage.saveButton);

    }

}
