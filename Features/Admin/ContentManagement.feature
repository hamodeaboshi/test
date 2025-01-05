#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature:  Content Management
Background: 
Given i am loged in as an admin
 
Scenario: View all recipes
    Given I am on the admin dashboard
    And I select "3" from the dashboard options
    And I am on the content management page
    When I select View Recipe then I should see the all recipes in the list
    Then return back to the content management page

  Scenario: Delete a recipe
    Given I am on the admin dashboard
    And I select "3" from the dashboard options
    And I am on the content management page
    When  I select Delete  and enter recipe name "cookies"
    Then I should see a success message "Recipe deleted successfully."
    And I submit and should see the all recipes in the list after deleted
    And return back to the content management page


  Scenario: response to  users feedback
    Given I am on the admin dashboard
    And I select "3" from the dashboard options
    And I am on the content management page
    When I select Respond feedback and enter username "ahmad" and write response message "thank you bro"
    Then I should see a success message "response send  successfully."   
    And return back to the content management page

  Scenario: view user feedback
    Given I am on the admin dashboard
    And I select "3" from the dashboard options
    And I am on the content management page
    When I select View feedback
    Then I should see all feedbacks 
    And return back to the content management page
    
    
     Scenario: delete user feedback
    Given I am on the admin dashboard
    And I select "3" from the dashboard options
    And I am on the content management page
    When I select Delete feedback and enter username "ahmad"
    Then I should see a success message "feedback deleted successfully."
    And I should see all feedbacks 
    And return back to the content management page