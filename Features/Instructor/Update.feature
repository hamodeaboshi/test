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

Feature: Update Program
  As an instructor
  I want to  update fitness programs
  So that I can manage my program offerings effectively
  
   Background:
    Given I am logged in as an instructor
   

   Scenario: I update a fitness program
     Given I have an existing program
     And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
     Then i submit
     And the program should be updated successfully
     And I should see a  message "Program updated successfully"
   
   Scenario: I update a program with missing title
   Given I have an existing program
   And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to "" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
   Then i submit
   And I should see a  message "Program update failed as expected."
   And the program should not be updated  

   Scenario: I update a program with missing duration
   Given I have an existing program
   And I am  on the program management page
   When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
   Then i submit
   And I should see a  message "Program update failed as expected."
   And the program should not be updated  
   
   
    Scenario: I update a program with missing goals
    Given I have an existing program
    And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    Then i submit
    And I should see a  message "Program update failed as expected."
    And the program should not be updated
    
   
     Scenario: I update a program with missing media
     Given I have an existing program
     And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "", images "", or documents  "" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
     Then i submit
     And I should see a  message "Program update failed as expected."
     And the program should not be updated
     
     
      Scenario:  I update a program with invalid media file format
      Given I have an existing program
      And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "invalid_file.exe", images "invalid_file.exe", or documents  "invalid_file.exe" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
  		Then i submit
 		 And I should see a  message "Program update failed as expected."
 		  And the program should not be updated
 		  
 		
 		Scenario:  I update a program with missing price (optional)
    Given I have an existing program
    And I am  on the program management page
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    Then i submit
    And the program should be updated successfully
    And I should see a  message "Program updated successfully" 
    
  	  Scenario:  I update a program with a missing difficulty level
  	  Given I have an existing program
  	 	And I am  on the program management page 
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    	Then i submit
    	And I should see a  message "Program update failed as expected."
    	And the program should not be updated
  	
  	  Scenario:  I update a program with an invalid price format
  	  Given I have an existing program
  	 	And I am  on the program management page 
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$-49" ,or the session ( type "Online" , days as "Monday, Wednesday, Friday" and the  time as "6:00 PM - 7:00 PM" ).    
    	Then i submit
    	And I should see a  message "Program update failed as expected."
    	And the program should not be updated 
    	
    	 Scenario:  I update a program with  a missing schedules
  	  Given I have an existing program
  	 	And I am  on the program management page 
     When I select update "Edit" and choose  the program with title "8-Week Fat Burn Bootcamp" to edit and update title to " 8-Week Fat Burn Bootcamp" , duration "4 weeks (30 minutes per session, 5 sessions per week)", difficulty level "Beginner to Intermediate", goals "Build lean muscle, improve flexibility, and boost energy levels",(video tutorials "path/to/newvideo.mp4", images "path/to/newimage.jpg", or documents  "path/to/newdocument.pdf" ) , price "$49" ,or the session ( type "" , days as "" and the  time as "" ).    
    	Then i submit
    	And I should see a  message "Program update failed as expected."
    	And the program should not be updated 