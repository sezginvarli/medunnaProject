@US_008
Feature:Password segment on Homepage should be editable
  Background:User is on the Password edit page
    Given user goes to the url
    When user clicks on the signIn section at the dropdown
    Then user verifies the Sign in page
    When user enters their credentials for signIn and clicks
    Then user clicks on the Password section at the dropdown
    And user verifies Password for page
@US_008_HP
    Scenario:User can edit and change their password
    Then user enter their current password as "erty"
    And user enter their new password as "erty"
    And user enter their confirmation password as "erty"
    Then user clicks on the save button
    And user verifies Password changed! pop-up
    And user saves the password data
    Then user closes the browser
  @US_008_TC01
  Scenario: TC01 new password should be confirmed
    Given user enter their current password as "erty"
    And user enter their new password as "eeeee"
    And user enter their confirmation password as "eeeee"
    Then user verifies there is no any error message for confirmation

  @US_008_TC02
  Scenario: TC02 new password should be confirmed
    Given user enter their current password as "erty"
    And user enter their new password as "eeeee"
    And user enter their confirmation password as "aaaaa"
    Then user verifies The password and its confirmation do not match! error message

  @US_008_TC03
  Scenario Outline: There should be at least 1 lowercase char and see the level chart
    Given user enter their current password as "erty"
    And user enter their new password as "<newPassword>"
    Then user should see one 1 bar in the password strength
    When user add "<char>" after the newPassword
    Then user should see one 2 bar in the password strength
    And user enter their confirmation password as "<confirmPassword>"
    Then user closes the browser
    Examples: test data
    |newPassword|char|confirmPassword|
    |123456     |k   |123456k        |
    |ASDFGH     |kl  |ASDFGHkl       |

  @US_008_TC04
  Scenario Outline: There should be at least 1 uppercase char and see the level chart
    Given user enter their current password as "erty"
    And user enter their new password as "<newPassword>"
    Then user should see one 2 bar in the password strength
    When user add "<char>" after the newPassword
    Then user should see one 4 bar in the password strength
    And user enter their confirmation password as "<confirmPassword>"
    Then user closes the browser
    Examples: test data
      |newPassword|char|confirmPassword|
      |123456k    |A   |123456kA       |
      |asdfgh1    |KL  |asdfgh1KL      |

  @US_008_TC05
  Scenario Outline: There should be at least 1 special char and see the level chart
    Given user enter their current password as "erty"
    And user enter their new password as "<newPassword>"
    Then user should see one 2 bar in the password strength
    When user add "<char>" after the newPassword
    Then user should see one 4 bar in the password strength
    And user enter their confirmation password as "<confirmPassword>"
    Then user closes the browser
    Examples: test data
      |newPassword|char|confirmPassword|
      |abcdefF    |!   |abcdefF!       |
      |asdfgh1    |!*  |asdfgh1!*      |

  @US_008_TC06
  Scenario Outline: There should be at least 1 digit and see the level chart
    Given user enter their current password as "erty"
    And user enter their new password as "<newPassword>"
    Then user should see one 4 bar in the password strength
    When user add "<char>" after the newPassword
    Then user should see one 5 bar in the password strength
    And user enter their confirmation password as "<confirmPassword>"
    Then user closes the browser
    Examples: test data
      |newPassword|char|confirmPassword|
      |ASDFGHf/!  |1   |ASDFGHf/!1     |
      |asdfghF!*  |123 |asdfghF!*123   |

  @US_008_TC07
  Scenario:The old password should not be used
    Then user enter their current password as "erty"
    And user enter their new password as "erty"
    And user enter their confirmation password as "erty"
    Then user clicks on the save button
    And user should not see Password changed! pop-up
    Then user closes the browser

  @US_008_TC08
  Scenario Outline: There should be at least 7 chars for a stronger password
    Given user enter their current password as "erty"
    And user enter their new password as "<newPassword1>" which includes all necessities
    Then user should see one 1 bar in the password strength
    Then user clears the text box
    And user enter their new password as "<newPassword2>" which includes all necessities
    Then user should see one 5 bar in the password strength
    Then user closes the browser
    Examples: test data
      |newPassword1|newPassword2  |
      |123@Wd      |123@Wd1       |
      |abc1F!      |abc1F!6.k     |

  @US_008_TC09
  Scenario: user should not see an increasing level without entering valid password combination
    Given user enter their current password as "erty"
    When user enter their new password as "       "
    Then user should not see more than 1 bar













