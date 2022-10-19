@Signin
@CreatedOrEditPatientByAdmin
Feature: Create Or Edit Patient By Admin

  Background: Go to homepage
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button


  @CreatedPatientByAdmin
  Scenario Outline: New patient is created by admin
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When Click on Items&Titles button then click patient button
    And Click on Create a new patient button
    And Enter "<firstname>" in firstname box
    And Enter "<lastname>" in lastname box
    And Enter "<birth_date>" in birth date box
    And Enter "<email>" in email box
    And Enter "<phone>" in phone box
    And Select gender in dropdown
    And Select blood group in dropdown
    And Enter Address in address box
    And Enter "<description>" in description box
    And Enter country in dropdown
    And Click on save button
    Then Verify "<message>" message
    Then close the application

    Examples:
      | username | password | firstname | lastname | birth_date | email | phone | description | message|
      | Batch86 |Batch86+ |Tom | Hanks | 2000-02-17T15:03 | tomhanks2@gmail.com |5095487814| Cold Flue|A new Patient is created |


@CreatedPatientByOtherUsers
  Scenario Outline: New patient is created by other users
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    Then Verify the Items&Titles is not here
    And User clicks on account drop-down-menu button
    Then user click on sign out
  Examples:
    | username | password |
    | team03doctor | team03Doctor  |
    | team03patient  | team03Patient |
    | team03staff  | team03Staff  |
    | userbatch8687 | Batch86+ |

@SeeAllInformationByAdmin
  Scenario Outline: Admin can see all patient information
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When Click on Items&Titles button then click patient button
    Then Verify all information
    Then  close the application
    Examples:
      | username | password |
      | Batch86 | Batch86+ |

@AllInformationPlusID
Scenario Outline: Admin can see all patient information plus id
  Given user enters a valid "<username>" username
  When user enters a valid "<password>" password
  And user clicks on second sign-in button
  When Click on Items&Titles button then click patient button
  And user click on edit button
  Then verify ID item is displayed
  And close the application
  Examples:
    | username | password |
    | Batch86 | Batch86+ |

  @AdminAssignPatientTheirDoctor
  Scenario Outline: Admin can see all patient information plus id
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When click on Items&Titles button then click appointment button
    And click first edit button
    And user assign new doctor for patient
    And Click on save button
    Then Verify "<message>" message
    Then close the application
    Examples:
      | username | password | message|
      | team03alpha | team03Admin | The Appointment is updated|

  @OtherUsersAssignPatientTheirDoctor
  Scenario Outline: Admin can see all patient information plus id
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    Then Verify the Items&Titles is not here
    And User clicks on account drop-down-menu button
    Then user click on sign out
    Examples:
      | username | password |
      | team03doctor | team03Doctor  |
      | team03patient  | team03Patient |
      | team03staff  | team03Staff  |
      | userbatch8687 | Batch86+ |

  @StateCanNotBeBlank1
  Scenario Outline: State should be provided as US state and cannot be blank
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When Click on Items&Titles button then click patient button
    And user click on edit button
    And user selects "<Country>" country
    And user selects "<state>" state
    And Click on save button
    Then Verify "<message>" message
    Then close the application
    Examples:
      | username | password |Country |state |  message|
      | team03alpha | team03Admin | USA|California| A Patient is updated|

  @StateCanNotBeBlank2
  Scenario Outline: State should be provided as US state and left blank
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When Click on Items&Titles button then click patient button
    And user click on edit button
    And user selects "<Country>" country
    And user selects "<state>" state
    And Click on save button
    Then Verify "<message>" message
    Then close the application
    Examples:
      | username | password |Country |state |  message|
      | team03alpha | team03Admin | USA|   | State is required|

  @AdminDeletesAnyPatient
  Scenario Outline: New patient is created by admin
    Given user enters a valid "<username>" username
    When user enters a valid "<password>" password
    And user clicks on second sign-in button
    When Click on Items&Titles button then click patient button
    And Click on Create a new patient button
    And Enter "<firstname>" in firstname box
    And Enter "<lastname>" in lastname box
    And Enter "<birth_date>" in birth date box
    And Enter "<email>" in email box
    And Enter "<phone>" in phone box
    And Select gender in dropdown
    And Select blood group in dropdown
    And Enter Address in address box
    And Enter "<description>" in description box
    And Enter country in dropdown
    And Click on save button
    And click on ID button for order
    And user clicks on delete button
    And user clicks on confirm delete button
    Then Verify "<message>" message
    Then close the application
    Examples:
      | username | password | firstname | lastname | birth_date | email | phone | description | message|
      | Batch86 |Batch86+ |Tom | Hanks | 2000-02-17T15:03 | tomhanks2@gmail.com |5095487814| Cold Flue|A Patient is deleted|
