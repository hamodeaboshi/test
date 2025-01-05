package fitness;

import java.util.HashMap;
import java.util.Map;

public class FeedbackSystem {
	 private Map<String, Feedback> programFeedback = new HashMap<String, Feedback>();

	    // Submit Feedback
	    public void submitFeedback(String programId, String feedback, boolean isAnonymous) {
	        if (feedback == null || feedback.trim().isEmpty()) {
	            throw new IllegalArgumentException("Feedback cannot be empty.");
	        }
	        programFeedback.put(programId, new Feedback(feedback, isAnonymous));
	    }

	    // Retrieve Feedback
	    public Feedback getFeedback(String programId) {
	        return programFeedback.get(programId);
	    }

	    // Update Feedback
	    public void updateFeedback(String programId, String updatedFeedback) {
	        if (updatedFeedback == null || updatedFeedback.trim().isEmpty()) {
	            throw new IllegalArgumentException("Feedback cannot be empty.");
	        }
	        Feedback existingFeedback = programFeedback.get(programId);
	        if (existingFeedback != null) {
	            programFeedback.put(programId, new Feedback(updatedFeedback, existingFeedback.isAnonymous()));
	        } else {
	            throw new IllegalArgumentException("Feedback for the program does not exist.");
	        }
	    }
	
	
}
	
class Feedback {
    private String feedbackText;
    private boolean isAnonymous;

    public Feedback(String feedbackText, boolean isAnonymous) {
        this.feedbackText = feedbackText;
        this.isAnonymous = isAnonymous;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }
}