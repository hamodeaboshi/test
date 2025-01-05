
@tag
Feature: Account Managment
 @tag1
 Scenario: User creates a profile
    Given the user is on the account creation page
    When the user enters personal details including age and fitness goals
    And the user submits the form
    Then the user should see a confirmation message that the profile has been created succesfully
     And the user's profile should reflect the entered details 
  
  @tag2
    Scenario: User creates a profile with missing required fields
  Given the user is on the account creation page
  When the user leaves one or more required fields (e.g., age, fitness goals) empty
  And the user tries to submit the form
  Then the user should see an error message indicating that the required fields are missing
  And the profile should not be created until the missing fields are completed
    
  @tag3  
    Scenario: User enters invalid personal details
    Given the user is on the account creation page
    When the user enters invalid personal details including age or fitness goals
    And the user tries to submits the form
    Then the user should see an error message indicating the invalid data
     And the user should not be able to create the profile until all errors are resolved
    
@tag4
  Scenario: Update dietary preferences
    Given the user is on their profile settings page
    When the user enters dietary preferences or restrictions
    And the user saves the changes
    Then the dietary preferences should be updated in the user's profile
    And the user should see a confirmation message about the successful update
 
 @tag5   
   Scenario: Update dietary preferences with invalid data
    Given the user is on their profile settings page
    When the user enters invalid dietary preferences or restrictions
    And the user tries to save the changes
    Then the user should see an error message indicating the invalid data
    And the dietary preferences should not be updated in the user's profile
    
@tag6
Scenario: User views their profile after creation
  Given the user has successfully created a profile
  When the user navigates to their profile page
  Then the profile should display the correct personal details, including age, fitness goals, and dietary preferences
 
 @tag7
 Scenario: User deletes their account
 Given the user is on the account deletion page
  When the user chooses to delete their account
  And the user confirms the action
  Then the user's account should be deleted permanently
  And the user should be logged out and redirected to the account creation page
    
    