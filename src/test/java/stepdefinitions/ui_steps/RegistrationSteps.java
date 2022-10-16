package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.Driver;

import static utilities.TXTWriter.saveUiRegistrantsData;

public class RegistrationSteps {
    Registrant registrant=new Registrant();
    RegistrationPage registrationPage=new RegistrationPage();

    Faker faker=new Faker();

    @Given("user provides their ssn id as {string}")
    public void user_provides_their_ssn_id_as(String ssn) {

        ssn =faker.idNumber().ssnValid();

        Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);
        registrant.setSsn(ssn);
    }
    @Given("user provides their firstname as {string}")
    public void user_provides_their_firstname_as(String firstname) {

        firstname =faker.name().firstName();

        Driver.waitAndSendText(registrationPage.firstNameTextBox,firstname);
        registrant.setFirstName(firstname);
    }
    @Given("user provides their lastname as {string}")
    public void user_provides_their_lastname_as(String lastname) {

        lastname=faker.name().lastName();

        Driver.waitAndSendText(registrationPage.lastNameTextBox,lastname);
        registrant.setLastName(lastname);
    }
    @When("user provides their username as {string}")
    public void user_provides_their_username_as(String username) {

        username=registrant.getFirstName() + registrant.getLastName();

        Driver.waitAndSendText(registrationPage.usernameTextBox,username);
        registrant.setLogin(username);
    }
    @When("user types in their email as {string}")
    public void user_types_in_their_email_as(String email) {

        email=registrant.getLogin()+"@gmail.com";

        Driver.waitAndSendText(registrationPage.emailTextBox,email);
        registrant.setEmail(email);
    }
    @When("user provides their password as {string}")
    public void user_provides_their_password_as(String password) {

        password=faker.internet().password(8,20,true,true);

        Driver.waitAndSendText(registrationPage.newPasswordTextBox,password);
        registrant.setPassword(password);
    }
    @When("user types their password confirmation as {string}")
    public void user_types_their_password_confirmation_as(String passwordconfirm) {

        passwordconfirm= registrant.getPassword();

        Driver.waitAndSendText(registrationPage.newPasswordConfirmationTextBox,passwordconfirm);

    }
    @Then("user registers and saves the records")
    public void user_registers_and_saves_the_records() {

        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(1);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
        saveUiRegistrantsData(registrant);
    }

}













































