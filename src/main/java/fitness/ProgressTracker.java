package fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressTracker {
	
	private Map<String, Integer> userProgress = new HashMap<String, Integer>(); 
    private List<String> achievements = new ArrayList<String>();


	public void updateMilestone(String milestone, int value) {
		// TODO Auto-generated method stub
		if (value < 0) {
            throw new IllegalArgumentException("Invalid input: Weight cannot be negative.");
        }
        userProgress.put(milestone, value);
		
	}

	public Map<String, Integer> getProgress() {
        return userProgress;
    }

	public void addAchievement(String achievement) {
        achievements.add(achievement);
    }

	public boolean hasAchievements() {
        return !achievements.isEmpty();
    }

	 public List<String> getAchievements() {
	        return achievements;
	    }

}
