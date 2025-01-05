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
Feature: User Management
Background: 
Given i am loged in as an admin

Scenario: View all user accounts
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I view the list of users
    Then I should see all users in the list

  #Add account (Instructor or Client)
  Scenario: Add a new user account
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I choose to add a new user and I enter the username "Tayma" , password "123" , and role "Admin"
    And I submit the new user details
    Then I should see all users in the list
    And I should see a success message "User added successfully."
