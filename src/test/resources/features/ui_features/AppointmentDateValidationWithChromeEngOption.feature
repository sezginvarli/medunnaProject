@US07_TC02
Feature: validation with chrome option english
  Scenario: user send date as MM/dd/yyyy on chrome lang en
    Given user goes to the url with chrome language option set to english
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03patient" username
    And user clicks on password input box
    And user enters a valid "team03Patient" password
    And user clicks on second sign-in button
    And user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with date format MM dd yyyy
    Then user verifies date value is changed correctly