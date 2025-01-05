package fitness;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationsAndUpdates_test {
	
	MyApp app;
	 
	public NotificationsAndUpdates_test(MyApp app){
		super();
		this.app=app;
	} 
	
	@Given("I am on the client  Notifications and Updates page")
	public void i_am_on_the_client_notifications_and_updates_page() {
		app.navigateTo("Notifications and Updates page");
		 assertTrue(app.isOnPage("Notifications and Updates page"));
	} 
	
	@Then("Clients participating in the program {string} should receive the notification")
	public void clients_participating_in_the_program_should_receive_the_notification(String string) {
	    app.sendNotificationToClients(string,"There has been an update to the program");
	    
	}

	@Then("clients should receive a notification about the new program with name {string}")
	public void clients_should_receive_a_notification_about_the_new_program_with_name(String string) {
	    app.sendNotificationToALLClients(string,"A new program has been added");

	}



	
}
