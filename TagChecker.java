
/**
 * This class checks if the tags in an HTML document
 * are nested correctly.
 * Uses ArrayStack.java class
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TagChecker {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Ask user to input File name, as well as name of person 
		Scanner in = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = in.next();

		// Construct the Scanner object for reading
		File inputFile = new File(inputFileName);
		Scanner reader = new Scanner(inputFile);
		String pageContents = "";
		while (reader.hasNextLine()) {
			pageContents += " " + reader.nextLine();
		}
		// Close reader when done
		reader.close();
		
		// Create new array stack
		ArrayStack stack = new ArrayStack(100);
		
		// Split the document into substrings (for each tag)
		String[] split = pageContents.split("\\s+");

		for (String s: split) {
			// For each opening tag we encounter, push onto stack
			if (s.indexOf('/') != 1) {
				stack.push(s);
			}
			else {
				// If we encounter a closing tag, then pop and compare to opening tag
				String opening = stack.pop();
				String s2 = s.replace("/", "");
				
				if (s2.equals(opening)) {
					System.out.println("The tags: " + opening + " and " + s  + " are correctly nested.");
				}
				else {
					System.out.println("Error! The tags: " + opening + " and " + s  + " are not correctly nested.");
				}
			}
		}	
	}
}
