@Api
@US_026
  Feature: Contact Messages
    @US_026_TC01_Api
    Scenario: TC01 contact message validation coming from UI
      Given user sends get request for all contact information
      And user deserializes the messages to java
      And user validates status code and their data using txt file