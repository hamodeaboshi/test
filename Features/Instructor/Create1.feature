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
Feature: Create Program
  As an instructor
  I want to create fitness programs
  So that I can manage my program offerings effectively
  
   Background:
    Given I am logged in as an instructor
   

@tag1
   Scenario: Instructor creates a fitness program with all required details and media
    Given I am on the program management page
    When I  select "Create program" and enters the program title "30-Day Full Body Transformation", duration "30 days (45 minutes per day)", difficulty level "Intermediate",goals "Improve overall strength and endurance" ,(video tutorials "path/to/video.mp4", images "path/to/image.jpg", or documents  "path/to/document.pdf" ),the price "$99" (if applicable), and the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    Then i submit the details
    And the program should be created successfully
    And I should see a  message "Program created successfully"
    And the program should appear in the program list
    
@tag2
     Scenario: Instructor creates a fitness program without a price
     Given I am on the program management page
		When I select "Create program" and enters the program title "8-Week Fat Burn Bootcamp", duration "8 weeks (1 hour per session, 4 sessions per week)", difficulty level "Advanced", and goals "Accelerate fat loss through high-intensity interval training (HIIT)", and (video tutorials "path/to/video.mp4", images "path/to/image.jpg", or documents "path/to/document.pdf") , and the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
     Then i submit the details
     And the program should be created successfully
     And I should see a  message "Program created successfully"
     And the program should appear in the program list
     
  @tag3 
    Scenario: Instructor creates a fitness program without video, image, or document
    Given I am the program management page
    When I do not upload any media
    And I try to create this fitness program
    Then I should see a  message "At least one media file (video, image, or document) is required"
    And the program should not be created
    
   @tag4
   Scenario: Instructor creates a fitness program with a missing title
    Given I am on the program management page
    When I do not enter a program title
    And I try to create a fitness program
    Then I should see a  message "All required fields must be filled."
    And the program should not be created

    
 @tag5
    Scenario: Instructor creates a fitness program with a missing duration
    Given I am on the program management page
    When I do not enter a program duration
    And I try to create this fitness program
    Then I should see a  message "All required fields must be filled."
    And the program should not be created
 
 
 @tag6
   Scenario: Instructor creates a fitness program with a missing difficulty level
     Given I am on the program management page
    When I do not not select a difficulty level
      And I try to create this fitness program
    Then I should see a  message "All required fields must be filled."
    And the program should not be created
    
@tag7
   Scenario: Instructor creates a fitness program with missing goals
    Given I am on the program management page
    When I do not enter goals for the program
    And I try to create this fitness program
    Then I should see a  message "All required fields must be filled."
    And the program should not be created
    
@tag8
    Scenario: Instructor creates a fitness program with Invalid file type for media
    Given I am the program management page
    When I upload an invalid file type "invalid_file.exe"
    And I try to create this fitness program
    Then I should see a  message "Invalid file format"
    And the program should not be created

	 
@tag9
    Scenario: Instructor creates a fitness program with missing schedules
    Given I am the program management page
    When I do not enter schedules for the program
    And I try to create this fitness program
    Then I should see a  message "All required fields must be filled."
    And the program should not be created
    
    

  