

package stepdefinitions.ui_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomeAndSigninPage;
import utilities.Driver;

public class US05UIStepDefs {


    HomeAndSigninPage homeAndSigninPage=new HomeAndSigninPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("User go to the {string}")
    public void userGoToThe(String arg0) {
        Driver.getDriver().get(arg0);
    }

    @Given("User click make an apointment button")
    public void user_click_make_an_apointment_button() throws InterruptedException {
      //  Thread.sleep(3000);
       // Driver.clickWithJS(homeAndSigninPage.MakeAnAppointment);
        Thread.sleep(3000);
      // ReusableMethods.waitForVisibility(homeAndSigninPage.MakeAnAppointment,20).click();
       homeAndSigninPage.MakeAnAppointment.click();
      //  js.executeScript("arguments[0].click();", homeAndSigninPage.MakeAnAppointment);
    }
    @When("User enter valid {string} that contains any char")
    public void user_enter_valid_that_contains_any_char(String firstname) {
        homeAndSigninPage.firstName.sendKeys(firstname);

    }
    @Then("User enters a registered {string}")
    public void user_enters_a_registered(String ssn) {
        homeAndSigninPage.ssn.sendKeys(ssn);
    }
    @Then("User enters a {string} that cointains any char")
    public void user_enters_a_that_cointains_any_char(String lastname) {
        homeAndSigninPage.lastName.sendKeys(lastname);

    }
    @Then("User provides valid {string}")
    public void user_provides_valid(String email) {
        homeAndSigninPage.email.sendKeys(email);

    }
    @Then("User enters valid {string}")
    public void user_enters_valid(String Phonenumber) {
        homeAndSigninPage.phone.sendKeys(Phonenumber);

    }
    @Then("User Clicks Send an Appointment Request")
    public void user_clicks_send_an_appointment_request() throws InterruptedException {
        Thread.sleep(2000);

       // homeAndSigninPage.SendAndAppointmantRequest.click();
        js.executeScript("arguments[0].click();", homeAndSigninPage.SendAndAppointmantRequest);

    }
    @Then("User clicks on sign-in")
    public void user_clicks_on_sign_in() throws InterruptedException {
        Thread.sleep(5000);
        homeAndSigninPage.signInButton1.click();
        Thread.sleep(1000);
        homeAndSigninPage.signInTab.click();

    }
    @Then("User Enters {string}")
    public void user_enters(String UserName) throws InterruptedException {
        Thread.sleep(1000);
        homeAndSigninPage.userNameTextArea.sendKeys(UserName);

    }
    @Then("User Enter {string}")
    public void user_enter(String Password) throws InterruptedException {
        Thread.sleep(1000);
        homeAndSigninPage.passwordTextbox.sendKeys(Password);

    }
    @Then("User clicks on sign-in Button")
    public void user_clicks_on_sign_in_button() throws InterruptedException {
        Thread.sleep(2000);
        homeAndSigninPage.signInButton.click();

    }
    @Then("User clicks My Pages patient Dropdown")
    public void user_clicks_my_pages_patient_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        homeAndSigninPage.myPagesPatient.click();

    }
    @Then("User searchs My Appointment")
    public void user_searchs_my_appointment() throws InterruptedException {
        Thread.sleep(1000);
        homeAndSigninPage.myAppointment.click();

    }
    @Then("Verify user assert the created appointment")
    public void verify_user_assert_the_created_appointment() throws InterruptedException {
        Thread.sleep(1000);
        for (WebElement w : homeAndSigninPage.createdDate) {
            Assert.assertTrue(w.isDisplayed());
        }

    }
    @Then("User closes the page")
    public void user_closes_the_page() {
        Driver.closeDriver();

    }


}







