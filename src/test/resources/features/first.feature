@feature
Feature: First 

Scenario: First scenario 
	Given Ready to test 
	When I test 
	Then It should successfull

Scenario Outline:: First scenario outline
	Given Ready to <test>
	When I test 
	Then It should successfull
	
Examples:
	|test	|
	|1		|