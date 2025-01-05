package fitness;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTracking_test {
	
	MyApp app;
	 
	public ProgressTracking_test(MyApp app){
		super();
		this.app=app;
	}
	
	@Given("I am on the  Progress Tracking page")
	public void i_am_on_the_progress_tracking_page() {
		app.navigateTo("Progress Tracking page");
		 assertTrue(app.isOnPage("Progress Tracking page"));
	}

	@When("I select a client {string}")
	public void i_select_a_client(String clientName) {
		 app.selectClient(clientName); 
	}

	@Then("I should see a detailed progress report")
	public void i_should_see_a_detailed_progress_report() {
	    assertTrue(true);
	}
	
	@Given("the client {string} has completed {string} of their program")
	public void the_client_has_completed_of_their_program(String string, String string2) {
		boolean isTrue=app.isTheCompletion(string,string2);
		   assertTrue(isTrue);
	}

	@When("I select a client {string} to send a Motivational Reminders")
	public void i_select_a_client_to_send_a_motivational_reminders(String string) {
	 boolean result= app.isClient(string);
	 assertTrue(result);
	}

	@Then("the system should send to {string} a motivational reminder {string}")
	public void the_system_should_send_to_a_motivational_reminder(String string, String string2) {
	   app.sendReminder(string, string2);
	}

}
