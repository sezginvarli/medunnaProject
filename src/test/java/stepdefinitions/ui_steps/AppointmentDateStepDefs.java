package stepdefinitions.ui_steps;

import io.cucumber.java.en.*;
import pages.AppointmentRequestPage;
import pages.PatientPage;
import utilities.ReusableMethods;

import java.time.LocalDate;

public class AppointmentDateStepDefs {
    AppointmentRequestPage appoRequestPage = new AppointmentRequestPage();
    PatientPage patientPage = new PatientPage();
    @When("user clicks on make an appointment button")
    public void user_clicks_on_make_an_appointment_button() {
        ReusableMethods.waitForVisibility(patientPage.makeAnAppointmentButton,5);
        patientPage.makeAnAppointmentButton.click();
    }

    @When("user fills the form with valid dates {string}")
    public void userFillsTheFormWithValidDates(String when) {
        ReusableMethods.waitForVisibility(appoRequestPage.appointmentDate,5);
//        LocalDate date = LocalDate.now();
        String day = "";
        String month = "";
        String year = "";
        switch (when){
            case "today":
                LocalDate date = LocalDate.now();
                day += date.getDayOfMonth();
                month += date.getMonthValue();
                year += date.getYear();
                System.out.println(month+"/"+day+"/"+year);
                break;
            case "tomorrow":
                break;
            case "oneyearlater":
                break;
        }
    }

    @When("user clicks on send an appointments request button")
    public void user_clicks_on_send_an_appointments_request_button() {
    }

    @Then("user verifies appointment can not be past date message is not displayed")
    public void user_verifies_appointment_can_not_be_past_date_message_is_not_displayed() {
    }
}
