@SFDC 
Feature: TC-SFDC lightening web application testing by fetching data from excel 

@test4C @Excel
Scenario: TC-04-SFDC Ligthening application 
	Given I have logged into "SFDC Lightening" application
	And I navigate to "SFDCContacts" page
	When I enter activites details and click save
	Then I should be able to see the activities listed