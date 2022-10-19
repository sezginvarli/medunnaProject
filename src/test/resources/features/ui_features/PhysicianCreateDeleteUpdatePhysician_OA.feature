@US18.02_TC01
Feature: Test_Physicians
  Scenario: Admin doctor can create a new physician
    Given when user go to main page
    Given user click on "Items&Titles" button
    When user click on "Physician" button
    And user click on "Create a new Physician " button
    And user fill the required credentials
    And user click on save button and should see "A physician is created with identifier (id number)"
    Then user refresh the page and click created date and in first place must see the created physician