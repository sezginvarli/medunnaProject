@US_0004
@Signin
Feature: US_04_user_sign-in

  Background: Go to homepage

    And User clicks on account drop-down-menu button
    When User clicks on sign-in button

  @US04_TC01
  Scenario Outline:need_to_test_user_sign-in
    When user clicks on username input box
    Then user enters a valid "<username>" username
    Then user clicks on password input box
    Then user enters a valid "<password>" password
    Then user clicks on second sign-in button
    When user verifies that signed-in "<signedInUserName>" is done successfully
    And user closes the browser
    Examples:user credentials
      | username | password | signedInUserName |
      | patient29  | patient29 | Patient29 patient |

  @US04_TC02
  Scenario Outline: need_to_test_remember_me_option_for_existing_credential
    And user clicks on username input box
    And user enters a valid "<username>" username
    And user clicks on password input box
    And user enters a valid "<password>" password
    Then Verify that remember me checkbox is clickable
    And user closes the browser
    Examples:user credentials
      | username | password |
      | Batch86  | Batch86+ |

  @US04_TC03
  Scenario Outline: need_to_update_password_if_forgotten
    When User clicks on Did you forget your password? text box
    Then User verifies that Reset your password? Header is visible
    Then User clicks on email text box
    And User enters a "<email>" address which was used to register
    And User clicks on Reset password button
    Then Verifies that Check your emails for details on how to reset your password is visible
    And user closes the browser
    Examples:user credentials
      | email |
      | patient29@gmail.com |

  @US04_TC04
  Scenario: need_to_navigate_registration_page_if_not_registered_yet
    And User Verifies that sign-in header is visible
    Then User verifies You don't have an account yet? Register a new account is visible
    When User clicks on Register a new account
    Then User verifies that Registration Page is visible
    And user closes the browser

  @US04_TC05
  Scenario: need_to_test_option_of_cancel_login
    And User Verifies that sign-in header is visible
    When User verifies that "cancel" button exists on the page
    And user closes the browser

  @US04_TC01Negative_01
  Scenario Outline: need_to_test_sign-in_with_wrong_username
    When User clicks on username input box second
    Then User enters a invalid "<wusername>" username
    Then clicks on password input box
    Then enters a valid "<password>" password
    Then clicks on sign-in button
    When verifies that Authentication information not correct is displayed
    And user closes the browser
    Examples:
      | wusername | password |
      | wpatient29  | patient29 |

  @US04_TC01Negative_02
  Scenario Outline: need_to_test_sign-in_with_wrong_password
    When User clicks on username input box second
    Then User enters a invalid "<username>" username
    Then clicks on password input box
    Then enters a valid "<wpassword>" password
    Then clicks on sign-in button
    When verifies that Authentication information not correct is displayed
    And user closes the browser
    Examples:
      | username | wpassword |
      | patient29  | wpatient29 |

  @US04_TC01_Negative_03
  Scenario Outline: need_to_test_sign-in_with_wrong_username_and_password
    When User clicks on username input box second
    Then User enters a invalid "<wusername>" username
    Then clicks on password input box
    Then enters a valid "<wpassword>" password
    Then clicks on sign-in button
    And user closes the browser

    Examples:
      | wusername | wpassword |
      | wpatient29  | wpatient29 |




