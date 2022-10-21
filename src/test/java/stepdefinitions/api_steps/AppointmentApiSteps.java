package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Appointment;
import pojos.AppointmentRequest;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.TXTWriter;

import java.time.LocalDate;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.Authentication.generateTokenWithUsernamePassword;

public class AppointmentApiSteps {
    Response response;
    Appointment appointment;
    String ssn = "132-45-1231";
    String firstName = "patient";
    String lastName = "team03";
    String email = "team03patient@mail.com";
    String phone = "555-555-9999";
    String date = readyAppointmentDate();
    AppointmentRequest appointmentRequest = new AppointmentRequest(null,null,email,firstName,null, lastName, phone,null,ssn,date);

    public String readyAppointmentDate(){
        LocalDate myDate = LocalDate.now();
//        return myDate.toString();
        return "2022-10-21";
    }

    @When("user sends post request for creating new appointment")
    public void user_sends_post_request_for_creating_new_appointment() {
//        System.out.println(appointmentRequest.toString());
        spec.pathParams("first","api","second","appointments","third","request");
        response= given().spec(spec).headers(
                "Authorization",
                "Bearer "+ generateTokenWithUsernamePassword ("team03patient","team03Patient"),//ConfigReader.getProperty("api_token"),//
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(appointmentRequest).when().post("/{first}/{second}/{third}");
    }
    @When("user deserializes the application data to java")
    public void user_deserializes_the_application_data_to_java() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        appointment =obj.readValue(response.asString(), Appointment.class);
        System.out.println(appointment.toString());
        System.out.println(appointment.getPatient().toString());

        TXTWriter.saveUiAppointmentData(appointment);
    }

    @Then("user validates appointment")
    public void userValidatesAppointment() {
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(appointment.getPatient().getUser().getSsn(),appointmentRequest.getSsn());
        Assert.assertEquals(appointment.getPatient().getFirstName(),appointmentRequest.getFirstName());
        Assert.assertEquals(appointment.getPatient().getLastName(),appointmentRequest.getLastName());
        Assert.assertEquals(appointment.getStartDate().substring(0,10),appointmentRequest.getStartDate());
    }
}
