package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import utilities.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBStepDefs {




    @Given("user connect to applicants database")
    public void user_connect_to_applicants_database() throws SQLException {

            DBUtils.createConnection();

    }

}
