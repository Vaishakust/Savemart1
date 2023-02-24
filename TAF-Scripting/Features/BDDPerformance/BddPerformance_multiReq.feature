@bddperformance_mul
Feature: BDD Performance with multiple http request sampler

	
@multiHttpSampler
Scenario: TC008-Checking Multiple API performance with ThreadUsers,Ramp up and LoopCount
	Given I have multiple rest api:
	|listUsers|singleUser|singleResource|
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|
		|1|5|3|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 


@multiHttpSampler_noskript
Scenario: TC009-Checking noskript API performance with ThreadUsers,Ramp up and LoopCount
	Given I have multiple rest api:
	|loginApi|browserDetailsApi|testObjectAPI|testStepAPI|testComponentAPI|testCaseAPI|testSetAPI|
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@multiHttpSampler_noskript_failed
Scenario: TC009-Checking noskript API performance with ThreadUsers,Ramp up and LoopCount
	Given I have multiple rest api:
	|browserDetailsApi|loginApi|testObjectAPI|testStepAPI|testComponentAPI|testCaseAPI|testSetAPI|
	And I generate the testplan with: 
		|ThreadUsers|RampUp|loopCount|
		|1|1|1|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 


@multiHttpSampler_constantTimer
Scenario: TC010-Checking Multiple API performance with ConstantTimer
	Given I have multiple rest api:
	|singleUser|listUsers|singleResource|
	And I generate the testplan with constant timer: 
		|ThreadUsers|RampUp|loopCount|constantTimer_delay_ms|
		|1|1|1|5000|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 
	
@multiHttpSampler_constantThroughputTimer
Scenario: TC0011-Checking Multiple API performance with Constant Throughput  Timer
	Given I have multiple rest api:
	|singleUser|listUsers|singleResource|
	And I generate the testplan with constant throughput timer: 
		|ThreadUsers|RampUp|loopCount|constantThroughputTimer|
		|1|1|1|10|
	When I execute the performance test plan 
	Then I should see the performance report generated successfully 