Feature: View, edit and delete Patient information

  Background: Go to homepage and Sign in as "Staff"
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    Then user close the application

    @Signin
    @US_09_1_TC01
    Scenario:
    When user clicks on my pages button
    And user clicks on search patient button
    And user search patient with SSN
    And user clicks on view button
    Then Verify "View Portal" is displayed





