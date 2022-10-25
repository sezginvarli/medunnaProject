Feature: Physician_db_test
  @PhysiciansDB
  Scenario: 18.2_Get_Physician_db
    Given admin send the credential for connect the database
    When admin get the all Physicians data
    Then admin check whether created Physician is exist or not