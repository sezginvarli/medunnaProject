@US_026
  Feature: Contact messages
    @US_026_TC01
    Scenario Outline: TC01_Any user who have account can use Contact portal to provide information or request info
      Given user goes to the url
      When User clicks on Contact without logging in
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies the pop-up that is Your message has been received
      And User saves the records
      Examples: information
      |name| email| subject| message|
      |John|john@gmail.com|payment|pay it|

    @US_026_TC02
    Scenario Outline: TC02_Any user who have not account can use Contact portal to provide information or request info
      Given User is on the sign in page
      When User clicks on Contact after logging in as "<username>" and "<password>"
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies the pop-up that is Your message has been received
      Examples: information
        |name| email| subject| message|username| password|
        |John|john@gmail.com|payment|pay it|john123| john123|

    @US_026_TC03
    Scenario Outline: TC03_User needs to provide name, lastname, email, Subject as required fields and message then send
      Given user goes to the url
      When User clicks on Contact without logging in
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies error messages for name is required
      And User verifies error messages for email is required
      And User verifies error messages for subject as This field is required
      And User verifies there is no any error messages for Message is required
      Examples: information
        |name| email| subject| message|
        |    |      |        |        |

    @US_026_TC04
    Scenario Outline: TC04_User should send messages without anything in the message box
      Given user goes to the url
      When User clicks on Contact without logging in
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies the pop-up that is Your message has been received
      Examples: information
        |name| email| subject| message|
        |John|john@gmail.com|payment|   |

    @US_026_TC05
    Scenario Outline: TC05_User should provide a valid email
      Given user goes to the url
      When User clicks on Contact without logging in
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies error messages for email is invalid
      Examples: information
        |name| email| subject| message|
        |John|john@gmailcom|payment|pay it later |

    @US_026_TC06
    Scenario Outline: TC06_User should send the same message twice
      Given user goes to the url
      When User clicks on Contact without logging in
      Then User verifies that on the contact page
      When User enters  their "<name>" in the name box
      And User enters  their "<email>" in the email box
      And User enters  their "<subject>" in the subject box
      And User enters  their "<message>" in the message box
      When User clicks on the Send button
      Then User verifies the pop-up that is Your message has been received
      When User clicks on the Send button again
      Then User verifies the pop-up that is Your message has been received
      Examples: information
        |name| email| subject| message|
        |John|john@gmail.com|payment|pay it|


