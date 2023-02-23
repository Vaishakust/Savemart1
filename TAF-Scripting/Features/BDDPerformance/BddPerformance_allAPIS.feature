@bddperformance_allAPI
Feature: BDD Performance with multiple api

@getApi
Scenario: TC005-Checking get user api performance with ThreadUsers,LoopCount and Rampup
	Given I have a "getUserDetail" rest api 
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@postApi
Scenario: TC006-Checking create user api performance with ThreadUsers,LoopCount and Rampup
	Given I have a "createUser" rest api 
	And I generate the testplan with:
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@putApi
Scenario: TC007-Checking update user api performance with ThreadUsers,LoopCount and Rampup
	Given I have a "updateUser" rest api 
	And I generate the testplan with:
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	

@deleteApi
Scenario: TC008-Checking delete user api performance with ThreadUsers,LoopCount and Rampup
	Given I have a "deleteUser" rest api 
	And I generate the testplan with:
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 

@post_responseAssertion
Scenario: TC009-Checking API performance with ThreadUsers,response assertion
	Given I have a "createUser" rest api 
	And request body in "jsonCsv" file
	And I generate the testplan with response assertion:
		|ThreadUsers|RampUp|loopCount|responseCode|AssertionFailureMessage|
		|3|1|1|200|Responsecode mismatch|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 