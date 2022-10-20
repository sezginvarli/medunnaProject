package stepdefinitions.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GetAllPhysicianValidate {
    @Given("admin send the credential for connect the database")
    public void admin_send_the_credential_for_connect_the_database() {
        DBUtils.createConnection();
    }
    @When("admin get the all Physicians data")
    public void admin_get_the_all_physicians_data() throws Exception {
        DBUtils.executeQuery("Select * from physician");
        ResultSet rs = DBUtils.getResultset();
        while (rs.next()) {
            System.out.println("id : "+rs.getObject(1)+"  "+"FirstName : "+rs.getObject(2)+" "+"LastName : "+rs.getObject(3)+" "+"BirthDate : "+rs.getObject(4)
                    +" "+"phone : "+rs.getObject(5)+" "+"gender : "+rs.getObject(6)+" "+"bloodGroup : "+rs.getObject(7)+" "+"adress : "+rs.getObject(8)+" "+"description : "+rs.getObject(9 )
                    +"  "+"createdDate : "+rs.getObject(10)+" "+"userId : "+rs.getObject(11)+"  "+"countryId : "+rs.getObject(12)+"  "+"cStateId : "+rs.getObject(13)+"  "+
                    "createdBy : "+rs.getObject(14)+"  "+"lastModifiedBy : "+rs.getObject(15)+"  "+"lastModifiedDate : "+rs.getObject(16)+"  "+"speciality : "+rs.getObject(17)
                    +"  "+"examFee : "+rs.getObject(18));

        }
        System.out.println(DBUtils.getRowCount());
    }
    @Then("admin check whether created Physician is exist or not")
    public void admin_check_whether_created_physician_is_exist_or_not() throws SQLException {
        DBUtils.executeQuery("SELECT * FROM physician WHERE id="+"214529");
        ResultSet rs = DBUtils.getResultset();
        List<Object> checkPhysician = new ArrayList<>();
        int a = 1;
        rs.next();
        for (int i = 0; i < 18; i++) {
            checkPhysician.add(rs.getObject(a));
            a++;
        }
        System.out.println(checkPhysician);
        Assert.assertEquals("There is no id like that","214529", rs.getObject("id").toString());
    }
}
