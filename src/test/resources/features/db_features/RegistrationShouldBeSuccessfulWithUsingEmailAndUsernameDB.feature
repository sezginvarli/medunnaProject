@US_002
Feature: US002_email_validation_db
  @US002_TC01_DB
  Scenario:TC01_email_validation
    Given user connects to the database
    Then user verifies that "jhi_user" table "email" column not contain "fakererer@gmail.com"
    And user closes the database connection