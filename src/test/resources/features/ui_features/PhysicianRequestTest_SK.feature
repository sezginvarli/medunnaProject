@US_00012
@Signin
Feature:My Appointments / Edit / Request a test only by Physician

  Background: Go to homepage
  Given User clicks on account drop-down-menu button
  When User clicks on sign-in button

  @US012_TC01
    Scenario Outline: Doctor may request a test
  Then user clicks on username input box
  And user enters a valid "<username>" username
  And user clicks on password input box
  And user enters a valid "<password>" password
  Then user clicks on second sign-in button
  When User clicks on My PAGES button.
  Then clicks on My Appointment button.
  Then choose the patient and clicks edit button
  Then clicks Request a test button
  When verifies that Test Items headers is visible
  And user closes the browser
  Examples:
    | username | password |
    | team03doctor | team03Doctor |

  @US012_TC02
  Scenario Outline: Test should have following items as checkmark options
    Then user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When User clicks on My PAGES button.
    Then clicks on My Appointment button.
    Then choose the patient and clicks edit button
    Then clicks Request a test button
    Then User clicks on the right buttons which are choosen tests
    Then User clicks save button
    And user closes the browser
    Examples:
      | username | password |
      | team03doctor | team03Doctor |
