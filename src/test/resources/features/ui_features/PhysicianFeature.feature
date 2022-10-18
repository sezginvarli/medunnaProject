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
  Scenario: user view inpatients
      When user clicks on mypages
      And user clicks on myinpatients button
      Then user verifies that a table header exist with given datas "ID" "Start Date" "End Date" "Status" "Description" "Created Date" "Room" "Appointment" "Patient"
      And user close the application

  @US_07_TC02
  Scenario: user edits inpatients
    When user clicks on mypages
    And user clicks on myinpatients button
    And user clicks on edit button
    Then user verifies if form inputs can be changed
