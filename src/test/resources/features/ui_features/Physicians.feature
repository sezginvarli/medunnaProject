@Signin
Feature: Test Physicians

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    When User clicks on sign-in button
    And user clicks on username input box


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


  @US18.02_TC01
  Scenario Outline: Admin doctor can create a new physician
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When user click on physician from dropdown button
    And user click on click on view button
    And user fill the required credentials
    And user click on save button and should see "A physician is created with identifier (id number)"
    Then user refresh the page and click created date and in first place must see the created physician
    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |



