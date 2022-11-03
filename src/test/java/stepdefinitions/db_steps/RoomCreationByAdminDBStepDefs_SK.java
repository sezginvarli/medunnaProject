package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.getColumnData;
import static utilities.DBUtils.getColumnNames;


public class RoomCreationByAdminDBStepDefs_SK {

    String query = "Select * from room where room_number = 17352";
    @Given("user connects to the room database")
    public void user_connects_to_the_room_database() {

        DBUtils.createConnection();

    }
    @When("user gets rooms data from database")
    public void user_gets_rooms_data_from_database() throws SQLException {

        DBUtils.executeQuery(query);
    }
    @Then("user validates room database")
    public void user_validates_room_database() throws Exception {
        ResultSet resultSet = DBUtils.getResultset();
        List<String> actualRoom = new ArrayList<>();
        while (resultSet.next()){
            actualRoom.add(resultSet.getString("id"));
            actualRoom.add(resultSet.getString("room_number"));
            actualRoom.add(resultSet.getString("room_type"));
            actualRoom.add(resultSet.getString("price"));
            actualRoom.add(resultSet.getString("description"));
            actualRoom.add(resultSet.getString("created_date"));
            actualRoom.add(resultSet.getString("created_by"));
            actualRoom.add(resultSet.getString("last_modified_by"));
            actualRoom.add(resultSet.getString("last_modified_date"));

        }
        System.out.println(DBUtils.getRowCount());
        List<Object>expectedRoom= Arrays.asList("3752","17352","TWIN","5000.00","This room was updated with API ","2021-12-25 16:45:45.481633","admin","team69","2022-08-31 05:12:27.267772");

        assertEquals(expectedRoom,actualRoom);

    }

    @Then("user validates room to get column data")
    public void user_validates_room_to_get_column_data() {
       List<Object> data = getColumnData(query, "room_number");
        System.out.println(data);

        List<String> columnNames = getColumnNames(query);
        System.out.println(columnNames);

        List<Object> allData= new ArrayList<>();
        for(String each : columnNames){
            allData= getColumnData(query, each);
            System.out.println(allData);
        }

    }


}





