 Feature: Check with the contact us feature 
 Scenario Outline: User enters invalid name
    Given the user is on website IP addresss
    When the user clicks the contact us link on the dashboard
    When the user Enters the name as "<name>"
    When I enter "john.doe@example.com" into the email field
    When I enter "9234567890" into the phone field
    When I enter "This is a test message." into the message field
    When clicks the valid Submit button
    Then the user should see the message as "<errorMessage>"

    Examples:
      | name      | errorMessage                   |
      | Jo        | Please enter minimum 3 letters |
      | Jo123     | Please Enter Valid Name!       |
      |           | The Name field is mandatory!   |
      | Jo@11     | Please Enter Valid Name!       |
      | ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg | Please enter no more than 45 characters.|
             
  Scenario Outline: User enters invalid phone number
    Given the user is on website IP addresss
    When the user clicks the contact us link on the dashboard
    When the user Enters the name as "John Doe"
    When I enter "john.doe@example.com" into the email field
    When I enter "<phoneNumber>" into the phone field
    When I enter "This is a test message." into the message field
    When clicks the valid Submit button
    Then the user should see the message as "<errorMessage>"

    Examples:
      | phoneNumber        | errorMessage                         |
      | 123                | Enter correct format                 |
      | abcdefghij         | Please enter a valid number.         |
      | 123456789012345678 | Enter correct format                 |
      | +1-800-555-5555    | Please enter a valid number.         |
      |                    | The phone number field is mandatory! |
  
 Scenario Outline: User enters invalid email
    Given the user is on website IP addresss
    When the user clicks the contact us link on the dashboard
    When the user Enters the name as "John Doe"
    When I enter "<email>" into the email field
    When I enter "9234567890" into the phone field
    When I enter "This is a test message." into the message field
    When clicks the valid Submit button
    Then the user should see the message as "<errorMessage>"

    Examples:
      | email                  | errorMessage                         |
      | john.doe@@example.com  | Please enter a valid email address.  |
      | invalid@invalid.comm   | Please enter a valid email address.  |
      | @invalid.com           | Please enter Valid Email!            |
      | invalid@invalid.co     | Please enter a valid email address.  |
      |                        | The Email field is mandatory!        |    
       
   
  Scenario Outline: User enters invalid message
    Given the user is on website IP addresss
    When the user clicks the contact us link on the dashboard
    When the user Enters the name as "John Doe"
    When I enter "john.doe@example.com" into the email field
    When I enter "9234567890" into the phone field
    When I enter "<message>" into the message field
    When clicks the valid Submit button
    Then the user should see the message as "<errorMessage>"

    Examples:
      | message              | errorMessage                           |
      | short                | Message must be at least 20 characters |
      |                      | The Message field is mandatory!        |
