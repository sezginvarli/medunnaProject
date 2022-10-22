package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PhysiciansMainPage;
import pages.PhysiciansTestRequestPage;
import pages.StaffPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class PhysicianTestResultAndRequestInpatientStepDefs_MT {

    PhysiciansMainPage physiciansMainPage = new PhysiciansMainPage();
    PhysiciansTestRequestPage physiciansTestRequestPage = new PhysiciansTestRequestPage();

    @When("User clicks on My Pages button")
    public void user_clicks_on_my_pages_button() {
        Driver.waitForVisibility(physiciansMainPage.myPagesDropdown, 3).click();
    }

    @And("user clicks on My Appointments button")
    public void userClicksOnMyAppointmentsButton() {
        physiciansMainPage.myAppointmentsButtonInMyPagesDropDown.click();
    }

    @And("user clicks on Show Test Results button")
    public void userClicksOnShowTestResultsButton() {
        Driver.wait(5);
        physiciansMainPage.showTestResultsButton.click();
    }

    @And("user clicks on View Test Results button")
    public void userClicksOnViewTestResultsButton() {
        Driver.wait(5);
        physiciansMainPage.viewResultsButton.click();
    }

    @Then("Verify all test information is displayed")
    public void verifyAllTestInformationIsDisplayed() {
        Driver.wait(5);
        Assert.assertTrue(physiciansTestRequestPage.idHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.nameHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.resultHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.minValueHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.maxValueHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.testHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.descriptionHeader.isDisplayed());
        Assert.assertTrue(physiciansTestRequestPage.dateHeader.isDisplayed());

    }

    @And("user clicks on Request Inpatient button")
    public void userClicksOnRequestInpatientButton() {
        Driver.wait(3);
        physiciansMainPage.requestInpatientButton.click();
    }

    @Then("Verify {string} pop up is display")
    public void verifyPopUpIsDisplay(String expectedMessage) {
        try {
            ReusableMethods.waitFor(2);
            String actualMessage = physiciansMainPage.newInPatientCreatedMessage.getText();
            Assert.assertTrue(actualMessage.contains(expectedMessage));
        }catch (Exception e){}
    }

    @And("user clicks on the Edit button")
    public void userClicksOnTheEditButton() {
        Driver.wait(5);
        ReusableMethods.waitForVisibility(physiciansMainPage.editButtonInMyAppointmentsPageWithChangingIndex, 3).click();
    }

}