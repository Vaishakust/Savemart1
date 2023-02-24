@test
Feature: TC-Sample desktop application testing

@test1
Scenario: TC-Sample desktop application testing
	Given I have "Sample" application
	And I enter the personal details
	And I click on submit1 button
	And I select the details on provided questions
	When I click on submit2 button
	Then I should be able to see thank you message
