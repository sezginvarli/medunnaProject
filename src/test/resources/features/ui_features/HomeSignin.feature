
Feature: Home Page and Sign-in Features

  @Signin
  Scenario Outline: Sign in feature

    When user click on account menu
    Then user can select Sign in
    And user enter their username as "<username>"
    And user enter their password as "<password>"
    And user click on Remember me checkbox
    Then user click on Sign in
    Examples:
      | username | password |
      | hk_admin |    Hk_admin |