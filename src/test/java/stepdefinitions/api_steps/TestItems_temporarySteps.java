package stepdefinitions.api_steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import hooks.Hooks;
import static hooks.Hooks.spec;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.CTestItem;
import utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class TestItems_temporarySteps {

    Response response;
    CTestItem testItem= new CTestItem();



}
