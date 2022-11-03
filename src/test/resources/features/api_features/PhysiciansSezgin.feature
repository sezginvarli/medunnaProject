@US_018.1
Feature: test api physicians
  @SmokeTest
  @Api
  @PhysiciansGet

@POST
  Scenario:TC_001_User_can_POST_physicians_as_admin

    Given user creates a postbody
    Given user sends post request for creating new physician
    Then Status codes should be 201


  Scenario:TC_001_User_should_validate_physicians_info_as_admin

    Given user sends a GET request for physicians data
    Then the status codes should be 200
    When user deserializeses the user data to java


  Scenario: TC_001_User_can_PUT_physicians_as_admin

    Given user creates a postbody
    Given user sends post request for creating new physician
    Then Status codes should be 201


  Scenario Outline: TC_001_User_can_DELETE_physicians_as_admin

    #döngü yaparasak outline gerek kalmıyor
    Given User sends DELETE request for physicians "<id>"
    Then the status codes should be 200
    Examples:
      | id |
      |    |



  Scenario: TC_001_User_can_update_physicians_as_admin
