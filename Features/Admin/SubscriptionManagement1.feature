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
Feature: Subscription Management
Background: 
Given i am loged in as an admin

  Scenario: Identify programs for each subscription plans
   Given I am on the subscription management page
   And there are programs that have been created
   When I chose the program called "30-Day Full Body Transformation" and chose the subscription plan "Basic" 
   Then The program with name "30-Day Full Body Transformation" will appeare for "Basic" clients

  Scenario: View subscription plans 
   Given I am on the subscription management page
    And there are subscription plans 
    When I View subscription plans 
    Then I should be able to see a list of available subscription plans 

  
  Scenario: Upgrade a subscription plan for a instructor
    Given a instructor is currently subscribed to the "Basic" subscription plan
    When I upgrade the instructor to the "Premium" subscription plan
    Then the instructor should be upgraded to the "Premium" plan
    And the instructor should be notified of the new subscription plan "Premium"


  Scenario: Downgrade a subscription plan for a instructor
    Given an instructor is subscribed to the "Premium" subscription plan
    When I downgrade the instructor to the "Basic" subscription plan
    Then the instructor should be downgraded to the "Basic" plan
     And the instructor should be notified of the new subscription plan "Basic"



  
 