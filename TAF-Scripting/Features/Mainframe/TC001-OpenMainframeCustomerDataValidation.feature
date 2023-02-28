@Mainframe 
Feature: TC001-Share Tech Mainframe System testing by adding, updating data 

@Mainframe-01
Scenario: TC-01-Validating mainframe Login functionality 
	Given I have Share Tech Mainframe System 
	And I navigate to "CICS" screen 
	When I login with username and password 
	Then I should successfully see the message "DFHCE3549 Sign-on is complete (Language ENU)." 
	
@Mainframe-02 
Scenario: TC-02-Creating new customer 
	Given I have login to Share Tech Mainframe System 
	And I navigate to "Menu" application 
	When I create new customer "655557" with below details: 
		| LastName | FirstName | Address  | State | ZipCode | 
		| lname    | fname     | add,test | kl    | 682030  |
	Then I should see "Customer record added." message 
	
@Mainframe-03 
Scenario: TC-03-Deleting Customer 
	Given I have login to Share Tech Mainframe System 
	And I navigate to "Menu" application 
	When I delete the customer "655557" details
	Then I should successfully see the message "Customer deleted." 
	
@Mainframe-04 
Scenario: TC-04-Validating an invalid customer Id 
	Given I have login to Share Tech Mainframe System 
	And I navigate to "Menu" application 
	When I fetch the details of customer "000000" 
	Then I should successfully see the message "That customer does not exist."
	
@Mainframe-05 
Scenario: TC-05-Running JCL jobs 
	Given I have Share Tech Mainframe System 
	And I navigate to "TSO" screen 
	And I navigate to batch JCL jobs screen
	When I submit the JCL job
	Then I should get "MAXCC=0" message
	