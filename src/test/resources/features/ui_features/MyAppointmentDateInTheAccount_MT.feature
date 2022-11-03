@Signin
@Close
@US25_2
Feature: Appointment Date Test with UI in the Account

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @US25_2_TC01_Positive
  Scenario Outline: User needs a valid date
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with valid dates "<date>"
    And user clicks on send an appointments request button
    Then user verifies Appointment registrations saved message is displayed
    Examples:
      | username      | password      | date            |
      | team03patient | team03Patient | tomorrow        |



  @US25_2_TC01_Negative
  Scenario Outline: User needs a invalid date: Negative
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with valid dates "<date>"
    And user clicks on send an appointments request button
    Then user verifies appointment can not be past date message is displayed
    Examples:
      | username      | password      | date           |
      | team03patient | team03Patient | yesterday      |

  @US25_2_TC02
  Scenario Outline: User checks if date format is MM/dd/yyyy
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    When user clicks on mypages
    And user clicks on make an appointment button
    And user fills the form with date format MM dd yyyy
    Then user verifies date value is changed
    Examples:
      | username      | password      |
      | team03patient | team03Patient |