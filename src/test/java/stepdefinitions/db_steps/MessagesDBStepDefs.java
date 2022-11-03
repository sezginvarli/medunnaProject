package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.DBUtils.getColumnData;
import static utilities.DBUtils.getQueryResultList;
import static utilities.TXTReader.readFile;


public class MessagesDBStepDefs {

        String query="select * from cmessage";
    @Given("user gets all user data using the {string}")
    public void user_gets_all_user_data_using_the(String query) throws Exception {
        DBUtils.executeQuery(query);

        ResultSet rs = DBUtils.getResultset();
        while (rs.next()) {
//            System.out.println("id :"+rs.getObject(1)+" "+"name : "+rs.getObject(2)+"  "+
//                    "email : "+rs.getObject(3)+" "+"subject : "+
//                    rs.getObject(4)+" "+"message : "+rs.getObject(5));
        }
        System.out.println(DBUtils.getRowCount());
    }
    @Then("validates the room data {string},{string},{string} and {string}")
    public void validates_the_room_data_and(String email, String name, String subject, String message) {
        String [] expectedMessage=readFile(ConfigReader.getProperty("messages_data_ui")).split("'");
        System.out.println("expectedMessage = " + Arrays.toString(expectedMessage));
        String expectedEmail=expectedMessage[1];
        String expectedName=expectedMessage[5];
        String expectedSubject=expectedMessage[7];
        String expectedMessages=expectedMessage[3];

        List<Object> actualEmailList = getColumnData(query,email);
        List<String> actualEmailListString= new ArrayList<>();

        for (Object w:actualEmailList) {
            actualEmailListString.add(w.toString());
        }
        Assert.assertTrue("There are no such email",actualEmailListString.contains(expectedEmail));

        List<Object> actualNameList = getColumnData(query,name);
        List<String> actualNameListString= new ArrayList<>();

        for (Object w:actualNameList) {
            actualNameListString.add(w.toString());
        }
        Assert.assertTrue("There are no such name",actualNameListString.contains(expectedName));

        List<Object> actualSubjectList = getColumnData(query,subject);
        List<String> actualSubjectListString= new ArrayList<>();

        for (Object w:actualSubjectList) {
            actualSubjectListString.add(w.toString());
        }
        Assert.assertTrue("There are no such subject",actualSubjectListString.contains(expectedSubject));

        List<Object> actualMessageList = getColumnData(query,message);
        List<String> actualMessageListString= new ArrayList<>();

        for (Object w:actualMessageList) {
            actualMessageListString.add(w.toString());
        }
        Assert.assertTrue("There are no such message",actualMessageListString.contains(expectedMessages));

    }
}
