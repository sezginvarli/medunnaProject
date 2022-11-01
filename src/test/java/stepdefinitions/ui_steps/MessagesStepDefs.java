package stepdefinitions.ui_steps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomeAndSigninPage;
import pages.admin.AdminMessagesPage;
import pojos.Message;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static utilities.TXTWriter.saveUiMessageData;

public class MessagesStepDefs {

    HomeAndSigninPage homeAndSigninPage=new HomeAndSigninPage();
    Faker faker=new Faker();
    AdminMessagesPage adminMessagesPage =new AdminMessagesPage();
    Message message=new Message();
    @Given("Admin enters username and password")
    public void admin_enters_username_and_password(DataTable credentials) {

        List<Map<String,String>> adminCredentials=credentials.asMaps(String.class, String.class);
        for (Map<String,String> each :adminCredentials){
            homeAndSigninPage.userNameTextArea.sendKeys(each.get("username"));
            homeAndSigninPage.passwordTextArea.sendKeys(each.get("password"));
        }
        ReusableMethods.waitFor(1);
    }
    @Given("Click on Items&Titles button then click messages button")
    public void click_on_items_titles_button_then_click_messages_button() {
        Driver.waitAndClick(adminMessagesPage.itemsTitlesButton,3);
        Driver.waitAndClick(adminMessagesPage.messagesButton,3);
    }
    @Then("validate to all messages, name and emails")
    public void validate_to_all_messages_name_and_emails() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminMessagesPage.nameColumn.isDisplayed());
        Assert.assertTrue(adminMessagesPage.emailColumn.isDisplayed());
        Assert.assertTrue(adminMessagesPage.messageColumn.isDisplayed());
    }
    @When("user clicks on create a new message button")
    public void user_clicks_on_create_a_new_message_button() {
        Driver.waitAndClick(adminMessagesPage.createNewMessageButton,3);
    }
    @When("user enter {string} in namebox")
    public void user_enter_in_namebox(String name) {
        name=faker.name().firstName();
        Driver.waitAndSendText(adminMessagesPage.messageNameBox,name);
        message.setName(name);
    }
    @When("user enter {string} in emailbox")
    public void user_enter_in_emailbox(String email) {
        email=faker.internet().emailAddress();
        Driver.waitAndSendText(adminMessagesPage.messageEmailBox,email);
        message.setEmail(email);
    }
    @When("user enter {string} in subjectbox")
    public void user_enter_in_subjectbox(String subject) {
        subject="Advice";
        Driver.waitAndSendText(adminMessagesPage.messageSubjectBox,subject);
        message.setSubject(subject);
    }
    @When("user enter {string} in messagesbox")
    public void user_enter_in_messagesbox(String messages) {
        messages="Hello World";
        Driver.waitAndSendText(adminMessagesPage.messageMessageBox,messages);
        message.setMessage(messages);
    }
    @When("user clicks on save button for creating message")
    public void user_clicks_on_save_button_for_creating_message() {
        Driver.waitAndClick(adminMessagesPage.saveMessageButton);
    }
    @When("user saves the message data into file")
    public void user_saves_the_message_data_into_file() {
        saveUiMessageData(message);
    }
    @Then("verify {string} message")
    public void verify_message(String message) {
        ReusableMethods.waitForVisibility(adminMessagesPage.successMessageToastContainer,5);
        Assert.assertTrue(adminMessagesPage.successMessageToastContainer.getText().contains(message));
    }
    @When("user clicks on first edit button")
    public void user_clicks_on_first_edit_button() {
        Driver.waitAndClick(adminMessagesPage.messageEditButton);
    }
    @When("update {string}, {string}, {string} and {string}")
    public void update_and(String name, String email, String subject, String messages) {
        name=faker.name().firstName();
        email=faker.internet().emailAddress();
        subject=faker.book().title();
        messages=faker.medical().symptoms();
        ReusableMethods.waitFor(1);
        adminMessagesPage.messageNameBox.clear();
        ReusableMethods.waitFor(1);
        adminMessagesPage.messageEmailBox.clear();
        ReusableMethods.waitFor(1);
        adminMessagesPage.messageSubjectBox.clear();
        ReusableMethods.waitFor(1);
        adminMessagesPage.messageMessageBox.clear();
        Driver.waitAndSendText(adminMessagesPage.messageNameBox,name);
        Driver.waitAndSendText(adminMessagesPage.messageEmailBox,email);
        Driver.waitAndSendText(adminMessagesPage.messageSubjectBox,subject);
        Driver.waitAndSendText(adminMessagesPage.messageMessageBox,messages);
    }
    @When("admin clicks on first delete button")
    public void admin_clicks_on_first_delete_button() {
        Driver.waitAndClick(adminMessagesPage.messageDeleteButton);
    }
    @When("admin clicks on confirm delete button")
    public void admin_clicks_on_confirm_delete_button() {
        ReusableMethods.waitFor(2);
        adminMessagesPage.confirmDeleteButton.click();

    }
}
