
@tag
Feature: Feedback and Reviews
 
  @tag1
  Scenario: User tries to rate or review a program they have not completed
    Given the user has not completed a program
    When the user navigates to the program review page
    Then the user should see a message stating they cannot review a program they have not completed


  @tag2
  Scenario: User submits invalid or incomplete feedback
    Given the user is on the program review page
    When the user enters invalid or incomplete feedback
    And the user attempts to submit the feedback
    Then the system should display an error message prompting the user to correct their input

@tag3
Scenario: User views their previously submitted feedback
    Given the user has previously submitted a rating and review for a program
    When the user navigates to the program review page
    Then the user should see their previously submitted rating and review

@tag4
Scenario: User edits or updates their submitted feedback
    Given the user has previously submitted a rating and review for a program
    When the user navigates to the program review page
    And the user updates their rating or review
    And the user submits the updated feedback
    Then the updated rating and review should replace the previous feedback
    And the user should see a confirmation message

@tag5
Scenario: User submits anonymous feedback
    Given the user is on the program feedback page
    When the user selects the option to submit feedback anonymously
    And the user submits suggestions for improvement
    Then the system should record the feedback as anonymous
    And the user should receive a confirmation message




  
