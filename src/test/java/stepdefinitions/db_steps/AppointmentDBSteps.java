package stepdefinitions.db_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.Appointment;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.TXTReader;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.getColumnData;

public class AppointmentDBSteps {
    Appointment appointment;
    String query = "select * from appointment where patient_id = 281916";
    @When("user gets appointments data from db")
    public void user_gets_appointments_data_from_db() {
        DBUtils.executeQuery(query);
    }
    @Then("user validates appointment exist db")
    public void user_validates_appointment_exist_db() throws JsonProcessingException {

        List<Object> actualList = getColumnData(query,"id");
        List<String> actualListString= new ArrayList<>();

        for (Object w:actualList) {
            actualListString.add(w.toString());
        }
        System.out.println(actualListString);

        Assert.assertTrue("There are no such ids",actualListString.contains("284252"));
    }
}
