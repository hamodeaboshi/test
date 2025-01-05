package fitness;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientInteraction_test {
 
	MyApp app;
	 
	public ClientInteraction_test(MyApp app){
		super();
		this.app=app;
	} 
@Given("I am on the client interaction page")
public void i_am_on_the_client_interaction_page() {
	app.navigateTo(" client interaction page");
	 assertTrue(app.isOnPage(" client interaction page"));
}

@When("I select a client {string} from the enrolled clients list and I write a message {string}")
public void i_select_a_client_from_the_enrolled_clients_list_and_i_write_a_message(String username, String message) {
	  app.sendMessageToUser(username,message);
}

@Then("the client should receive the communication")
public void the_client_should_receive_the_communication() {
	 assertTrue(app.isMessageReceived());
}

@Then("the communication should be visible in the messaging or discussion history")
public void the_communication_should_be_visible_in_the_messaging_or_discussion_history() {
	   assertTrue(app.isMessageInHistory());
}

@When("I select a client {string} from the enrolled clients and provide feedback or upload a progress report {string}")
public void i_select_a_client_from_the_enrolled_clients_and_provide_feedback_or_upload_a_progress_report(String username, String feedbackOrReport) throws IOException {
	app.provideFeedbackOrUploadReport(username, feedbackOrReport);
}

@Then("the client {string} should receive the feedback or progress report")
public void the_client_should_receive_the_feedback_or_progress_report(String username) {
	assertTrue(app.isFeedbackOrReportVisibleInProfile(username));
}




@When("a client {string} sends a query")
public void a_client_sends_a_query(String username) {
	 app.sendClientQuery(username, "This is a test query from the client.");
}

@Then("the client {string} should receive my response")
public void the_client_should_receive_my_response(String username) {
	 assertTrue(app.isResponseReceived(username));
}






@When("I respond to the query")
public void i_respond_to_the_query() throws IOException {
	app.respondToQuery("ahmad","This is the response to the client's query.");
			
}


}
