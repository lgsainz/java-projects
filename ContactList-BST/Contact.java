/**
 * Contact class for getting and creating new contacts.
 * Used in ContactList class.
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-10-2015
 *
 */

public class Contact implements Comparable<Object> {

	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String number;
	
	/**
	 * Construct new Contact.
	 * @param first the first name
	 * @param last the last name
	 * @param mail the email address
	 * @param n the phone number
	 */
	public Contact(String first, String last, String mail, String n) {
		this.firstName = first;
		this.lastName = last;
		this.fullName = first + " " + last;
		this.email = mail;
		this.number = n;
	}
	
	/**
	 * Returns the persons first name.
	 * @return
	 */
	public String getName() {
		return fullName;
	}
	
	/**
	 * Returns the persons email address.
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Returns the persons phone number.
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Modified method to return in the correct format.
	 */
	public String toString() {
		return "\nName: " + this.fullName + ". Email: " + this.email + 
				". Number: " + this.number;
	}
	
	/**
	 * Override the compareTo method so that it works with the Contact class.
	 */
	public int compareTo(Object obj) {
		return getName().compareTo(((Contact) obj).getName());
	}
	
}
