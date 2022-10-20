package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
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

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class PhysiciansStepDefs {
    Response response;
    Physician [] pyhsician;
    Physician postbody= new Physician();

    @Given("user sends a GET request for physicians data")
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

//    @Given("User sends DELETE request for physicians {id})
//    public void userSendsDELETERequestForPhysiciansData(int id) {
//        response= given().headers(
//                "Authorization",
//                "Bearer "+generateToken(),
//                "Content-type", ContentType.JSON,
//                "Accept", ContentType.JSON
//        ).when().get(ConfigReader.getProperty("pyhsicians_api_delete_url"));
//        response.prettyPrint();
//    }

    @Given("user creates a postbody")
    public void user_creates_a_postbody() {

        postbody.setSsn(new Faker().idNumber().ssnValid());
        postbody.setFirstName(new Faker().name().firstName());
        postbody.setLastName(new Faker().name().lastName());
        postbody.setBirthDate("01/01/2000");
        postbody.setExamFee(125);
    }
    @Given("user sends post request for creating new physician")
    public void user_sends_post_request_for_creating_new_physician() {
        spec.pathParams("first","api","second","physicians");
        response= given().spec(spec).headers(
                "Authorization",
                "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON
        ).body(postbody).when().post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("Status codes should be {int}")
    public void status_code_should_be(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }

}
