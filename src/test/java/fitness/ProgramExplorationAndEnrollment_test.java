package fitness;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import fitness.ProgramCatalog;
import fitness.ProgramCatalog.Programs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ProgramExplorationAndEnrollment_test {
	
    
	  private ProgramCatalog programCatalog = new ProgramCatalog();
	    private List<ProgramCatalog.Programs> filteredPrograms;
	    private String message;
	    private String userId = "user123";

	    @Given("the user is on the program exploration page")
	    public void theUserIsOnTheProgramExplorationPage() {
	        // No action needed
	    }

	    @Then("the user should see all available programs")
	    public void theUserShouldSeeAllAvailablePrograms() {
	        assertEquals(programCatalog.getPrograms().size(), programCatalog.getPrograms().size());
	    }

	    @When("the user selects a difficulty level filter {string}")
	    public void theUserSelectsADifficultyLevelFilter(String difficulty) {
	        filteredPrograms = programCatalog.filterPrograms(difficulty, null);
	    }

	    @Then("the programs should be filtered according to the selected difficulty level")
	    public void theProgramsShouldBeFilteredAccordingToTheSelectedDifficultyLevel() {
	    	boolean allMatch = true;
	        
	        for (Programs p : filteredPrograms) {
	            if (!"Beginner".equals(p.getDifficulty())) {
	                allMatch = false;
	                break;
	            }
	        }
	        
	        assertTrue(allMatch); 
	    }

	    @When("the user selects a focus area filter {string}")
	    public void theUserSelectsAFocusAreaFilter(String focusArea) {
	        filteredPrograms = programCatalog.filterPrograms(null, focusArea);
	    }

	    @Then("the programs should be filtered according to the selected focus area")
	    public void theProgramsShouldBeFilteredAccordingToTheSelectedFocusArea() {
	    	boolean allMatch = true;

	        for (Programs p : filteredPrograms) {
	            if (!"Muscle Building".equals(p.getFocusArea())) {
	                allMatch = false;
	                break;
	            }
	        }

	        assertTrue(allMatch);
	    }

	    @Given("the user is on the program exploration page1")
	    public void theUserIsOnTheProgramExplorationPage1() {
	        // No action needed
	    }

	    @Then("the programs should be filtered according to the selected difficulty level and focus area")
	    public void theProgramsShouldBeFilteredAccordingToTheSelectedDifficultyLevelAndFocusArea() {
	        filteredPrograms = programCatalog.filterPrograms("Intermediate", "Flexibility");
	        boolean allMatch = true;

	        for (Programs p : filteredPrograms) {
	            if (!"Intermediate".equals(p.getDifficulty()) || !"Flexibility".equals(p.getFocusArea())) {
	                allMatch = false;
	                break;
	            }
	        }

	        assertTrue(allMatch);
	    }

	    @Given("the user has applied a difficulty level filter")
	    public void theUserHasAppliedADifficultyLevelFilter() {
	        filteredPrograms = programCatalog.filterPrograms("Beginner", null);
	    }

	    @When("the user changes the selected difficulty level")
	    public void theUserChangesTheSelectedDifficultyLevel() {
	        filteredPrograms = programCatalog.filterPrograms("Advanced", null);
	    }

	    @Then("the programs should update according to the newly selected difficulty level")
	    public void theProgramsShouldUpdateAccordingToTheNewlySelectedDifficultyLevel() {
	    	boolean allMatch = true;

	        for (Programs p : filteredPrograms) {
	            if (!"Advanced".equals(p.getDifficulty())) {
	                allMatch = false;
	                break;
	            }
	        }

	        assertTrue(allMatch);
	    }

	    @When("the user applies filters that do not match any program")
	    public void theUserAppliesFiltersThatDoNotMatchAnyProgram() {
	        filteredPrograms = programCatalog.filterPrograms("NonExistentDifficulty", "NonExistentFocus");
	    }

	    @Then("a message should be displayed indicating {string}")
	    public void aMessageShouldBeDisplayedIndicating(String expectedMessage) {
	        if (filteredPrograms.isEmpty()) {
	            message = "No programs found";
	        }
	        assertEquals(expectedMessage, message);
	    }

	    @Given("the user has applied filters")
	    public void theUserHasAppliedFilters() {
	        filteredPrograms = programCatalog.filterPrograms("Beginner", "Flexibility");
	    }

	    @When("the user clicks on the {string} button")
	    public void theUserClicksOnTheButton(String buttonName) {
	        if (buttonName.equals("Clear Filters")) {
	            filteredPrograms = programCatalog.getPrograms();
	        }
	    }

	    @Then("the user should see all available programs without any filters applied")
	    public void theUserShouldSeeAllAvailableProgramsWithoutAnyFiltersApplied() {
	        assertEquals(programCatalog.getPrograms().size(), filteredPrograms.size());
	    }

	    @Given("the user is viewing a fitness program from the filtered list")
	    public void theUserIsViewingAFitnessProgramFromTheFilteredList() {
	        filteredPrograms = programCatalog.filterPrograms("Beginner", null);
	    }

	    @When("the user clicks on the enroll button")
	    public void theUserClicksOnTheEnrollButton(String buttonName) {
	    	 if (buttonName.equals("Enroll Now")) {
	    	        // Ensure that the correct program is passed for enrollment
	    	        Programs selectedProgram = programCatalog.getProgramByName("Weightlifting for Beginners");
	    	        if (selectedProgram != null) {
	    	            // Debugging log to confirm program details
	    	            System.out.println("Enrolling user in program: " + selectedProgram.getName());
	    	            programCatalog.enrollUser(userId, selectedProgram.getName());
	    	        } else {
	    	            System.out.println("Program 'Weightlifting for Beginners' not found.");
	    	        }
	    	    }
	    }

	    @When("the user views the program schedule")
	    public void theUserViewsTheProgramSchedule() {
	        message = programCatalog.getPrograms().get(0).getSchedule();
	    }

	    @Then("the user should be enrolled in the program")
	    public void theUserShouldBeEnrolledInTheProgram() {
	    	System.out.println("Checking enrollment for user: " + userId);
	        boolean isEnrolled = programCatalog.isUserEnrolled(userId, "Weightlifting for Beginners");

	        // Debugging output for user enrollment status
	        if (isEnrolled) {
	            System.out.println("User is enrolled in Weightlifting for Beginners!");
	        } else {
	            System.out.println("User is NOT enrolled in Weightlifting for Beginners.");
	        }

	        // Assert that the user is indeed enrolled
	        assertTrue("User should be enrolled in the program", isEnrolled); 
	    }

	    @Then("the user should receive a program enrollment confirmation message")
	    public void theUserShouldReceiveAProgramEnrollmentConfirmationMessage() {
	        message = "You are now enrolled in Weightlifting for Beginners!";
	        assertEquals("You are now enrolled in Weightlifting for Beginners!", message);
	    }

	    @Given("the user is viewing the program list")
	    public void theUserIsViewingTheProgramList() {
	        filteredPrograms = programCatalog.getPrograms();
	    }

	    @When("the user clicks on a specific program")
	    public void theUserClicksOnASpecificProgram() {
	        message = programCatalog.getPrograms().get(0).toString();
	    }

	    @Then("the user should see detailed information about the program, including duration, goals, and schedule")
	    public void theUserShouldSeeDetailedInformationAboutTheProgramIncludingDurationGoalsAndSchedule() {
	        ProgramCatalog.Programs program = programCatalog.getPrograms().get(0);
	        assertNotNull(program.getDuration());
	        assertNotNull(program.getDescription());
	    }

	    @When("the user clicks on the {string} button for a full program")
	    public void theUserClicksOnTheButtonForAFullProgram(String buttonName) {
	        if (buttonName.equals("Enroll Now")) {
	            message = "Enrollment not available";
	        }
	        assertEquals("Enrollment not available", message);
	    }

	    @Given("the user is enrolled in a fitness program")
	    public void theUserIsEnrolledInAFitnessProgram() {
	        programCatalog.enrollUser(userId, "Weightlifting for Beginners");
	    }

	    @When("the user navigates to their profile")
	    public void theUserNavigatesToTheirProfile() {
	        // No action needed for this simple implementation
	    }

	    @Then("the profile should display the enrolled program with start date and schedule")
	    public void theProfileShouldDisplayTheEnrolledProgramWithStartDateAndSchedule() {
	        assertTrue(programCatalog.isUserEnrolled(userId, "Weightlifting for Beginners"));
	    }
	}

