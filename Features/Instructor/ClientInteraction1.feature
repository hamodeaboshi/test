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
Feature: Client Interaction

  Scenario: Communicate with enrolled clients via messaging or discussion forums
    Given I am logged in as an instructor
    And I am on the client interaction page
    When I select a client "ahmad" from the enrolled clients list and I write a message "hello"
    Then i submit
    And the client should receive the communication
    And the communication should be visible in the messaging or discussion history

  Scenario: Provide feedback or progress reports to clients
    Given I am logged in as an instructor
    And I am on the client interaction page
    When  I select a client "ahmad" from the enrolled clients and provide feedback or upload a progress report "feedback"
    Then i submit
    And the client "ahmad" should receive the feedback or progress report
   

  

  Scenario: Respond to client queries
    Given I am logged in as an instructor
    And I am on the client interaction page
    When a client "ahmad" sends a query
    And I respond to the query
    Then i submit
    And the client "ahmad" should receive my response
    
    