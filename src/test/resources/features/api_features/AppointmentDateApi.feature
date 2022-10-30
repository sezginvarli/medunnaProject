@US07-14
@SmokeTest
  @Close
Feature: Appointment date test with api
  @Api
  @TC07_TC03
  Scenario: User sends and fetch appointments with api
    When user sends post request for creating new appointment
    And user deserializes the application data to java
    Then user validates appointment
