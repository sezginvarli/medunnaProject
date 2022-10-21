@Signin @CreateorEditPhysiciansByAdmin
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
#    When user clicks on specialty dropdown menu
#    And users selects specialty
#    Then user verifies specialty is provided
#    When user closes the browser
#    And user clicks on Choose File button
#    Then user verifies folder is opened
#    When user selects a picture of doctor
#    And user clicks open button on folder
#    Then user verifies picture of doctor is loaded
#    When user provides a valid "<exam fee>"
#    Then user verifies exam fee is provided
#    When user clicks on User dropdown menu
#    And user chooses an existing user
#    Then user verifies an existing user is choosed

  #  And user sign out
    Examples:
      | username | password | ssn         |exam fee|
      | Batch86  | Batch86+ | 678-78-1001 |100.00  |

#  @US18.01_TC02
#  Scenario Outline:test populated areas
#    Given user clicks on Use Search button
#    When user provides valid "<ssn>" id in SSN box
#    And user clicks Search User Button
#
#    Examples:
#      | ssn         |
#      | 555-55-9874 |

#  @US18.01_TC03
#  Scenario:test doctor specialty
#    Given user clicks on specialty dropdown menu
#    When users selects specialty
#    Then user verifies specialty is provided
#    And user closes the browser

#  @US18.01_TC04
#  Scenario:test picture is loaded
#    Given user clicks on Choose File button
#    Then user verifies folder is opened
#    When user selects a picture of doctor
#    And user clicks open button on folder
#    Then user verifies picture of doctor is loaded
#    And user closes the browser

#  @US18.01_TC05
#  Scenario Outline:test exam fee
#    Given user provides a valid "<exam fee>"
#    Then user verifies exam fee is provided
#    And user closes the browser
#    Examples:
#      | exam fee |
#      | 100      |
#
#  @US18.01_TC06
#  Scenario:test choose a doctor among existing users
#    Given user clicks on User dropdown menu
#    When user chooses an existing user
#    Then user verifies an existing user is choosed
#    And user closes the browser
