Feature: Doctor view and edit inpatients

  Background: User sign in as doctor
    Given user navigates to URL "https://medunna.com"
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03doctor" username
    And user clicks on password input box
    And user enters a valid "team03Doctor" password
    And user clicks on second sign-in button

  @US_07_TC01
  Scenario Outline: user view inpatients
    When user clicks on mypages
    And user clicks on myinpatients button
    Then user verifies that a table header exist with given data "<data>"
    And User clicks on account drop-down-menu button
    And user click on sign out
    And user close the application
    Examples:
      | data |
      |   ID   |
      |  Start Date    |
      |  End Date    |
      |  Status    |
      |  Description    |
      |  Created Date    |
      |  Room    |
      |  Appointment    |
      |  Patient    |

  @US_07_TC02
  Scenario Outline: user edits inpatients
    When user clicks on mypages
    And user clicks on myinpatients button
    And user gets inpatient data before changing data
    And user clicks on edit button
    And user sets inpatient "<item>" data
    And user clicks on save button
    And user gets inpatient data after changing data
    Then user verifies if the inpatient create or edit form "<item>" area has changed
    And User clicks on account drop-down-menu button
    And user click on sign out
    And user close the application
    Examples:
      | item |
      |   ID   |
#      |  Start Date    |
#      |  End Date    |
#      |  Status    |
#      |  Description    |
#      |  Created Date    |
#      |  Room    |
#      |  Appointment    |
#      |  Patient    |
