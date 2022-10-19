package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InpatientsCreateOrEditPage;
import pages.PhysiciansInpatientsPage;
import pages.PhysiciansMainPage;
import pojos.Appointment;
import pojos.InPatient;
import pojos.Patient;
import pojos.Room;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PhysicianUiStepDefs {
    PhysiciansMainPage mainPage = new PhysiciansMainPage();
    PhysiciansInpatientsPage inpatientsPage = new PhysiciansInpatientsPage();
    InpatientsCreateOrEditPage inpatientsEditPage = new InpatientsCreateOrEditPage();
    InPatient inpatientBeforeChange = new InPatient();
    InPatient inPatientAfterChange = new InPatient();
    @When("user clicks on mypages")
    public void user_clicks_on_mypages() {
        ReusableMethods.waitForVisibility(mainPage.myPagesDropdown,5);
        mainPage.myPagesDropdown.click();
    }
    @When("user clicks on myinpatients button")
    public void user_clicks_on_myinpatients_button() {
        ReusableMethods.waitForVisibility(mainPage.myInPatients,5);
        mainPage.myInPatients.click();
    }

    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableHeaders,10);
        List<WebElement> editButtons = inpatientsPage.inPatientsEditButtons;
        editButtons.get(0).click();
    }

    @Then("user verifies that a table header exist with given data {string}")
    public void userVerifiesThatATableHeaderExistWithGivenData(String data) {

        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableHeaders,10);
        List<String> headers = new ArrayList<>();
        String header;

        for(int i=1;i<10;i++){
            header = inpatientsPage.inPatientsTableHeaders.findElement(By.xpath("//tr/th["+i+"]")).getText();
            headers.add(header);
        }

        Assert.assertTrue(headers.contains(data));
    }

    @Then("user verifies if the inpatient create or edit form {string} area can be changed")
    public void userVerifiesIfTheInpatientCreateOrEditFormAreaCanBeChanged(String item) {
        //items: "ID" "Start Date" "End Date" "Status" "Description" "Created Date" "Room" "Appointment" "Patient"
        switch (item){
            case "ID":
                break;
            case "Start Date":
                break;
            case "End Date":
                break;
            case "Status":
                break;
            case "Description":
                break;
            case "Created Date":
                break;
            case "Room":
                break;
            case "Appointment":
                break;
            case "Patient":
                break;

        }
    }

    @And("user gets inpatient data before changing data")
    public void userGetsInpatientDataBeforeChangingData() {

        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableBody,10);
        inpatientBeforeChange = getInpatientDetailsFromTable();

    }
    @When("user sets inpatient {string} data")
    public void user_sets_inpatient_data(String string) {
        ReusableMethods.waitForVisibility(inpatientsEditPage.id,10);

        Assert.assertTrue(inpatientsEditPage.id.isEnabled());
        inpatientsEditPage.id.click();
        inpatientsEditPage.id.sendKeys("123456");
    }

    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        ReusableMethods.waitFor(1);
        inpatientsEditPage.saveButton.click();
    }
    @And("user gets inpatient data after changing data")
    public void userGetsInpatientDataAfterChangingData() {
        inPatientAfterChange = getInpatientDetailsFromTable();
    }
    public InPatient getInpatientDetailsFromTable(){
        InPatient inpatient = new InPatient();
        try {
            //gets first inpatients in table
            WebElement inpatientsData = inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr[1]"));

            //set inpatient data to be able to compare
            inpatient.setId(Integer.parseInt(inpatientsData.findElement(By.xpath("//td[1]")).getText()));
            inpatient.setStartDate(inpatientsData.findElement(By.xpath("//td[2]")).getText());
            inpatient.setEndDate(inpatientsData.findElement(By.xpath("//td[3]")).getText());
            inpatient.setStatus(inpatientsData.findElement(By.xpath("//td[4]")).getText());
            inpatient.setDescription(inpatientsData.findElement(By.xpath("//td[5]")).getText());
            inpatient.setCreatedDate(inpatientsData.findElement(By.xpath("//td[6]")).getText());

            //set new classes for class variables
            inpatient.setRoom(new Room());
            inpatient.getRoom().setId(Integer.parseInt(inpatientsData.findElement(By.xpath("//td[7]")).getText()));

            //set new classes for class variables
            inpatient.setAppointment(new Appointment());
            inpatient.getAppointment().setId(Integer.parseInt(inpatientsData.findElement(By.xpath("//td[8]")).getText()));

            //set new classes for class variables
            inpatient.setPatient(new Patient());

            //table cell has many patient detail. split data than assign to patient corresponding variables
            String patientDetail = inpatientsData.findElement(By.xpath("//td[9]")).getText();
            String[] patientSsnAndFullname = patientDetail.split(":");
            String patientSsn = patientSsnAndFullname[0];
            int i = patientSsnAndFullname[1].lastIndexOf(" ");
            String[] fullName =  {patientSsnAndFullname[1].substring(0, i), patientSsnAndFullname[1].substring(i)};

            inpatient.getPatient().setSsn(patientSsn);
            inpatient.getPatient().setFirstName(fullName[0]);
            inpatient.getPatient().setLastName(fullName[1]);

        }catch (NoSuchElementException e){
            System.out.println("the phsyician does not have any inpatients");
            e.getStackTrace();
        }
        return inpatient;
    }
}