package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AppointmentRequestPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.time.LocalDate;

public class AppointmentDateStepDefs {
    AppointmentRequestPage appoRequestPage = new AppointmentRequestPage();
    PatientPage patientPage = new PatientPage();
    String phoneNumber = "555-666-7744";

    String day = "";
    String month = "";
    String year = "";
    @When("user clicks on make an appointment button")
    public void user_clicks_on_make_an_appointment_button() {
        ReusableMethods.waitForVisibility(patientPage.makeAnAppointmentButton,5);
        patientPage.makeAnAppointmentButton.click();
    }

    @When("user fills the form with valid dates {string}")
    public void userFillsTheFormWithValidDates(String when) {
        ReusableMethods.waitForVisibility(appoRequestPage.appointmentDate,5);

        appoRequestPage.phone.sendKeys(phoneNumber);

        LocalDate date = LocalDate.now();
        System.out.println(date);

        switch (when){
            case "today":
                day += date.getDayOfMonth();
                month += date.getMonthValue();
                year += date.getYear();

//                String dateWithFormValueFormat =year+"-"+month+"-"+day;
                if(month.length()<2){
                    month = "0"+month;
                }
                if(day.length()<2){
                    day = "0"+day;
                }
                System.out.println(month+"/"+day+"/"+year);

                appoRequestPage.appointmentDate.click();
                appoRequestPage.appointmentDate.sendKeys(day+month+year);

                break;
            case "tomorrow":
                day += date.getDayOfMonth()+1;
                month += date.getMonthValue();
                year += date.getYear();

//                String dateWithFormValueFormat =year+"-"+month+"-"+day;
                if(month.length()<2){
                    month = "0"+month;
                }
                if(day.length()<2){
                    day = "0"+day;
                }
                day = day.equals("32") ? "01" : day;
                month = month.equals("13") ? "01" : month;
                System.out.println(month+"/"+day+"/"+year);

                appoRequestPage.appointmentDate.click();
                appoRequestPage.appointmentDate.sendKeys(day+month+year);
                break;
            case "oneyearlater":
                day += date.getDayOfMonth()+1;
                month += date.getMonthValue();
                year += date.getYear()+1;

//                String dateWithFormValueFormat =year+"-"+month+"-"+day;
                if(month.length()<2){
                    month = "0"+month;
                }
                if(day.length()<2){
                    day = "0"+day;
                }
                day = day.equals("32") ? "01" : day;
                month = month.equals("13") ? "01" : month;

                appoRequestPage.appointmentDate.click();
                appoRequestPage.appointmentDate.sendKeys(day+month+year);
                break;
            case "yesterday":
                day += date.getDayOfMonth()-1;
                month += date.getMonthValue();
                year += date.getYear();

//                String dateWithFormValueFormat =year+"-"+month+"-"+day;
                if(month.length()<2){
                    month = "0"+month;
                }
                if(day.length()<2){
                    day = "0"+day;
                }
                day = day.equals("00") ? "30" : day;
                month = month.equals("13") ? "01" : month;

                appoRequestPage.appointmentDate.click();
                appoRequestPage.appointmentDate.sendKeys(day+month+year);
                break;
            case "oneyearbefore":
                day += date.getDayOfMonth();
                month += date.getMonthValue();
                year += date.getYear()-1;

//                String dateWithFormValueFormat =year+"-"+month+"-"+day;
                if(month.length()<2){
                    month = "0"+month;
                }
                if(day.length()<2){
                    day = "0"+day;
                }
                day = day.equals("32") ? "01" : day;
                month = month.equals("13") ? "01" : month;

                appoRequestPage.appointmentDate.click();
                appoRequestPage.appointmentDate.sendKeys(day+month+year);
                break;
        }
    }

    @When("user clicks on send an appointments request button")
    public void user_clicks_on_send_an_appointments_request_button() {
        ReusableMethods.waitForClickablility(appoRequestPage.sendAppointmentRequestButton,5).click();
    }

    @Then("user verifies appointment can not be past date message is not displayed")
    public void user_verifies_appointment_can_not_be_past_date_message_is_not_displayed() {
        try {
            ReusableMethods.waitForVisibility(appoRequestPage.dateCanNotBePastDateMessage,2);
            if(appoRequestPage.dateCanNotBePastDateMessage.isDisplayed()){
                Assert.fail();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Then("user verifies Appointment registrations saved message is displayed")
    public void userVerifiesAppointmentRegistrationsSavedMessageIsDisplayed() {
        ReusableMethods.waitForVisibility(appoRequestPage.registrationSavedMessage,5);
        Assert.assertTrue(appoRequestPage.registrationSavedMessage.isDisplayed());
    }

    @Then("user verifies appointment can not be past date message is displayed")
    public void userVerifiesAppointmentCanNotBePastDateMessageIsDisplayed() {
        ReusableMethods.waitForVisibility(appoRequestPage.dateCanNotBePastDateMessage,5);
        Assert.assertTrue(appoRequestPage.dateCanNotBePastDateMessage.isDisplayed());
    }

    @Then("user verifies Appointment registrations saved message is not displayed")
    public void userVerifiesAppointmentRegistrationsSavedMessageIsNotDisplayed() {
        try {
            ReusableMethods.waitForVisibility(appoRequestPage.registrationSavedMessage,2);
            if(appoRequestPage.registrationSavedMessage.isDisplayed()){
                Assert.fail();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @And("user fills the form with date format MM dd yyyy")
    public void userFillsTheFormWithDateFormatMMDdYyyy() {
        ReusableMethods.waitForVisibility(appoRequestPage.appointmentDate,5);
//        JSUtils.clickElementByJS(appoRequestPage.appointmentDate);
        appoRequestPage.phone.sendKeys(phoneNumber);

        day = "15";
        month = "05";
        year = "2022";

        appoRequestPage.appointmentDate.click();
        ReusableMethods.waitFor(1);
        appoRequestPage.appointmentDate.sendKeys(month);
        ReusableMethods.waitFor(1);
        appoRequestPage.appointmentDate.sendKeys(day);
        ReusableMethods.waitFor(1);
        appoRequestPage.appointmentDate.sendKeys(year);
    }

    @Then("user verifies date value is changed correctly")
    public void userVerifiesDateValueIsChangedCorrectly() {
        ReusableMethods.waitFor(1);
        String dateValue = appoRequestPage.appointmentDate.getAttribute("value");

        System.out.println(dateValue);
        System.out.println(day+month+year);

        Assert.assertTrue(dateValue.contains(day));
        Assert.assertTrue(dateValue.contains(month));
        Assert.assertTrue(dateValue.contains(year));
    }

    @Given("user goes to the url with chrome language option set to english")
    public void userGoesToTheUrlWithChromeLanguageOptionSetToEnglish() {
        Driver.getChromeWithLangOption("en-US").get(ConfigReader.getProperty("base_url"));
        ReusableMethods.waitFor(3);
        patientPage = new PatientPage();
        appoRequestPage = new AppointmentRequestPage();
    }
}
