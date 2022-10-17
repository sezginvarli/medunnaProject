@US002
@US002_DB
Feature: US002_email_validation_db
  Scenario:TC01_email_db
    Given user connects to the database
    Then user verifies that "jhi_user" table "email" column contains "maryland@gmail.com"
    And user close the database connection