@SFDC 
Feature: TC-SFDC lightening web application testing by fetching data from excel 

@test3C @Excel
Scenario: TC-03-SFDC Ligthening application opportunities creation using excel as data input 
	Given I have logged into "SFDC Lightening" application 
	And I navigate to "SFDCOpportunities" page 
	When I enter "SFDCOpportunities" creation details and click save
	Then I should be able to see the "SFDCOpportunities" created	
