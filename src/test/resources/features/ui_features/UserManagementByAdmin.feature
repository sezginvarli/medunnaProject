@US_0020
Feature: Admin can view and edit people info

  Background: User sign in as admin
    Given user goes to the url
    When User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And user clicks on username input box
    And user enters a valid "Batch86" username
    And user clicks on password input box
    And user enters a valid "Batch86+" password
    And user clicks on second sign-in button


  @US_0020_TC01
  Scenario:Admin views users
    When User clicks on Administrations
    And User clicks on User Management
    Then User clicks on view button
    And User verifies user's information on the page
    And user close the page

  @US_0020_TC02
  Scenario:Admin can edit
    When User clicks on Administrations
    And User clicks on User Management
    And User clicks on Edit button
    And User selects Activated checkbox
    And User cliks on Save button
    And user close the page

  @US_0020_TC03
  Scenario Outline:Admin can edit
    When User clicks on Administrations
    And User clicks on User Management
    And User clicks on Edit button
    And User selects Activated checkbox
    And User assigns "<role>" "<index>" to the user
    And User cliks on Save button
    And user close the page
    Examples:
        | role           | index |
        | ROLE_ADMIN     | 0 |
        | ROLE_USER      | 1 |
        | ROLE_PATIENT   | 2 |
        | ROLE_STAFF     | 3 |
        | ROLE_PHYSICIAN | 4 |

  @US_0020_TC04
  Scenario:Admin can edit
    When User clicks on Administrations
    And User clicks on User Management
    Then User clicks on Delete
    And User clicks on Delete button in Delete message
    And user close the page
