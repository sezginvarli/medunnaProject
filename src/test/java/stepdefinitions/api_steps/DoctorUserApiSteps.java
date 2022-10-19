package stepdefinitions.api_steps;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DoctorUserApiSteps {
    Response response;
    String doctor_token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkb2N0b3J1cmZhNSIsImF1dGgiOiJST0xFX1BIWVNJQ0lBTiIsImV4cCI6MTY2NjMwMzk3Nn0.svjN4u_QeUrUhh-3h2xuDZMmfl9S7gtLAuz1XhwkilcsB2z1s_t8C53Aia9rplnPExv8wHrtklrfC8Zuhy4FyQ";
    @Given("user sends a GET patient request for doctor users")
    public void user_sends_a_GET_patient_request_for_doctor_users() {

        RequestSpecification spec=new RequestSpecBuilder().setBaseUri("https://medunna.com").build();

        spec.pathParams("first","api","second","appointments");
        response=given().headers(
                "Authorization",
                "Bearer "+doctor_token,
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
