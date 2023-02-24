@bddperformance_single
Feature: BDD Performance with single http request sampler

@loopCount
Scenario: TC001-Checking API performance with ThreadUsers and LoopCount
	Given I have a "singleUser" rest api 
	And I generate the testplan with: 
		|ThreadUsers|loopCount|
		|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@Rampup
Scenario: TC002-Checking API performance with ThreadUsers,LoopCount and Rampup
	Given I have a "singleUser" rest api 
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|
		|3|1|4|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@Scheduler 
Scenario: TC003-Checking API performance for SchedulerDuration
	Given I have a "singleUser" rest api 
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|SchedulerDuration|SchedulerStartDelay|
		|1|1|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
		
@JMXFile 
Scenario: TC004-To run performance test for given JMX file 
	Given I have "TC001" jmx file 
	When I execute the jmx file with: 
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	Then I should see the performance report generated successfully 
