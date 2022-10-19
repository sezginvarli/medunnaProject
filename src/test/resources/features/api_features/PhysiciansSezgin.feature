@US_018.1
Feature: test api physicians

  @Api
  @PhysiciansGet

  Scenario: TC01 physicians validation

    Given user sends a get request for physicians data
    Then the status codes should be 200
    When user deserializeses the user data to java

  Scenario: TC02 physicians create

    Given user sends a post for physicians
