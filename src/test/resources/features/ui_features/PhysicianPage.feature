
Feature: Physiacian Features

  Background:
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @Signin
    Scenario Outline:
      And user enters a valid "<username>" username
      Then user clicks on password input box
      Then user enters a valid "<password>" password
      Then user clicks on second sign-in button
      Examples:
        |username  | password|
        |alimeCann | aliCan86 |

