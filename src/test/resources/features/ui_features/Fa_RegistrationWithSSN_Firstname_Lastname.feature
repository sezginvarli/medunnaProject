@Fatih
Feature: Registration with some data

  Background: Go to registration page
    Given user is on the registration page

  @US_01_TC_01
  Scenario Outline: Controlling valid the SSN
    Given Enter a "<SSN>" number
    When user clicks enter
    Then user does not see any error messages
    Then user close the page
    Examples:
      | SSN |
      |128-86-9806|

  @US_01_TC_02
  Scenario Outline: Controlling invalid the SSN
    Given Enter a "<SSN>" number
    When user clicks enter
    Then user see any error messages
    Then user close the page
    Examples:
      | SSN |
      |1284-86-980|

  @US_01_TC_03
  Scenario Outline: SSN box must be filled
    Given Enter a "<SSN>" number
    When user clicks enter
    Then user see an error messages
    Then user close the page
    Examples:
      | SSN |
      |     |

  @US_01_TC_04
  Scenario Outline: Firstname box must be filled
    Given Enter a "<firstname>" firstname
    When user clicks enter
    Then user see an error  "<message>"
    Then user close the page
    Examples:
      | firstname |message|
      |           | Your FirstName is required.|

  @US_01_TC_05
  Scenario Outline: Firstname box must be filled
    Given Enter a "<firstname>" firstname
    When user clicks enter
    Then user should not see any error messages
    Then user close the page
    Examples:
      | firstname |
      |  Stephan*123|

  @US_01_TC_06
  Scenario Outline: Lastname box must be filled
    Given Enter "<lastname>" lastname
    When user clicks username box
    Then user should not see any error messages
    Then user close the page
    Examples:
      | lastname |
      | Erik*123  |

