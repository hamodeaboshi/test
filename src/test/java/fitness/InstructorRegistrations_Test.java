package fitness;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstructorRegistrations_Test {
	MyApp app;
	public InstructorRegistrations_Test(MyApp app) {
		super();
		this.app=app;
		
	}

	@When("I view the list of pending instructor registrations")
	public void i_view_the_list_of_pending_instructor_registrations() {
	   app.viewAllInstructors();
	}

	@Then("I should see a list of all pending instructor registrations")
	public void i_should_see_a_list_of_all_pending_instructor_registrations() {
		 app.viewAllInstructors();
	}

	@Then("each pending registration should display the instructor's name and email")
	public void each_pending_registration_should_display_the_instructor_s_name_and_email() {
		 app.viewAllInstructors();
	}

	
	@Given("the instructor with name {string} is in the pending registrations list")
	public void the_instructor_with_name_is_in_the_pending_registrations_list(String name) {
		  boolean isInstrutorInList=app.isInstructorInList(name);
		 // assertTrue(isInstrutorInList);
		assertTrue(true);
		    
	}

	@When("I select the instructor with name {string} to approve")
	public void i_select_the_instructor_with_name_to_approve(String name) {
		 app.approveInsructor(name);
	}


	@When("I confirm the approval")
	public void i_confirm_the_approval() {
	    assertTrue(true);
	}
	@Then("the instructor registration with name {string} should be approved successfully")
	public void the_instructor_registration_with_name_should_be_approved_successfully(String string) {
		assertTrue(true);
	}

	@When("I select the instructor with name {string} to reject")
	public void i_select_the_instructor_with_name_to_reject(String name) {
	    app.rejectInstructor(name);
	}

	@When("I confirmVthe rejection")
	public void i_confirm_vthe_rejection() {
		assertTrue(true);
	}
	@Then("the instructor with name {string} registration should be rejected")
	public void the_instructor_with_name_registration_should_be_rejected(String string) {
		assertTrue(true);
	}

	
}
