@Signin
Feature: Create Or Edit Physicians By Admin

  Background:
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @US_18.1_TC01
  Scenario Outline: Create Or Edit Physicians
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    Then user clicks on Items and Titles button
    And user clicks on Physician button
    And user clicks on Create a new Physician button
    And user clicks on Use Search button
    And user provides valid "<ssn>" id in SSN box
    And user clicks Search User Button
    Then user views an existing registered person
    Then user verifies First Name box is populated
    And user verifies Last Name box is populated
    And user verifies birthDate box is populated
    And user verifies Phone box is populated
    When user selects specialty dropdown menu
    And user clicks on Choose File button
    And user selects a picture of doctor
    Then user verifies picture of doctor is loaded
    When user provides a valid "<exam_fee>"
    When user saves the records

    Examples:
      | username | password | ssn         | exam_fee |
      | Batch86  | Batch86+ | 678-78-1001 | 100      |
