
@tag
Feature: Program Exploration and Enrollment

@tag1
Scenario: User views all available programs by default
  Given the user is on the program exploration page
  Then the user should see all available programs

  @tag2
   Scenario: User browses programs by difficulty level
    Given the user is on the program exploration page
    When  the user selects a difficulty level filter "Beginner"
    Then the programs should be filtered according to the selected difficulty level
  @tag3
   Scenario: User browses programs by focus area
    Given the user is on the program exploration page
    When the user selects a focus area filter "Muscle Building"
    Then the programs should be filtered according to the selected focus area
    
    @tag4
Scenario: User browses programs by combining filters
  Given the user is on the program exploration page1
  When the user selects a difficulty level filter "Intermediate"
  And the user selects a focus area filter "Flexibility"
  Then the programs should be filtered according to the selected difficulty level and focus area
    
  @tag5
  Scenario: User changes filters after applying
Given the user has applied a difficulty level filter
When the user changes the selected difficulty level
Then the programs should update according to the newly selected difficulty level
    
    @tag6
    Scenario: User encounters no programs matching filters
Given the user is on the program exploration page
When the user applies filters that do not match any program
Then a message should be displayed indicating "No programs found"

@tag7
Scenario: User clears all filters
    Given the user has applied filters 
    When the user clicks on the "Clear Filters" button
    Then the user should see all available programs without any filters applied
    @tag8
     Scenario: User enrolls in a fitness program
    Given the user is viewing a fitness program from the filtered list
    When the user clicks on the "Enroll Now" button
    And the user views the program schedule
    Then the user should be enrolled in the program
    And the user should receive a program enrollment confirmation message

@tag9
 Scenario: User views program details before enrollment
    Given the user is viewing the program list
    When the user clicks on a specific program
    Then the user should see detailed information about the program, including duration, goals, and schedule
    
    
    @tag10
Scenario: User encounters an error during program enrollment
  Given the user is viewing a fitness program from the filtered list
  When the user clicks on the "Enroll Now" button for a full program
  Then a message should be displayed indicating "Enrollment not available"
    

@tag11
Scenario: User confirms enrollment status
  Given the user is enrolled in a fitness program
  When the user navigates to their profile
  Then the profile should display the enrolled program with start date and schedule





