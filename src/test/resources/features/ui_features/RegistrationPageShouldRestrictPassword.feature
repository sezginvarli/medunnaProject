Feature: Registration Page Should Restrict Password


  @US03_TC01
  Scenario Outline: For a valid passcode there should be at least 4 chars

    Given user goes to the url
    Then user clicks on the register section at the dropdown
    And user chooses a four digit password from the same type of characters "<password>"
    And verify password at least four chars
    And user closes the browser
    Examples:
      | password |
      |aaAA      |
      |ab2@      |
      |eDc4      |

  @US03_TC02
  Scenario Outline: There should be at least 1 UpperCase char for stronger password and  see the level chart change accordingly

    Given user goes to the url
    Then user clicks on the register section at the dropdown
    And user enters password at least as one uppercase "<password>"
    And verify the level chart change accordingly
    Examples:
      | password |
      |aAAA    |
      |b2@C    |
      |Dc4Z    |

  @US03_TC03
Scenario Outline:There should be at least 1 special char and see the level chart change accordingly
  Given user goes to the url
  Then user clicks on the register section at the dropdown
  And user enters char as special "<password>"
  And verify the level bar change accordingly
    Examples:
      | password |
      |aAAA#    |
      |b2@C.    |
      |Dc4Z?    |

  @US03_TC04
    Scenario Outline: There should be at least 1 digit and see the level chart change accordingly

      Given user goes to the url
      Then user clicks on the register section at the dropdown
      And user enters char as digit "<password>"
      And verify the level bar level change accordingly
    Examples:
      | password |
      |aAAA#8    |
      |b2@C.5    |
      |Dc4Z?2    |

  @US03_TC05
    Scenario Outline: There should be at least 7 chars for a stronger password
      Given user goes to the url
      Then user clicks on the register section at the dropdown
      And user enters char at least seven digit password "<password>"
    And verify at least 7 chars for strong password
      Examples:
        | password |
        |aA!A#8y    |
        |b2@C.5g    |
        |Dc4Z?2h    |