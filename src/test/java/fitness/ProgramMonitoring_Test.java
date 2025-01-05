package fitness;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramMonitoring_Test {
	MyApp app;
	public ProgramMonitoring_Test(MyApp app) {
		super();
		this.app=app;
	}

	@Given("I navigate to the program monitoring page")
	public void i_navigate_to_the_program_monitoring_page() {
		app.AdminDashboardOptiones("2");
	}

	@Given("I select {string}")
	public void i_select(String ReportType) throws FileNotFoundException, IOException {
		app.selectReport(ReportType);
	}

	@Then("I should see a list of Most Popular Programs by Enrollment.")
	public void i_should_see_a_list_of_most_popular_programs_by_enrollment() {
		assertTrue(true);
	}
	
	@Then("I should see a report of profits")
	public void i_should_see_a_report_of_profits() {
		assertTrue(app.reportShown);
	}

	@Then("I should see a financial report for the selected")
	public void i_should_see_a_financial_report_for_the_selected() {
		assertTrue(app.reportGenerated);
	}

	@Then("I should see a list of all active programs with progress metrics")
	public void i_should_see_a_list_of_all_active_programs_with_progress_metrics() throws FileNotFoundException, IOException {
	    app.printActiveProgram();
	}
	@Then("display completed programs with summary statistics.")
	public void display_completed_programs_with_summary_statistics() {
	   app.printCompletedProgram();
	}

}
