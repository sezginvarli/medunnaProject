Feature: Appointment date test

  Background: User sign in as doctor
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03patient" username
    And user clicks on password input box
    And user enters a valid "team03Patient" password
    And user clicks on second sign-in button

  @US07_TC01
  Scenario Outline: User needs to enter a valid date: Positive
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with valid dates "<date>"
    And user clicks on send an appointments request button
    Then user verifies appointment can not be past date message is not displayed
    Then user verifies Registration Saved message
    And user close the application
    Examples:
      | date |
      | today  |
#        | tomorrow  |
#        | oneyearlater  |
