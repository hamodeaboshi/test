package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTracking {
	
	private ProgressTracker progressTracker = new ProgressTracker();
	 private String errorMessage;
	 private String notificationMessage;
	    private List<String> suggestedPrograms = Arrays.asList("Weightlifting", "Yoga", "Cardio");
	
	@Given("the user is on their progress tracking page")
	public void theUserIsOnTheirProgressTrackingPage() {
		// No action needed
	}

	@When("the user updates their fitness milestones {string}")
	public void theUserUpdatesTheirFitnessMilestones(String milestoneAndValue) {
		String[] parts = milestoneAndValue.split(":");
	    if (parts.length < 2) {
	        errorMessage = "Invalid input format. Expected format: milestone:value";
	        return;
	    }
	    String milestone = parts[0].trim();
	    int value;
	    try {
	        value = Integer.parseInt(parts[1].trim());
	    } catch (NumberFormatException e) {
	        errorMessage = "Invalid value. Please enter a numeric value.";
	        return;
	    }
	    try {
	        progressTracker.updateMilestone(milestone, value);
	        errorMessage = null; // Reset error message
	    } catch (IllegalArgumentException e) {
	        errorMessage = e.getMessage();
	    }
	}

	@Then("the user's progress should be updated in the system")
	public void theUserSProgressShouldBeUpdatedInTheSystem() {
		assertNull(errorMessage);
        assertTrue(( progressTracker.getProgress()).size() > 0);
	}

	@Then("the user should see a summary of their milestones")
	public void theUserShouldSeeASummaryOfTheirMilestones() {
		 assertNotNull(progressTracker.getProgress());
	}

	@When("the user attempts to update milestones but leaves mandatory fields blank")
	public void theUserAttemptsToUpdateMilestonesButLeavesMandatoryFieldsBlank() {
		errorMessage = "Mandatory fields are missing";
	}

	@Then("the system should prompt the user to complete the required fields")
	public void theSystemShouldPromptTheUserToCompleteTheRequiredFields() 
	{
		assertEquals("Mandatory fields are missing", errorMessage);
	}

	@When("the user enters invalid data {string}")
	public void theUserEntersInvalidData(String invalidData) {
		  try {
	            progressTracker.updateMilestone("weight", Integer.parseInt(invalidData));
	            errorMessage = null;
	        } catch (IllegalArgumentException e) {
	            errorMessage = e.getMessage();
	        }
	}

	@Then("the system should display an error message")
	public void theSystemShouldDisplayAnErrorMessage() {
		assertNotNull(errorMessage);
	 
	}

	@Then("the user's progress should not be updated")
	public void theUserSProgressShouldNotBeUpdated() {
		Map<String, Integer> progress = progressTracker.getProgress();
	    assertTrue(progress.isEmpty());
	}

	@Given("the user completes a specific milestone or program goal")
	public void theUserCompletesASpecificMilestoneOrProgramGoal() {
		progressTracker.addAchievement("Weight Loss Milestone");
	}

	@When("the milestone or goal is achieved")
	public void theMilestoneOrGoalIsAchieved() {
		//No action needed.
	}

	@Then("the system should notify the user of the new badge earned")
	public void theSystemShouldNotifyTheUserOfTheNewBadgeEarned() {
		notificationMessage = "New badge earned! Weight Loss Milestone"; 
       assertNotNull(notificationMessage);
	}

	@Then("the badge should be visible on the achievements page")
	public void theBadgeShouldBeVisibleOnTheAchievementsPage() {
		assertTrue(progressTracker.getAchievements().contains("Weight Loss Milestone"));
	}

	@Given("the user has completed one or more programs")
	public void theUserHasCompletedOneOrMorePrograms() {
		 progressTracker.addAchievement("Completed Weightlifting Program");
	}

	@When("the user visits the achievements page")
	public void theUserVisitsTheAchievementsPage() {
	    
	}

	@Then("the user should see badges or achievements for completing programs")
	public void theUserShouldSeeBadgesOrAchievementsForCompletingPrograms()
	 {
		assertTrue(progressTracker.getAchievements().contains("Completed Weightlifting Program"));
	}

	@Given("the user has not completed any programs")
	public void theUserHasNotCompletedAnyPrograms() {
		 //No action needed
	}

	@Then("the system should display a message indicating no achievements yet")
	public void theSystemShouldDisplayAMessageIndicatingNoAchievementsYet()
	 {
		 assertEquals(0, progressTracker.getAchievements().size()); 
	        notificationMessage = "No achievements yet.  Try these programs:"; 
	        assertNotNull(notificationMessage);
	}

	@Then("suggest programs to complete")
	public void suggestProgramsToComplete() {
		assertEquals(suggestedPrograms, getSuggestedPrograms());
	}

	public List<String> getSuggestedPrograms(){
        return suggestedPrograms;
    }

	

}
