@SFDC 
Feature: TC-SFDC lightening web application testing by fetching data from excel 

@test1 @Excel
Scenario: TC-01-SFDC Lightening application account creation using excel as data input 
	Given I have logged into "SFDC Lightening" application 
	And I navigate to "SFDCAccounts" page 
	When I enter "SFDCAccount" creation details and click save
	Then I should be able to see the "SFDCAccount" created