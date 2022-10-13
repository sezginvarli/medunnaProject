Feature: Test Registration data

  Scenario Outline: test new applicants
    Given user provides their ssn id as "<ssn>"
    And user provides their firstname as "<firstname>"
    And user provides their lastname as "<lastname>"
    When user provides their username as "<username>"
    And user types in their email as "<email>"
    When user provides their password as "<password>"
    And user types their password confirmation as "<password_confirm>"
    Then user registers and saves the records

    Examples: test data for applicants
      | ssn | firstname | lastname | username | email | password | password_confirm |
      |     |           |          |          |       |          |                  |