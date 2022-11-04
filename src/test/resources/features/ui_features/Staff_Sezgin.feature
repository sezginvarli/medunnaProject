@Signin
Feature: Create Or Edit Staff By Admin

  Background:
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @US_019_TC_01
  Scenario Outline: Create Or Edit Staff
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    Then user clicks on Items and Titles button
    And user clicks on Staff button
    And user clicks on Create a new Staff button
    And user clicks on Use Search button
    And user provides valid "<ssn>" id in SSN box
    And user clicks Search User Button
    Then user views an existing registered person
    Then user verifies all required infos are populated
    And user verifies Phone box is populated
    When select a user from existing users
    Then user verifies registered people is selected
    When user saves the records
    Examples:
      | username | password | ssn         |
      | Batch86  | Batch86+ | 678-78-1001 |