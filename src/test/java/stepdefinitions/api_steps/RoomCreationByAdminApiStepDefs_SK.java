package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Room;
import pojos.Room_SK;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;
//import static utilities.TXTWriter.saveUiAllRoomsData;


public class RoomCreationByAdminApiStepDefs_SK {

    Response response;
    Room[] rooms;

    Room_SK[] room_sk;

    Room_SK expectedRoom = new Room_SK();

    @Given("admin sends a get request for rooms' data")
    public void admin_sends_a_get_request_for_rooms_data() {
        response= given().headers(
                "Authorization",
                "Bearer "+ generateToken(),
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("allRooms_api_url"));
        //response.prettyPrint();
    }
    @Given("admin should receive {int} status code")
    public void admin_should_receive_status_code(Integer statusCode) {


        response.then().assertThat().statusCode(200);
    }
    @Given("admin deserializes the rooms' data to java")
    public void admin_deserializes_the_rooms_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        rooms = obj.readValue(response.asString(), Room[].class);
        System.out.println(" Size of the actual element : " + rooms.length);

        boolean flag = false;
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room id :" + rooms[i].getId());
            System.out.println("Room Number : " + rooms[i].getRoomNumber());
            System.out.println("Room Type : " + rooms[i].getRoomType());

            if("734000".equals(String.valueOf(rooms[i].getRoomNumber()).trim())){
                flag= true;
            }
        }
        assertTrue(flag);
    }
//    @Then("admin saves the rooms' data to corresponding file and validates the data")
//    public void admin_saves_the_rooms_data_to_corresponding_file_and_validates_the_data() {
//
//        saveUiAllRoomsData(rooms);
//    }

    @Given("admin sends a post request for rooms' data")
    public void admin_sends_a_post_request_for_rooms_data() {
        //set the url
        spec.pathParams("first", "api", "second", "rooms");

        //set the expected data

        expectedRoom.setRoomNumber(65007896);
        expectedRoom.setRoomType("DELUXE");
        expectedRoom.setDescription("validation");
        expectedRoom.setStatus(true);
        expectedRoom.setPrice(15000);

        //send the request and get the response
        response= given().spec(spec).headers(
                "Authorization",
                "Bearer "+ generateToken(),
                "Content-type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).contentType(ContentType.JSON).body(expectedRoom).when().post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("admin validates the post data to java")
    public void admin_validates_the_post_data_to_java() throws JsonProcessingException {
        response.then().assertThat().body("roomNumber", equalTo(expectedRoom.getRoomNumber())).
                body("roomType", equalTo(expectedRoom.getRoomType())).
                body("description",equalTo(expectedRoom.getDescription())).
                body("price", equalTo(expectedRoom.getPrice()));
        ObjectMapper obj = new ObjectMapper();

//        Map<String,Object> actualMapData = response.as(HashMap.class);
//
//        Assert.assertEquals(actualMapData.get("status"), expectedRoom.getStatus());
//        Assert.assertEquals(actualMapData.get("roomNumber"), expectedRoom.getRoomNumber());
//        Assert.assertEquals(actualMapData.get("description"), expectedRoom.getDescription());
//        Assert.assertEquals(actualMapData.get("roomType"), expectedRoom.getRoomType());



//        JsonPath jsonPath = response.jsonPath();
//
//        Assert.assertEquals(jsonPath.getInt("roomNumber"), expectedRoom.getRoomNumber());
//        Assert.assertEquals(jsonPath.getString("roomType"), expectedRoom.getRoomType());
//        Assert.assertEquals(jsonPath.getString("description"), expectedRoom.getDescription());
//        Assert.assertEquals(jsonPath.getBoolean("status"), expectedRoom.getStatus());


    }

}
