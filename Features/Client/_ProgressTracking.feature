
@tag
Feature:  Progress Tracking
  

  @tag1
 Scenario: User tracks personal fitness milestones
Given the user is on their progress tracking page
When the user updates their fitness milestones "wegiht:70"
Then the user's progress should be updated in the system
And the user should see a summary of their milestones

  
@tag3
Scenario: User attempts to update milestones with incomplete data
Given the user is on their progress tracking page
When the user attempts to update milestones but leaves mandatory fields blank
Then the system should prompt the user to complete the required fields


@tag4
Scenario: User fails to update milestones due to invalid input
Given the user is on their progress tracking page
When the user enters invalid data " negative weight"
Then the system should display an error message
And the user's progress should not be updated

@tag6
Scenario: User earns a new badge
Given the user completes a specific milestone or program goal
When the milestone or goal is achieved
Then the system should notify the user of the new badge earned
And the badge should be visible on the achievements page


@tag2
  Scenario: User views achievements or badges
Given the user has completed one or more programs
When the user visits the achievements page
Then the user should see badges or achievements for completing programs


@tag5
Scenario: User attempts to view achievements without completing a program
Given the user has not completed any programs
When the user visits the achievements page
Then the system should display a message indicating no achievements yet
And suggest programs to complete





  