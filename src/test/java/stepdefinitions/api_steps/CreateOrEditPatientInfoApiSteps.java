package stepdefinitions.api_steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Patient;
import utilities.Authentication;
import utilities.ConfigReader;


import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;


public class CreateOrEditPatientInfoApiSteps {
    Response response;

    JsonPath json;

    Patient [] patients;

    @Given("user sends get request all patients")
    public void user_sends_get_request_all_patients() {
        response = given().headers("Authorization",
                        "Bearer " + Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"),ConfigReader.getProperty("passwordAdmin")),
                        "Content-Type", ContentType.JSON,
                        "Accept",ContentType.JSON)
                .when().get(ConfigReader.getProperty("allPatients_api_url"));
        //response.prettyPrint();
    }
    @Then("user sees the status code as {int}")
    public void user_sees_the_status_code_as(Integer statusCode) {
        Assert.assertEquals((long)statusCode,response.getStatusCode());
    }
    @Then("User makes  all patients info deserialize")
    public void user_makes_all_patients_info_deserialize() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        patients=obj.readValue(response.asString(),Patient[].class);
    }
    @Then("validate {string} Id")
    public void validate_id(String Id) {
       Assert.assertEquals(Id,String.valueOf(patients[0].getId()));
    }
    @Then("validate {string} Ssn")
    public void validate_ssn(String Ssn) {
        Assert.assertEquals(Ssn,patients[0].getUser().getSsn());
    }
    @Then("validate {string} firstname")
    public void validate_firstname(String firstname) {
        Assert.assertEquals(firstname,patients[0].getFirstName());
    }
    @Then("validate {string} lastname")
    public void validate_lastname(String lastname) {
        Assert.assertEquals(lastname,patients[0].getLastName());
    }
    @Then("validate {string} birthDate")
    public void validate_birth_date(String birthDate) {
        Assert.assertEquals(birthDate,patients[0].getBirthDate());
    }
    @Then("validate {string} phone")
    public void validate_phone(String phone) {
        Assert.assertEquals(phone,patients[0].getPhone());
    }
    @Then("validate {string} email")
    public void validate_email(String email) {
        Assert.assertEquals(email,patients[0].getEmail());
    }
    @Then("validate {string} gender")
    public void validate_gender(String gender) {
        Assert.assertEquals(gender,patients[0].getGender());
    }
    @Then("validate {string} bloodGroup")
    public void validate_blood_group(String bloodGroup) {
        Assert.assertEquals(bloodGroup,patients[0].getBloodGroup());
    }
    @Then("validate {string} address")
    public void validate_address(String address) {
        Assert.assertEquals(address,patients[0].getAdress());
    }
    @Then("validate {string} description")
    public void validate_description(String description) {
        Assert.assertEquals(description,patients[0].getDescription());
    }
    @Then("validate {string} createDate")
    public void validate_create_date(String createDate) {
        Assert.assertEquals(createDate,patients[0].getCreatedDate());
    }
    @Then("validate {string} username")
    public void validate_username(String username) {
        Assert.assertEquals(username,patients[0].getUser().getLogin());
    }
    @Then("validate {string} country")
    public void validate_country(String country) {
        Assert.assertEquals(country,patients[0].getCountry().getName());
    }
    @Then("validate {string} state/city")
    public void validate_state_city(String state) {
        Assert.assertEquals(state,patients[0].getCstate().getName());
    }

}
