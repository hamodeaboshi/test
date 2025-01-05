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
Feature: User Activity
  Background: 
     Given i am loged in as an admin


   
    Scenario: Admin views overall user activity statistics
    Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    When I select the "1" section
    Then I should see an overview of user activity, including total logins, and active users
    
    
      Scenario: Admin views user engagement statistics 
     Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    When I select the "2" section and user name "leen"
    And I view the user engagement statistics
    Then I should see the engagement statistics, including average session time and interactions with platform features

    
   
    Scenario: Admin views detailed activity of a specific user
    Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    And the user with username "leen" exists
    When I select the user account "leen"
    And I view the activity details of the user
    Then I should see detailed statistics about the user activities, such as login history and page visits

