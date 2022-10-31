@Signin
@US_09
Feature: View, edit and delete Patient information

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    When User clicks on sign-in button

    @US_09_1_TC01
    Scenario Outline: View patient information
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And User clicks on My PAGES button.
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on View button
      Then Verify view portal is displayed
      And user close the page
      Examples:
        | username    | password    | SSN         |
        | team03staff | team03Staff | 128-65-1234 |


      @US_09_1_TC02
      Scenario Outline: Edit all patient information
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And User clicks on My PAGES button.
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on Edit button
      And user sends a new firstname
      And user sends a new lastname
      And user sends a new birthday
      And user sends a new email
      And user sends a new phone
      And user select a new gender
      And user select a new blood group
      And user sends a new address
      And user sends a new description
      And user select a new user
      And user select a new country
      And user select a new state-city
      And user clicks on Save button
      Then Verify "A new Patient is created with identifier" pop up
      And user close the page
      Examples:
        | username    | password    | SSN         |
        | team03staff | team03Staff | 128-65-1234 |


    @US_09_1_TC03
    Scenario Outline: Search new applicant with SSN and see all info
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And User clicks on My PAGES button.
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on View button
      And Verify All Patient Info is displayed
      And user close the page
      Examples:
        | username    | password    | SSN         |
        | team03staff | team03Staff | 128-65-1234 |

