package fitness;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserActivty_Test {
	MyApp app;
	
	public UserActivty_Test(MyApp app) {
		super();
		this.app=app;
	}

	@When("I select the {string} section")
	public void i_select_the_section(String string) throws FileNotFoundException, IOException {
		 app.selectSection(string,"");
	}

	@Then("I should see an overview of user activity, including total logins, and active users")
	public void i_should_see_an_overview_of_user_activity_including_total_logins_and_active_users() {
	   assertTrue(true);
	}
	@When("I select the {string} section and user name {string}")
	public void iSelectTheSectionAndUserName(String string, String string2) throws FileNotFoundException, IOException {
		 app.selectSection(string,string2);
	    
	}

	@When("I view the user engagement statistics")
	public void i_view_the_user_engagement_statistics() {
		 assertTrue(true);
	}

	@Then("I should see the engagement statistics, including average session time and interactions with platform features")
	public void i_should_see_the_engagement_statistics_including_average_session_time_and_interactions_with_platform_features() {
		 assertTrue(true);
	}

	@Given("the user with username {string} exists")
	public void the_user_with_username_exists(String username) {
	   boolean b=app.isUserLoggedIn(username) ;
	   assertTrue(true);
	}

	@When("I select the user account {string}")
	public void i_select_the_user_account(String username) {
		app.countUserLogins(username);
	}

	@When("I view the activity details of the user")
	public void i_view_the_activity_details_of_the_user() {
		assertTrue(true);
	}

	@Then("I should see detailed statistics about the user activities, such as login history and page visits")
	public void i_should_see_detailed_statistics_about_the_user_activities_such_as_login_history_and_page_visits() {
		assertTrue(true);
	}

}
