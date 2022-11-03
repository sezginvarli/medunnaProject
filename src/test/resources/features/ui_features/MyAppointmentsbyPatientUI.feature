@US_024
Feature: My Appointments by Patient
  @US_024_UI_HP
  Scenario Outline: HP_Patient sign into their account and see their test result and invoice
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User enters their appointment's date
    Then User verifies the Show Tests section visible than click
    And User verifies that is on the Tests page
    Then User should see ID,Name,Description,Date,Created Date and Appointment headers
    When User clicks on the View Results section
    Then User verifies the Test Results section visible
    And User should see ID, Name for test, default max and min value, test date and description
    When User navigates back to two times
    When User enters their appointment's date
    When User verifies the Show Invoice section visible than click
    Then User verifies that is on the Invoice page
    And User should see Date,SSN,Name,Payment Method and Total Cost headers
    And User should see own ssn across the ssn header and total cost
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | john123  | john123  |
  @US_024_UI_TC01
  Scenario Outline: TC01_Patient sign into their account and see their result
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User enters their appointment's date
    Then User verifies the Show Tests section visible than click
    And User verifies that is on the Tests page
    Then User should see ID,Name,Description,Date,Created Date and Appointment headers
    When User clicks on the View Results section
    Then User verifies the Test Results section visible
    And User should see ID, Name for test, default max and min value, test date and description
    Then user closes the browser
    Examples: Sign in credentials
    | username | password |
    | john123  | john123  |

  @US_024_UI_TC02
  Scenario Outline: TC02_Patient sign into their account and can not see their result
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User enters their appointment's date
    Then User verifies the Show Tests section visible than click
    And User verifies that is on the Tests page
    Then User should see No Tests Found
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | Michelle  | Michelle  |
  @US_024_UI_TC03
  Scenario Outline: TC03_Patient can also view their invoice
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User enters their appointment's date
    Then User should see the status is "CANCELLED" or "COMPLETED"
    When User verifies the Show Invoice section visible than click
    Then User verifies that is on the Invoice page
    And User should see Date,SSN,Name,Payment Method and Total Cost headers
    And User should see own ssn across the ssn header and total cost
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | john123  | john123  |
  @US_024_UI_TC04
  Scenario Outline: TC04_Patient can not view their invoice
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User enters their appointment's date
    Then User should see the status is "PENDING"
    When User verifies the Show Invoice section is not visible
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | Michelle | Michelle |
  @US_024_UI_TC05
  Scenario Outline: TC05_Patient can not view their appointment
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    When User verifies the No Appointment Found is visible
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | john123 | john123 |
  @US_024_UI_TC06
  Scenario Outline: TC06_Patient see their new appointment in unapproved status
    Given User is on the sign in page
    And User enters their sign in credentials as "<username>" and "<password>"
    Then User clicks on the My Pages
    And Clicks on the My Appointments
    Then User verifies that is on the Appointments page
    Then User should see the status is "UNAPPROVED"
    When User verifies the Show Invoice section is not visible
    Then User verifies the Show Tests section visible than click
    And User verifies that is on the Tests page
    Then User should see No Tests Found
    Then user closes the browser
    Examples: Sign in credentials
      | username | password |
      | Michelle | Michelle |