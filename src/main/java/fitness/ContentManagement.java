package fitness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContentManagement {
	private static final String BASE_PATH = "files"; // Use relative path
    private static final String RECIPES_FILE_PATH = Paths.get(BASE_PATH, "recipes.txt").toString();
    private static final String FEEDBACK_FILE_PATH = Paths.get(BASE_PATH, "feedback.txt").toString();
    private static final String RESPONSE_FILE_PATH = Paths.get(BASE_PATH, "responseFeedback.txt").toString();

    private static final String RECIPE_DELETED_MESSAGE = "Recipe deleted successfully.";
    private static final String RESPONSE_SENT_MESSAGE = "Response sent successfully.";
    private static final String FEEDBACK_DELETED_MESSAGE = "Feedback deleted successfully.";

	public void viewRecipes() {
		printFileContent(RECIPES_FILE_PATH);
		
	}

	private void printFileContent(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            handleException(e, "Error reading file: " + filePath);
        }
		
	}

	private void handleException(IOException e, String message) {
		// Log the error and notify the user
        System.err.println(message);
      //  e.printStackTrace();
        JOptionPane.showMessageDialog(null, message);
	}

	public void deleteRecipes(String programname) {
		List<String> recipes = readFileLines(RECIPES_FILE_PATH);
        recipes.removeIf(line -> line.toLowerCase().startsWith(programname + ","));
        writeFile(RECIPES_FILE_PATH, recipes);
        printMessages(RECIPE_DELETED_MESSAGE);
		
	}

	private void printMessages(String message) {
		 JOptionPane.showMessageDialog(null, message);
		
	}

	private void writeFile(String filePath, List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            handleException(e, "Error writing to file: " + filePath);
        }
		
	}

	private List<String> readFileLines(String filePath) {
		 List<String> lines = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                lines.add(line);
	            }
	        } catch (IOException e) {
	            handleException(e, "Error reading file lines: " + filePath);
	        }
	        return lines;
	}

	public void responseFeedback(String string, String responseMessage) {
		String username = findUsername(string, FEEDBACK_FILE_PATH);
        if (username != null) {
            String response =  username + "," + responseMessage;
            appendToFile(RESPONSE_FILE_PATH, response);
            printMessages(RESPONSE_SENT_MESSAGE);
        } else {
            printMessages("Feedback for " + string + " not found.");
        }
		
	}

	private String findUsername(String string, String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                .filter(line -> line.startsWith(string + ","))
                .map(line -> line.split(",")[1])
                .findFirst()
                .orElse(null);
        } catch (IOException e) {
            handleException(e, "Error finding username: " + filePath);
        }
        return null;
	}

	private void appendToFile(String filePath, String content) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            handleException(e, "Error appending to file: " + filePath);
        }
		
	}

	public void viewFeedback() {
		printFileContent(FEEDBACK_FILE_PATH);
		
	}

	public void deleteFeedback(String string) {
		List<String> feedbacks = readFileLines(FEEDBACK_FILE_PATH);
        feedbacks.removeIf(line -> line.startsWith(string + ","));
        writeFile(FEEDBACK_FILE_PATH, feedbacks);
        printMessages(FEEDBACK_DELETED_MESSAGE);
		
	}

}
