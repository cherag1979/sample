Feature: Alternate scenarios

@AlternateScenario.S1 @sanity
Scenario: check that computer is not added successfully if input criteria is not met

Given I open Computer Database app
When I select to add a new computer
Then I should not be able to add computer with below details
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|					|	2017-01-01		|	2018-01-01			|	Sony		|
|	PowerMac		|	abc				|	2018-01-01			|	Sony		|
|	PowerMac		|	2017-01-01		|	xyz					|	Sony		|
|	PowerMac		|	2017-01-01		|	01-01-2018			|	Sony		|
|	PowerMac		|	01/01/2017		|	2018-01-01			|	Sony		|






@AlternateScenario.S1
Scenario: check that computer is not updated successfully if input criteria is not met

Given I open Computer Database app
When I select an existing computer from the list
Then I should not be able to update computer with below details
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|					|	2017-01-01		|	2018-01-01			|	Sony		|
|	PowerMac		|	abc				|	2018-01-01			|	Sony		|
|	PowerMac		|	2017-01-01		|	xyz					|	Sony		|
|	PowerMac		|	2017-01-01		|	01-01-2018			|	Sony		|
|	PowerMac		|	01/01/2017		|	2018-01-01			|	Sony		|






@AlternateScenario.S2
Scenario: check that computer is not updated if cancelled

Given I open Computer Database app
And I select to add a new computer
And I input the below computer details
|	Name		|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac	|	2017-01-01		|	2018-01-01			|	Sony		|
And I select to cancel
When I filter the computer list by name PowerMac
Then computer PowerMac should not be available in the list





@AlternateScenario.S3
Scenario: check that the total number of computers counter increments correctly

Given I open Computer Database app
And I capture the total number of computers in the database
When I add a new computer successfully
Then the total number of computers should increment by 1





@AlternateScenario.S4
Scenario: check that filtering of computers by name is correct and page navigation is correct

Given I open Computer Database app
And I add 10 computers with below details
|	Name		|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac	|	2017-01-01		|	2018-01-01			|	Sony		|
When I filter the computer list by name PowerMac
Then I should see 10 computers in the list
And I should not be able to navigate to previous page
And I should not be able to navigate to next page

When I add a new computer with below details
|	Name		|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac	|	2017-01-01		|	2018-01-01			|	Sony		|

Then I should not be able to navigate to previous page
And I should be able to navigate to next page

When I navigate to the next page
Then I should not be able to navigate to next page
And I should be able to navigate to previous page





@AlternateScenario.S5
Scenario: check that after adding or updating computer, the details are shown correctly in the list table

Given I open Computer Database app
And I add computer with below details
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	UltimateMac		|	2017-02-02		|	2018-02-02			|	IBM			|

Then I should see below details on the list page
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	UltimateMac		|	02 Feb 2017		|	02 Feb 2018			|	IBM			|





@AlternateScenario.S6
Scenario: check that user is able to navigate to the landing page from the computer details screen

Given I open Computer Database app
And I select to add a new computer
And I input the below computer details
|	Name		|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac	|	2017-01-01		|	2018-01-01			|	Sony		|

And I navigate to the computers list page
Then I should be on the computers list page




#Additional scenarios
Scenario: check that app does not allow adding / updating computers such that they are duplicate based on name and company
Scenario: Check while updating or creating computer, the introduced date cannot be in future
Scenario: Check while updating or creating computer, the discontinued date cannot be before introduced date
Scenario: check that user is able / not able to update computer without changing any details.
Scenario: check that computer list is able to be filtered using wild card characters / regular expressions
Scenario: check for UI rendering on IE, Chrome and Firefox browsers
Scenario: check for caching
