@US25-01
@Close
Feature: Appointment date test with ui

  Background: User sign in as patient
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "team03patient" username
    And user clicks on password input box
    And user enters a valid "team03Patient" password
    And user clicks on second sign-in button
  @Make_new_appointment
  Scenario: user_make_new_appointment
    When User click on Make an Appointment from My Pages dropdown
    And User should fill the credentials
    And User click on Send an appointment request see "Appointment registration saved!"
    Then User should click on my appointments and see the new appointments

  Scenario: user make a new appointment using their portal with same email but different credentials
    When User click on Make an Appointment from My Pages dropdown
    And User should fill the credentials
    Then User change name and click on Send an apointment request see it is saved
    And User change lastname and click on Send an apointment request see it is saved
    And User change email and click on Send an apointment request see it is saved

  @AbsentCredentialsPatientAppointmentRequest
  Scenario: user can not make a new appointment using their portal with absent credentials
    When User click on Make an Appointment from My Pages dropdown
    And User should fill the credentials except name and should see "Your FirstName is required."
    And User should fill the credentials except lastname "Your LastName is required."
    Then User change the ssn id and when click on should see "Email is already in use!"
    Then User change the date before the current time and should see "Appointment date can not be past date!"

 @TC25.01WrongPlacedSigns
 Scenario Outline: User can not make a new appointment using their portal with wrong credentials
    When User click on Make an Appointment from My Pages dropdown
    When User shouldn't put @ sign in wrong place with "<at sign>"
    And User shouldn't place sign in wrong place in ssn id with "<- sign>"
   Examples:
   |at sign       |- sign     |
   |asda@.com     |123-453-234|
   |@asdtqwye.com |34-123-1233|
   |asdjgk@ff.com@|1-23-123123|




