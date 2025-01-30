Feature: Check with the contact us feature with valid one
@smoketestt
 Scenario Outline: User enters valid name
    Given the user is on the website IP address
    When the user click the contact us link on the mainpage
    When I Enters the name is "john doe"
    When I enter "john.doe@example.com" email field
    When I enter "9234567890" the phone field
    When I enter "This is a test message." into message field
    When clicks the valid Submit button to enter
    Then the user should see a success message for "Thank you for reaching out to us!"
    
