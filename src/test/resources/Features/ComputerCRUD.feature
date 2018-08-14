Feature: As a user, I should be able to add, update or delete a computer from database


@ComputerCRUD @sanity
Scenario: Check that new computer is able to be added, updated and deleted from the database successfully

Given I open Computer Database app
And I add computer with below details
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac		|	2017-01-01		|	2018-01-01			|	Sony		|

Then I should see computer added alert message

When I search and select computer PowerMac
Then I should see the computer details as below
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	PowerMac		|	2017-01-01		|	2018-01-01			|	Sony		|

When I search and select computer PowerMac
And I update computer with below details
|	Name			|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	UltimateMac		|	2017-02-02		|	2018-02-02			|	IBM			|
Then I should see computer updated alert message

When I search and select computer UltimateMac
Then I should see the computer details as below
|	Name		|	IntroducedDate	|	DiscontinuedDate	|	Company		|
|	UltimateMac	|	2017-02-02		|	2018-02-02			|	IBM			|

When I delete computer UltimateMac
Then I should see computer deleted alert message









