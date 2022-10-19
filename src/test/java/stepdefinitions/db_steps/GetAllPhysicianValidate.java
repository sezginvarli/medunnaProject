package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllPhysicianValidate {
    @Given("admin send the credential for connect the database")
    public void admin_send_the_credential_for_connect_the_database() {
        DBUtils.createConnection();
    }
    @When("admin get the all Physicians data")
    public void admin_get_the_all_physicians_data() throws Exception {

        DBUtils.executeQuery("Select * from physician");
        DBUtils.getResultset().next();
        Object column1 = DBUtils.getResultset().getObject("first_name");
        System.out.println(column1);
        System.out.println(DBUtils.getRowCount());
    }
    @Then("admin check whether created Physician is exist or not")
    public void admin_check_whether_created_physician_is_exist_or_not() throws SQLException {
        boolean flag= false;
        while (DBUtils.getResultset().next()){
            Object currentRowData = DBUtils.getResultset().getObject("first_name");
            System.out.println(currentRowData);
//            if (currentRowData.equals("236400")){
//                flag = true;
//                break;
//            }
        }
//        Assert.assertTrue(flag);
    }
}
