@US10_TC04

Feature: Validate_appointments_with_DB

  Scenario:   Validate appointments with DB
  Given   user connect to applicants database
  Then   user get the data from database
  And   user reads all of the patient's id, start date, end date from database
  And   user close the connection


