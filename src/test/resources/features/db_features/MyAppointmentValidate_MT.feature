@US25_2
@Close
Feature: Validate Appointments with DB
  @US25_2_TC04
  Scenario: Validate appointments using DB
    When user connects to the database
    And user gets appointments data from db
    Then user validates appointment exist db
    And user closes the database connection