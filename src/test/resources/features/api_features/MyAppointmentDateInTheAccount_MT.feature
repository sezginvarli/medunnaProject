@US25_2
@Close
Feature: Appointment Date Test with API in the Account
  @Api
  @US25.2_TC03
  Scenario: Create appointments and fetch appointments using API
    When user sends post request for creating new appointment
    And user deserializes the application data to java
    Then user validates appointment
