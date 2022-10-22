@US005_Api

Feature:api

  Scenario: api appointment

    Given user sends a get request for appointment
    And user converts appointment records to Java
    Then user validates 280851 appointment id

