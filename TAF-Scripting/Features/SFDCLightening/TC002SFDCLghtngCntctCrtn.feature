@SFDC 
Feature: TC-SFDC lightening web application testing by fetching data from excel 
	
@test1CC @Excel
Scenario: TC-02-SFDC Lightening application contact creation using excel as data input 
	Given I have logged into "SFDC Lightening" application 
	And I navigate to "SFDCcontacts" page 
	When I enter "SFDCContact" creation details and click save
	Then I should be able to see the "SFDCContact" created