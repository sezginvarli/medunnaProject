Feature: My Appointments Edit And Test Results by Physician

  Background: Go to homepage
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @Signin
  @US_013_TC01
    Scenario Outline: Staff updates test results
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And user clicks on My Pages button
      And user clicks on Search Patient button
      And user send an SSN to search box
      And user clicks on Show Appointments button
      And user clicks on Show Tests button
      And user clicks on View Results button
      And user clicks on Edit button
      And user updates test result
      Then user clicks on Save button
      And user close the application
    Examples:
      | username    | password    |
      | team03staff | team03Staff |


  @Signin
  @US_013_TC02
  Scenario Outline: Doctor can see all test information
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    And user clicks on My Pages button
    And user clicks on My Appointments button
    And user clicks on Edit button
    And user clicks on Show Test Results button
    And user clicks on View Results button
    Then Verify all test information is displayed
    And user close the application
    Examples:
      | username    | password    |
      | team03doctor | team03Doctor |


  @Signin
  @US_013_TC03
  Scenario Outline: Doctor request Inpatient
    When user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    And user clicks on second sign-in button
    And user clicks on My Pages button
    And user clicks on My Appointments button
    And user clicks on Edit button
    And user clicks on Request Inpatient button
    Then Verify "A new In Patient is created" pop up
    And user close the application
    Examples:
      | username    | password    |
      | team03doctor | team03Doctor |




