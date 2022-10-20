package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AppointmentRequestPage;
import pages.PatientPage;
import utilities.ReusableMethods;

import java.time.LocalDate;

public class AppointmentDateStepDefs {
    AppointmentRequestPage appoRequestPage = new AppointmentRequestPage();
    PatientPage patientPage = new PatientPage();
    String phoneNumber = "555-666-7744";
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

        String day = "";
        String month = "";
        String year = "";

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
}
