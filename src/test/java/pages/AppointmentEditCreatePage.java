package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentEditCreatePage {
    // appointment details here
    // Request A Test button is here for physicians / absent if staff login
    // Show Test Results button is here for physicians / absent if staff login
    // Request Inpatient button is here for physicians / absent if staff login
    // For the rest of the locates are same for physicians & staff

    public AppointmentEditCreatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "hospitalmsappfrontendApp.appointment.home.createOrEditLabel")
    public WebElement headerCreateOrEdit ;

    @FindBy(id = "appointment-id")
    public WebElement appointmentId;

    @FindBy(id = "appointment-startDate")
    public WebElement appointmentStartDate;

    @FindBy(id = "appointment-endDate")
    public WebElement appointmentEndDate;

    @FindBy(id = "appointment-status")
    public WebElement appointmentStatusDropdown;

    @FindBy(id = "appointment-anamnesis")
    public WebElement appointmentAnamnesisTextArea ;

    @FindBy(id = "appointment-treatment")
    public WebElement appointmentTreatmentTextArea;

    @FindBy(id = "appointment-diagnosis")
    public WebElement appointmentDiagnosisTextArea;

    @FindBy(id = "appointment-prescription")
    public WebElement appointmentPrescriptionTextArea;

    @FindBy(id = "appointment-description")
    public WebElement appointmentDescriptionTextArea ;

    @FindBy(id = "appointment-physician")
    public WebElement appointmentPhysicianArea;

    @FindBy(id = "save-entity")
    public WebElement appointmentSaveButton;

    @FindBy(xpath ="(//div[@class='invalid-feedback'])[1]")
    public WebElement anamnesisRequiredWarning ;

    @FindBy(xpath ="(//div[@class='invalid-feedback'])[2]")
    public WebElement treatmentRequiredWarning ;

    @FindBy(xpath ="(//div[@class='invalid-feedback'])[3]")
    public WebElement diagnosisRequiredWarning ;




}
