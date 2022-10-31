package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Message;
import utilities.ConfigReader;


import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static utilities.Authentication.generateToken;
import static utilities.TXTReader.readFileElementExist;
import static utilities.TXTWriter.saveApiMessagesData;

public class MessagesApiStepDefs {
    Message expectedMessage =new Message();
    Faker faker=new Faker();
    Response response;
    Message [] messages;
    @Given("user send a post request for message creating")
    public void user_send_a_post_request_for_message_creating() {
        spec.pathParams("first","api","second","c-messages");

        expectedMessage.setEmail(faker.internet().emailAddress());
        expectedMessage.setMessage(faker.shakespeare().asYouLikeItQuote());
        expectedMessage.setName(faker.name().firstName());
        expectedMessage.setSubject(faker.medical().hospitalName());

        response=given().spec(spec).headers(
                "Authorization","Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).contentType(ContentType.JSON).body(expectedMessage).when().post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("status code should be {string}")
    public void status_code_should_be(String statusCode) {
        response.then().assertThat().statusCode(Integer.parseInt(statusCode));
    }
    @Then("user validates the post data")
    public void user_validates_the_post_data() throws JsonProcessingException {
//        //Validation 1
//            response.then().assertThat().statusCode(201).body("email",equalTo(expectedMessage.getEmail())).
//                    body("message",equalTo(expectedMessage.getMessage())).
//                    body("name",equalTo(expectedMessage.getName())).
//                    body("subject",equalTo(expectedMessage.getSubject()));
//
//         //Validation 2
//        JsonPath jsonPath=response.jsonPath();
//        Assert.assertEquals(jsonPath.getString("email"),expectedMessage.getEmail());
//        Assert.assertEquals(jsonPath.getString("name"),expectedMessage.getName());
//        Assert.assertEquals(jsonPath.getString("subject"),expectedMessage.getSubject());
//        Assert.assertEquals(jsonPath.getString("message"),expectedMessage.getMessage());
//
//        //Validation 3
//
//        Map<String,Object> actualMapData = response.as(HashMap.class);
//
//        Assert.assertEquals(actualMapData.get("email"), expectedMessage.getEmail());
//        Assert.assertEquals(actualMapData.get("name"), expectedMessage.getName());
//        Assert.assertEquals(actualMapData.get("subject"), expectedMessage.getSubject());
//        Assert.assertEquals(actualMapData.get("message"), expectedMessage.getMessage());
//
//        //Validation 4
//
//        Message actualMessageData=response.as(Message.class);
//
//        Assert.assertEquals(actualMessageData.getEmail(),expectedMessage.getEmail());
//        Assert.assertEquals(actualMessageData.getMessage(), expectedMessage.getMessage());
//        Assert.assertEquals(actualMessageData.getName(), expectedMessage.getName());
//        Assert.assertEquals(actualMessageData.getSubject(), expectedMessage.getSubject());

        //Validation 5

        ObjectMapper obj = new ObjectMapper();

        Message actualMessageObj = obj.readValue(response.asString(), Message.class);

        Assert.assertEquals(actualMessageObj.getMessage(), expectedMessage.getMessage());
        Assert.assertEquals(actualMessageObj.getName(), expectedMessage.getName());
        Assert.assertEquals(actualMessageObj.getEmail(), expectedMessage.getEmail());
        Assert.assertEquals(actualMessageObj.getSubject(), expectedMessage.getSubject());

        //Validation 6

//        Gson gson = new Gson();
//
//        Message actualMessageGson=gson.fromJson(response.asString(),Message.class);
//
//        Assert.assertEquals(actualMessageGson.getMessage(), expectedMessage.getMessage());
//        Assert.assertEquals(actualMessageGson.getName(), expectedMessage.getName());
//        Assert.assertEquals(actualMessageGson.getEmail(), expectedMessage.getEmail());
//        Assert.assertEquals(actualMessageGson.getSubject(), expectedMessage.getSubject());
    }
    @Given("user send a get request for message reading")
    public void user_send_a_get_request_for_message_reading() {
        spec.pathParams("first","api","second","c-messages").queryParams("size",50);

        response=given().spec(spec).headers(
                "Authorization","Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).contentType(ContentType.JSON).when().get("/{first}/{second}");
        //response.prettyPrint();
    }
    @When("user deserializes the message's data to Java and save")
    public void user_deserializes_the_message_s_data_to_java_and_save() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();

        Message[] messages = obj.readValue(response.asString(), Message[].class);

        saveApiMessagesData(messages);
    }
    @Then("user validates the room data {string},{string},{string} and {string}")
    public void user_validates_the_room_data_and(String email, String name, String subject, String message) {

        boolean flag=readFileElementExist(ConfigReader.getProperty("messages_data"),email);
        boolean flag2=readFileElementExist(ConfigReader.getProperty("messages_data"),name);
        boolean flag3=readFileElementExist(ConfigReader.getProperty("messages_data"),subject);
        boolean flag4=readFileElementExist(ConfigReader.getProperty("messages_data"),message);
    }
}
