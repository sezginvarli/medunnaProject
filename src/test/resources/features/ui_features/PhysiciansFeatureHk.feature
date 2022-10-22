@Signin
Feature: Physiacian Features

  Background:
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button

  @PhysicianAppointmentEdit
  Scenario Outline: Physician Editing appointment - Happy path :)
    And user enters a valid "<username>" username
    Then user clicks on password input box
    Then user enters a valid "<password>" password
    Then user clicks on second sign-in button
    And  user validate user login as "<name>" at account menu
    And user click on MyAppointments under MyPages
    And user validate being at Appointments page
    And Choose a patient & click on Edit button to edit an appointment
    And Assert that Create_or_Edit_an_Appointment page is opened
    Then check if patient id, start date, end date, status, physician area are fullfilled
    And Validate only appointment status  "PENDING", "COMPLETED", "CANCELLED" can be selected
    And check if the anamnesis as "<Anamnesis>" text box is editable and cannot be left empty
    And check if the treatment as "<Treatment>" text box is editable and cannot be left empty
    And check if the diagnosis as "<Diagnosis>" text box is editable and cannot be left empty
    And check if the prescription as "<prescription>" text box is editable and cannot be left empty
    And check if the description as "<description>" text box is editable and cannot be left empty
    Then user saves the updated appointment
    And verify the appointment is updated successfully
    And user sign out

    Examples:
      | username   | password | name       | Anamnesis           | Treatment     | Diagnosis | prescription | description          |
      | alimeCann  | aliCan86 | alime cann | knee pain,dorsalgia | ASA           | RA        | Aspirin      | call back next month |
#     | allimeCann | aliCan86 | alime can  | cough               | Acetylsistein | URTI      |              |                      |

    @PhysicianAppointment
    Scenario Outline: Physician Sign in
      And user enters a valid "<username>" username
      Then user clicks on password input box
      Then user enters a valid "<password>" password
      Then user clicks on second sign-in button
      And  user validate user login as "<name>" at account menu
      And oser click on MyAppointments under MyPages
      And user validate being at Appointments page
      And Choose a patient & click on Edit button to edit an appointment
      And Assert that Create_or_Edit_an_Appointment page is opened
      Then check if patient id, start date, end date, status, physician area are fullfilled
      And Validate only appointment status  "PENDING", "COMPLETED", "CANCELLED" can be selected
      And check if the Anamnesis text box is editable and cannot be left empty
      And check if the Treatment text box is editable and cannot be left empty
      And check if the Diagnosis text box is editable and cannot be left empty

      Examples:
        | username  | password | name       |
        | alimeCann | aliCan86 | alime cann |