package stepdefinitions.db_steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;


public class RegistrationShouldBeSuccessfulWithUsingEmailAndUsernameStepDefsDB {


    @Then("user verifies that {string} table {string} column not contain {string}")
    public void user_verifies_that_table_column_contains_us(String table, String column, String data) {

        String query = "SELECT * FROM "+table;
        List<Object> allColumnData = DBUtils.getColumnData(query,column);
        //System.out.println(allColumnData);
        Assert.assertFalse(allColumnData.contains(data));

    }
    @And("user closes the database connection")
    public void userClosesTheDatabaseConnection() {
        DBUtils.closeConnection();
    }

    @Given("user connects to the database")
    public void userConnectsToTheDatabase() {
        DBUtils.createConnection();
    }
}
