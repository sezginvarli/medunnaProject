@Close
  @US05
Feature: Make An Appointment with Registered SSN

Scenario Outline:Make an appointment
  Given User go to the "https://medunna.com"
  Given User click make an apointment button
  When User enter valid "<firstname>" that contains any char
  Then User enters a registered "<SSN id>"
  And User enters a "<lastname>" that cointains any char
  And User provides valid "<email>"
  And User enters valid "<Phonenumber>"
  And User Clicks Send an Appointment Request
  And User clicks on sign-in
  And User Enters "<UserName>"
  And User Enter "<password>"
  And User clicks on sign-in Button
  And User clicks My Pages patient Dropdown
  And User searchs My Appointment
  Then Verify user assert the created appointment
  Then User closes the page
  Examples:
    | firstname | SSN id | lastname | email         | Phonenumber | UserName | password |
    |Ahmet    |122-22-1111 |Ertem   |artem@gmail.com|234-245-4567  |artem     |12345 |