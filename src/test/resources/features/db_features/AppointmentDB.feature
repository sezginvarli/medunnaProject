@US07-14
  @Close
Feature: validate appointments with db
  @SmokeTest
  @US07_TC04
  Scenario: validate if appointments exist in db
    When user connects to the database
    And user gets appointments data from db
    Then user validates appointment exist db
    And user closes the database connection