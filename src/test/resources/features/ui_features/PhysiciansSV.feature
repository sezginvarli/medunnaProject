@Signin
Feature: Create Or Edit Physicians By Admin

  Background: Go to homepage
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @US18.01_TC01

  Scenario Outline: test existed
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    And user clicks on Items&Titles button
    And user clicks on Physician button
    And user clicks on Create a new Physician button
    And user clicks on Use Search button
    And user provides valid "<ssn>" id in SSN box
    And user clicks Search User Button
    Then user views an existing registered person
    And user closes the browser
    Examples:
      | username        | password  | ssn         |
      | sezginakmeseler | akmese_25 | 555-55-2345 |
