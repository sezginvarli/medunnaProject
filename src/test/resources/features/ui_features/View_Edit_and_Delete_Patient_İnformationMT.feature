Feature: View, edit and delete Patient information

  Background: Go to homepage
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

    @Signin
    @US_09_1_TC01
    Scenario Outline: View patient information
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And user clicks on My Pages button
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on View button
      Then Verify view portal is displayed
      And user close the application
      Examples:
        | username    | password    | SSN         |
        | team03staff | team03Staff | 132-45-1231 |


      @Signin
      @US_09_1_TC02
      Scenario Outline: Edit all patient information
      And user clicks on My Pages button
      And user clicks on Search Patient button
      And user search patient with "<SSN>"
      And user clicks on View button
      And user clicks on Edit button
      And user edit id
      And user edit firstname
      And user edit lastname
      And user edit birthday
      And user edit email
      And user edit phone
      And user select a gender
      And user select a blood group
      And user edit address
      And user edit description
      And user select a user
      And user select a country
      And user select a state/city
      And user clicks on "Save" button
      Then Verify "A new Patient is created with identifier" pop up
      And user close the application
      Examples:
        | username    | password    | SSN         |
        | team03staff | team03Staff | 132-45-1231 |

    @Signin
    @US_09_1_TC03
    Scenario Outline: Search new applicant with SSN and see all info
      When user clicks on username input box
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      And user clicks on second sign-in button
      And user clicks on My Pages button
      And user clicks on Search Patient button
      And user sends an SSN to Search Box
      And user clicks on View button
      And Verify Patient Info Page is displayed
      Then user close the application
      Examples:
        | username    | password    |
        | team03staff | team03Staff |






