package fitness;

import static org.junit.Assert.*;

import org.junit.Test;

import io.cucumber.java.en.When;

public class DeactivateUser_Test {
	MyApp app;
	public DeactivateUser_Test(MyApp app ) {
		super();
		this.app=app;
	}
	
	@When("I choose to Deactivate the user with username {string}")
	public void iChooseToDeactivateTheUserWithUsername(String username) {
		 app.deleteUser(username);
	}

}
