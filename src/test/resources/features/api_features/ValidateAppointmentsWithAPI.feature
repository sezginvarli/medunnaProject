@US10
Feature: My Appointments for Physician(Doctor) Validate appointments with API and DB

  @US10_TC030
  Scenario Outline: Validate appointments with API
    Given user sends a GET patient request for doctor users
    And user converts user record to Java
    Then user validates users data <id> <index>
    Examples:
      | id     | index |
      | 16556  | 0     |
      | 16557  | 1     |
      | 16565  | 2     |
      | 16586  | 3     |
      | 16600  | 4     |
      | 141996 | 5     |
      | 277757 | 6     |