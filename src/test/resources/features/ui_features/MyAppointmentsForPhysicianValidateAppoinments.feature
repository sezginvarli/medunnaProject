Feature: My Appointments for Physician(Doctor) Validate appoinments with API and DB


  @US10_TC01
  Scenario Outline: user (doctor) can see their appointments list and time slots on My Appointments
    Given user navigate medunna.com
    Then user click sign drop-down button
    And user click signin button
    And user enter Username (as a doctor account)"<username>"
    And user enter Password "<password>"
    And user click Sign in button
    And user click my pages drop-down button
    And click My Appointments
    And verify Appointments page
    Examples:
      | username    | password |
      | doctorurfa5 | 123urfa  |

  @US10_TC02
  Scenario Outline:user(doctor) can see patient id, start date, end date, status

    Given user navigate medunna.com
    Then user click sign drop-down button
    And user click signin button
    And user enter Username (as a doctor account)"<username>"
    And user enter Password "<password>"
    And user click Sign in button
    And user click my pages drop-down button
    And click My Patients
    And verify Patients page
    Examples:
      | username    | password |
      | doctorurfa5 | 123urfa  |

  @US10_TC02
  Scenario Outline:Validate appointments with API
    Given user(doctor account) send a get request for users' data
    Then user deserializes the users' data to java
    And user saves the users' data to correspondent files and validates
