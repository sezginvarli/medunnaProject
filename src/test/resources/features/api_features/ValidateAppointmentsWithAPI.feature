@US10
Feature: My Appointments for Physician(Doctor) Validate appointments with API and DB


  @US10_TC030
  Scenario : Validate appointments with API

    Given user sends a GET patient request for doctor users
    And user converts user records to Java
    Then user validates users data

