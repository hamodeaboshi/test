

package fitness;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String currentUsername;
	private MyApp app;
	private String userName;
	private String password;
	 private List<String> dashboardOptions;

	
	public Client() {
		super();
	
	}
	
	 public Client(String name, String password2) {
		 super();
			this.userName = name;
			this.password = password2;
	}
	public void setApp(MyApp app) {
	        this.app = app;
	        this.currentUsername = app.getCurrentUsername(); // Set current username from app
	    }

	public String getUsername() {
				return userName;
	}
	
	public void setUsername(String username) {
		this.userName = username;
	}
	

	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void ClientDashboard() {
        // Initialize the list of options available in the user dashboard
        dashboardOptions = new ArrayList<>();
        dashboardOptions.add("1. Post and share personal dessert creations");
        dashboardOptions.add("2. Browse and search for dessert recipes");
        dashboardOptions.add("3. Filter recipes based on dietary needs or food allergies");
        dashboardOptions.add("4. Purchase desserts directly from store owners");
        dashboardOptions.add("5. Directly communicate with store owners and suppliers");
        dashboardOptions.add("6. Provide feedback on purchased products and shared recipes");
        dashboardOptions.add("7. Manage personal account");
        dashboardOptions.add("8. Logout");
    }

	public void printDashboard() {
        System.out.println("Client Dashboard:");
        for (String option : dashboardOptions) {
            System.out.println(option);
        }
    }
}
