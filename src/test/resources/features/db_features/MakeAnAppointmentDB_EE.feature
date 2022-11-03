@US05_DB
@SmokeTest
Feature:US05_Make An Appointment DB

  Scenario Outline: TC01
    Given User connects to database
    Then User gets appointment info
    And User verifies appointment "<id>"
    Then User closes the database connection

    Examples: ssn
      |id|
      |280851|
