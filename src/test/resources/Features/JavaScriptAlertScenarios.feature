Feature: Verify the different types of javascript alerts and verify the result of the actions performed on the alert.

@JSAlert @sanity
Scenario: Check that alert text and the result of the action is correct for js alert

Given I open alerts web app
And I click on js alert
Then I should see alert with message 'I am a JS Alert'
When I accept the alert
Then result should display 'You successfuly clicked an alert'




@JSConfirm @sanity
Scenario: Check that alert text and the result of the action is correct for js confirm

Given I open alerts web app
And I click on js confirm
Then I should see alert with message 'I am a JS Confirm'

When I accept the alert
Then result should display 'You clicked: Ok'

When I click on js confirm
And I dismiss the alert
Then result should display 'You clicked: Cancel'




@JSPrompt @sanity
Scenario: Check that alert text and the result of the action is correct for js prompt

Given I open alerts web app
And I click on js prompt
Then I should see alert with message 'I am a JS prompt'

When I dismiss the alert
Then result should display 'You entered: null'

When I click on js prompt
And I accept the alert
Then result should display 'You entered:'

When I click on js prompt
And I input 'test' in the alert prompt
And I accept the alert
Then result should display 'You entered: test'

When I click on js prompt
And I input 'test' in the alert prompt
And I dismiss the alert
Then result should display 'You entered: null'
