package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AppointmentPage;
import pages.HomeAndSigninPage;
import pages.PatientAppointment;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAppointmentsbyPatientStepDefs {
    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    PatientPage patientPage = new PatientPage();
    PatientAppointment patientAppointment=new PatientAppointment();
    AppointmentPage appointmentPage=new AppointmentPage();

    @Given("User is on the sign in page")
    public void user_is_on_the_sign_in_page() {
        Driver.getDriver().get(ConfigReader.getProperty("signin_page_url"));
    }
    @Given("User enters their sign in credentials as {string} and {string}")
    public void user_enters_their_sign_in_credentials_as_and(String username, String password) {
        homeAndSigninPage.userNameTextArea.sendKeys(username);
        homeAndSigninPage.passwordTextArea.sendKeys(password);
        homeAndSigninPage.signInButton.click();

    }
    @Then("User clicks on the My Pages")
    public void user_clicks_on_the_my_pages() {
        Driver.waitAndClick(patientPage.myPagesDropdown);
    }
    @Then("Clicks on the My Appointments")
    public void clicks_on_the_my_appointments() {
        patientPage.myAppointment.click();
    }
    @Then("User verifies that is on the Appointments page")
    public void user_verifies_that_is_on_the_appointments_page() {
        Assert.assertTrue(patientAppointment.AppointmentsText.isDisplayed());
    }
    @When("User enters their appointment's date")
    public void user_enters_their_appointment_s_date() {
        appointmentPage.dateFrom.sendKeys("17.11.2022");
        appointmentPage.dateTo.sendKeys("17.11.2022");

    }
    @Then("User verifies the Show Tests section visible than click")
    public void user_verifies_the_show_tests_section_visible_than_click() {
        Driver.wait(3);
        Assert.assertTrue(patientAppointment.showTestsButton.isDisplayed());
        patientAppointment.showTestsButton.click();

    }
    @Then("User verifies that is on the Tests page")
    public void user_verifies_that_is_on_the_tests_page() {
        Assert.assertTrue(patientAppointment.TestsText.isDisplayed());

    }
    @Then("User should see ID,Name,Description,Date,Created Date and Appointment headers")
    public void user_should_see_id_name_description_date_created_date_and_appointment_headers() {
        Driver.wait(3);
        List <String> headers = ReusableMethods.getElementsText(patientAppointment.headers);
        System.out.println(headers); //[ID, Name, Description, Date, Created Date, Appointment]
        String [] arr= {"ID", "Name", "Description", "Date", "Created Date", "Appointment"};
        List <String> expectedHeaders = Arrays.asList(arr);
        System.out.println(expectedHeaders);
        Assert.assertTrue(headers.containsAll(expectedHeaders));
    }
    @When("User clicks on the View Results section")
    public void user_clicks_on_the_view_results_section() {
        patientAppointment.viewResultsButton.click();
    }
    @Then("User verifies the Test Results section visible")
    public void user_verifies_the_test_results_section_visible() {
        Driver.wait(2);
        Assert.assertTrue(patientAppointment.testResultsText.isDisplayed());
    }
    @Then("User should see ID, Name for test, default max and min value, test date and description")
    public void user_should_see_id_name_for_test_default_max_and_min_value_test_date_and_description() {
        Driver.wait(3);
        List <String> headers = ReusableMethods.getElementsText(patientAppointment.headers);
        System.out.println(headers); //[ID, Name, Description, Date, Created Date, Appointment]
        String [] arr= {"ID", "Name", "Description", "Date", "Default Min. Value", "Default Min. Value", "Test", "Result"};
        List <String> expectedHeaders = Arrays.asList(arr);
        System.out.println(expectedHeaders);
        Assert.assertTrue(headers.containsAll(expectedHeaders));
    }
    @Then("User should see No Tests Found")
    public void user_should_see_no_tests_found() {
        Driver.wait(3);
        Assert.assertTrue( patientAppointment.noTestFoundText.isDisplayed());
    }
    @Then("User should see the status is {string} or {string}")
    public void userShouldSeeTheStatusIsOr(String cancelled, String completed) {
        Driver.wait(3);
        String statusType = patientAppointment.statusType.getText();
        boolean flag= false;
        if (statusType.contains(cancelled) || statusType.contains(completed)){
            flag= true;
        }
        Assert.assertTrue(flag);
    }
    @When("User verifies the Show Invoice section visible than click")
    public void user_verifies_the_show_invoice_section_visible_than_click() {
        Driver.wait(3);
        Assert.assertTrue(patientAppointment.showInvoiceButton.isDisplayed());
        patientAppointment.showInvoiceButton.click();
    }
    @Then("User verifies that is on the Invoice page")
    public void user_verifies_that_is_on_the_invoice_page() {
        Driver.wait(3);
        Assert.assertTrue(patientAppointment.invoiceText.isDisplayed());
    }
    @Then("User should see Date,SSN,Name,Payment Method and Total Cost headers")
    public void user_should_see_date_ssn_name_payment_method_and_total_cost_headers() {
        Driver.wait(3);
        List <String> headers = ReusableMethods.getElementsText(patientAppointment.invoiceHeaders);
        System.out.println(headers); //[INVOICE, Date:, 2022-10-26T11:11:48.063624Z, SSN:, 532-65-8712, Name:, John John, Payment Method:, CREDIT_CARD, Total Cost:, 1361$]
        String [] arr= {"Date:", "SSN:", "Name:", "Payment Method:", "Total Cost:"};
        List <String> expectedHeaders = Arrays.asList(arr);
        System.out.println(expectedHeaders);
        Assert.assertTrue(headers.containsAll(expectedHeaders));

    }
    @Then("User should see own ssn across the ssn header and total cost")
    public void user_should_see_own_ssn_across_the_ssn_header_and_total_cost() {
        List <String> headers = ReusableMethods.getElementsText(patientAppointment.invoiceHeaders);
        String [] arr= {"532-65-8712", "1361$"};
        Assert.assertTrue(headers.containsAll(Arrays.asList(arr)));
    }
    @Then("User should see the status is {string}")
    public void user_should_see_the_status_is(String pending) {
        Driver.wait(3);
        String statusType = patientAppointment.statusType.getText();
        boolean flag= false;
        if (statusType.contains(pending)){
            flag= true;
        }
        Assert.assertTrue(flag);
    }
    @When("User verifies the Show Invoice section is not visible")
    public void user_verifies_the_show_invoice_section_is_not_visible() {
        int size= patientAppointment.numShowInvoiceButton.size();
        System.out.println(size);
        Assert.assertTrue(size==0);
    }
    @When("User verifies the No Appointment Found is visible")
    public void user_verifies_the_no_appointment_found_is_visible() {
        Driver.wait(3);
        Assert.assertTrue(patientAppointment.noAppointmentsFound.isDisplayed());
    }
    @When("User navigates back to two times")
    public void userNavigatesBackToTwoTimes() {
        Driver.wait(3);
        Driver.backToTwoTimes();
    }
}
