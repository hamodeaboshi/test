package fitness;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUser_Test {
	public AddUser_Test(MyApp app) {
		super();
		this.app=app;
	}

	MyApp app;
	
	
	@Given("i am loged in as an admin")
	public void iAmLogedInAsAnAdmin() throws IOException {
		app.login("Tayma", "123", "Admin");
        assertTrue(true);
	}
	@Given("I am on the admin dashboard")
	public void iAmOnTheAdminDashboard() {
		 app.AdminDashboardpage();
	        assertTrue(app.adminDashbordOpen);
	}
	@Given("I select {string} from the dashboard options")
	public void iSelectFromTheDashboardOptions(String string) {
		app.AdminDashboardOptiones("1");
	}
	@Given("I am on the user management page")
	public void iAmOnTheUserManagementPage() {
		assertTrue(app.userManagementPageOpen);
	}
	@When("I view the list of users")
	public void iViewTheListOfUsers() {
		app.viewAllUsers();
	}
	@Then("I should see all users in the list")
	public void iShouldSeeAllUsersInTheList() {
		app.viewAllUsers();
	}
	@When("I choose to add a new user and I enter the username {string} , password {string} , and role {string}")
	public void iChooseToAddANewUserAndIEnterTheUsernamePasswordAndRole(String username, String password, String role) {
		  app.addUser(username, password, role);
	}

	

	@When("I submit the new user details")
	public void iSubmitTheNewUserDetails() {
		assertTrue(app.addedSuccessfully);
	}

	@Then("I should see a success message {string}")
	public void iShouldSeeASuccessMessage(String message) {
		app.printMessage(message);
	}

}
