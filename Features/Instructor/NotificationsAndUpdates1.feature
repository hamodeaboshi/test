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
Feature: Notifications and Updates
  As an instructor, I want to notify clients about changes to program schedules and announce new programs or special offers, so they stay informed and engaged.

  Background:
   Given I am logged in as an instructor

 Scenario: Notify clients about changes to the program 
   Given I am on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    Then i submit
    And Clients participating in the program "8-Week Fat Burn Bootcamp" should receive the notification
   
  

  Scenario: Announce new programs
    Given I am on the program management page
    When I  select "Create program" and enters the program title "30-Day Full Body Transformation", duration "30 days (45 minutes per day)", difficulty level "Intermediate",goals "Improve overall strength and endurance" ,(video tutorials "path/to/video.mp4", images "path/to/image.jpg", or documents  "path/to/document.pdf" ),the price "$99" (if applicable), and the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    Then i submit
    And clients should receive a notification about the new program with name "Ultimate 30-Day Strength & Endurance Challenge"
    
    