@Signin
  @ab
@SmokeTest
Feature: User Settings
  Background: Go to homepage
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @US_06_TC_01
  Scenario Outline: New patient is created by admin
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    And User clicks on account drop-down-menu button
    And user clicks on settings button
    Then verify "<firstname>" as firstname
    And verify "<lastname>" as lastname
    And verify "<email>" as email
    Then close the application
    Examples:
      | username | password | firstname | lastname | email |
      | userbatch8687 | Batch86+ | sukru | katip | yavuzkatip@gmail.com |

  @US_06_TC_02
  Scenario Outline: New patient is created by admin
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    And User clicks on account drop-down-menu button
    And user clicks on settings button
    And user updates "<firstname>" as fatih
    And user clicks on save button to update
    Then verify "<firstname>" as firstname
    Then close the application
    Examples:
      | username | password | firstname |
      | patientbatch8687 | Batch86+ | fatih |

  @US_06_TC_03
  Scenario Outline: New patient is created by admin
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    And User clicks on account drop-down-menu button
    And user clicks on settings button
    And user updates "<lastname>" as kaya
    And user clicks on save button to update
    Then verify "<lastname>" as lastname
    Then close the application
    Examples:
      | username | password | lastname |
      | patientbatch8687 | Batch86+ | kaya |





