Feature: Second 

@scenario
Scenario: Second scenario 
	Given Ready to test 
	When I test 
	Then It should successfull
	
Scenario Outline:: Second scenario outline
	Given Ready to <test>
	When I test 
	Then It should successfull
	
Examples:
	|test	|
	|2		|