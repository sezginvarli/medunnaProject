package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomeAndSigninPage;
import pages.StaffPage;
import pojos.Registrant;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class StaffStepDefs_MT {

    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    StaffPage staffPage = new StaffPage();
    Registrant registrant = new Registrant();
    Faker faker = new Faker();

    @When("user clicks on Search Patient button")
    public void user_clicks_on_search_patient_button() {
        staffPage.searchPatientButton.click();
    }

    @When("user search patient with {string}")
    public void user_search_patient_with(String SSN) {
        staffPage.searchPatientWithSsn.sendKeys(SSN);
    }

    @When("user clicks on View button")
    public void user_clicks_on_view_button() {
        ReusableMethods.waitForClickablility(staffPage.viewButtonAfterSearchingPatient, 3).click();
    }

    @Then("Verify view portal is displayed")
    public void verify_view_portal_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(staffPage.viewPortal.isDisplayed());
    }


    @And("Verify All Patient Info is displayed")
    public void verifyAllPatientInfoIsDisplayed() {

        Assert.assertTrue(staffPage.ssnInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.firstNameInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.lastNameInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.birthDateInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.phoneInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.emailInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.genderInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.bloodGroupInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.adressInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.descriptionInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.createdDateInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.userInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.countryInfoTitle.isDisplayed());
        Assert.assertTrue(staffPage.stateCityInfoTitle.isDisplayed());


    }

    @And("user clicks on Edit button")
    public void userClicksOnEditButton() {
        ReusableMethods.waitForVisibility(staffPage.editButtonAfterSearchingPatientPage, 3).click();
    }

    @And("user sends a new firstname")
    public void userSendsANewFirstname() {
        ReusableMethods.waitForVisibility(staffPage.patientFirstNameBox, 1).clear();
        staffPage.patientFirstNameBox.sendKeys(Faker.instance().name().firstName());
    }

    @And("user sends a new lastname")
    public void userSendsANewLastname() {
        staffPage.patientLastNameBox.clear();
        staffPage.patientLastNameBox.sendKeys(Faker.instance().name().lastName());
    }

    @And("user sends a new birthday")
    public void userSendsANewBirthday() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(staffPage.patientBirthDateBox, "12-05-1995").sendKeys(Keys.ARROW_RIGHT)
                .sendKeys("09-30").build().perform();
    }

    @And("user sends a new email")
    public void userSendsANewEmail() {
        staffPage.patientEmailBox.clear();
        staffPage.patientEmailBox.sendKeys(Faker.instance().internet().emailAddress());
    }

    @And("user sends a new phone")
    public void userSendsANewPhone() {
        staffPage.patientPhoneBox.clear();
        String phoneNumber = "555123" + faker.phoneNumber().subscriberNumber(4);
        staffPage.patientPhoneBox.sendKeys(phoneNumber);
    }

    @And("user select a new gender")
    public void userSelectANewGender() {
        Select select = new Select(staffPage.patientGenderDropDown);
        int randomGenderIndex = faker.number().numberBetween(0, 2);
        select.selectByIndex(randomGenderIndex);
    }

    @And("user select a new blood group")
    public void userSelectANewBloodGroup() {
        Select select = new Select(staffPage.patientBloodGroupDropDown);
        int randomBloodGroupIndex = faker.number().numberBetween(0, 7);
        select.selectByIndex(randomBloodGroupIndex);
    }

    @And("user sends a new address")
    public void userSendsANewAddress() {
        staffPage.patientAdressBox.clear();
        staffPage.patientAdressBox.sendKeys(Faker.instance().address().fullAddress());
    }

    @And("user sends a new description")
    public void userSendsANewDescription() {
        staffPage.patientDescriptionBox.clear();
        staffPage.patientDescriptionBox.sendKeys(Faker.instance().job().field());
    }

    @And("user select a new user")
    public void userSelectANewUser() {
        Select select = new Select(staffPage.patientUserDropDown);
        int randomUserIndex = faker.number().numberBetween(0, 18);
        select.selectByIndex(randomUserIndex);
    }

    @And("user select a new country")
    public void userSelectANewCountry() {
        Select select = new Select(staffPage.patientCountryDropDown);
        select.selectByVisibleText("Germany");

    }

    @And("user select a new state-city")
    public void userSelectANewStateCity() {
        ReusableMethods.waitFor(2);
        Select select = new Select(staffPage.patientCityStateDropDown);
        select.selectByIndex(0);
    }

    @And("user clicks on Save button")
    public void userClicksOnSaveButton() {
        ReusableMethods.waitForClickablility(staffPage.saveButton, 3).click();
    }

    @Then("Verify {string} pop up")
    public void verifyPopUp(String popUpMessage) {
        try {
            ReusableMethods.waitForVisibility(staffPage.newPatientCreatedMessage, 5);
            Assert.assertTrue(staffPage.newPatientCreatedMessage.getText().contains(popUpMessage));
        } catch (Exception e) {
        }
    }

    @And("user clicks on Show Appointments button")
    public void userClicksOnShowAppointmentsButton() {
        ReusableMethods.waitForClickablility(staffPage.showAppointmentsButtonAfterSearchingPatientPage, 3).click();

    }

    @And("user clicks on Show Tests button")
    public void userClicksOnShowTestsButton() {
        ReusableMethods.waitForClickablility(staffPage.showTestsButton, 3).click();
    }

    @And("user clicks on View Results button")
    public void userClicksOnViewResultsButton() {
        ReusableMethods.waitForClickablility(staffPage.viewResultsButton, 3).click();
    }

    @And("user updates test result")
    public void userUpdatesTestResult() {

        ReusableMethods.waitFor(2);
        staffPage.testResultBox.clear();
        staffPage.testResultBox.sendKeys(Faker.instance().ancient().primordial());
        staffPage.testResultDescriptionBox.clear();
        staffPage.testResultDescriptionBox.sendKeys(Faker.instance().superhero().descriptor());

    }

    @And("user clicks on Result Save button")
    public void userClicksOnResultSaveButton() {

        JSUtils.clickElementByJS(staffPage.testResultSaveButton);
    }

    @Then("Verify {string} pop up is displayed")
    public void verifyPopUpIsDisplayed(String updateMessage) {

        ReusableMethods.waitFor(2);
        // ReusableMethods.waitForVisibility(staffPage.testResultUpdatedMessage,2);
        String actualMessage = staffPage.testResultUpdatedMessage.getText();
        Assert.assertTrue(actualMessage.contains(updateMessage));

    }
}