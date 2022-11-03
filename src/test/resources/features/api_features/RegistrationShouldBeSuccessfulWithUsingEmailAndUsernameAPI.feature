@US_002
@Api
Feature:Username and email should be validated with api and must be unique
  @US002_TC01_Api
  Scenario Outline: TC01 username validation
    Given user sends a get request for user data
    Then the status code should be 200
    And user deserializes the user data to java
    And username as "<username>" should be validated
    And usernames must be unique
    Examples: test data
    |username|
    |brad@654....|

  @US002_TC02_Api
  Scenario Outline: TC02 username validation
    Given user sends a get request for user data
    Then the status code should be 200
    And user deserializes the user data to java
    And username as "<username>" which is already used should be validated
    And usernames must be unique
    Examples: test data
      |username|
      |samsunmerkez|

  @US002_TC03_Api
  Scenario Outline: TC03 email validation
    Given user sends a get request for user data
    Then the status code should be 200
    And user deserializes the user data to java
    And email as "<email>" should be validated
    And emails must be unique
    Examples: test data
      |email|
      |brad@654@gmail.com|

  @US002_PostApi
  Scenario: TC04 email_post_request
    Given user creates a post body
    Given user sends post request for creating new registrant
    Then Status code should be 201
    And user verifies username and email with given data in body

