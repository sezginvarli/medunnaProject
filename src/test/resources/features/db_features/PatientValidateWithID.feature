@US_009DB
Feature:US09 DB Test.
  @US_009DB
  Scenario:User needs to validate all patient info from DB

    Given User connects to Medunna database
    And  User gets info from table Patient
    And  User validate patient info
    And   Then user close the connection
