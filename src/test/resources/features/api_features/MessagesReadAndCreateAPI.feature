@Api
  @US_27_API
Feature: Creating and Reading Messages With API
  @US_27_TC_05
  Scenario: Creating messages Data
  Given user send a post request for message creating
  Then status code should be "201"
  And user validates the post data

  @US_27_TC_06
    Scenario Outline: Reading all messages Data
  Given user send a get request for message reading
  Then status code should be "200"
  When user deserializes the message's data to Java and save
  Then user validates the room data "<email>","<name>","<subject>" and "<message>"
    Examples:
      | email | name | subject | message |
      | kado@gmail.com | Ali | sikayet mesaji | lutfen sikayetmi duzeltin |

