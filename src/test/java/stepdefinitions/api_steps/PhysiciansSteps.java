package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Physician;
import utilities.ConfigReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.TXTReader.readFile;
import static utilities.TXTReader.readFileElementExist;
import static utilities.TXTWriter.savePhysiciansData;

public class PhysiciansSteps {
    Physician[] physiciansApi;
    Response response;
    @Given("admin send the request for physicians data")
    public void admin_send_the_request_for_physicians_data() {
        response= given().headers(
                "Authorization",
                "Bearer "+ generateToken (),//
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("physicians_api_url"));
    }
    @Given("admin deserialization the physicians data to java")
    public void admin_deserialization_the_physicians_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        physiciansApi = obj.readValue(response.asString(), Physician[].class);
        System.out.println(physiciansApi.length);
    }
    @Then("admin saves users data correspondent files to validate")
    public void admin_saves_users_data_correspondent_files_to_validate() {
        savePhysiciansData(physiciansApi);
        String files = readFile(ConfigReader.getProperty("physicians_api_data"));
        System.out.println(files.contains("Kay"));
        boolean flag = readFileElementExist(ConfigReader.getProperty("physicians_api_data"),"merve_mahir@gmail.com");
        System.out.println("yes there is exist"+flag);
        Assert.assertTrue(flag);
    }
}
