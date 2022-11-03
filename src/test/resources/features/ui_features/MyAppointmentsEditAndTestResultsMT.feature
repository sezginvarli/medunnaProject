@Signin
@Close
@US_013
Feature: My Appointments Edit And Test Results by Physician

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    When User clicks on sign-in button

  @US_013_TC01
    Scenario Outline: Staff updates test results
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And User clicks on My PAGES button.
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on Show Appointments button
      And user clicks on Show Tests button
      And user clicks on View Results button
      And user clicks on Edit button
      And user updates test result
      And user clicks on Result Save button
      Then Verify "A Test Result is updated" pop up is displayed
    Examples:
      | username    | password    | SSN   |
      | team03staff | team03Staff | 153-11-7830 |


  @US_013_TC02
  Scenario Outline: Doctor can see all test information
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    And User clicks on My Pages button
    And user clicks on My Appointments button
    And user clicks on Edit button
    And user clicks on Show Test Results button
    And user clicks on View Test Results button
    Then Verify all test information is displayed
    Examples:
      | username    | password    |
      | team03doctor | team03Doctor |


  @US_013_TC03
  Scenario Outline: Doctor request Inpatient
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    And User clicks on My Pages button
    And user clicks on My Appointments button
    And user clicks on the Edit button
    And user clicks on Request Inpatient button
    Then Verify "A new In Patient is created" pop up is display
    Examples:
      | username    | password    |
      | alimecann | aliCan86 |




