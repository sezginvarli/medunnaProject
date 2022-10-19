package stepdefinitions.api_steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.Patient;
import utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class PatientValidateInfoApiSteps {

    Patient[] patientSsn;
    Patient patient;
    Response response;


    @Given("User sends GET patient request as Staff to end point")
    public void user_sends_get_patient_request_as_staff_to_end_point() {

        response = given().headers("Authorization",
                        "Bearer " + Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameStaff"),ConfigReader.getProperty("passwordStaff")),
                        "Content-Type", ContentType.JSON,
                        "Accept",ContentType.JSON)
                .when().get(ConfigReader.getProperty("endpointGetId"));
        response.prettyPrint();
    }


    @Given("User validate status code {int}")
    public void user_validate_status_code(Integer statusCode) {
        // response.then().assertThat().statusCode(statusCode);
        int  code=response.getStatusCode();
        Assert.assertTrue("Status code is not 200.Status code is "+ code+"",code==statusCode);
    }


    @Given("User makes patient info deserialize")
    public void user_makes_patient_info_deserialize()throws Exception {

        ObjectMapper obj=new ObjectMapper();
        patient=obj.readValue(response.asString(),Patient.class);

    }


    @Given("User validate patient with {string}")
    public void user_validate_patient_with(String id) {
        System.out.println(patient.getId());
      Assert.assertTrue("It is not same id",id.equals(String.valueOf(patient.getId())));

    }

    @Given("User sends GET request as Admin to end point")
    public void user_sends_get_request_as_admin_to_end_point() {
        response = given().headers("Authorization",
                        "Bearer " +Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"),ConfigReader.getProperty("passwordAdmin")),
                        "Content-Type", ContentType.JSON,
                        "Accept",ContentType.JSON)
                .when().get(ConfigReader.getProperty("endpointGetId"));
        response.prettyPrint();

    }
    @Given("Admin sends DELETE request to URL")
    public void admin_sends_delete_request_to_url() {

        response = given().headers("Authorization",
                        "Bearer " +Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"),ConfigReader.getProperty("passwordAdmin")),
                        "Content-Type", ContentType.JSON)
                .when().delete(ConfigReader.getProperty("endpointDeleteId"));


    }
    @Given("Staff sends DELETE request to URL")
    public void staff_sends_delete_request_to_url() {
        response = given().headers("Authorization",
                        "Bearer " +Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameStaff"),ConfigReader.getProperty("passwordStaff")),
                        "Content-Type", ContentType.JSON)
                .when().delete(ConfigReader.getProperty("endpointDeleteId2"));
    }
    @Given("Staff validate status code {int}")
    public void staff_validate_status_code(int statusCode) {
        int  code= response.getStatusCode();
        System.out.println(code);
        Assert.assertTrue("Status code is not 400 or 403",code==403);

    }

    @Given("Staff sends {string} to search URL")
    public void staff_sends_to_search_url(String string) {

        response = given().headers("Authorization",
                        "Bearer " +Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameStaff"),ConfigReader.getProperty("passwordStaff")),
                        "Content-Type", ContentType.JSON,
                        "Accept",ContentType.JSON)
                .when().get(ConfigReader.getProperty("endpointsearch"));
        response.prettyPrint();
    }

    @Given("Staff makes patient info deserialize")
    public void staff_makes_patient_info_deserialize() throws Exception {

        ObjectMapper obj=new ObjectMapper();
        patientSsn=obj.readValue(response.asString(),Patient[].class);
        System.out.println(patientSsn[0].getUser().getSsn());
    }

    @Given("Staff validate patient info")
    public void staff_validate_patient_info() {

        Assert.assertEquals("111-27-8888",patientSsn[0].getUser().getSsn());
    }

    @Given("Admin sends {string} to search URL")
    public void admin_sends_to_search_url(String string) {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        String enddd="https://medunna.com/api/patients/search?ssn=111-27-8888";
        spec.pathParams("first", "api", "second", "appointments");
        response = given().headers("Authorization",
                        "Bearer " +Authentication.generateTokenWithUsernamePassword(ConfigReader.getProperty("usernameAdmin"),ConfigReader.getProperty("passwordAdmin")),
                        "Content-Type", ContentType.JSON,
                        "Accept",ContentType.JSON)
                .when().get(ConfigReader.getProperty("endpointsearch"));
        response.prettyPrint();
    }

    @Given("Admin verifies status code {int}")
    public void admin_verifies_status_code(Integer statusCode) {
        int  code=response.getStatusCode();
        System.out.println(code);
        Assert.assertTrue("Status code is not 400. Admin shouldn't be able to search.Status code "+code,code==statusCode);
    }


}
