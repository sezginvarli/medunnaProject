package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AppointmentPage;
import pages.AppointmentRequestPage;
import pages.PatientPage;
import utilities.Driver;
import utilities.ReusableMethods;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class PatientAppointment_OA {
    PatientPage patientPage = new PatientPage();
    AppointmentPage appointmentPage = new AppointmentPage();
    AppointmentRequestPage appointmentRequestPage = new AppointmentRequestPage();
    Faker faker = new Faker();
    String appointmentDateTime;
    String hour;
    Format f = new SimpleDateFormat("dd/MM/yy");
    @When("User click on Make an Appointment from My Pages dropdown")
    public void user_click_on_make_an_appointment_from_my_pages_dropdown() {
        ReusableMethods.waitForVisibility(patientPage.myPagesDropdown,2);
        patientPage.myPagesDropdown.click();
        ReusableMethods.waitForVisibility(patientPage.makeAnAppointmentButton,1);
        patientPage.makeAnAppointmentButton.click();
    }
    @When("User should fill the credentials")
    public void user_should_fill_the_credentials() {
        ReusableMethods.waitForVisibility(appointmentRequestPage.firstName,5);
        appointmentRequestPage.phone.sendKeys(faker.number().digits(10));
    }
    @When("User click on Send an appointment request see {string}")
    public void user_click_on_send_an_appointment_request_see(String string) {
        Format hours = new SimpleDateFormat("HH:mm");
        hour = hours.format(new Date());
        String date = f.format(new Date());
//        appointmentDateTime = date.getDayOfMonth()+""+date.getMonthValue()+""+date.getYear();
        appointmentDateTime = date;
        System.out.println(appointmentDateTime);
        System.out.println(hour);
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitForVisibility(appointmentPage.toastifyAllert,3);
        Assert.assertTrue(appointmentPage.toastifyAllert.getText().contains(string));
    }
    @Then("User should click on my appointments and see the new appointments")
    public void user_should_click_on_my_appointments_and_see_the_new_appointments() {
        patientPage.myPagesDropdown.click();
        ReusableMethods.waitForVisibility(patientPage.myAppointmentsButton,1);
        patientPage.myAppointmentsButton.click();
        ReusableMethods.waitForVisibility(appointmentPage.dateFrom,10);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+appointmentDateTime+" "+hour+"']")).isDisplayed());
    }
    @Then("User change name and click on Send an apointment request see it is saved")
    public void user_change_name_and_click_on_send_an_appointment_request_see_it_is_saved() {
        appointmentRequestPage.firstName.clear();
        appointmentRequestPage.firstName.sendKeys(faker.name().firstName());
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitForVisibility(appointmentRequestPage.registrationSavedMessage,2);
        Assert.assertTrue(appointmentRequestPage.registrationSavedMessage.isDisplayed());
    }
    @Then("User change lastname and click on Send an apointment request see it is saved")
    public void user_change_lastname_and_click_on_send_an_apointment_request_see_it_is_saved() {
        appointmentRequestPage.lastName.clear();
        appointmentRequestPage.lastName.sendKeys(faker.name().lastName());
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitForVisibility(appointmentRequestPage.registrationSavedMessage,2);
        Assert.assertTrue(appointmentRequestPage.registrationSavedMessage.isDisplayed());
    }
    @Then("User change email and click on Send an apointment request see it is saved")
    public void user_change_email_and_click_on_send_an_apointment_request_see_it_is_saved() {
        appointmentRequestPage.email.clear();
        appointmentRequestPage.email.sendKeys(faker.internet().emailAddress());
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitForVisibility(appointmentRequestPage.registrationSavedMessage,2);
        Assert.assertTrue(appointmentRequestPage.registrationSavedMessage.isDisplayed());
    }
    @When("User should fill the credentials except name and should see {string}")
    public void user_should_fill_the_credentials_except_name_and_should_see(String string) {
        ReusableMethods.waitForVisibility(appointmentRequestPage.firstName,5);
        appointmentRequestPage.firstName.clear();
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '" + string + "']")).isDisplayed());
    }
    @When("User should fill the credentials except lastname {string}")
    public void user_should_fill_the_credentials_except_lastname(String string) {
        appointmentRequestPage.firstName.sendKeys(faker.name().firstName());
        appointmentRequestPage.lastName.clear();
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '" + string + "']")).isDisplayed());
    }
    @Then("User change the ssn id and when click on should see {string}")
    public void user_change_the_ssn_id_and_when_click_on_should_see(String string) {
        appointmentRequestPage.lastName.sendKeys(faker.name().lastName());
        appointmentRequestPage.phone.sendKeys(faker.number().digits(10));
        appointmentRequestPage.ssn.clear();
        appointmentRequestPage.ssn.sendKeys("123-23-5050");
        appointmentRequestPage.sendAppointmentRequestButton.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForVisibility(appointmentRequestPage.toastifyAlertAppointmentRequestPage,2);
        Assert.assertEquals(appointmentRequestPage.toastifyAlertAppointmentRequestPage.getText(), string);
    }
    @Then("User change the date before the current time and should see {string}")
    public void user_change_the_date_before_the_current_time_and_should_see(String string) {
        String currentDate = f.format(new Date());
        String day =currentDate.substring(0,2);
        String newDay;
        if (Integer.parseInt(day)<2){
            newDay = "20";
        }
        else if (Integer.parseInt(day)>27){
            newDay = "11";
        }
        else {
            newDay = "1";
        }
        String newDate = newDay+currentDate.substring(2);
        appointmentRequestPage.appointmentDate.sendKeys(newDate);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = '"+string+"']")).isDisplayed());
    }
    @When("User shouldn't put @ sign in wrong place with {string}")
    public void user_shouldn_t_put_sign_in_wrong_place_with(String string) {
        ReusableMethods.waitForVisibility(appointmentRequestPage.firstName,5);
        appointmentRequestPage.email.clear();
        appointmentRequestPage.email.sendKeys(string);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = 'This field is invalid']")).isDisplayed());
    }
    @When("User shouldn't place sign in wrong place in ssn id with {string}")
    public void user_shouldn_t_place_sign_in_wrong_place_in_ssn_id_with(String string) {
       appointmentRequestPage.ssn.clear();
       appointmentRequestPage.ssn.sendKeys(string);
       ReusableMethods.waitFor(1);
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text() = 'Your SSN is invalid']")).isDisplayed());
    }


}
