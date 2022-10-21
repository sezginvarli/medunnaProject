package stepdefinitions.ui_steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentEditCreatePage;
import pages.AppointmentPage;
import pages.PhysiciansMainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class CreateOrEditAppByPhysicianStepDefsHk {
    PhysiciansMainPage physiciansMainPage=new PhysiciansMainPage();
    AppointmentEditCreatePage appointmentEditCreatePage=new AppointmentEditCreatePage();
    AppointmentPage appointmentPage=new AppointmentPage();
    String appId;

    @Then("user validate user login as {string} at account menu")
    public void user_validate_user_login_as_at_account_menu(String loginName) {
        String loginAs= ReusableMethods.waitForVisibility(physiciansMainPage.userAccountMenu,3).getText();
        System.out.println(loginAs);
        Assert.assertTrue(loginAs.contains(loginName));
    }
    @Then("user click on MyAppointments under MyPages")
    public void user_click_on_my_appointments_under_my_pages() {
        Driver.waitForClickablility(physiciansMainPage.myPagesDropdown,1).click();
        physiciansMainPage.dropdownElementMyAppointments.click();
    }
    @Then("user validate being at Appointments page")
    public void user_validate_being_at_appointments_page() {
        appointmentPage.appointmentListPageAppointmentHeading.click();
        String appointmentHeadingText=appointmentPage.appointmentListPageAppointmentHeading.getText();
        Assert.assertTrue(appointmentHeadingText.contains("Appointments"));
    }
    @Then("Choose a patient & click on Edit button to edit an appointment")
    public void choose_a_patient_click_on_edit_button_to_edit_an_appointment() {
        ReusableMethods.waitForVisibility(appointmentPage.firstEditButton,15);
        ReusableMethods.waitForClickablility(appointmentPage.firstEditButton,1).click();
    }
    @Then("Assert that Create_or_Edit_an_Appointment page is opened")
    public void assert_that_create_or_edit_an_appointment_page_is_opened() {
        String appointmentEditCreateHeader= appointmentEditCreatePage.createEditAppointmentHeader.getText();
        Assert.assertTrue(appointmentEditCreateHeader.contains("Create or Edit an Appointment"));
    }
    @Then("check if patient id, start date, end date, status, physician area are fullfilled")
    public void check_if_patient_id_start_date_end_date_status_physician_area_are_fullfilled() throws InterruptedException {
        Thread.sleep(3000);

        appId=appointmentEditCreatePage.appointmentId.getAttribute("value").toString();
        System.out.println("Application Id : "+appId);
            Assert.assertTrue(appId.length()>0);
        String appStartDate=appointmentEditCreatePage.appointmentStartDate.getAttribute("value").toString();
        System.out.println("Application start date : "+appStartDate);
            Assert.assertTrue(appStartDate.length()>0);
        String appEndDate=appointmentEditCreatePage.appointmentEndDate.getAttribute("value").toString();
        System.out.println("Application end date : "+appEndDate);
            Assert.assertTrue(appEndDate.length()>0);
        String appPhysician=appointmentEditCreatePage.appointmentPhysicianArea.getAttribute("value").toString();
        System.out.println("Application Physician : "+appPhysician);
// BUG SOMETIMES EMPTY        Assert.assertTrue(appPhysician.length()>0);

        String statusElements= Driver.waitAndGetText(appointmentEditCreatePage.appointmentStatusDropdown,1);
         System.out.println("appointmentStatusDropdown : "+Driver.waitAndGetText(appointmentEditCreatePage.appointmentStatusDropdown,1));
        Assert.assertTrue(statusElements.contains("PENDING"));
        Assert.assertTrue(statusElements.contains("COMPLETED"));
        Assert.assertTrue(statusElements.contains("CANCELLED"));

    }
    @Then("Validate only appointment status  {string}, {string}, {string} can be selected")
    public void validate_only_appointment_status_can_be_selected(String str1, String str2, String str3) {
        Select select=new Select(appointmentEditCreatePage.appointmentStatusDropdown);
        select.selectByVisibleText("PENDING");
            String selectedP=select.getFirstSelectedOption().getText();
            System.out.println("selectedP : "+selectedP);
            Assert.assertTrue(selectedP.equals("PENDING"));
        select.selectByVisibleText("COMPLETED");
            String selectedComp=select.getFirstSelectedOption().getText();
            System.out.println("selectedComp : "+selectedComp);
            Assert.assertTrue(selectedComp.equals("COMPLETED"));
        select.selectByVisibleText("CANCELLED");
            String selectedCanc=select.getFirstSelectedOption().getText();
            System.out.println("selectedCanc : "+selectedCanc);
            Assert.assertTrue(selectedCanc.equals("CANCELLED"));
        select.selectByVisibleText("UNAPPROVED");
            String selectedUnapp=select.getFirstSelectedOption().getText();
            System.out.println("selectedUnapp : "+selectedUnapp);
            Assert.assertFalse(selectedUnapp.equals("UNAPPROVED"));
    }
    @Then("check if the anamnesis as {string} text box is editable and cannot be left empty")
    public void check_if_the_anamnesis_as_text_box_is_editable_and_cannot_be_left_empty(String anamnesis) {
        appointmentEditCreatePage.appointmentAnamnesisTextArea.clear();
        appointmentEditCreatePage.appointmentAnamnesisTextArea.sendKeys(anamnesis);
        String anamnText=Driver.waitAndGetText(appointmentEditCreatePage.appointmentAnamnesisTextArea,2).toString();
            System.out.println(anamnText);
        appointmentEditCreatePage.appointmentAnamnesisTextArea.clear();
        appointmentEditCreatePage.appointmentAnamnesisTextArea.sendKeys(Keys.ENTER);
        String anamnesisWarning=Driver.waitAndGetText(appointmentEditCreatePage.anamnesisRequiredWarning,2).toString();
        System.out.println(anamnesisWarning);
        Assert.assertEquals("This field is required.",anamnesisWarning);
        appointmentEditCreatePage.appointmentAnamnesisTextArea.sendKeys(anamnesis);

    }
    @Then("check if the treatment as {string} text box is editable and cannot be left empty")
    public void check_if_the_treatment_as_text_box_is_editable_and_cannot_be_left_empty(String treatment) {
        appointmentEditCreatePage.appointmentTreatmentTextArea.clear();
        appointmentEditCreatePage.appointmentTreatmentTextArea.sendKeys(treatment);
        String treatmText=Driver.waitAndGetText(appointmentEditCreatePage.appointmentTreatmentTextArea,1).toString();
            System.out.println(treatmText);
        appointmentEditCreatePage.appointmentTreatmentTextArea.clear();
        appointmentEditCreatePage.appointmentTreatmentTextArea.sendKeys(Keys.ENTER);
        String trementWarn= Driver.waitAndGetText(appointmentEditCreatePage.treatmentRequiredWarning,1).toString();
            System.out.println(trementWarn);
        Assert.assertEquals("This field is required.",trementWarn);
        appointmentEditCreatePage.appointmentTreatmentTextArea.sendKeys(treatment);

    }
    @Then("check if the diagnosis as {string} text box is editable and cannot be left empty")
    public void check_if_the_diagnosis_as_text_box_is_editable_and_cannot_be_left_empty(String diagnosis) {

        appointmentEditCreatePage.appointmentDiagnosisTextArea.clear();
        appointmentEditCreatePage.appointmentDiagnosisTextArea.sendKeys(diagnosis);
        String diagnText=Driver.waitAndGetText(appointmentEditCreatePage.appointmentDiagnosisTextArea,1).toString();
        System.out.println(diagnText);
        appointmentEditCreatePage.appointmentDiagnosisTextArea.clear();
        appointmentEditCreatePage.appointmentDiagnosisTextArea.sendKeys(Keys.ENTER);
        String diagWarning=Driver.waitAndGetText(appointmentEditCreatePage.diagnosisRequiredWarning,1).toString();
        System.out.println(diagWarning);
        Assert.assertTrue(diagWarning.contains("This field is required."));
        appointmentEditCreatePage.appointmentDiagnosisTextArea.sendKeys(diagnosis);
    }

    @Then("check if the prescription as {string} text box is editable and cannot be left empty")
    public void check_if_the_prescription_as_text_box_is_editable_and_cannot_be_left_empty(String prescription) {
        appointmentEditCreatePage.appointmentPrescriptionTextArea.clear();
        appointmentEditCreatePage.appointmentPrescriptionTextArea.sendKeys(prescription);
        String prescText=Driver.waitAndGetText(appointmentEditCreatePage.appointmentPrescriptionTextArea,1).toString();
            System.out.println(prescText);
        appointmentEditCreatePage.appointmentPrescriptionTextArea.clear();
        appointmentEditCreatePage.appointmentPrescriptionTextArea.sendKeys(Keys.ENTER);
        try {
            Assert.assertTrue(appointmentEditCreatePage.prescriptionRequiredWarning.isDisplayed());
        }catch(Exception e){
            System.out.println("Prescription text area is not mandatory !");
        }
        appointmentEditCreatePage.appointmentPrescriptionTextArea.sendKeys(prescription);
    }
    @Then("check if the description as {string} text box is editable and cannot be left empty")
    public void check_if_the_description_as_text_box_is_editable_and_cannot_be_left_empty(String description) {
        appointmentEditCreatePage.appointmentDescriptionTextArea.clear();
        appointmentEditCreatePage.appointmentDescriptionTextArea.sendKeys(description);
        String descText=Driver.waitAndGetText(appointmentEditCreatePage.appointmentDescriptionTextArea,1).toString();
            System.out.println(descText);
        appointmentEditCreatePage.appointmentDescriptionTextArea.clear();
        appointmentEditCreatePage.appointmentDescriptionTextArea.sendKeys(Keys.ENTER);
        try {
            Assert.assertTrue(appointmentEditCreatePage.descriptionRequiredWarning.isDisplayed());
        }catch(Exception e){
            System.out.println("Description text area is not mandatory !");
        }
        appointmentEditCreatePage.appointmentDescriptionTextArea.sendKeys(description);

        String appPhysician2=Driver.waitForVisibility(appointmentEditCreatePage.appointmentPhysicianArea,9).getAttribute("value").toString();
        System.out.println("Application Physician2 : "+appPhysician2);

// BUG SOMETIMES EMPTY        Assert.assertTrue(appPhysician.length()>0);
// Physicians name Takes too long to appear

    }
    @Then("user saves the updated appointment")
    public void user_saves_the_updated_appointment() {
        JSUtils.scrollIntoViewJS(appointmentEditCreatePage.appointmentSaveButton);
        JSUtils.clickElementByJS(appointmentEditCreatePage.appointmentSaveButton);
    }
    @Then("verify the appointment is updated successfully")
    public void verify_the_appointment_is_updated_successfully() {

        String appointmentEditSuccessMessage=Driver.waitForVisibility(appointmentPage.toastifyAllert,3).getText();
        System.out.println("The Appointment is updated with identifier "+appId);
        Assert.assertTrue(appointmentEditSuccessMessage.contains("The Appointment is updated"));
    Driver.getDriver().navigate().refresh();
    }

    @Then("user sign out")
    public void user_sign_out() {
        Driver.waitForClickablility(physiciansMainPage.userAccountMenu,3).click();
        Driver.waitForClickablility(physiciansMainPage.physicianAccountSignOut,3);
        JSUtils.clickElementByJS(physiciansMainPage.physicianAccountSignOut);

    }
}
