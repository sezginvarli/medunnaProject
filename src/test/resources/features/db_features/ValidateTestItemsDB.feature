
Feature: Test Items validation with DB
  @dbTestItems
  Scenario Outline:User needs to validate Test Items creation in DB

    Given User connects to Medunna database
    And  User gets info from the table "<table>"
    And  User validate the test item id "<id>" is created
    And   Then user close the connection
    Examples:
      | table | id |
      | c_test_item | 294670 |
      | c_test_item | 294671 |
      | c_test_item | 294672 |
      | c_test_item | 294673 |

