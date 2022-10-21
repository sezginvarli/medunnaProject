package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.InpatientsCreateOrEditPage;
import pages.PhysiciansInpatientsPage;
import pages.PhysiciansMainPage;
import pojos.Appointment;
import pojos.InPatient;
import pojos.Patient;
import pojos.Room;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PhysicianUiStepDefs {
    PhysiciansMainPage mainPage = new PhysiciansMainPage();
    PhysiciansInpatientsPage inpatientsPage = new PhysiciansInpatientsPage();
    InpatientsCreateOrEditPage inpatientsEditPage = new InpatientsCreateOrEditPage();
    InPatient inpatientBeforeChange;
    InPatient inPatientAfterChange;
    int inpatientId = 235230;
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

    @When("user clicks on inpatient edit button")
    public void user_clicks_on_edit_button() {
        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableHeaders,10);
        inpatientsPage.inPatientsTableBody.findElement(By.xpath("//a[contains(@href,"+inpatientId+")]")).click();
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

    @And("user gets inpatient data before changing data")
    public void userGetsInpatientDataBeforeChangingData() {

        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableBody,10);
        inpatientBeforeChange = getInpatientDetailsFromTable();

    }

    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        ReusableMethods.waitFor(1);

        JSUtils.clickElementByJS(inpatientsEditPage.saveButton);
        ReusableMethods.waitFor(3);
    }

    @Then("user verifies inpatient is updated message")
    public void userVerifiesInpatientIsUpdatedMessage() {
        ReusableMethods.waitForVisibility(inpatientsEditPage.inpatientEditSuccessMessage,10);
        Assert.assertTrue(inpatientsEditPage.inpatientEditSuccessMessage.isDisplayed());
    }

    @And("user gets inpatient data after changing data")
    public void userGetsInpatientDataAfterChangingData() {
        inPatientAfterChange = getInpatientDetailsFromTable();
    }
    public InPatient getInpatientDetailsFromTable(){
        InPatient inpatient = new InPatient();
        try {
            //gets inpatients row in table
//            List<WebElement> inpatientPageTableRows = Driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
//            System.out.println(newEditPage.inPatientsTableBodyRows.get(0).getText());
            int index = 1;
            for(int i=0;i<inpatientsPage.inPatientsTableBodyRows.size();i++){
                if(inpatientsPage.inPatientsTableBodyRows.get(i).getText().contains(String.valueOf(inpatientId))){
                    index = i+1;
                }
            }
            System.out.println(index);

            //set inpatient data to be able to compare
            inpatient.setId(Integer.parseInt(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[1]")).getText()));
            inpatient.setStartDate(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[2]")).getText());
            inpatient.setEndDate(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[3]")).getText());
            inpatient.setStatus(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[4]")).getText());
            inpatient.setDescription(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[5]")).getText());
            inpatient.setCreatedDate(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[6]")).getText());

            //set new classes for class variables
            inpatient.setRoom(new Room());
            if(!inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[7]")).getText().isEmpty()){
                inpatient.getRoom().setId(Integer.parseInt(inpatientsPage.inPatientsTableBody.
                        findElement(By.xpath("//tr["+index+"]/td[7]")).getText()));
            }

            //set new classes for class variables
            inpatient.setAppointment(new Appointment());
            if(!inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[8]")).getText().isEmpty()){
                inpatient.getAppointment().setId(Integer.parseInt(inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[8]")).getText()));
            }

            //set new classes for class variables
            inpatient.setPatient(new Patient());

            //table cell has many patient detail. split data than assign to patient corresponding variables
            String patientDetail = inpatientsPage.inPatientsTableBody.findElement(By.xpath("//tr["+index+"]/td[9]")).getText();
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

    @And("user sets inpatient {string} with {string}")
    public void userSetsInpatientWith(String data, String value) {
        ReusableMethods.waitForVisibility(inpatientsEditPage.id,10);
        switch (data){
            case "ID":
                Assert.assertTrue(inpatientsEditPage.id.isEnabled());
                JSUtils.clickElementByJS(inpatientsEditPage.id);
                inpatientsEditPage.id.sendKeys(value);
                break;
            case "Start Date":
                Assert.assertTrue(inpatientsEditPage.startDate.isEnabled());
                JSUtils.clickElementByJS(inpatientsEditPage.startDate);
                JSUtils.setValueByJS(inpatientsEditPage.startDate,value);
                break;
            case "End Date":
                Assert.assertTrue(inpatientsEditPage.endDate.isEnabled());
                JSUtils.clickElementByJS(inpatientsEditPage.endDate);
                JSUtils.setValueByJS(inpatientsEditPage.endDate,value);
                break;
            case "Status":
                Assert.assertTrue(inpatientsEditPage.status.isEnabled());
//                JSUtils.clickElementByJS(inpatientsEditPage.room);
//                page gives error without room
                Select selectARoom = new Select(inpatientsEditPage.room);
                selectARoom.selectByValue("28476");

                Select selectStatus = new Select(inpatientsEditPage.status);
                String oldStatus = selectStatus.getFirstSelectedOption().getText();
                selectStatus.selectByVisibleText("STAYING");
                break;
            case "Description":
                Assert.assertTrue(inpatientsEditPage.description.isEnabled());
                JSUtils.clickElementByJS(inpatientsEditPage.description);
                inpatientsEditPage.description.clear();
                inpatientsEditPage.description.sendKeys(value);
                break;
            case "Created Date":
                Assert.assertTrue(inpatientsEditPage.createdDate.isEnabled());
                JSUtils.clickElementByJS(inpatientsEditPage.createdDate);
                inpatientsEditPage.createdDate.sendKeys(value);
                break;
            case "Room":
                Assert.assertTrue(inpatientsEditPage.room.isEnabled());
                Select selectRoom = new Select(inpatientsEditPage.room);
                String oldRoom = selectRoom.getFirstSelectedOption().getText();
                selectRoom.selectByValue(value);
                String newRoom = selectRoom.getFirstSelectedOption().getText();
//                if(oldRoom.equals(newRoom)){
//                    selectRoom.selectByValue("6385");
//                }
                break;
            case "Appointment":
                Assert.assertTrue(inpatientsEditPage.appointment.isEnabled());
//                JSUtils.clickElementByJS(inpatientsEditPage.room);
                Select selectAppointment = new Select(inpatientsEditPage.appointment);
                String oldApp = selectAppointment.getFirstSelectedOption().getText();
                selectAppointment.selectByIndex(0);
                String newApp = selectAppointment.getFirstSelectedOption().getText();
                if(oldApp.equals(newApp)){
                    selectAppointment.selectByIndex(1);
                }

                break;
            case "Patient":
                Assert.assertTrue(inpatientsEditPage.patient.isEnabled());
//                JSUtils.clickElementByJS(inpatientsEditPage.room);
                Select selectPatient = new Select(inpatientsEditPage.patient);
                String oldP = selectPatient.getFirstSelectedOption().getText();
                selectPatient.selectByValue(value);
                String newP = selectPatient.getFirstSelectedOption().getText();
                if(oldP.equals(newP)){
                    selectPatient.selectByIndex(1);
                }
                break;
        }
    }

    @Then("user verifies if the inpatient create or edit form {string} area has changed with {string}")
    public void userVerifiesIfTheInpatientCreateOrEditFormAreaHasChangedWith(String data, String value) {

        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForVisibility(inpatientsPage.inPatientsTableBody,20);

        switch (data){
            case "ID":
                Assert.assertEquals(Integer.parseInt(value),inPatientAfterChange.getId());
                break;
            case "Start Date":
                System.out.println(inPatientAfterChange.getStartDate());
                Assert.assertEquals(value,inPatientAfterChange.getStartDate());
                break;
            case "End Date":
                Assert.assertEquals(value,inPatientAfterChange.getEndDate());
                break;
            case "Status":
                Assert.assertEquals(value,inPatientAfterChange.getStatus());
                break;
            case "Description":
                Assert.assertEquals(value,inPatientAfterChange.getDescription());
                break;
            case "Created Date":
                Assert.assertEquals(value,inPatientAfterChange.getCreatedDate());
                break;
            case "Room":
                Assert.assertEquals(Integer.parseInt(value),inPatientAfterChange.getRoom().getId());
                break;
            case "Appointment":
                Assert.assertEquals(Integer.parseInt(value),inPatientAfterChange.getAppointment().getId());
                break;
            case "Patient":
                Assert.assertEquals(value,inPatientAfterChange.getPatient().getSsn());
                break;
        }
    }

    @Then("user verifies status options has UNAPPROVED, DISCHARGED, STAYING or CANCELLED")
    public void userVerifiesStatusOptionsHasUNAPPROVEDDISCHARGEDSTAYINGOrCANCELLED() {
        ReusableMethods.waitForVisibility(inpatientsEditPage.id,10);
        Select selectStatus = new Select(inpatientsEditPage.status);
        List<WebElement> options = selectStatus.getOptions();
        List<String> optionValues = new ArrayList<>();
        for (WebElement option : options) {
            optionValues.add(option.getText());
        }
        Assert.assertTrue(optionValues.contains("UNAPPROVED"));
        Assert.assertTrue(optionValues.contains("DISCHARGED"));
        Assert.assertTrue(optionValues.contains("STAYING"));
        Assert.assertTrue(optionValues.contains("CANCELLED"));
        Assert.assertEquals(4,optionValues.size());
    }
}