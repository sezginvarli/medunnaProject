package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigReader;
import pojos.Physician;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class PhysiciansStepDefs {
    Response response;
    Physician [] pyhsician;

    @Given("user sends a get request for physicians data")
    public void userSendsAGetRequestForUserData() {
        response= given().headers(
                "Authorization",
                "Bearer "+generateToken(),
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("pyhsicians_api_get_url"));
        response.prettyPrint();
    }

    @Then("the status codes should be {int}")
    public void thestatuscodesshouldbe(Integer statuscode) {
        response.then().assertThat().statusCode(statuscode);
    }

    @When("user deserializeses the user data to java")
    public void userDeserializesTheUserDataToJava() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        pyhsician =obj.readValue(response.asString(),Physician [].class);

    }

}
