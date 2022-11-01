@US_27_Messages
@Signin
@Close
Feature: Admin Read, Create, Update and Delete
  Background: Go to home page and click messages
    Given User clicks on account drop-down-menu button
    And User clicks on sign-in button
    And Admin enters username and password
        |username|password|
        |Batch86 |Batch86+|
    And user clicks on second sign-in button
    And Click on Items&Titles button then click messages button
    @US_27_TC_01
    Scenario: Admin view all messages, their authors and emails
      Then validate to all messages, name and emails

    @US_27_TC_02
    Scenario Outline: Admin creates a new message
      When user clicks on create a new message button
      And user enter "<name>" in namebox
      And user enter "<email>" in emailbox
      And user enter "<subject>" in subjectbox
      And user enter "<messages>" in messagesbox
      And user clicks on save button for creating message
      And user saves the message data into file
      Then verify "<message>" message
      Examples:
        | name | email | subject | messages | message |
        | Ahmet | ahmet1234@gmail.com | Congrats | Your treatment is perfect |A new Message is created|

    @US_27_TC_03
    Scenario Outline:Admin updates message
      When user clicks on first edit button
      And update "<name>", "<email>", "<subject>" and "<messages>"
      And user clicks on save button for creating message
      Then verify "<message>" message
      Examples:
        | name | email | subject | messages | message |
        | recep | recep@gmail.com | Hello | Be relax | A Message is updated |

    @US_27_TC_04
    Scenario Outline:Admin deletes message
      When admin clicks on first delete button
      And admin clicks on confirm delete button
      Then verify "<message>" message
      Examples:
          | message |
          | A Message is deleted |
