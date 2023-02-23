@Speed
Feature: ChatBot Speed Testing

  @Speed
  Scenario: Checking the speed of chatbot
    Given I have a health care chatbot
    When I validate the response time taking for scenarios in "PerfSenarioOne" file
    Then I should get the resopnse time matching with provided baseline

  @Speed
  Scenario: Checking the performence of chatbot
    Given I have a health care chatbot
    When I validate the response time taking for scenarios in "PerfSenarioTwo" file
    Then I should get the resopnse time matching with provided baseline

    
    