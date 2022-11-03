@Api
@hk
Feature: Validate Te@Apist Items Creation with Api

  @TestItemCheckApi
  Scenario Outline: Validate new test items creation by admin, from Api 17.2_1
    Given admin sends a GET request for test items all data
    When user deserializes the test items data to java
    Then Check if the new created tests exist by <id>
    Examples:
      | id        |
      | 289286    |
      | 289286456 |

  @TestItemsCreationApi
  Scenario Outline: Creating test items via Api

    When user sends price as <price>, defaultValMax as "<defaultValMax>", defaultValMin as "<defaultValMin>"
    And user sends description as "<description>" ,test items' name as "<name>"
    Then admin make a post request to create a new test item
    Then user validate test item is created as expected
    Examples:
      | price | defaultValMax | defaultValMin | description  | name     |
      | 33    | 333           | 33            | thirty three | thrty_01 |

  @TestItemsDeletionApi
  Scenario Outline: Deleting test items via Api
    Given admin sends a GET request for test items all data
    When user deserializes the test items data to java
    Then Check if the new created tests exist by <id>
    And user make a delete request for the <id> test item & validate the deletion
    Examples:
      | id |
    |  2946702 |
    |  2946703 |





