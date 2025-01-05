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
Feature: Delete Program
  As an instructor
  I want to delete fitness programs
  So that I can manage my program offerings effectively
  
  Background:
    Given I am logged in as an instructor
  
     Scenario: I delete a fitness program
     Given I have an existing program
     And I am  on the program management page
     When I select delete "Delete" and choose the program with title  "30-Day Full Body Transformation" to delete
     Then i submit
     And the program should be deleted successfully
     And I should see a  message "program deleted successfully"
     
  
   	Scenario: 	I select a program that doesn't exist anymore
    Given: I have an existing program.
    And  I am  on the program management page
    And I select delete "Delete" and choose the program with title  "" to delete
   	Then i submit
    Then I should see a  message "this program dose not exist"
    
  