package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentEditCreatePage;
import pages.AppointmentPageByStaff;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsByStaff {
    AppointmentPageByStaff appointmentPage = new AppointmentPageByStaff();
    AppointmentEditCreatePage appointmentEditPage = new AppointmentEditCreatePage();
    int doctorsId = 277669;
    @Then("user verifies edit button is displayed")
    public void user_verifies_edit_button_is_displayed() {
        ReusableMethods.waitForVisibility(appointmentPage.firstEditButton,10);
        System.out.println(appointmentPage.firstEditButton.isDisplayed());
        Assert.assertTrue(appointmentPage.firstEditButton.isDisplayed());
    }

    @And("user clicks on first appointments edit button")
    public void userClicksOnFirstAppointmentsEditButton() {
        ReusableMethods.waitForClickablility(appointmentPage.firstEditButton,10).click();
    }

    @Then("user verifies that user can select UNAPPROVED, PENDING or CANCELLED, but cannot select COMPLETED")
    public void userVerifiesThatUserCanSelectUNAPPROVEDPENDINGOrCANCELLEDButCannotSelectCOMPLETED() {
        ReusableMethods.waitForVisibility(appointmentEditPage.appointmentStatusDropdown,10);

        Select selectStatus = new Select(appointmentEditPage.appointmentStatusDropdown);
        List<WebElement> options = selectStatus.getOptions();
        List<String> optionValues = new ArrayList<>();

        for(WebElement e: options){
            optionValues.add(e.getText());
        }

        //Assert that select has number of options with the same number of given options
        Assert.assertEquals(4,options.size());

        Assert.assertTrue(optionValues.contains("UNAPPROVED"));
        Assert.assertTrue(options.get(0).isEnabled());

        Assert.assertTrue(optionValues.contains("PENDING"));
        Assert.assertTrue(options.get(1).isEnabled());

        Assert.assertTrue(optionValues.contains("COMPLETED"));
        //Assert that user can not choose completed
        Assert.assertFalse(options.get(2).isEnabled());

        Assert.assertTrue(optionValues.contains("CANCELLED"));
        Assert.assertTrue(options.get(3).isEnabled());
    }

    @Given("user sets anamnesis box as blank")
    public void userSetsAnamnesisBoxAsBlank() {
        ReusableMethods.waitForVisibility(appointmentEditPage.appointmentAnamnesisTextArea,10);
        appointmentEditPage.appointmentAnamnesisTextArea.click();
        appointmentEditPage.appointmentAnamnesisTextArea.sendKeys("123");
        ReusableMethods.waitFor(2);
        appointmentEditPage.appointmentAnamnesisTextArea.clear();
        JSUtils.blurElementByJS(appointmentEditPage.appointmentAnamnesisTextArea);
    }

    @And("user sets treatment box as blank")
    public void userSetsTreatmentBoxAsBlank() {
        ReusableMethods.waitForVisibility(appointmentEditPage.appointmentTreatmentTextArea,10);
        appointmentEditPage.appointmentTreatmentTextArea.click();
        appointmentEditPage.appointmentTreatmentTextArea.sendKeys("234");
        ReusableMethods.waitFor(2);
        appointmentEditPage.appointmentTreatmentTextArea.clear();
        JSUtils.blurElementByJS(appointmentEditPage.appointmentDescriptionTextArea);
    }

    @And("user sets diagnosis box as blank")
    public void userSetsDiagnosisBoxAsBlank() {
        ReusableMethods.waitForVisibility(appointmentEditPage.appointmentDiagnosisTextArea,10);
        appointmentEditPage.appointmentDiagnosisTextArea.click();
        appointmentEditPage.appointmentDiagnosisTextArea.sendKeys("345");
        ReusableMethods.waitFor(2);
        appointmentEditPage.appointmentDiagnosisTextArea.clear();
        JSUtils.blurElementByJS(appointmentEditPage.appointmentDiagnosisTextArea);
    }

    @Then("user verifies that the error message is not displayed")
    public void userVerifiesThatTheErrorMessageIsNotDisplayed() {
        ReusableMethods.waitFor(1);
        try {
            if(
                    appointmentEditPage.anamnesisRequiredWarning.isDisplayed() ||
                    appointmentEditPage.treatmentRequiredWarning.isDisplayed() ||
                    appointmentEditPage.diagnosisRequiredWarning.isDisplayed()
            ){
                Assert.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("user selects a doctor")
    public void userSelectsADoctor() {
        ReusableMethods.waitFor(30);
        Select selectDoctor = new Select(appointmentEditPage.appointmentPhysicianArea);
        selectDoctor.selectByValue(String.valueOf(doctorsId));

        String selected = selectDoctor.getFirstSelectedOption().getText();
        System.out.println(selected);
    }

    @Then("user verifies a doctor is selected")
    public void userVerifiesADoctorIsSelected() {
//        Select selectedDoctor = new Select(appointmentEditPage.appointmentPhysicianArea);
        appointmentEditPage.appointmentPhysicianArea.isSelected();
        System.out.println(appointmentEditPage.appointmentPhysicianArea.isSelected());
    }
}
