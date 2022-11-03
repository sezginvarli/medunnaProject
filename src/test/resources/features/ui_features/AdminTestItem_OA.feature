@Signin
@Close
@AllFeatureUS17.01
Feature: Test Physicians

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    When User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03alpha" username
    And user clicks on password input box
    And user enters a valid "team03Admin" password
    And user clicks on second sign-in button
  @TC17.01Create_TestItem
  Scenario:
    When User click on Test Item from dropdown button
    And User click on Create a New Test Item
    And User filled the credentials
    Then User click the save button and see Test Item is Created alert.
    Then User should click Created Date and see the created Test Item

  @TC17.01Create_FieldCheck
  Scenario:
    When User click on Test Item from dropdown button
    And User click on Create a New Test Item
    Then User click back button and  should see main Test Item page
    When User should click again Create a New Test Item
    Then User should see Name,Description,Price,Default Min. And Max. Value,Created Date,Back and Save Buttons

  @TC17.01View_Fields
  Scenario:
    When User click on Test Item from dropdown button
    Then User should see how many test item on page and totaly how many test items are exist
    When User click on random view button
    Then User should see all fields

  @TC17.01Update_TestItem
  Scenario:
    When User click on Test Item from dropdown button
    And User should click on random edit button
    And User should edit testItem credentials by using java faker
    Then User click save button should see "A Test Item is updated with identifier "

  @TC17.01Field_errors
  Scenario:
    When User click on Test Item from dropdown button
    And User click on Create a New Test Item
    Then User filled the credentials except name and when click save button must see "This field is required."
    And User filled the credentials except price must see "This field is required."
    And User filled the credentials but filled price with other than numbers must see "This field should be at least 0."

