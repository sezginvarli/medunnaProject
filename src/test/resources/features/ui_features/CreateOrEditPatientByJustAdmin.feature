@CreatedOrEditPatientByAdmin
Feature: Create Or Edit Patient By Admin

  Background: Go to homepage
    Given user opens to Medunna Page
    And user click on account menu
    And user can select Sign in


  @CreatedPatientByAdmin
  Scenario Outline: New patient is created by admin
    Given user enter their username as "<username>"
    When user enter their password as "<password>"
    And user click on Sign in
    When Click on Items&Titles button then click patient button
    And Click on Create a new patient button
    And Enter "<firstname>" in firstname box
    And Enter "<lastname>" in lastname box
    And Enter "<birth_date>" in birth date box
    And Enter "<email>" in email box
    And Enter "<phone>" in phone box
    And Select gender in dropdown
    And Select blood group in dropdown
    And Enter Address in address box
    And Enter "<description>" in description box
    And Enter country in dropdown
    And Click on save button
    Then Verify "A new Patient is created" message
    Then close the application

    Examples:
      | username | password | firstname | lastname | birth_date | email | phone | description |
      | Batch86 | Batch86+ | Tom | Hanks | 2000-02-17T15:03 | tomhanks2@gmail.com | 5095487814 | Cold Flue |

@CreatedPatientByOtherUsers
  Scenario Outline: New patient is created by other users
    Given user enter their username as "<username>"
    When user enter their password as "<password>"
    And user click on Sign in
    Then Verify the Items&Titles is not here
    And user click on account menu
    Then user click on sign out
  Examples:
    | username | password |
    | team03doctor | team03Doctor  |
    | team03patient  | team03Patient |
    | team03staff  | team03Staff  |
    | userbatch8687 | Batch86+ |







