Feature: Doctor view and edit inpatients

  Background: User sign in as doctor
    Given user navigates to URL "https://medunna.com"
    And User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03doctor" username
    And user clicks on password input box
    And user enters a valid "team03Doctor" password
    And user clicks on second sign-in button

    @US_07_TC1
  Scenario: user view inpatients
      When user clicks on mypages
      And user clicks on myinpatients button
      Then user veifies that a table header exist with given datas "ID" "Start Date" "End Date" "Status" "Description" "Created Date" "Room" "Appointment" "Patient"
      And user close the application