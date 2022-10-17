Feature: Registration Page Should Restrict Password

  @Signin
  @US03_TC01
  Scenario: For a valid passcode there should be at least 4 chars

  Given user navigates to URL "https://medunna.com"
  When  User clicks on account drop-down-menu button
  Then User clicks on sign-in button
  And user click new password inputbox
  And user chooses a 4-digit password from the same type of characters
  And verify password at least 4 chars


