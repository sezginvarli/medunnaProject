package stepdefinitions.db_steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.valueOf;
import static utilities.DBUtils.getCellValue;
import static utilities.DBUtils.getColumnData;

public class TestItemsStepDefsDB {
    List<String> actualListString;

    @Given("User gets info from the table {string}")
    public void user_gets_info_from_the_table(String table) {

        String query = "SELECT * FROM " + table;
        List<Object> actualList = getColumnData(query, "id");
        System.out.println("Actual list : " + actualList);
        actualListString = new ArrayList<>();

        for (Object w : actualList) {
            actualListString.add(w.toString());
        }

    }
    @And("User validate the test item id {string} is created")
    public void userValidateTheTestItemIdIsCreated(String id) {

        System.out.println("Id  : "+id);
        Assert.assertTrue("The id is not found !",actualListString.contains(id));
    }
}
