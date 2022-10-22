package stepdefinitions.api_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.generateTokenApi.getToken;

public class MakeAnAppointmentApiStepDefs {
    Response response;

    //String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDg2IiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2Njg1MjU0NTV9.gOPwwnl0uHxgv_1tkhq6A8g6RD4oUnic5DMXqZkzL7r1hPsS2_wwazXZ80puJkvlEOjIK4GdriLXEvcDL9n2GQ";
    @Given("user sends a get request for appointment")
    public void user_sends_a_get_request_for_appointment() {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "appointments","third","280851");
        response = given().headers(
                "Authorization", "Bearer "+ Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"),ConfigReader.getProperty("passwordAdmin")),
                "Content-Type", ContentType.JSON,
                "Accept" , ContentType.JSON
        ).spec(spec).when().get("/{first}/{second}/{third}");
    }
    @Given("user converts appointment records to Java")
    public void user_converts_user_records_to_java() {

        response.prettyPrint();
    }

    @Then("user validates {int} appointment id")
    public void userValidatesAppointmentId(int id) {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(id,jsonPath.getInt("id"));
    }
}