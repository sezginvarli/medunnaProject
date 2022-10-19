package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.admin.AdminPatientPage;
import pages.AppointmentEditCreatePage;
import pages.AppointmentPage;
import pages.HomeAndSigninPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;


public class Acar_CreateOrEditPatientStepDefs {

    AdminPatientPage adminPatientPage=new AdminPatientPage();
    Faker faker=new Faker();
    HomeAndSigninPage homeAndSigninPage=new HomeAndSigninPage();

    AppointmentPage appointmentPage=new AppointmentPage();

    AppointmentEditCreatePage appointmentEditCreatePage=new AppointmentEditCreatePage();

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
        Assert.assertTrue(adminPatientPage.successMessageToastContainer.getText().contains(message));
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
        homeAndSigninPage.signOutButton.click();
    }
    @Then("Verify all information")
    public void verify_all_information() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.ssn.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.firstName.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.lastName.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.birthDate.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.phone.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.email.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.gender.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.bloodGroup.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.address.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.description.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.createdDate.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.user.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.country.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminPatientPage.stateCity.isDisplayed());
    }
    @When("user click on edit button")
    public void user_click_on_edit_button() {
        ReusableMethods.waitForClickablility(adminPatientPage.patientEditButton, 5).click();
    }
    @Then("verify ID item is displayed")
    public void verify_id_item_is_displayed() {
        boolean IDIsDisplayed=ReusableMethods.waitForVisibility(adminPatientPage.ID,5).isDisplayed();
        Assert.assertTrue(IDIsDisplayed);
    }
    @When("click on Items&Titles button then click appointment button")
    public void click_on_items_titles_button_then_click_appointment_button() {
        ReusableMethods.waitForClickablility(adminPatientPage.itemsTitlesButton,5).click();
        ReusableMethods.waitFor(1);
        appointmentPage.appointmentButton.click();
    }
    @When("click first edit button")
    public void click_first_edit_button() {
        ReusableMethods.waitForClickablility(appointmentPage.firstEditButton,40).click();
    }
    @When("user assign new doctor for patient")
    public void user_assign_new_doctor_for_patient() {
        ReusableMethods.waitForVisibility(appointmentEditCreatePage.appointmentPhysicianArea,5);
        ReusableMethods.waitFor(2);
        Select select =new Select(appointmentEditCreatePage.appointmentPhysicianArea);
        select.selectByValue("277681");
    }
}
