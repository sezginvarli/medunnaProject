@US_21
Feature: Appointment management by staff
  Background: user signs in as staff
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03staff" username
    And user clicks on password input box
    And user enters a valid "team03Staff" password
    And Verify that remember me checkbox is clickable
    And user clicks on second sign-in button

    @US_21_TC_01
    Scenario: Staff click on update button
      When user click my pages drop-down button
      And user clicks on Search Patient button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      Then user verifies edit button is displayed
      And user clicks on first appointments edit button
      Then user verifies current url contains appointment-update

    @US_21_TC_02
    Scenario: Staff can make the status UNAPPROVED, PENDING or CANCELLED, but cannot make it COMPLETED
      When user click my pages drop-down button
      And user clicks on Search Patient button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      And user clicks on first appointments edit button
      Then user verifies that user can select UNAPPROVED, PENDING or CANCELLED, but cannot select COMPLETED

    @US_21_TC_03
    Scenario: Staff does not need to provide Anamnesis, Treatment or Diagnosis as required fields
      When user click my pages drop-down button
      And user clicks on Search Patient button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      And user clicks on first appointments edit button
      Given user sets anamnesis box as blank
      And user sets treatment box as blank
      And user sets diagnosis box as blank
      Then user verifies that the error message is not displayed

    @US_21_TC_04
    Scenario: Staff can select the current doctor that needs to be selected for the patient
      When user click my pages drop-down button
      And user clicks on Search Patient button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      And user clicks on first appointments edit button
      And user selects a doctor
      Then user verifies a doctor is selected

    @US_21_TC_05
    Scenario: Staff can view the patients test results
      When user click my pages drop-down button
      And user clicks on Search Patient button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      And user clicks on show tests button for appointment id: 286714
      And user clicks on view results button
      Then user verifies that user view test result

    @US_21_TC_06
    Scenario: Staff can only update appointments: so staff can not create new appointment
      When user click my pages drop-down button
      And user clicks on Search Patient button
      Then user verifies there is no create an appointment button
      And user search patient with "132-45-1231"
      And user clicks on Show Appointments button
      Then user verifies there is no create an appointment button

    @US_21_TC_07
    Scenario: Staff can only update appointments: so staff can not create new appointment
      When user navigates to "https://medunna.com/appointments/new"
      Then user verifies that authorization denied message is displayed