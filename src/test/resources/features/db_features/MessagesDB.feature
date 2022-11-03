Feature: Messages Reading
  @US_27_TC_07
  Scenario Outline: validate some data with db
    Given user connects to the database
    And user gets all user data using the "<query>"
    Then validates the room data "<email>","<name>","<subject>" and "<message>"
    And   user close the connection
    Examples:
      | query | email | name | subject | message |
      | select * from cmessage | email | name |subject|message|