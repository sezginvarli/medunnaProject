package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class   Authentication {

    public static String generateToken(){
    // set the base url and pathParams
        spec.pathParams("first","api","second","authenticate");

    // set the expected data
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("password","Batch86+");
        expectedData.put("rememberMe",true);
        expectedData.put("username","Batch86");

    // send the request & get the response
        Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();
        JsonPath json=response.jsonPath();

        return json.getString("id_token");
    }

}
