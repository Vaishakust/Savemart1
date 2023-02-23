@ErrorHandling
Feature: ChatBot ErrorHandling

  @ErrorHandling
  Scenario: Validating the Static Error Responces from ChatBot
    Given I have a health care chatbot
    When I test chatbot with invalid questions in "InvalidQuestionSetOne" file
    Then I should be able see the chatbot handles the error scenarios by giving below responses:
      | ErrorResponse                            |
      | Sorry, what was that?                    |
      | I missed what you said. Say it again?    |
      | Say that again?                          |
      | Can you say that again?                  |
      | I missed that.                           |
      | Sorry, could you say that again?         |
      | I didn't get that.                       |
      | Sorry, I didn't get that.                |
      | Sorry, could you say that again?         |
      | I missed what you said. Say it again?    |
      | I didn't get that. Can you say it again? |
      | What was that?                           |
      | One more time?                           |
      | Sorry, can you say that again?           |

  @ErrorHandling
  Scenario: Validating the Error Responces from ChatBot
    Given I have a health care chatbot
 		When I test chatbot with invalid questions in "InvalidQuestionSetTwo" file
    Then I should be able see the chatbot handles the error scenarios by giving below responses:
      | ErrorResponse                            |
      | Sorry, what was that?                    |
      | I missed what you said. Say it again?    |
      | Say that again?                          |
      | Can you say that again?                  |
      | I missed that.                           |
      | Sorry, could you say that again?         |
      | I didn't get that.                       |
      | Sorry, I didn't get that.                |
      | Sorry, could you say that again?         |
      | I missed what you said. Say it again?    |
      | I didn't get that. Can you say it again? |
      | What was that?                           |
      | One more time?                           |
      | Sorry, can you say that again?           |
