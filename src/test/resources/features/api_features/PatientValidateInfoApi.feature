@US_009API
Feature:US009 API Test

  @US_009API_PatientGet_Staff
  Scenario Outline:TC_004_User_should_validate_patient_info_as_staff

    Given User sends GET patient request as Staff to end point
    And User validate status code 200
    And User makes patient info deserialize
    And User validate patient with "<id>"
    Examples: id
      |id|
      |276234|

  @US_009API_PatientGet_Admin
  Scenario Outline:TC_004_User_should_validate_patient_info_as_admin

    Given User sends GET request as Admin to end point
    And User validate status code 200
    And User makes patient info deserialize
    And User validate patient with "<id>"
    Examples: id
      |id|
      |276234|


  @US_009API_PatientDelete_Admin
  Scenario:TC_004_User_can_delete_patient_as_admin

    Given Admin sends DELETE request to URL
    And User validate status code 200



  @US_009API_PatientDelete_Staff
  Scenario:TC_004_User_cannot_delete_patient_as_staff

    Given Staff sends DELETE request to URL
    And Staff validate status code 400

  @US_009API_PatientSearch_Staff_ssn
  Scenario Outline:TC_004_Staff_should_search_patient_info

    Given Staff sends "<SSN>" to search URL
    And User validate status code 200
    And Staff makes patient info deserialize
    And Staff validate patient info
    Examples: ssn
      |SSN|
      |111-27-8888|


  @US_009API_PatientSearch_admin_ssn
  Scenario Outline:TC_004_Admin_cannot_search_patient_info

    Given Admin sends "<SSN>" to search URL
    And Admin verifies status code 400
    Examples: ssn
      |SSN|
      |111-27-8888|
