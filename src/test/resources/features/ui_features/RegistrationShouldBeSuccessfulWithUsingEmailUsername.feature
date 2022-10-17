
Feature: Registration should be successful with email and username
  Background: user navigates to the registration page
    Given user goes to the url
    When user clicks on the register section at the dropdown
    Then user verifies the registration page
    When user provides their ssn id as "ssn"
    And user provides their firstname as "firstname"
    And user provides their lastname as "lastname"
  @ValidationEmailAndUsername
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
  @BlankUsername
    Scenario: TC02 blank username
      And user types in their email as "email"
      Then user hit the enter
      And user verifies Your username is required message
      And user closes the browser
  @SpaceInUsername
  Scenario Outline: TC03 space in the username
    When user enters their username as "<username>"
    Then user hit the enter
    And user verifies Your username is invalid message
    And user closes the browser
    Examples: test data
    |username|
    |Brad Pitt|
  @UsernameSpecialChar
  Scenario Outline: TC04 valid username contain special character
    When user enters their username as "<username>"
    Then user hit the enter
    Then user verifies there is no any error message for username
    And user closes the browser
    Examples: test data
      |username|
      |Brad123@|

  @ValidEmail
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

  @InvalidEmail
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

  @BlankEmail
  Scenario: TC07 blank email
    When user provides their username as "username"
    Then user hit the enter
    And user verifies Your email is required message
    And user closes the browser

  @NotBlankEmail
  Scenario: TC08 can not be blank email
    When user provides their username as "username"
    And user types in their email as "email"
    Then user hit the enter
    Then user verifies there is no any error message for email
    And user closes the browser








