package fitness;

public class User {
	 private Object id; 
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    private boolean isDeleted;
    private boolean isLoggedOut;

    public User() {
        this.id = null;
    }
    
    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }
    
    public Object getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }


    // Method to create an account
    public String createAccount() {
        if (age <= 0) {
          //  System.out.println("Debug: Invalid age detected");
            return "Invalid age.";
        }
        if (fitnessGoals == null || fitnessGoals.isEmpty()) {
           // System.out.println("Debug: Invalid fitness goals detected");
            return "Invalid fitness goals.";
        }
        if (dietaryPreferences == null || dietaryPreferences.isEmpty()) {
            //System.out.println("Debug: Invalid dietary preferences detected");
            return "Invalid dietary preferences.";
        }
        this.id = generateId();
        return "Profile created successfully!";
    }

    private Object generateId() {
		// TODO Auto-generated method stub
    	return (int) (Math.random() * 10000);
	}

	// Method to update dietary preferences
    public String updateDietaryPreferences() {
        if (dietaryPreferences == null || dietaryPreferences.isEmpty()) {
            //System.out.println("Debug: Invalid dietary preferences detected");
            return "Invalid dietary preferences.";
        }
        return "Dietary preferences updated successfully!";
    }

	public void deleteAccount() {
		// TODO Auto-generated method stub
		 isDeleted = true;
		 logout();
		
	}

	public String confirmDeleteAccount() {
		// TODO Auto-generated method stub
		if (isDeleted) {
            return "Account deleted successfully.";  // Return success message
        } else {
            return "Account deletion failed.";  // In case account isn't deleted
        }
	}

	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return isDeleted;
	}
	
	 public void logout() {
	        isLoggedOut = true;
	    }

	public boolean isLoggedOut() {
		// TODO Auto-generated method stub
		 return isLoggedOut;
	}

	
}



