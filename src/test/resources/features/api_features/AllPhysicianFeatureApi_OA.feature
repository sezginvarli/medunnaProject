Feature: medunna_physician_api
  @Api
  @allPhysicians
  Scenario: physicians
    Given admin send the request for physicians data
    And admin deserialization the physicians data to java
    Then admin saves users data correspondent files to validate