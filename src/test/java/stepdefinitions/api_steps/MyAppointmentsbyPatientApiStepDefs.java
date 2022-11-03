package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Bill;
import pojos.CTestOneResult;

import java.util.Arrays;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateTokenWithUsernamePassword;

public class MyAppointmentsbyPatientApiStepDefs {
    Response response;
    Response response2;
    Bill bill;
    CTestOneResult [] cTestOneResult;
    @Given("user sends a get request with given id {string} for payment validation")
    public void user_sends_a_get_request_with_given_id_for_payment_validation(String id) {
        spec.pathParams("first", "api", "second", "bills","third","appointment","fourth",id);
        response= given().headers(
                "Authorization",
                "Bearer "+generateTokenWithUsernamePassword("John123","john123"),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().spec(spec).get("/{first}/{second}/{third}/{fourth}");
        //response.prettyPrint();
    }
    @Then("the status code should be {int} for payment validation")
    public void the_status_code_should_be_for_payment_validation(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }
    @Then("user deserializes the payment data to java")
    public void user_deserializes_the_payment_data_to_java() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        bill =obj.readValue(response.asString(), Bill.class);

    }
    @Then("user should be validated payment information")
    public void user_should_be_validated_payment_information() {
        Assert.assertEquals(bill.getSsn(),"532-65-8712");
        assertTrue(bill.getTotalCost()==1361.0);
        assertTrue(bill.getId()==262925);
        Assert.assertEquals(bill.getBillName(),"John John");
        Assert.assertEquals(bill.getPaymentMethod(),"CREDIT_CARD");

    }
    @Given("user sends a get request with given id {string} for test results validation")
    public void user_sends_a_get_request_with_given_id_for_test_results_validation(String id) {
        spec.pathParams("first", "api", "second", "c-test-results","third","c-test","fourth",id);
        response2= given().headers(
                "Authorization",
                "Bearer "+generateTokenWithUsernamePassword("JohnStaff","JohnStaff"),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().spec(spec).get("/{first}/{second}/{third}/{fourth}");
        response2.prettyPrint();

    }
    @Then("the status code should be {int} for test results validation")
    public void the_status_code_should_be_for_test_results_validation(Integer statusCode) {
        response2.then().assertThat().statusCode(statusCode);

    }
    @Then("user deserializes the test results data to java")
    public void user_deserializes_the_test_results_data_to_java() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        cTestOneResult =obj.readValue(response2.asString(), CTestOneResult [].class);
        System.out.println(Arrays.toString(cTestOneResult));
    }
    @Then("user should be validated test results information")
    public void user_should_be_validated_test_results_information() {
        boolean flag=false;
        for (int i = 0; i < cTestOneResult.length; i++) {
            if ("50".contains(cTestOneResult[i].getMaxValue()) & "JohnBloodTest".contains(cTestOneResult[i].getName()) &
                    cTestOneResult[i].getPrice()==250 & cTestOneResult[i].getMinValue().contains("5")){
                flag=true;
            }
        }
        assertTrue(flag);
    }
}
