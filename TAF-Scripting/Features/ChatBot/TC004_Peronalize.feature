@Personalization
Feature: ChatBot Personalize testing

  @Personalization
  Scenario: Validating the chatbot Personalization
    Given I have a health care chatbot
    When I test the chatbot with questions in "PersonlizeScenaio" file
    Then I should see chatbot response with personalized sentences 
