@Api
@US_024
  Feature: My Appointments by Patient
    @US_024_TC01
    Scenario: TC01 payment validation by patient
      Given user sends a get request with given id "289363" for payment validation
      Then the status code should be 200 for payment validation
      And user deserializes the payment data to java
      And user should be validated payment information
    @US_024_TC02
    Scenario: TC02 test results validation by staff
      Given user sends a get request with given id "278785" for test results validation
      Then the status code should be 200 for test results validation
      And user deserializes the test results data to java
      And user should be validated test results information
    @US_024_TC03
    Scenario: TC03 test items validation by admin
      Given user sends a post request creating test items
      #Then the status code should be 201 for test results validation
      #And user deserializes the test results data to java
      #And user should be validated test results information

