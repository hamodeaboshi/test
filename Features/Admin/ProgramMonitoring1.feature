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
Feature: Program Monitoring
Background: 
 Given i am loged in as an admin


  
   Scenario: View Most Popular Programs by Enrollment
    Given I navigate to the program monitoring page
    When I select "1"
    Then I should see a list of Most Popular Programs by Enrollment.
    
    
     Scenario: View profit reports
    Given I navigate to the program monitoring page
     When I select "2"
    Then I should see a report of profits

  Scenario: Generate a financial report
    Given I navigate to the program monitoring page
     When I select "3"
    Then I should see a financial report for the selected 
    
    Scenario: Track Active and Completed Programs
    Given I navigate to the program monitoring page
    When I select "4"
    Then I should see a list of all active programs with progress metrics
    And display completed programs with summary statistics.   
    
    
  
  
    