Feature: Appointment date test
  @Api
  @TC07_TC03
  Scenario: User sends and fetch appointments with api
    When user sends post request for creating new appointment
    And user deserializes the application data to java
    Then user validates appointment
