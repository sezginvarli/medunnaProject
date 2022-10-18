package stepdefinitions.ui_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.InpatientsCreateOrEditPage;
import pages.PhysiciansInpatientsPage;
import pages.PhysiciansMainPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class PhysicianUiStepDefs {
    PhysiciansMainPage mainPage = new PhysiciansMainPage();
    PhysiciansInpatientsPage inpatientsPage = new PhysiciansInpatientsPage();
    InpatientsCreateOrEditPage inpatientsEditPage = new InpatientsCreateOrEditPage();
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

    @Then("user verifies that a table header exist with given datas {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void userVerifiesThatATableHeaderExistWithGivenDatas(String id, String startDate, String endDate, String status, String description, String createdDate, String room, String appointment, String patient) {

        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableHeaders,10);
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
    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableHeaders,10);
        List<WebElement> editButtons = inpatientsPage.inPatientsEditButtons;
        editButtons.get(0).click();
    }

    @Then("user verifies if form inputs can be changed")
    public void user_verifies_if_form_inputs_can_be_changed() {

        ReusableMethods.waitForVisibility(inpatientsEditPage.id,10);
        //id
        inpatientsEditPage.id.click();
        System.out.println(inpatientsEditPage.id.isEnabled());
        Assert.assertTrue(inpatientsEditPage.id.isEnabled());
        inpatientsEditPage.id.sendKeys("123546");
        String idText = inpatientsEditPage.id.getAttribute("value");
        System.out.println(idText);

        //start date
        inpatientsEditPage.startDate.click();
        System.out.println(inpatientsEditPage.startDate.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.startDate.isEnabled());
//        inpatientsEditPage.startDate.sendKeys("123546");
        String startDateText = inpatientsEditPage.startDate.getAttribute("value");
        System.out.println(startDateText);

        //end date
        inpatientsEditPage.endDate.click();
        System.out.println(inpatientsEditPage.endDate.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.endDate.isEnabled());
//        inpatientsEditPage.endDate.sendKeys("11112022");
        String endDateText = inpatientsEditPage.endDate.getAttribute("value");
        System.out.println(endDateText);

        //description
        inpatientsEditPage.description.click();
        System.out.println(inpatientsEditPage.description.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.description.isEnabled());
//        inpatientsEditPage.description.sendKeys("description automated test");
        String descriptionText = inpatientsEditPage.description.getAttribute("value");
        System.out.println(descriptionText);

        //created date
        inpatientsEditPage.createdDate.click();
        System.out.println(inpatientsEditPage.createdDate.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.createdDate.isEnabled());
//        inpatientsEditPage.createdDate.sendKeys("11112022");
        String createdDateText = inpatientsEditPage.createdDate.getAttribute("value");
        System.out.println(createdDateText);

        //appointment
        inpatientsEditPage.appointmentId.click();
        System.out.println(inpatientsEditPage.appointmentId.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.appointmentId.isEnabled());
//        inpatientsEditPage.appointmentId.sendKeys("278848");
        String appointmentIdText = inpatientsEditPage.appointmentId.getAttribute("value");
        System.out.println(appointmentIdText);

        //status
        System.out.println(inpatientsEditPage.status.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.status.isEnabled());
        Select selectStatus = new Select(inpatientsEditPage.status);
        selectStatus.selectByIndex(0);
        String statusText = selectStatus.getFirstSelectedOption().getText();
        System.out.println(statusText);

        //room
        System.out.println(inpatientsEditPage.room.isEnabled());
//        Assert.assertTrue(inpatientsEditPage.room.isEnabled());
        Select selectRoom = new Select(inpatientsEditPage.room);
        selectStatus.selectByIndex(1);
        String roomText = selectRoom.getFirstSelectedOption().getText();
        System.out.println(roomText);

        //patient
        System.out.println(inpatientsEditPage.patient.isEnabled());
        Select selectPatient = new Select(inpatientsEditPage.patient);
//        selectPatient.selectByValue("277764");
        String patientText = selectPatient.getFirstSelectedOption().getText();
        System.out.println(patientText);
    }
}
