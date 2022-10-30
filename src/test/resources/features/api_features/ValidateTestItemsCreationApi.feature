
  @hk
Feature: Validate Test Items Creation with Api
  @TestItemCheckApi
  Scenario Outline: Validate new test items creation by admin, from Api 17.2_1
    Given admin sends a GET request for test items all data
    When user deserializes the test items data to java
    Then Check if the new created tests exist by <id>
    Examples:
      | id     |
      | 289286     |
      | 289286456     |

  @TestItemsCreationApi
  Scenario: Creating test items via Api
    Given admin make a post request to create a new test item



