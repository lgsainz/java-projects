import java.util.Scanner;
import java.util.HashSet;
/**
 * Program to add and remove web pages to a hash set.
 * Uses WebPage and HashSet classes.
 * @author Leticia Garcia-Sainz
 * @version 10-11-2015
 */

public class WebFavorites {
	
	public static void main(String[] args) {
		
		// Create a new Hash set, add a couple of new web pages to it
		HashSet webFaves = new HashSet(10);
		WebPage first = new WebPage("google.com", "search on google", "5");
		WebPage second = new WebPage("yahoo.com", "search on yahoo", "3");
		webFaves.add(first);
		webFaves.add(second);
		
		// Set up scanners to ask for user input 
		Scanner in = new Scanner(System.in);
		Scanner inUrl = new Scanner(System.in);
		Scanner inDesc = new Scanner(System.in);
		Scanner inRat = new Scanner(System.in);

		// ask if user wants to add more contacts
		System.out.println("Would you like to add a web page? Y/N: ");
		String answer = in.nextLine();
		while (answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
			
			// input for url 
			System.out.println("Enter the URL: ");
			String url = inUrl.nextLine();

			// input for page description
			System.out.println("Enter the description: ");
			String description = inDesc.nextLine();

			// input for page rating
			System.out.println("Enter the rating (1-5): ");
			String rating = inRat.nextLine();
			
			// add new webpage
			webFaves.add(new WebPage(url, description, rating));
			
			// check if user wishes to continue or exit
			System.out.println("Do you want to add another web page? Y/N: ");
			String continuation = in.next();
				if (continuation.equalsIgnoreCase("N")) {
					System.out.println("Goodbye.");
					break;
				}
		}
		
		// Print the web pages present in the HashSet
		System.out.println("\nCurrent webpages on file: ");
		for (Object w: webFaves) {
			System.out.println("Page: " + w.toString());
		}
		
		// Print the current size of the list
		System.out.println("The size of the set is: " + webFaves.size());
		
		
		String answer2 = "";
		do {
			Scanner modifySet = new Scanner(System.in);
			System.out.println("\nIf you want to retrieve a web page through a URL, enter U." +
				 "\nIf you want to remove a web page, enter R: " + "\nTo quit enter Q: ");
			answer2 = in.nextLine();
		
			// Return the corresponding web page for a URL
			if (answer2.equalsIgnoreCase("U")) {
				System.out.println("Enter the URL: ");
				Scanner find = new Scanner(System.in); 
				String user = find.nextLine();
				System.out.println("Here is the searched URL: ");
				webFaves.contains(new WebPage(user, null, null));
			}
		
			// Remove the web page according to URL
			else if (answer2.equalsIgnoreCase("R")) {
				System.out.println("Enter the URL of the page you wish to remove: ");
				Scanner rem = new Scanner(System.in);
				String user = rem.nextLine();
				webFaves.remove(new WebPage(user, null, null));
			}

		}
		while(!answer2.equalsIgnoreCase("Q"));
		
		// Print the final set after all modifications
		System.out.println("The set is now as follows: ");
		for (Object w: webFaves) {
			System.out.println("Page: " + w.toString());
		}
		
		// close scanners
		in.close();
		inUrl.close();
		inDesc.close();
		inRat.close();
	}
}
