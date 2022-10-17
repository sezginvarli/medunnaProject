package stepdefinitions.ui_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.PhysiciansInpatientsPage;
import pages.PhysiciansMainPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class PhysicianUiStepDefs {
    PhysiciansMainPage mainPage = new PhysiciansMainPage();
    PhysiciansInpatientsPage inpatientsPage = new PhysiciansInpatientsPage();
    @When("user clicks on mypages")
    public void user_clicks_on_mypages() {
        ReusableMethods.waitFor(1);
        mainPage.myPagesDropdown.click();
    }
    @When("user clicks on myinpatients button")
    public void user_clicks_on_myinpatients_button() {
        ReusableMethods.waitFor(1);
        mainPage.myInPatients.click();
    }
    @Then("user veifies that a table header exist with given data {string}")
    public void user_veifies_that_a_table_header_exist_with_given_data(String string) {
        ReusableMethods.waitFor(10);
        for(int i=1;i<10;i++){
            String text = inpatientsPage.inPatientsTableHeaders.findElement(By.xpath("//tr/th["+i+"]")).getText();
            System.out.println(text);
        }
    }

    @Then("user veifies that a table header exist with given datas {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void userVeifiesThatATableHeaderExistWithGivenDatas(String id, String startDate, String endDate, String status, String description, String createdDate, String room, String appointment, String patient) {

        ReusableMethods.waitFor(10);
        List<String> headers = new ArrayList<>();
        String header;

        for(int i=1;i<10;i++){
            header = inpatientsPage.inPatientsTableHeaders.findElement(By.xpath("//tr/th["+i+"]")).getText();
            headers.add(header);
        }

        Assert.assertTrue(headers.contains(id));
        Assert.assertTrue(headers.contains(startDate));
        Assert.assertTrue(headers.contains(endDate));
        Assert.assertTrue(headers.contains(status));
        Assert.assertTrue(headers.contains(description));
        Assert.assertTrue(headers.contains(createdDate));
        Assert.assertTrue(headers.contains(room));
        Assert.assertTrue(headers.contains(appointment));
        Assert.assertTrue(headers.contains(patient));
    }
}
