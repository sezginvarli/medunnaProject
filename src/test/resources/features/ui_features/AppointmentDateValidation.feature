Feature: Appointment date test

  Background: User sign in as patient
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
#    Then user verifies appointment can not be past date message is not displayed
    Then user verifies Appointment registrations saved message is displayed
    And User clicks on account drop-down-menu button
    And user click on sign out
#    And close the application
    Examples:
      | date |
      | today  |
      | tomorrow  |
      | oneyearlater  |

  @US07_TC01N
  Scenario Outline: User needs to enter a valid date: Negative
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with valid dates "<date>"
    And user clicks on send an appointments request button
    Then user verifies appointment can not be past date message is displayed
#    Then user verifies Appointment registrations saved message is not displayed
    And User clicks on account drop-down-menu button
    And user click on sign out
#    And close the application
    Examples:
      | date |
      | yesterday  |
      | oneyearbefore  |

  @US07_TC02
  Scenario: User checks if date format is MM/dd/yyyy
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with date format MM dd yyyy
    Then user verifies date value is changed correctly
    And close the application