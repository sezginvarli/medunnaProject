package stepdefinitions.ui_steps;
import io.cucumber.java.en.*;
import pages.Contact;
import pages.HomeAndSigninPage;
import pojos.Message;
import utilities.Driver;
import utilities.JSUtils;
import static utilities.TXTWriter.saveTheMessageData;

public class ContactMessagesStepDefs {
    Contact contact= new Contact();
    HomeAndSigninPage homeAndSigninPage = new HomeAndSigninPage();
    Message messages =new Message();


    @When("User clicks on Contact without logging in")
    public void user_clicks_on_contact_without_logging_in() {
        contact.contactSection.click();

    }
    @Then("User verifies that on the contact page")
    public void user_verifies_that_on_the_contact_page() {
        Driver.waitAndVerify(contact.contactVerify);
    }
    @When("User enters  their {string} in the name box")
    public void userEntersTheirInTheNameBox(String name) {
        JSUtils.scrollIntoViewJS(contact.nameTextBox);
        contact.nameTextBox.sendKeys(name);
        messages.setName(name);

    }
    @And("User enters  their {string} in the email box")
    public void userEntersTheirInTheEmailBox(String email) {
        contact.emailTextBox.sendKeys(email);
        messages.setEmail(email);

    }
    @And("User enters  their {string} in the subject box")
    public void userEntersTheirInTheSubjectBox(String subject) {
        contact.subjectTextBox.sendKeys(subject);
        messages.setSubject(subject);
    }
    @And("User enters  their {string} in the message box")
    public void userEntersTheirInTheMessageBox(String message) {
        contact.messageTextBox.sendKeys(message);
        messages.setMessage(message);
    }
    @When("User clicks on the Send button")
    public void user_clicks_on_the_send_button() {
       Driver.scrollDown();
        Driver.wait(3);
        contact.sendButton.click();

    }
    @Then("User verifies the pop-up that is Your message has been received")
    public void user_verifies_the_pop_up_that_is_your_message_has_been_received() {
        Driver.waitAndVerify(contact.successMessageToastContainer);
    }
    @When("User clicks on Contact after logging in as {string} and {string}")
    public void userClicksOnContactAfterLoggingInAsAnd(String username, String password) {
        homeAndSigninPage.userNameTextArea.sendKeys(username);
        homeAndSigninPage.passwordTextArea.sendKeys(password);
        homeAndSigninPage.signInButton.click();
        Driver.wait(2);
        contact.contactSection.click();
    }
    @Then("User verifies error messages for name is required")
    public void user_verifies_error_messages_for_name_is_required() {
        Driver.waitAndVerify(contact.nameIsRequired);
    }
    @Then("User verifies error messages for email is required")
    public void user_verifies_error_messages_for_email_is_required() {
        Driver.waitAndVerify(contact.emailIsRequired);
    }
    @Then("User verifies error messages for subject as This field is required")
    public void user_verifies_error_messages_for_subject_as_this_field_is_required() {
        Driver.waitAndVerify(contact.fieldIsRequired);
    }
    @Then("User verifies there is no any error messages for Message is required")
    public void user_verifies_there_is_no_any_error_messages_for_message_is_required() {
        Driver.waitAndVerify(contact.noErrorMessage);
    }
    @Then("User verifies error messages for email is invalid")
    public void userVerifiesErrorMessagesForEmailIsInvalid() {
        Driver.waitAndVerify(contact.fieldIsInvalidEmail);
    }
    @When("User clicks on the Send button again")
    public void userClicksOnTheSendButtonAgain() {
        Driver.wait(3);
        contact.sendButton.click();
    }

    @And("User saves the records")
    public void userSavesTheRecords() {
        saveTheMessageData(messages);

    }
}
