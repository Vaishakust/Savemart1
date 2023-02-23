@Accuracy
Feature: ChatBot accuracy testing

  @Accuracy
  Scenario: Validating the chatbot accuracy
    Given I have a health care chatbot
    When I test the chatbot for accuracy using questions in "AccScenarioOne" file
    Then I should get the response from chatbot

  @Accuracy
  Scenario: Validating the chatBot accuracy using phrases Generator
    Given I have a health care chatbot
    And I am generating multiple phrases of "How are you"
    When I test chatbot accuracy using the generated phrases
    Then I should get the responses from chatbot as below:
      | Answers                       |
      | Feeling wonderful!            |
      | I'm doing very well. Thanks!  |
      | Doing great, thanks.          |
      | Wonderful! Thanks for asking. |
