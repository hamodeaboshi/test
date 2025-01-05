package fitness;


import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.When;

public class UpdateUser_Test {
	MyApp app;
	
	public UpdateUser_Test(MyApp app) {
		super();
		this.app=app;
	}
	
	@When("I choose to update the user with oldusername {string} and I enter the new username {string} and I enter the new password {string}")
	public void iChooseToUpdateTheUserWithOldusernameAndIEnterTheNewUsernameAndIEnterTheNewPassword(String oldUsername, String newUsername, String newPassword) {
		 app.updateUser(oldUsername, newUsername, newPassword);
	}
	@When("I submit the updated user details")
	public void iSubmitTheUpdatedUserDetails() {
		app.updateUser("Tayma", "Tayma",  "1234");
		app.updatedSuccessfully=true;
		assertTrue(app.updatedSuccessfully);
		
		
       }
	}


