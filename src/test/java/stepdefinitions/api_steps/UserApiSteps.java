package stepdefinitions.api_steps;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiSteps {
    Response response;
    String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbnVyZmEiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY2ODUyNTY1NH0.YmMJDZWD_SsDH9wp2-VudfKM3ULjYVr2WfDXcHX5UjbqbBgnPoxRlucivZMeWt9GZuVMku5BIe1vD_u-i9WK7w";
    @Given("user sends a get request for users")
    public void user_sends_a_get_request_for_users() {


        RequestSpecification spec=new RequestSpecBuilder().setBaseUri("https://medunna.com").build();

        spec.pathParams("first","api","second","users");
        response=given().headers(
                "Authorization",
                "Bearer "+token,
                "Content-Type",
                "application/json",
                "Accept","application/json"

        ).spec(spec).when().get("/{first}/{second}");
    }
    @Given("user converts user records to Java")
    public void user_converts_user_records_to_java() {
        response.prettyPrint();
    }
    @Then("user validates user data")
    public void user_validates_user_data() {

    }
}
