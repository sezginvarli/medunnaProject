package stepdefinitions.ui_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentEditCreatePage;
import pages.AppointmentPageByStaff;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsByStaff {
    AppointmentPageByStaff appointmentPage = new AppointmentPageByStaff();
    AppointmentEditCreatePage appointmentEditPage = new AppointmentEditCreatePage();
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
}
