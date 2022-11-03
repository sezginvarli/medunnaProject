Feature: user validate room information with DB


  @DB_US_16
  Scenario: user can verify room information with DB

    Given user connects to the room database
    When user gets rooms data from database
    Then user validates room database
    Then user validates room to get column data
    And user closes the database connection

