package stepdefinitions.db_steps;

import io.cucumber.java.en.*;
import utilities.DBUtils;
import utilities.Driver;

public class RegistrationEmailValidation {
    @Given("user connects to the database US_{int}")
    public void user_connects_to_the_database_us(Integer int1) {
        DBUtils.getConnection();
    }
    @Then("user verifies that {string} table {string} column contains {string} US_{int}")
    public void user_verifies_that_table_column_contains_us(String string, String string2, String string3, Integer int1) {

    }
    @Then("user close the database connection US_{int}")
    public void user_close_the_database_connection_us(Integer int1) {

    }
}
