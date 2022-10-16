package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Physicians;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.TXTWriter.savePhysiciansData;

public class PhysiciansSteps {
    Physicians[] physiciansApi;
    Response response;
    @Given("admin send the request for physicians data")
    public void admin_send_the_request_for_physicians_data() {
        response= given().headers(
                "Authorization",
                "Bearer "+ generateToken (),//
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("physicians_api_url"));
        response.prettyPrint();
    }
    @Given("admin deserialization the physicians data to java")
    public void admin_deserialization_the_physicians_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        physiciansApi = obj.readValue(response.asString(), Physicians[].class);
        System.out.println(physiciansApi.length);
    }
    @Then("admin saves users data correspondent files to validate")
    public void admin_saves_users_data_correspondent_files_to_validate() {
        savePhysiciansData(physiciansApi);
    }
}
