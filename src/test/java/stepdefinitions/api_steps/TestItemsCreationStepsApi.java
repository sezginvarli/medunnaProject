package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
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
import static hooks.Hooks.spec;
import utilities.TXTWriter;

import java.util.List;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.Authentication.generateTokenWithUsernamePassword;
import static utilities.TXTWriter.saveApiTestItemsData;

public class TestItemsCreationStepsApi {
    Response response;
    Response response2;
    CTestItem[] cTestItem;
    JsonPath json;
    List<Integer> actualId;
    CTestItem testItem = new CTestItem();

    @Given("admin sends a GET request for test items all data")
    public void admin_sends_a_get_request_for_test_items_all_data() {

        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "c-test-items", "third", "all");
        response = given().headers("Authorization", "Bearer " +
                        Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"), ConfigReader.getProperty("passwordAdmin")),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).spec(spec).when().get("/{first}/{second}/{third}");
        System.out.println(Authentication.generateTokenWithUsernamePassword("team03alpha", "team03Admin"));
        //response.prettyPrint();

    }

    @When("user deserializes the test items data to java")
    public void user_deserializes_the_test_items_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        cTestItem = obj.readValue(response.asString(), CTestItem[].class);
        System.out.println(cTestItem.length);

    }

    @Then("Check if the new created tests exist by {int}")
    public void check_if_the_new_created_tests_exist_by(int id) {

        json = response.jsonPath();
        actualId = json.getList("findAll{it.id>0}.id");
        System.out.println(actualId);
        boolean flag = false;
        for (int i = 0; i < actualId.size(); i++) {
            if (actualId.get(i) == id) {
                flag = true;
                System.out.println("Your id is here : " + actualId.get(i));
            }
            //else { System.out.println("Your id is NOT here : " + actualId.get(i)); }
        }
        Assert.assertTrue(flag);
    }

    /*
    @Given("admin make a post request to create a new test item")
    public void admin_make_a_post_request_to_create_a_new_test_item() {

        expectedTestItem.setCreatedBy("Batch86.hk");
        expectedTestItem.setCreatedDate("2022-10-31T10:10:32.858662Z");
        expectedTestItem.setPrice(187.0);
        expectedTestItem.setDefaultValMin("10.0");
        expectedTestItem.setDefaultValMax("50.0");
        expectedTestItem.setDescription("eda.hk");
        expectedTestItem.setName("bloodtest4");


        spec.pathParams("first", "api", "second", "c-test-items");
        response2 = given().spec(spec).headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(expectedTestItem).when().post("/{first}/{second}");
        response2.prettyPrint();

        response2.then().assertThat().statusCode(201);
    }       */

    @When("user sends price as {double}, defaultValMax as {string}, defaultValMin as {string}")
    public void user_sends_price_as_default_val_max_as_default_val_min_as(Double price, String maxValue, String minValue) {
        testItem.setPrice(price);
        testItem.setDefaultValMax(maxValue);
        testItem.setDefaultValMin(minValue);
    }
    @When("user sends description as {string} ,test items' name as {string}")
    public void user_sends_description_as_test_items_name_as(String description, String name) {
        testItem.setDescription(description);
        testItem.setName(name);
    }
    @Then("admin make a post request to create a new test item")
    public void admin_make_a_post_request_to_create_a_new_test_item() {
        spec.pathParams("first", "api", "second", "c-test-items");

        response= given().spec(spec).headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(testItem).when().post("/{first}/{second}");
        response.prettyPrint();

        TXTWriter.saveApiCreatedTestItemsData(response);
    }
    @Then("user validate test item is created as expected")
    public void user_validate_test_item_is_created_as_expected() {
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(201,response.statusCode());
        Assert.assertEquals(jsonPath.getString("defaultValMax"),testItem.getDefaultValMax());
        Assert.assertEquals(jsonPath.getString("defaultValMin"),testItem.getDefaultValMin());
        Assert.assertEquals(jsonPath.getString("description"),testItem.getDescription());
        Assert.assertEquals(jsonPath.getString("name"),testItem.getName());
        Assert.assertEquals(jsonPath.getDouble("price"),testItem.getPrice(),0);

    }
    @Then("user make a delete request for the {int} test item & validate the deletion")
    public void user_make_a_delete_request_for_the_test_item_validate_the_deletion(Integer id) {
        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "c-test-items", "third", id);
        response = given().headers("Authorization", "Bearer " +
                        Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"), ConfigReader.getProperty("passwordAdmin")),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).spec(spec).when().get("/{first}/{second}/{third}");
        System.out.println("get response : ");
   //     response.prettyPrint();

        response = given().headers("Authorization", "Bearer " +
                        Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"), ConfigReader.getProperty("passwordAdmin")),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).spec(spec).when().delete("/{first}/{second}/{third}");
        System.out.println("delete response : ");
   //     response.prettyPrint();
        Assert.assertEquals(204,response.statusCode());



    }


}


