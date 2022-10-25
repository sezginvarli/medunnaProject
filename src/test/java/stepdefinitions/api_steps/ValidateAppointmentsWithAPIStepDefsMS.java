package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.lu.a;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.Appointment;
import pojos.Registrant;
import utilities.Authentication;
import utilities.ConfigReader;

import java.awt.*;

import static io.restassured.RestAssured.given;

public class ValidateAppointmentsWithAPIStepDefsMS {
    Response response;
    Appointment[] appointment;
    @Given("user sends a GET patient request for doctor users")
    public void user_sends_a_GET_patient_request_for_doctor_users() {
        RequestSpecification spec=new RequestSpecBuilder().setBaseUri("https://medunna.com").build();

        spec.pathParams("first","api","second","patient","third","physician");
        response=given().headers(
                "Authorization",
                "Bearer "+ Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("doctor_username"),ConfigReader.getProperty("doctor_password")),
                "Content-Type",
                "application/json",
                "Accept","application/json"

        ).spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Given("user converts user record to Java")
    public void user_converts_user_record_to_java() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        appointment=obj.readValue(response.asString(),Appointment[].class);

    }
    @Then("user validates users data {int} {int}")
    public void user_validates_users_data(int id, int index) {
    //int id=16556;
    Assert.assertEquals(id,appointment[index].getId());
    }
}

