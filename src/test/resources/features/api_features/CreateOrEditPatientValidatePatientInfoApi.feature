Feature: US_015
  @SmokeTest
  @PatientInfoValidation
Scenario Outline:Create Or Edit Patient Info With API
  Given user sends get request all patients
  Then user sees the status code as 200
  And User makes  all patients info deserialize
  Then validate "<Id>" Id
  And validate "<Ssn>" Ssn
  And validate "<firstname>" firstname
  And validate "<lastname>" lastname
  And validate "<birthDate>" birthDate
  And validate "<phone>" phone
  And validate "<email>" email
  And validate "<gender>" gender
  And validate "<bloodGroup>" bloodGroup
  And validate "<address>" address
  And validate "<description>" description
  And validate "<createDate>" createDate
  And validate "<username>" username
  And validate "<country>" country
  And validate "<state>" state
    Examples:
      | Id | Ssn | firstname | lastname | birthDate | phone | email | gender | bloodGroup | address | description | createDate | username | country | state |
      | 4864 | 345-34-2323| patient45 | patient45 | 1990-02-01T10:12:00Z | 205-900-2000 | patient45@qa.team | MALE | Apositive | tt | ddd | 2022-01-01T17:50:50.631639Z | hasta | Turkey | Afyonkarahisar |




