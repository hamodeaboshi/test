package fitness;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class maintest {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		
	     try (Scanner scanner = new Scanner(System.in)) {
	            MyApp app = new MyApp();
	            System.out.println("Welcome to the Alternative Sweet Management System!");

	            while (true) {
	                displayMainMenu();
	                String choice = scanner.nextLine();

	                switch (choice) {
	                    case "1":
	                        signUp(app, scanner);
	                        break;
	                    case "2":
	                        login(app, scanner);
	                        break;
	                    case "3":
	                        System.out.println("Exiting the system. Goodbye!");
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                        break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void displayMainMenu() {
	        System.out.println("Please choose an option:");
	        System.out.println("1. Sign Up");
	        System.out.println("2. Login");
	        System.out.println("3. Exit");
	    }

	    private static void signUp(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username:");
	        String username = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();
	        
	        System.out.println("Enter Role ( Instructor, Client):");
	        System.out.println("1. Instructor");
	        System.out.println("2. Client");
	        //System.out.println("3. Client");
	        String role = scanner.nextLine();
	        String roleyser=""; 
	        switch(role) {
	        case "1":
	        	roleyser="Instructor";
	        	break;
	        case "2":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	        app.SignUpUser(username, password, roleyser);
	    }

	    private static void login(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username:");
	        String username = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();
	        System.out.println("Enter Role (Admin, Instructor, Client):");
	        System.out.println("1. Admin");
	        System.out.println("2. Instructor");
	        System.out.println("3. Client");
	        String role = scanner.nextLine();
	        String roleyser=""; 
	        switch(role) {
	        case "1":
	        	roleyser="Admin";
	        	break;
	        case "2":
	        	roleyser="Instructor";
	        	break;
	        case "3":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	       
	        app.login(username, password, roleyser);

	        if (app.isUserLoggedIn) {
	            Client client = app.client; // Assuming `app.user` gives the current logged-in user
	            client.setApp(app); // Set the MyApp instance in the user for any necessary references

	            switch (roleyser) {
	                case "Admin":
	                    adminDashboard(app, scanner);
	                    break;
	                case "Instructor":
	                	instructorDashboard(app, scanner);
	                    break;
	                case "Client":
	                    clientDashboard(client,app, scanner);
	                    break;
	                default:
	                    
	                    break;
	            }
	        } else {
	            System.out.println("Login failed. Please check your credentials.");
	        }
	    }

	    private static void adminDashboard(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            app.AdminDashboardpage();
	            System.out.println("Enter your choice:");
	            String choice = scanner.nextLine();
	            switch (choice) {
	                case "1":
	                    app.AdminDashboardOptiones("1");
	                    userManagement(app, scanner);
	                    break;
	                case "2":
	                    app.AdminDashboardOptiones("2");
	                    handleReports(app, scanner);
	                    break;
	                case "3":
	                    app.AdminDashboardOptiones("3");
	                    contentManagement(app, scanner);
	                    break;
	                case "4":
	                	app.AdminDashboardOptiones("4");
	                	subscripationManagement(app, scanner);
	                	break;
	                
	                default:
	                    System.out.println("Returning to main menu.");
	                    return;
	            }
	        }
	    }
	    
	    private static void contentManagement(MyApp app, Scanner scanner) throws IOException {
	    	while(true) {
	          System.out.println("6. Back to Admin Dashboard");
	        String contentManagementOption = scanner.nextLine();
	        if (contentManagementOption.equalsIgnoreCase("1")) {
	        	app.contentmanagement.viewRecipes();
	        } else if (contentManagementOption.equalsIgnoreCase("2")) {
	        	 System.out.println("Enter program name ");
	        	 String programname = scanner.nextLine();
	        	app.contentmanagement.deleteRecipes(programname);
	        }else if (contentManagementOption.equalsIgnoreCase("3")) {
	           System.out.println("Enter client name ");
	       	   String clientname = scanner.nextLine();
	       	   System.out.println("response to  users feedback ");
	    	   String response = scanner.nextLine();
	        	app.contentmanagement.responseFeedback(clientname,response);
	        }else if(contentManagementOption.equalsIgnoreCase("4")) {
	    		app.contentmanagement.viewFeedback();

	        }else if (contentManagementOption.equalsIgnoreCase("5")) {
	        	System.out.println("Enter client name ");
	        	   String name = scanner.nextLine();
	        	app.contentmanagement.deleteFeedback( name);
	        }
	    	}
	    }

	    private static void subscripationManagement(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
	    	while(true) {
	    	System.out.println("1.  Identify programs for each subscription plans");
	        System.out.println("2.  View subscription plans ");
	        String subscripationOption = scanner.nextLine();
	        if (subscripationOption.equalsIgnoreCase("1")) {
	        	   System.out.println("Enter progrwm name ");
	        	   String prog = scanner.nextLine();
	        	   System.out.println("Enter subscription plan you want ");
	        	   System.out.println("1.  Basic");
	               System.out.println("2.  Premium");
	               String plan = scanner.nextLine();
	               String p="";

	               switch (plan) {
	                   case "1":
	                       p="Basic";
	                       break;
	                   case "2":
	                	   p="Premium";
	                       break;
	        	}
	               app.SubscriptionPlanPrograms(prog,p);
	        } else if (subscripationOption.equalsIgnoreCase("2")) {
	        	app.displayPlanPrograms("Basic");
	   		    app.displayPlanPrograms("Premium");
	        }
	    	}
		}

		private static void handleReports(MyApp app, Scanner scanner) throws IOException {
			while(true) {
	          System.out.println("5. Back to Admin Dashboard");
	        String reportOption = scanner.nextLine();
	        switch(reportOption) {
	        case "1":
	        	app.selectReport("1");
	        	break;
	        case "2":
	        	 app.selectReport("2");
	        	 break;
	        case "3":
	        	app.selectReport("3");
	        	break;
	        case "4":
	        	app.selectReport("4");
	        	break;
	        case "5":
	        	return;
	        }
	          
			}
	    }

	    private static void userManagement(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            displayUserManagementMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    app.viewAllUsers();
	                    break;
	                case "2":
	                    addUser(app, scanner);
	                    break;
	                case "3":
	                    deleteUser(app, scanner);
	                    break;
	                case "4":
	                    updateUser(app, scanner);
	                    break;
	                case "5":
	                	instructorRegistrations(app,scanner);
	                	break;
	                case "6":
	                	 userActivity(app,scanner);
	                	 break;
	                case "7":
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void userActivity(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
	    	System.out.println("1. views overall user activity statistics");
	        System.out.println("2. views user engagement statistics ");
	        System.out.println("3. views detailed activity of a specific user");
	        String userActivityoption = scanner.nextLine();
	        switch(userActivityoption) {
	        case "1":
	        	app.selectSection("1", "");
				break;
	        case "2":
	        	String user = scanner.nextLine();
				app.selectSection("2", user);
				break;
	        case "3":
	        	String spuser = scanner.nextLine();
				if (app.isUserLoggedIn(spuser)) {
					app.countUserLogins(spuser);
				}
				break;
	        default:
	       	 System.out.println("Invalid choice -_-");
	        	
	        }
			
		}

		private static void instructorRegistrations(MyApp app, Scanner scanner) {
			System.out.println("1. View instructor registrations");
			System.out.println("2. Approve a new instructor registration ");
			System.out.println("3. Reject a new instructor registration ");
			int instructorregistrations = scanner.nextInt();
			switch (instructorregistrations) {
			 case 1:
				app.viewAllInstructors();
				break;
			 case 2:
				System.out.print("Enter username for the Instructor you want to add: ");
				String Instructorusernameadmin = scanner.nextLine();
				if (app.isInstructorInList(Instructorusernameadmin)) {
					app.approveInsructor(Instructorusernameadmin);
				}
				break;
		 	case 3:
				System.out.print("Enter username for the Instructor you want to delete: ");
				String delInstructorusernameadmin = scanner.nextLine();
				if (app.isInstructorInList(delInstructorusernameadmin)) {
					app.rejectInstructor(delInstructorusernameadmin);
				}
				break;
			}
		}

		private static void displayUserManagementMenu() {
	        System.out.println("User Management Options:");
	        System.out.println("1. View All Users");
	        System.out.println("2. Add User");
	        System.out.println("3. Delete User");
	        System.out.println("4. Update User");
	        System.out.println("5. instructor registrations");
	        System.out.println("6. user activity and engagement statistics");
	        System.out.println("7. Back to Admin Dashboard");
	    }

	    private static void addUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String newPassword = scanner.nextLine();
	        System.out.println("Enter Role:");
	        System.out.println("1. Admin");
	        System.out.println("2. Instructor");
	        System.out.println("3. Client");
	        String newRole = scanner.nextLine();
	        String roleyser=""; 
	        switch(newRole) {
	        case "1":
	        	roleyser="Admin";
	        	break;
	        case "2":
	        	roleyser="Instructor";
	        	break;
	        case "3":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	       
	        app.addUser(newUsername, newPassword, roleyser);
	    }

	    private static void deleteUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username to delete:");
	        String deleteUsername = scanner.nextLine();
	        app.deleteUser(deleteUsername);
	    }

	    private static void updateUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter current Username:");
	        String oldUsername = scanner.nextLine();
	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter new Password:");
	        String newPassword = scanner.nextLine();
	        app.updateUser(oldUsername, newUsername, newPassword);
	    }

	    private static void instructorDashboard(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            displayInstructorMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    managePrograms(app, scanner);
	                    break;
	                case "2":
	                	clientInteraction(app,scanner);
	                    break;
	                case "3":
	                	progressTracking(app,scanner);
	                    break;
	                case "4":
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void progressTracking(MyApp app, Scanner scanner) {
	    	while (true) {
		    	displayProgressTrackingMenu();
		    	 String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                	 MonitorClientProgress(app, scanner);
		                    break;
		                case "2":
		                	Sendreminders(app, scanner);
		                    break;
		                case "3":
		                	return;
		                
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
			}
			
		}

		private static void Sendreminders(MyApp app, Scanner scanner) {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	    	System.out.println("Enter the reminder message:");
	        String message = scanner.nextLine();
			app.sendReminder(ClientName,message);
			
		}

		private static void MonitorClientProgress(MyApp app, Scanner scanner) {
			   System.out.println("Enter client's name:");
		        String ClientName = scanner.nextLine();
		        app.selectClient(ClientName);		      			
		}

		private static void displayProgressTrackingMenu() {
			System.out.println(" Progress Tracking :");
	        System.out.println("1. Monitor client progress ");
	        System.out.println("2. Send motivational reminders or recommendations.");
	        System.out.println("3. Back to Instructor Dashboard");
			
			
		}

		private static void clientInteraction(MyApp app, Scanner scanner) throws IOException {
	    	while (true) {
	    	displayClientInteractionMenu();
	    	 String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                	message(app, scanner);
	                    break;
	                case "2":
	                	feedback(app, scanner);
	                    break;
	                case "3":
	                	Respond(app, scanner);
	                    break;
	                case "4":
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
		}
	    }
		private static void Respond(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
			System.out.println("Client's query :");
			 String filePath= "files/messagesToInstructor.txt";  
		        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            if((line = br.readLine()) != null) {
		            while ((line = br.readLine()) != null) {
		    			System.out.println(line);
		            }
		            }
		            else {
		    			System.out.println("there is no query");

		            }
		            
		            }
		        System.out.println("Enter client's name:");
		        String ClientName = scanner.nextLine();
		        System.out.println("Enter the Respond to the query");
		        String message = scanner.nextLine();
		        app.respondToQuery(ClientName,message);
		        System.out.println(app.getMessage());
		        }

		

		private static void feedback(MyApp app, Scanner scanner) throws IOException {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	        System.out.println("Enter the feedback message");
	        String message = scanner.nextLine();
	        app.provideFeedbackOrUploadReport(ClientName,message);
	        System.out.println(app.getMessage());
			
		}

		private static void message(MyApp app, Scanner scanner) {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	        System.out.println("Enter the message");
	        String message = scanner.nextLine();
	        app.sendMessageToUser(ClientName, message);	
	        System.out.println(app.getMessage());

		}

		private static void displayClientInteractionMenu() {
			System.out.println("Client Interaction");
	        System.out.println("1. Send a message to a client ");
	        System.out.println("2. Send a feedback to a client");
	        System.out.println("3. Respond to a query");
	        System.out.println("4. Back to Instructor Dashboard");
			
		}

		private static void displayInstructorMenu() {
	        System.out.println("Instructor Dashboard:");
	        System.out.println("1. Program Management");
	        System.out.println("2. Client Interaction");
	        System.out.println("3. Progress Tracking");
	        System.out.println("4. Back to Main Menu");
	    }

	
	    private static void managePrograms(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            displayProgramManagementMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    addProgram(app, scanner);
	                    break;
	                case "2":
	                    editProgram(app, scanner);
	                    break;
	                case "3":
	                    deleteProgram(app, scanner);
	                    break;
	                case "4":
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void displayProgramManagementMenu() {
	        System.out.println("Program Management:");
	        System.out.println("1. Create program");
	        System.out.println("2. update program");
	        System.out.println("3. Delete program");
	        System.out.println("4. Back to Instructor Dashboard");
	    }

	    private static void addProgram(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Program title:");
	        String programTitle = scanner.nextLine();
	        System.out.println("Enter Program duration:");
	        String programDuration = scanner.nextLine();
	        System.out.println("Enter Program difficulty level:");
	        String programLevel = scanner.nextLine();
	        System.out.println("Enter Program goals:");
	        String programGoals = scanner.nextLine();
	        System.out.println("Enter Program Video path:");
	        String programVideo = scanner.nextLine();
	        System.out.println("Enter Program images path:");
	        String programImages = scanner.nextLine();
	        System.out.println("Enter Program documents path:");
	        String programDoc = scanner.nextLine();
	        System.out.println("Enter Program Price:");
	        String programPrice = scanner.nextLine();
	        System.out.println("Enter group sessions type :");
	        String sessionsType = scanner.nextLine();
	        System.out.println("Enter group sessions days :");
	        String sessionsDay = scanner.nextLine();
	        System.out.println("Enter group sessions times ::");
	        String sessionsTime = scanner.nextLine();
	        System.out.println("Do you want to send a notification to clients?");
	        System.out.println("1. yes");
	        System.out.println("2. no");
	        String choice = scanner.nextLine();
	        app.CreateProgram(programTitle, programDuration, programLevel,programGoals,programVideo,programImages,programDoc,programPrice,sessionsType,sessionsDay,sessionsTime);
	        System.out.println(app.getMessage());
	        switch (choice) {
	        case "1":
               app.sendNotificationToALLClients(programTitle,"A new program has been added");
                break;
            case "2":
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	    }

	    private static void editProgram(MyApp app, Scanner scanner) throws IOException {
	    	System.out.println("Enter Program title to edit:");
	        String programSearchTitle = scanner.nextLine();
	    	System.out.println("Enter the new title:");
	        String programTitle = scanner.nextLine();
	        System.out.println("Enter the new duration:");
	        String programDuration = scanner.nextLine();
	        System.out.println("Enter the new difficulty level:");
	        String programLevel = scanner.nextLine();
	        System.out.println("Enter the new goals:");
	        String programGoals = scanner.nextLine();
	        System.out.println("Enter the new Video path:");
	        String programVideo = scanner.nextLine();
	        System.out.println("Enter the new images path:");
	        String programImages = scanner.nextLine();
	        System.out.println("Enter the new documents path:");
	        String programDoc = scanner.nextLine();
	        System.out.println("Enter the new Price:");
	        String programPrice = scanner.nextLine();
	        System.out.println("Enter the new group sessions type :");
	        String sessionsType = scanner.nextLine();
	        System.out.println("Enter the new group sessions days :");
	        String sessionsDay = scanner.nextLine();
	        System.out.println("Enter the new group sessions times :");
	        String sessionsTime = scanner.nextLine();
	        System.out.println("Do you want to send a notification to clients?");
	        System.out.println("1. yes");
	        System.out.println("2. no");
	        String choice = scanner.nextLine();
	        app.editProgram(programSearchTitle,programTitle, programDuration, programLevel,programGoals,programVideo,programImages,programDoc,programPrice,sessionsType,sessionsDay,sessionsTime);
	        System.out.println(app.getMessage());
	        switch (choice) {
	        case "1":
               app.sendNotificationToClients(programTitle, "There has been an update to the program");
                break;
            case "2":
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	    }

	    private static void deleteProgram(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Program title to Delete:");
	        String productName = scanner.nextLine();
	        app.deleteProgram(productName);
	        System.out.println(app.getMessage());

	    }

	    

    

	  
	    private static void clientDashboard(Client user, MyApp app, Scanner scanner) {
	        user.ClientDashboard();
	        while (true) {
	            user.printDashboard(); // Assuming this prints the available options
	            System.out.println("Enter your choice:");
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    postAndShareDessert(user, scanner);
	                    break;
	                case "2":
	                    browseDessertRecipes(user, scanner);
	                    break;
	                case "3":
	                    filterRecipes(user, scanner);
	                    break;
	                case "4":
	                    purchaseProduct(user, scanner);
	                    break;
	                case "5":
	                    communicate(user, scanner);
	                    break;
	                case "6":
	                    sendFeedback(user, scanner);
	                    break;
	                case "7":
	                    try {
	                        manageAccount(user, app, scanner); // Pass MyApp instance
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                    break;
	                case "8":
	                    System.out.println("Logging out...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
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
 
	    private static void postAndShareDessert(User user, Scanner scanner) {
	        System.out.println("Enter the name of your dessert:");
	        String dessertName = scanner.nextLine();
	        System.out.println("Enter the ingredients and preparation details:");
	        String components = scanner.nextLine();
	        user.PostAndSharePersonalDessert(dessertName, components);
	    }

	    private static void browseDessertRecipes(User user, Scanner scanner) {
	        System.out.println("Enter the name of the recipe you want to search for:");
	        String recipeName = scanner.nextLine();
	        user.SearchDessertRecipes(recipeName);
	    }

	    private static void filterRecipes(User user, Scanner scanner) {
	        System.out.println("Enter the dietary needs or ingredients to filter recipes:");
	        String ingredient = scanner.nextLine();
	        user.filterRecipes(ingredient);
	    }

	    private static void purchaseProduct(User user, Scanner scanner) {
	        System.out.println("Enter Product Name to Purchase:");
	        String productName = scanner.nextLine();
	        System.out.println("Enter Quantity:");
	        int quantity = Integer.parseInt(scanner.nextLine());
	        user.purchaseProduct(productName, quantity);
	    }

	    private static void communicate(User user, Scanner scanner) {
	        System.out.println("Enter 'owner' or 'supplier' to communicate with:");
	        String userType = scanner.nextLine();
	        System.out.println("Enter your message:");
	        String message = scanner.nextLine();
	        user.chatWithOwner_Supplier(userType, message);
	    }

	    private static void sendFeedback(User user, Scanner scanner) {
	        System.out.println("Enter your feedback:");
	        String feedback = scanner.nextLine();
	        user.sendFeedback(feedback);
	    }

	    private static void manageAccount(User user, MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            displayAccountManagementMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    updateAccount(user, app, scanner);
	                    break;
	                case "2":
	                    deleteAccount(user, app, scanner);
	                    return; // Exit after deleting the account
	                case "3":
	                    System.out.println("Returning to User Dashboard...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void displayAccountManagementMenu() {
	        System.out.println("Manage Personal Account:");
	        System.out.println("1. Update Account Information");
	        System.out.println("2. Delete Account");
	        System.out.println("3. Back to User Dashboard");
	    }

	    private static void updateAccount(User user, MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter your current username:");
	        String currentUsername = scanner.nextLine();
	        
	        if (!currentUsername.equals(app.loggedName)) {
	            System.out.println("Incorrect username. Cannot update account.");
	            return;
	        }

	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter new Password:");
	        String newPassword = scanner.nextLine();

	        app.updateUser(currentUsername, newUsername, newPassword);

	        // Update the User object with new details
	        user.setUsername(newUsername);
	        user.setPassword(newPassword);

	        System.out.println("Account updated successfully.");
	    }

	    private static void deleteAccount(User user, MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Are you sure you want to delete your account? This action cannot be undone. (yes/no)");
	        String confirmation = scanner.nextLine();

	        if ("yes".equalsIgnoreCase(confirmation)) {
	            app.deleteUser(user.getUsername());
	            System.out.println("Account deleted successfully. Logging out...");
	            user.setUsername(null); // Clear the current user session
	            user.setPassword(null);
	        } else {
	            System.out.println("Account deletion canceled.");
	        }
	    }

	    private static void contentManagement(MyApp app, Scanner scanner) throws IOException {
	        // This would depend on how ContentManagement is handled
	        // Assuming it uses similar methods as before
	    }
	}
	 
		 
		 
	
