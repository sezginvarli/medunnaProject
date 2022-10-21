@Signin
Feature: Test Physicians

    @US18.01_TC01
  Scenario Outline: test existed physicians
      Given user enters a valid "<username>" username
      And user enters a valid "<password>" password
      When user clicks on second sign-in button
      Given user click on "Items&Titles" button
    When user click on "Physician" button
    And user click on "Create a new Physician " button
    And user click on "Use Search" button
    And user provides valid "<ssn>" id in SSN box
    And user click "Search User" Button
    Then user views an existing registered person
    Examples:
      | username | password | ssn         |
      | Batch86  | Batch86+ | 678-78-1001 |
