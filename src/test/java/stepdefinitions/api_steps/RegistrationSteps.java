package stepdefinitions.api_steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.TXTWriter.saveUiRegistrantsData;

public class RegistrationSteps {
    Response response;
    Registrant [] registrants;
    @Given("user sends a get request for users' data")
    public void user_sends_a_get_request_for_users_data() {

        response= given().headers(
            "Authorization",
            "Bearer "+ConfigReader.getProperty("api_token"),//generateToken (),//
            "Content-type", ContentType.JSON,
            "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("users_api_url"));


    }
    @Given("user deserializes the users' data to java")
    public void user_deserializes_the_users_data_to_java() throws Exception {

        ObjectMapper obj=new ObjectMapper();

        registrants=obj.readValue(response.asString(),Registrant[].class);

 System.out.println("Size ==>> "+registrants.length);
/*
        boolean flag=false;
        for (int i = 0; i < registrants.length; i++) {
 //           System.out.println("mane"+ i+1+" : "+registrants[i].getFirstName);
            if ("856-45-6777".contains(registrants[i].getSsn())){
                flag=true;
            }
        }
        assertTrue(flag);               */
    }

    @Then("user saves the users' data to correspondent files and validates")
    public void user_saves_the_users_data_to_correspondent_files_and_validates() {

        saveUiRegistrantsData(registrants);

    }

}

