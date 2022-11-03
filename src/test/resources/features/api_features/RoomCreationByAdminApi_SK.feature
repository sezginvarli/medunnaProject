@Api
@API_US_16

Feature: Validate all rooms with API creating, reading, updating and deleting

  @RoomGetRequest
  Scenario: Get Room Validation from API

    Given admin sends a get request for rooms' data
    Given admin should receive 200 status code
    And admin deserializes the rooms' data to java
    Then admin saves the rooms' data to corresponding file and validates the data


  @RoomPostRequest
  Scenario: Post Room Validation from API

    Given admin sends a post request for rooms' data
    And admin validates the post data to java

