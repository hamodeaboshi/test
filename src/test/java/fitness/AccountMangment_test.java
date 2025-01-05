package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class AccountMangment_test {

    private User user;
    private String confirmationMessage;
    private String errorMessage;
    private List<User> userList;

    @Given("the user is on the account creation page")
    public void theUserIsOnTheAccountCreationPage() {
    	// System.out.println("User navigates to account creation page");
        user = new User();
        userList = new ArrayList<User>();
    }

    @When("the user enters personal details including age and fitness goals")
    public void theUserEntersPersonalDetailsIncludingAgeAndFitnessGoals() {
    	 //System.out.println("User enters personal details");
    	    user.setAge(25);
    	    user.setFitnessGoals("Lose weight");
    	    user.setDietaryPreferences("Vegetarian");
    	    userList.add(user);
    }

    @When("the user submits the form")
    public void theUserSubmitsTheForm() {
    	   //System.out.println("User submits the account creation form");
        confirmationMessage = user.createAccount();
    }

    @Then("the user should see a confirmation message that the profile has been created succesfully")
    public void theUserShouldSeeAConfirmationMessageThatTheProfileHasBeenCreatedSuccesfully() {
    	 //System.out.println("Confirmation message displayed: " + confirmationMessage);
    	    assertEquals("Profile created successfully!", confirmationMessage);
    	    assertTrue(userList.contains(user));
       // assertTrue("Expected confirmation message", confirmationMessage.equals("Profile created successfully!"));
        //assertTrue("User list should contain the user", userList.contains(user));
    }
    @Then("the user's profile should reflect the entered details")
    public void theUserSProfileShouldReflectTheEnteredDetails() {
        assertEquals(25, user.getAge());
        assertEquals("Lose weight", user.getFitnessGoals());
    }
    
    @When("the user leaves one or more required fields \\(e.g., age, fitness goals) empty")
    public void theUserLeavesOneOrMoreRequiredFieldsEGAgeFitnessGoalsEmpty() {
        // Simulate the user leaving required fields empty (e.g., empty age or fitness goals)
        user.setAge(-1); // Invalid age
        user.setFitnessGoals(""); // Invalid fitness goals
    }

    @When("the user tries to submit the form")
    public void theUserTriesToSubmitTheForm() {
        // Attempt to submit the form with the incomplete data
        errorMessage = user.createAccount(); // Assuming createAccount returns an error message if fields are invalid
    }

    @Then("the user should see an error message indicating that the required fields are missing")
    public void theUserShouldSeeAnErrorMessageIndicatingThatTheRequiredFieldsAreMissing() {
        // Verify that the error message indicates missing required fields
        if (user.getAge() <= 0) {
            assertEquals("Invalid age.", errorMessage);
        } else if (user.getFitnessGoals() == null || user.getFitnessGoals().isEmpty()) {
            assertEquals("Invalid fitness goals.", errorMessage);
        } else {
            throw new AssertionError("Unexpected error message: " + errorMessage);
        }
    }

    @Then("the profile should not be created until the missing fields are completed")
    public void theProfileShouldNotBeCreatedUntilTheMissingFieldsAreCompleted() {
        // Check that the profile has not been created due to missing fields
        assertNull("User should not be created with invalid data", user.getId()); // Assuming user.getId() is null if not created
    }

    @When("the user enters invalid personal details including age or fitness goals")
    public void theUserEntersInvalidPersonalDetailsIncludingAgeOrFitnessGoals() {
    	 user.setAge(-1); // Invalid age
    	    user.setFitnessGoals(""); // Invalid fitness goals
    	    user.setDietaryPreferences("Vegetarian"); // Valid dietary preference
    }

    @When("the user tries to submits the form")
    public void theUserTriesToSubmitsTheForm() {
        errorMessage = user.createAccount();
    }

    @Then("the user should see an error message indicating the invalid data")
    public void theUserShouldSeeAnErrorMessageIndicatingTheInvalidData() {
    	//System.out.println("Debug: Error Message: " + errorMessage);
        //System.out.println("User age: " + user.getAge());
        //System.out.println("User fitness goals: " + user.getFitnessGoals());
       // System.out.println("User dietary preferences: " + user.getDietaryPreferences());

        if (user.getAge() <= 0) {
            assertEquals("Invalid age.", errorMessage);
        } else if (user.getFitnessGoals() == null || user.getFitnessGoals().isEmpty()) {
            assertEquals("Invalid fitness goals.", errorMessage);
        } else if (user.getDietaryPreferences() == null || user.getDietaryPreferences().isEmpty()) {
            assertEquals("Invalid dietary preferences.", errorMessage);
        } else {
            throw new AssertionError("Unexpected error message: " + errorMessage);
        }
    }
    
    @Then("the user should not be able to create the profile until all errors are resolved")
    public void theUserShouldNotBeAbleToCreateTheProfileUntilAllErrorsAreResolved() {
        assertNull("User's profile should not be created due to invalid data", user.getId());
        assertNotNull("Error message should exist", errorMessage); 
    }

    @Given("the user is on their profile settings page")
    public void theUserIsOnTheirProfileSettingsPage() {
        user = new User();
        //System.out.println("Step executed: User is on profile settings page");
    }

    @When("the user enters dietary preferences or restrictions")
    public void theUserEntersDietaryPreferencesOrRestrictions() {
        user.setDietaryPreferences("Vegetarian");
    }

    @When("the user saves the changes")
    public void theUserSavesTheChanges() {
        confirmationMessage = user.updateDietaryPreferences();
    }

    @Then("the dietary preferences should be updated in the user's profile")
    public void theDietaryPreferencesShouldBeUpdatedInTheUserSProfile() {
        assertEquals("Dietary preferences updated successfully!", confirmationMessage);
        assertEquals("Vegetarian", user.getDietaryPreferences());
    }
    @Then("the user should see a confirmation message about the successful update")
    public void theUserShouldSeeAConfirmationMessageAboutTheSuccessfulUpdate() {
        
    	assertEquals("Dietary preferences updated successfully!", confirmationMessage);
    }

    @When("the user enters invalid dietary preferences or restrictions")
    public void theUserEntersInvalidDietaryPreferencesOrRestrictions() {
    	user.setAge(25);
    	user.setFitnessGoals("Lose weight");
    	user.setDietaryPreferences(null);
    }

    @When("the user tries to save the changes")
    public void theUserTriesToSaveTheChanges() {
        errorMessage = user.updateDietaryPreferences();
    }

    @Then("the dietary preferences should not be updated in the user's profile")
    public void theDietaryPreferencesShouldNotBeUpdatedInTheUserSProfile() {
    	// System.out.println("Error Message: " + errorMessage);
    	    
    	    
    	    //assertEquals("Expected error message for invalid dietary preferences", "Invalid dietary preferences.", errorMessage);
    	    
    	    //assertNotEquals("Dietary preferences should not be updated", "Vegetarian", user.getDietaryPreferences());
    	
    	assertEquals("Invalid dietary preferences.", errorMessage);
        assertNotEquals("Vegetarian", user.getDietaryPreferences());
    }

    @Given("the user has successfully created a profile")
    public void theUserHasSuccessfullyCreatedAProfile() {
        user = new User();
        user.setAge(25);
        user.setFitnessGoals("Lose weight");
        user.setDietaryPreferences("Vegetarian");
        user.createAccount();  // Assume this creates the user account
    }
    
    @When("the user navigates to their profile page")
    public void theUserNavigatesToTheirProfilePage() {
       
    }
    
    @Then("the profile should display the correct personal details, including age, fitness goals, and dietary preferences")
    public void theProfileShouldDisplayTheCorrectDetails() {
        assertEquals(25, user.getAge());
        assertEquals("Lose weight", user.getFitnessGoals());
        assertEquals("Vegetarian", user.getDietaryPreferences());
    }

    @Given("the user is on the account deletion page")
    public void theUserIsOnTheirProfileSettingsPageForDeletion() {
        user = new User();
    }

    @When("the user chooses to delete their account")
    public void theUserChoosesToDeleteTheirAccount() {
        user.deleteAccount();
    }

    @When("the user confirms the action")
    public void theUserConfirmsTheAction() {
        confirmationMessage = user.confirmDeleteAccount();
    }

    @Then("the user's account should be deleted permanently")
    public void theUsersAccountShouldBeDeletedPermanently() {
        assertTrue(( user).isDeleted());
        assertEquals("Account deleted successfully.", confirmationMessage);
    }

    @Then("the user should be logged out and redirected to the account creation page")
    public void theUserShouldBeLoggedOutAndRedirected() {
        assertTrue(user.isLoggedOut());
    }
}

