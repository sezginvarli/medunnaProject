package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.getColumnData;

public class PatientValidateInfoDbSteps {
    String query ="SELECT * FROM patient";

    @Given("User connects to Medunna database")
    public void user_connects_to_medunna_database() {
        DBUtils.createConnection();
    }

    @Given("User gets info from table Patient")
    public void user_gets_info_from_table_patient() {
        DBUtils.executeQuery(query);
    }

    @Given("User validate patient info")
    public void user_validate_patient_info() {

        List<Object> actualList = getColumnData(query,"id");
        List<String> actualListString= new ArrayList<>();

        for (Object w:actualList) {
            actualListString.add(w.toString());
        }
        Assert.assertTrue("There are no such ids",actualListString.contains("276234"));
    }

    @Given("Then user close the connection")
    public void then_user_close_the_connection() {
        DBUtils.closeConnection();
    }

}
