package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Update_test {
	 
	MyApp app;
	 
	public Update_test(MyApp app){
		super();
		this.app=app;
	}
	
	
	@Given("I have an existing program")
	public void i_have_an_existing_program() {
		app.CreateProgram("8-Week Fat Burn Bootcamp", "8 weeks (1 hour per session, 4 sessions per week)", "Advanced", "Accelerate fat loss through high-intensity interval training (HIIT)","path/to/video.mp4","path/to/image.jpg","path/to/document.pdf","$99","Online","Monday, Wednesday, Friday","6:00 PM - 7:00 PM");
	   assertTrue(app.programListNotEmpty());
		
	}

	@Given("I am  on the program management page")
	public void i_am_on_the_program_management_page() {
		app.navigateTo(" Program ManagementDashboard");
	}
 
	@When("I select update {string} and choose  the program with title {string} to edit and update title to {string} , duration {string}, difficulty level {string}, goals {string},\\(video tutorials {string}, images {string}, or documents  {string} ) , price {string} ,or the session \\( type {string} , days as {string} and the  time as {string} ).")
	public void i_select_update_and_choose_the_program_with_title_to_edit_and_update_title_to_duration_difficulty_level_goals_video_tutorials_images_or_documents_price_or_the_session_type_days_as_and_the_time_as(String action, String searchTitle, String UpdatedTitle, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price, String sessionType, String sessionDay, String sessionTime) throws IOException {
		if (action.equals("Edit")) {
			app.editProgram(searchTitle,UpdatedTitle, duration,  level,  goals,  videoPath, imagePath,  documentPath,  price, sessionType,sessionDay,sessionTime);
		    }
	}


	@Then("i submit")
	public void i_submit() {
		 assertTrue(true);
	}

	@Then("the program should be updated successfully")
	public void the_program_should_be_updated_successfully() {
		 assertTrue(app.programUpdationSuccess());
	}

	@Then("the program should not be updated")
	public void the_program_should_not_be_updated() {
		assertEquals("Program update failed as expected.", app.getMessage());
	}

	




	

	








}

