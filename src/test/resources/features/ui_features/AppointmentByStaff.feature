
Feature: Appointment management by staff
  Background: user signs in as staff
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03staff" username
    And user clicks on password input box
    And user enters a valid "team03Staff" password
    And user clicks on second sign-in button

  @US_21_TC_01
    Scenario: Staff click on update button
    When user click my pages drop-down button
    And user clicks on Search Patient button
    And user search patient with "132-45-1231"
    And user clicks on Show Appointments button