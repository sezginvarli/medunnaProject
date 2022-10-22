@husrev
Feature: Doctor view and edit inpatients

  Background: User sign in as doctor
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03doctor" username
    And user clicks on password input box
    And user enters a valid "team03Doctor" password
    And user clicks on second sign-in button

  @US14_TC01
  Scenario Outline: user view inpatients
    When user clicks on mypages
    And user clicks on myinpatients button
    Then user verifies that a table header exist with given data "<data>"
    And User clicks on account drop-down-menu button
    And user click on sign out
#    And user close the application
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

  @US14_TC02
  Scenario Outline: user edits inpatients
    When user clicks on mypages
    And user clicks on myinpatients button
#    And user gets inpatient data before changing data
    And user clicks on inpatient edit button
    And user sets inpatient "<data>" with "<value>"
    And user clicks on save button
    Then user verifies inpatient is updated message
    And user gets inpatient data after changing data
    Then user verifies if the inpatient create or edit form "<data>" area has changed with "<value>"
    And User clicks on account drop-down-menu button
    And user click on sign out
#    And user close the application
    Examples:
      | data | value|
#      |   ID   | 987321   |
#      |  Start Date    |15/11/2022 12:12|
#      |  End Date    | 16/11/2022 11:11 |
#      |  Status    | STAYING   |
      |  Description    | description is changed by automated script 002|
#      |  Created Date    | 14/11/2022 10:10|
#      |  Room    |  31712      |
#      |  Appointment    | 279463 |
#      |  Patient    | 277764    |

  @US14_TC02_2
  Scenario: status can be UNAPPROVED, DISCHARGED, STAYING or CANCELLED
    When user clicks on mypages
    And user clicks on myinpatients button
    And user clicks on inpatient edit button
    Then user verifies status options has UNAPPROVED, DISCHARGED, STAYING or CANCELLED

  @US14_TC03
    Scenario: user can change reserved room
      When user clicks on mypages
      And user clicks on myinpatients button
      And user clicks on inpatient edit button
      And user sets inpatient "Room" with "130655"
      And user clicks on save button
      Then user verifies inpatient is updated message
      And user gets inpatient data after changing data
      And user verifies if the inpatient create or edit form "Room" area has changed with "130655"
