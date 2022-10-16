Feature: test user api


@userApi
  Scenario: user api data request

    Given user sends a get request for users
    And user converts user records to Java
    Then user validates user data