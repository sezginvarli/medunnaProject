package stepdefinitions.ui_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomeAndSigninPage;
import pages.admin.AdminPhysicianPage;
import pages.admin.AdminStaffMainPage;


public class StaffStepDefs_SV {

    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    AdminStaffMainPage adminStaffMainPage = new AdminStaffMainPage();
    AdminPhysicianPage adminPhysicianPage = new AdminPhysicianPage();
    Select select;


    @Then("user clicks on Staff button")
    public void user_clicks_on_staff_button() {
        adminStaffMainPage.staffButton.click();
    }

    @Then("user clicks on Create a new Staff button")
    public void user_clicks_on_create_a_new_staff_button() {
        adminStaffMainPage.createNewStaffButton.click();
    }

//    @Then("user verifies all required infos are populated")
//    public void user_verifies_all_required_infos_are_populated() {
//        String staffFirstName = adminStaffMainPage.staffFirstName.getAttribute("value").toString();
//        Assert.assertTrue(staffFirstName.length() > 0);
//
//        String staffLastName = adminStaffMainPage.staffLastName.getAttribute("value").toString();
//        Assert.assertTrue(staffLastName.length() > 0);
//
//        String staffBirthDate = adminStaffMainPage.staffBirthDate.getAttribute("value").toString();
//        Assert.assertTrue(staffBirthDate.length() > 0);
//
//        String staffPhone = adminStaffMainPage.staffPhoneBox.getAttribute("value").toString();
//        Assert.assertTrue(staffPhone.length() > 0);
//    }

    @When("select a user from existing users")
    public void select_a_user_from_existing_users() {
        Select select = new Select(adminStaffMainPage.staffUser);
        select.selectByValue("291549");
        //      List<String> userList= adminStaffMainPage.staffUser.getAttribute("value").toString();
//
//        Select selectStatus = new Select(appointmentEditPage.appointmentStatusDropdown);
//        List<WebElement> options = selectStatus.getOptions();
//        List<String> optionValues = new ArrayList<>();
//
//        for(WebElement e: options){
//            optionValues.add(e.getText());
//        }
//

    }

//    @Then("user verifies registered people is selected")
//    public void user_verifies_registered_people_is_selected() {
//        String expectedUser = adminStaffMainPage.staffUser.getText();
//        String actualUser="alivelim";
//        Assert.assertEquals(expectedUser,actualUser);
//    }


}
