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
Feature: Instructor Registration 
 Background: 
     Given i am loged in as an admin

    Scenario: Admin views pending instructor registrations
     Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    When I view the list of pending instructor registrations
    Then I should see a list of all pending instructor registrations
    And each pending registration should display the instructor's name and email
    

    Scenario: Admin approves a new instructor registration
     Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    And the instructor with name "tayma" is in the pending registrations list
    When I select the instructor with name "tayma" to approve
    And I confirm the approval
    Then the instructor registration with name "tayma" should be approved successfully
     And I should see a success message "The instructor approved successfully."

    
    
    Scenario: Admin rejects a new instructor registration
    Given I am on the admin dashboard
     And I select "1" from the dashboard options
     And I am on the user management page
    And the instructor with name "tayma" is in the pending registrations list
    When I select the instructor with name "tayma" to reject
    And I confirmVthe rejection
    Then the instructor with name "tayma" registration should be rejected
    And I should see a success message "The instructor rejected successfully."
