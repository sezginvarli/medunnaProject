Feature: test api registrants data

  @Api
  @GetApiRegistrants
  Scenario:
    Given user sends a get request for users' data
    And user deserializes the users' data to java
    Then user saves the users' data to correspondent files and validates



