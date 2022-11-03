@Signin
@RoomCreation

Feature: Room creation / View / Update / Delete

  Background: Go to homepage
      And User clicks on account drop-down-menu button
      When User clicks on sign-in button
      When user clicks on username input box


  @US16_TC01

 Scenario Outline: User (Admin) can create new rooms for inpatients
      Then user enters a valid "<username>" username
      Then user clicks on password input box
      Then user enters a valid "<password>" password
      Then user clicks on second sign-in button
      Given admin clicks on Items&Titles button
      When admin clicks on Room button
      Then admin clicks on create a new room button
      Then admin verify that Create or edit Room is visible
      Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US16_TC02

  Scenario Outline: creating a room, there should be room number (required field), room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE
      Then user enters a valid "<username>" username
      Then user clicks on password input box
      Then user enters a valid "<password>" password
      Then user clicks on second sign-in button
      Given admin clicks on Items&Titles button
      When admin clicks on Room button
      Then admin clicks on create a new room button
      Then admin clicks on Room button
      Then admin enters a unique number
      And admin verify that room number is required
      And admin clicks on room type
      And admin verifies exist room types
      And admin select the room type
      And admin verifies that room type is required
      Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US16_TC03

  Scenario Outline: Current status can be set for the room
     Then user enters a valid "<username>" username
     Then user clicks on password input box
     Then user enters a valid "<password>" password
     Then user clicks on second sign-in button
     Given admin clicks on Items&Titles button
     When admin clicks on Room button
     Then admin clicks on create a new room button
     Then admin clicks on status button
     And  admin verifies that status is full
     And admin do not clicks on status button
     And admin verifies that status is available
     Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US16_TC04

  Scenario Outline: Price can be added and cannot be blank
     Then user enters a valid "<username>" username
     Then user clicks on password input box
     Then user enters a valid "<password>" password
     Then user clicks on second sign-in button
     Given admin clicks on Items&Titles button
     When admin clicks on Room button
     Then admin clicks on create a new room button
     Then admin clicks on price button
     And admin enters a valid price
     And admin verifies that price is required
     Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US16_TC05

  Scenario Outline: Description can be provided optionally
     Then user enters a valid "<username>" username
     Then user clicks on password input box
     Then user enters a valid "<password>" password
     Then user clicks on second sign-in button
     Given admin clicks on Items&Titles button
     When admin clicks on Room button
     Then admin clicks on create a new room button
     Then admin clicks on description button
     And admin clicks on save button
     And admin verifies that it is not required
     Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |


  @US16_TC07

  Scenario Outline: Admin can view all rooms with same items
     Then user enters a valid "<username>" username
     Then user clicks on password input box
     Then user enters a valid "<password>" password
     Then user clicks on second sign-in button
     Given admin clicks on Items&Titles button
     When admin clicks on Room button
     Then admin can see list of room type
     Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US16_TC08

  Scenario Outline: Admin can edit(update) existing rooms
     Then user enters a valid "<username>" username
     Then user clicks on password input box
     Then user enters a valid "<password>" password
     Then user clicks on second sign-in button
     Given admin clicks on Items&Titles button
     When admin clicks on Room button
     Then admin selects a room and clicks edit button
     And admin verifies that a room can be update
     Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |
  @US16_TC06

  Scenario Outline: Created date as MM/DAY/YEAR and cannot be typed earlier
    Then user enters a valid "<username>" username
    Then user clicks on password input box
    Then user enters a valid "<password>" password
    Then user clicks on second sign-in button
    Given admin clicks on Items&Titles button
    When admin clicks on Room button
    Then admin clicks on create a new room button
    Then admin clicks on the date button
    And admin verifies that date should be current
    Then admin enters a passed date
    Then user closes the browser

    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

