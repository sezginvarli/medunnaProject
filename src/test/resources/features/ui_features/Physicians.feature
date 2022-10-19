@Signin
Feature: Test Physicians

  Background: user goto home page

    @US18.01_TC01
  Scenario Outline: test existed physicians
    Given user click on "Items&Titles" button
    When user click on "Physician" button
    And user click on "Create a new Physician " button
    And user click on "Use Search" button
    And user provides valid "<ssn>" id in SSN box
    And user click "Search User" Button
    Then user views an existing registered person
    Examples:
      | ssn         |
      | 555-55-9874 |
