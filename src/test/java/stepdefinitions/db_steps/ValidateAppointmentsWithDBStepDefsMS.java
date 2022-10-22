package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.getColumnData;

public class ValidateAppointmentsWithDBStepDefsMS {
    String query ="SELECT * FROM appointment where physician_id=277681" ;
    @Given("user connect to applicants database")
    public void user_connect_to_applicants_database() throws SQLException {
        DBUtils.createConnection();
    }
    @Then("user get the data from database")
    public void user_get_the_data_from_database() {
        DBUtils.executeQuery(query);

    }
    @Then("user reads all of the patient's id, start date, end date from database")
    public void user_reads_all_of_the_patient_s_id_start_date_end_date_from_database() {
        List<Object> actualList = getColumnData(query,"id");
        List<String> actualListString= new ArrayList<>();

        for (Object w:actualList) {
            actualListString.add(w.toString());
            System.out.println(w);
        }
        Assert.assertTrue("There are no such ids",actualListString.contains("277935"));
    }

    @Then("user close the connection")
    public void user_close_the_connection() {
        DBUtils.closeConnection();
    }
}
