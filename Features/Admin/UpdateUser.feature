     @tag
     Feature: Update User
     Background: 
     Given i am loged in as an admin
    
   Scenario: Update user information
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I choose to update the user with oldusername "Tayma" and I enter the new username "Tayma" and I enter the new password "newpassword" 
    And I submit the updated user details
    Then I should see all users in the list
    And I should see a success message "User updated successfully."
    
    