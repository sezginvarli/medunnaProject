package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Message;
import utilities.ConfigReader;

import java.util.Arrays;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;
import static utilities.TXTReader.readFile;

public class ContactMessagesApiStepDefs {
    Response response;
    Message [] message;
    @Given("user sends get request for all contact information")
    public void user_sends_get_request_for_all_contact_information() {
        spec.pathParams("first","api","second","c-messages").queryParams("size",20100);
        response= given().spec(spec).headers(
                "Authorization",
                "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get("/{first}/{second}");
        response.prettyPrint();
    }
    @Given("user deserializes the messages to java")
    public void user_deserializes_the_messages_to_java() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        message =obj.readValue(response.asString(), Message [].class);
        System.out.println(Arrays.toString(message));

    }
    @Given("user validates status code and their data using txt file")
    public void user_validates_status_code_and_their_data_using_txt_file() {
        String messageData= readFile(ConfigReader.getProperty("save_message"));
        String [] data= messageData.split("'");
        System.out.println(Arrays.toString(data));
        String email= data[1];
        System.out.println(email);
        String messageStr= data[3];
        System.out.println(messageStr);
        String name = data[5];
        System.out.println(name);
        String subject = data[7];
        System.out.println(subject);

        boolean flag=false;
        for (int i = 0; i < message.length; i++) {
            if (email.contains(message[i].getEmail()) & messageStr.contains(message[i].getMessage()) &
                    message[i].getName().contains(name) & message[i].getSubject().contains(subject)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);

        int counter=0;
        for (int i = 0; i < message.length; i++) {
            if (email.contains(message[i].getEmail())) {
                counter++;
            }
        }
        System.out.println("number of john' message : "+counter);
    }
}
