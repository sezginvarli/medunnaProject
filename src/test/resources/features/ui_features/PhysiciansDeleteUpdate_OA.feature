@Signin
@Close
@AllFeatureUS18.02
Feature: Test Physicians

  Background: Go to homepage
    And User clicks on account drop-down-menu button
    When User clicks on sign-in button
    And user clicks on username input box


  @US18.02_TC01
  Scenario Outline: Admin doctor can update a new physician
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When user click on physician from dropdown button
    And user click on click on edit button
    And user click on back button
    And user fill the required credentials
    And user click on save button and should see successfully edited message
    Then user refresh the page should see edited physician
    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US18.02_TC02
  Scenario Outline: Admin doctor can create a new physician
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When user click on physician from dropdown button
    And user click on click on create physician button
    And user fill the required field credentials
    And user click on save button and should see successfully created message
    Then user refresh the page and click created date and in first place must see the created physician
    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US18.02_TC03
  Scenario Outline:Admin doctor can delete a physician
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When user click on physician from dropdown button
    When Admin should click  "Delete" button which is created by admin
    Then Admin should see deleted message
    And when page is refreshed admin couldn't see the physician
    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

    @US18.02_TC04
    Scenario Outline:Admin doctor can view a physician
      And user enters a valid "<username>" username
      And user clicks on password input box
      And user enters a valid "<password>" password
      Then user clicks on second sign-in button
      When user click on physician from dropdown button
      And Admin should see physican in page with scroll down
      When Admin click on random physician view button
      Then Page must include "First Name,Last Name,Birth Date,Phone,User,Exam Fee etc…
      Examples:user credentials
        | username | password |
        | Batch86  | Batch86+ |

      @US18.02_TC05
      Scenario Outline:Admin doctor can not create without obligate fields
        And user enters a valid "<username>" username
        And user clicks on password input box
        And user enters a valid "<password>" password
        Then user clicks on second sign-in button
        When user click on physician from dropdown button
        When Admin should click Create a new Physician button
        Then Admin must see "Create or edit a Physician"
        When Admin fill the required credentials except First Name
        Then Admin click on save button and should see "This field is required."
        When Admin fill the required credentials except Last Name
        Then Admin click on save button and should see "This field is required."
        When Admin fill the required credentials except Exam Fee
        Then Admin click on save button and should see "This field is required."
        When Admin fill the required credentials except Phone
        Then Admin click on save button and should see "Phone number is required."
        When Admin fill the required credentials but;filled date outside of the stated dates
        Then Admin click on save button and should see "Date must be between 10/21/1822 and 10/21/2002"
        Examples:user credentials
          | username | password |
          | Batch86  | Batch86+ |

