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
Feature: Progress Tracking
  As an instructor, I want to monitor client progress and send motivational reminders or recommendations, so I can support clients in achieving their goals.

  Background:
    Given I am logged in as an instructor

  Scenario: Monitoring Client Progress (Completion Rate,Attendance)
    Given I am on the  Progress Tracking page
    When I select a client "ahmad" 
    Then I should see a detailed progress report
    
    
  Scenario: Sending Motivational Reminders to Clients
   Given I am on the  Progress Tracking page
    And the client "Dana" has completed "40%" of their program
    When I select a client "Dana" to send a Motivational Reminders
    Then the system should send to "Dana" a motivational reminder "Dana, you can do it! Let's pick up the pace!"

  