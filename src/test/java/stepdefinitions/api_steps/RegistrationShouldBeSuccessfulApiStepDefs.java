package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Registrant;
import utilities.ConfigReader;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;


public class RegistrationShouldBeSuccessfulApiStepDefs {
    Response response;
    Registrant [] registrants ;
    List<String> actualUsernameData;
    JsonPath json;
    List<String> actualEmailData;
    Registrant postBody =  new Registrant();

    @Given("user sends a get request for user data")
    public void userSendsAGetRequestForUserData() {
        response= given().headers(
                "Authorization",
                "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("users_api_url"));
        //response.prettyPrint();
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("username as {string} should be validated")
    public void username_as_should_be_validated(String username) {
        json=response.jsonPath();
        actualUsernameData= json.getList("findAll{it.id>0}.login");
//        boolean flag=false;
//        for (int i = 0; i <actualUsernameData.size() ; i++) {
//            if (!actualUsernameData.contains(username)){
//                flag= true;
//            }
//        }
//        Assert.assertTrue(flag);
       //response.then().assertThat().body("login",hasItem(username.toLowerCase()));
        Assert.assertFalse("Username cannot be the same as the others",actualUsernameData.contains(username));

    }

    @Then("usernames must be unique")
    public void usernames_must_be_unique() {
        System.out.println(actualUsernameData);
        Set<String> uniqueUsername= new HashSet<>();
        for (String w:actualUsernameData) {
            uniqueUsername.add(w);
        }
        boolean flag= false;
        if(actualUsernameData.size()== uniqueUsername.size()){
            flag= true;
        }
        Assert.assertTrue(flag);

    }
    @And("user deserializes the user data to java")
    public void userDeserializesTheUserDataToJava() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        registrants =obj.readValue(response.asString(),Registrant[].class);

    }
    @And("username as {string} which is already used should be validated")
    public void usernameAsWhichIsAlreadyUsedShouldBeValidated(String username) {
        json=response.jsonPath();
        actualUsernameData= json.getList("findAll{it.id>0}.login");
        Assert.assertTrue(actualUsernameData.contains(username));
        System.out.println("Username cannot be the same as the others");
    }

    @And("email as {string} should be validated")
    public void emailAsShouldBeValidated(String email) {
        json=response.jsonPath();
        actualEmailData= json.getList("findAll{it.id>0}.email");
//        boolean flag=false;
//        for (int i = 0; i <actualUsernameData.size() ; i++) {
//            if (!actualUsernameData.contains(username)){
//                flag= true;
//            }
//        }
//        Assert.assertTrue(flag);
        //response.then().assertThat().body("login",hasItem(username.toLowerCase()));
        Assert.assertFalse("Email cannot be the same as the others",actualEmailData.contains(email));

    }

    @And("emails must be unique")
    public void emailsMustBeUnique() {
        System.out.println(actualEmailData);
        Set<String> uniqueEmail= new HashSet<>();
        for (String w:actualEmailData) {
            uniqueEmail.add(w);
        }
        boolean flag= false;
        if(actualEmailData.size()== uniqueEmail.size()){
            flag= true;
        }
        Assert.assertTrue(flag);
    }

    @Given("user creates a post body")
    public void userCreatesAPostBody() {
        postBody.setFirstName(new Faker().name().firstName());
        postBody.setLastName(new Faker().name().lastName());
        postBody.setSsn(new Faker().idNumber().ssnValid());
        postBody.setLogin(new Faker().name().username());
        postBody.setPassword(new Faker().internet().password(8,10,true,true));
        postBody.setEmail(new Faker().name().username()+"@gmail.com");

    }
    @Given("user sends post request for creating new registrant")
    public void user_sends_post_request_for_creating_new_registrant() {
        spec.pathParams("first","api","second","users");
        response= given().spec(spec).headers(
                "Authorization",
                "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(postBody).when().post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("Status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }
    @Then("user verifies username and email with given data in body")
    public void user_verifies_username_and_email_with_given_data_in_body() {
        json =response.jsonPath();
        Assert.assertEquals(postBody.getLogin(),json.getString("login"));
        Assert.assertEquals(postBody.getEmail(),json.getString("email"));

    }
}
