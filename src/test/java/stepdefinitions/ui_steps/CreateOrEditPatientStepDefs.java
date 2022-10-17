package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class CreateOrEditPatientStepDefs {

    AdminPatientPage adminPatientPage=new AdminPatientPage();
    Faker faker=new Faker();

    @Given("user opens to Medunna Page")
    public void user_opens_to_medunna_page() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @When("Click on Items&Titles button then click patient button")
    public void click_on_items_titles_button_then_click_patient_button() {
        ReusableMethods.waitFor(2);
        adminPatientPage.itemsTitlesButton.click();
        ReusableMethods.waitFor(1);
        adminPatientPage.patientButton.click();
    }
    @When("Click on Create a new patient button")
    public void click_on_create_a_new_patient_button() {
        adminPatientPage.createPatientButton.click();
    }
    @When("Enter {string} in firstname box")
    public void enter_in_firstname_box(String firstname) {
        firstname=faker.name().firstName();
        adminPatientPage.firstnameBox.sendKeys(firstname);
    }
    @When("Enter {string} in lastname box")
    public void enter_in_lastname_box(String lastname) {
        lastname=faker.name().lastName();
        adminPatientPage.lastnameBox.sendKeys(lastname);
    }
    @When("Enter {string} in birth date box")
    public void enter_in_birth_date_box(String birthDate) {
        adminPatientPage.birthDateBox.sendKeys(birthDate);
    }
    @When("Enter {string} in email box")
    public void enter_in_email_box(String email) {
        email=faker.internet().emailAddress();
        adminPatientPage.emailBox.sendKeys(email);
    }
    @When("Enter {string} in phone box")
    public void enter_in_phone_box(String phone) {
        phone="50578952"+faker.phoneNumber().subscriberNumber(2);
       adminPatientPage.phoneBox.sendKeys(phone);
    }
    @When("Select gender in dropdown")
    public void select_gender_in_dropdown() {
        Select select =new Select(adminPatientPage.genderDropDown);
        select.selectByValue("MALE");
    }
    @When("Select blood group in dropdown")
    public void select_blood_group_in_dropdown() {
        Select select =new Select(adminPatientPage.bloodDropDown);
        select.selectByVisibleText("O+");
    }
    @When("Enter Address in address box")
    public void enter_address_in_address_box() {
        adminPatientPage.adressBox.sendKeys(faker.address().fullAddress());
    }
    @When("Enter {string} in description box")
    public void enter_in_description_box(String description) {
        adminPatientPage.descriptionTextArea.sendKeys(description);
    }
    @When("Enter country in dropdown")
    public void enter_country_in_dropdown() {
        Select select=new Select(adminPatientPage.countryDropDown);
        select.selectByVisibleText("France");
    }
    @When("Click on save button")
    public void click_on_save_button() {
        adminPatientPage.saveButton.click();
    }
    @Then("Verify {string} message")
    public void verify_message(String message) {
        ReusableMethods.waitForVisibility(adminPatientPage.successMessageToastContainer,5);
        Assert.assertTrue(adminPatientPage.successMessageToastContainer.isDisplayed());
    }



    @Then("Verify the Items&Titles is not here")
    public void verify_the_items_titles_is_not_here() {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(0, Driver.getDriver().findElements(By.xpath("//span[.='Items&Titles']")).size());
    }
    @Then("close the application")
    public void close_the_application() {
        Driver.getDriver().close();

    }

    @Then("user click on sign out")
    public void user_click_on_sign_out() {
        ReusableMethods.waitFor(1);
        adminPatientPage.signOutButton.click();
    }
}
