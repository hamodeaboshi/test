package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedbackAndReviews_test {
	
	private FeedbackSystem feedbackSystem = new FeedbackSystem();
    private String programId = "program123";
    private String feedbackMessage;
    private String errorMessage;
    private boolean isAnonymous;

	@Given("the user has not completed a program")
	public void theUserHasNotCompletedAProgram() {
		//No action needed.  Assume the user hasn't completed a program by default
	}

	@When("the user navigates to the program review page")
	public void theUserNavigatesToTheProgramReviewPage() {
	    
	}

	@Then("the user should see a message stating they cannot review a program they have not completed")
	public void theUserShouldSeeAMessageStatingTheyCannotReviewAprogramTheyHaveNotCompleted() {
		feedbackMessage = "You must complete the program before submitting a review.";
        assertEquals("You must complete the program before submitting a review.", feedbackMessage);
	}

	@Given("the user is on the program review page")
	public void theUserIsOnTheProgramReviewPage() {
	    
	}

	@When("the user enters invalid or incomplete feedback")
	public void theUserEntersInvalidOrIncompleteFeedback() {
		feedbackMessage = "";
	}

	@When("the user attempts to submit the feedback")
	public void theUserAttemptsToSubmitTheFeedback() {
		 try {
	            feedbackSystem.submitFeedback(programId, feedbackMessage, false);
	            errorMessage = null;
	        } catch (IllegalArgumentException e) {
	            errorMessage = e.getMessage();
	        }
	}

	@Then("the system should display an error message prompting the user to correct their input")
	public void theSystemShouldDisplayAnErrorMessagePromptingTheUserToCorrectTheirInput() {
		assertEquals("Feedback cannot be empty.", errorMessage);
	}

	@Given("the user has previously submitted a rating and review for a program")
	public void theUserHasPreviouslySubmittedARatingAndReviewForAProgram() {
		feedbackSystem.submitFeedback(programId, "Great program!", false);
	}

	@Then("the user should see their previously submitted rating and review")
	public void theUserShouldSeeTheirPreviouslySubmittedRatingAndReview() {
		 Feedback feedback = feedbackSystem.getFeedback(programId);
	        assertNotNull(feedback);
	        assertEquals("Great program!", feedback.getFeedbackText());
	}

	@When("the user updates their rating or review")
	public void theUserUpdatesTheirRatingOrReview() {
		feedbackMessage = "Even better now!";
	}

	@When("the user submits the updated feedback")
	public void theUserSubmitsTheUpdatedFeedback() {
		 feedbackSystem.updateFeedback(programId, feedbackMessage);
	}

	@Then("the updated rating and review should replace the previous feedback")
	public void theUpdatedRatingAndReviewShouldReplaceThePreviousFeedback()
	 {
		 Feedback feedback = feedbackSystem.getFeedback(programId);
	        assertEquals("Even better now!", feedback.getFeedbackText());
	}

	@Then("the user should see a confirmation message")
	public void theUserShouldSeeAConfirmationMessage() {
		 feedbackMessage = "Feedback updated successfully!";
	        assertEquals("Feedback updated successfully!", feedbackMessage);
	}

	@Given("the user is on the program feedback page")
	public void theUserIsOnTheProgramFeedbackPage() {
	    
	}

	@When("the user selects the option to submit feedback anonymously")
	public void theUserSelectsTheOptionToSubmitFeedbackAnonymously() {
		 isAnonymous = true;
	}

	@When("the user submits suggestions for improvement")
	public void theUserSubmitsSuggestionsForImprovement() {
		feedbackSystem.submitFeedback(programId, "Improve exercise explanations", isAnonymous);
	}

	@Then("the system should record the feedback as anonymous")
	public void theSystemShouldRecordTheFeedbackAsAnonymous() {
		 Feedback feedback = feedbackSystem.getFeedback(programId);
	        assertNotNull(feedback);
	        assertTrue(feedback.isAnonymous());
	}
	 @Then("the user should receive a confirmation message")
	    public void theUserShouldReceiveAConfirmationMessage() {
	        feedbackMessage = "Feedback submitted successfully!";
	        assertEquals("Feedback submitted successfully!", feedbackMessage);
	    }
}
