package stepdefinitions.db_steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import java.util.ArrayList;
import java.util.List;

public class MakeAnAppointmentDB_EEStepDefs {
    String query = "SELECT * FROM appointment WHERE id=280851";
    List<Object> appointmentList;

    @Given("User connects to database")
    public void user_connects_to_database() {
        DBUtils.createConnection();
    }

    @Then("User gets appointment info")
    public void user_gets_appointment_info() {
        DBUtils.executeQuery(query);
        appointmentList = DBUtils.getColumnData(query, "id");
        System.out.println(appointmentList);
    }

    @Then("User verifies appointment {string}")
    public void user_verifies_appointment(String id) {
        List<String> idList = new ArrayList<>();
        for (Object w : appointmentList) {
            idList.add(w.toString());
        }
        Assert.assertTrue("There is no id", idList.contains(id));

    }

    @Then("User closes the database connection")
    public void user_closes_the_database_connection() {
        DBUtils.closeConnection();
    }


}