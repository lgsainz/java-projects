/**
 * Contact list class used to create new contact lists, add and remove contacts,
 * and find a contact.
 * This class uses Contact.java and BinarySearchTree.java
 * 
 * @author Leticia Garcia-Sainz
 * @version 14-10-2015
 */
import java.util.Scanner;

public class ContactList extends BinarySearchTree {

	public static void main(String[] args) {
		
		// Create new contact list, add a few contacts
		ContactList list = new ContactList();
		list.add(new Contact("Lucas", "Scott", "scott@gmail.com", "123"));
		list.add(new Contact("Peyton", "Sawyer", "sawyer@gmail.com", "321"));
		list.add(new Contact("Nathan", "Scott", "nate@gmail.com", "333"));
		
		
		String answer = "";
		do {
			// Program menu
			Scanner in = new Scanner(System.in);
			System.out.println("Menu: \nAdd a new contact (A) \nFind a contact (F) \nRemove a contact (R) \nExit (E)");
			answer = in.nextLine();
			
			// Add new contacts sub-menu
			while (answer.equalsIgnoreCase("A") && !answer.equalsIgnoreCase("Q")) {
				System.out.println("Enter the contact name: ");
				String firstName = in.next();
				String lastName = in.next();
			
				System.out.print("Enter the email address: ");
				String email = in.next();
			
				System.out.println("Enter the phone number: ");
				String number = in.next();
				
				// Add new contact to list
				Contact more = new Contact(firstName, lastName, email, number);
				list.add(more);
			
				System.out.println("Would you like to add another contact? (A) Press Q to exit: ");
				
				// No more contacts to add
				if (in.next().equalsIgnoreCase("Q")) {
					System.out.println("No more contacts to add at this time.");
					break;
				}
			}
			
			// Find a contact sub-menu
			if (answer.equalsIgnoreCase("F")) {
				System.out.println("Enter the contact's name: ");
				String search = in.nextLine();
				System.out.println("Contact info for " + search + ":");
				list.findDummyContact(search);	
			}
			
			// Remove a contact sub-menu
			else if (answer.equalsIgnoreCase("R")) {
				System.out.println("Enter contact's name: ");
				String toRemove = in.nextLine();
				list.remove(toRemove);
				System.out.println("Removal was successful.");
			}
			
			// Exit the program and say Goodbye
			if (answer.equalsIgnoreCase("E")) {
				System.out.println("Goodbye!");
				break;
			}
			
			// Print the contacts in the list
			System.out.println("The size of the list is: " + list.size());
			System.out.println("\nThe contacts that are currently on this list: ");
			list.print();
			System.out.println();
		}
		while (!answer.equalsIgnoreCase("E"));
		
		// Print the ordered list
		System.out.println("\nThe ordered list is: ");
		list.inOrder();
	}	
}
