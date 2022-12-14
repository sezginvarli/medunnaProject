@US_002
@SmokeTest
Feature: Registration should be successful with email and username
  Background: user navigates to the registration page
    Given user goes to the url
    When user clicks on the register section at the dropdown
    Then user verifies the registration page
    When user provides their ssn id as "ssn"
    And user provides their firstname as "firstname"
    And user provides their lastname as "lastname"
  @US002_TC01_UI
    Scenario: TC01 valid email and username
      When user provides their username as "username"
      And user types in their email as "email"
      Then user verifies there is no any error message for username
      Then user verifies there is no any error message for email
      When user provides their password as "password"
      And user types their password confirmation as "password_confirm"
      Then user clicks register button and saves the records
      Then user verifies Registration Saved message
      And user closes the browser
  @US002_TC02_UI
    Scenario: TC02 blank username
      And user types in their email as "email"
      Then user hit the enter
      And user verifies Your username is required message
      And user closes the browser
  @US002_TC03_UI
  Scenario Outline: TC03 space in the username
    When user enters their username as "<username>"
    Then user hit the enter
    And user verifies Your username is invalid message
    And user closes the browser
    Examples: test data
    |username|
    |Brad Pitt|
  @US002_TC04_UI
  Scenario Outline: TC04 valid username contain special character
    When user enters their username as "<username>"
    Then user hit the enter
    Then user verifies there is no any error message for username
    And user closes the browser
    Examples: test data
      |username|
      |Brad123@|
      |Brad+/12|

  @US002_TC05_UI
  Scenario Outline: TC05 valid email that contains "@."
    When user provides their username as "username"
    When user enters their email as "<email>"
    Then user hit the enter
    Then user verifies there is no any error message for email
    And user closes the browser
    Examples: test data
      |email|
      |fake@gmail.com|
      |fake@hotmail.com  |

  @US002_TC06_UI
  Scenario Outline: TC06 valid email that not contains "@."
    When user provides their username as "username"
    When user enters their email as "<email>"
    Then user hit the enter
    Then user verifies This field is invalid message
    And user closes the browser
    Examples: test data
      |email|
      |fake mail@gmail.com|
      |fakehotmail.com  |
      |fake@hotmailcom  |

  @US002_TC07_UI
  Scenario: TC07 blank email
    When user provides their username as "username"
    Then user hit the enter
    And user verifies Your email is required message
    And user closes the browser

  @US002_TC08_UI
  Scenario: TC08 can not be blank email
    When user provides their username as "username"
    And user types in their email as "email"
    Then user hit the enter
    Then user verifies there is no any error message for email
    And user closes the browser








