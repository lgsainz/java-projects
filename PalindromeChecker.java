/**
 * Checks whether a string is a palindrome, by implementing
 * the array stack class.
 * 
 * @author Leticia Garcia-Sainz
 * @version 10-7-2015
 */

public class PalindromeChecker {

	ArrayStack stack = new ArrayStack(100);
	private int currentSize = 0;
	
	/**
	 * Checks if a string is a palindrome, by implementing
	 * the array stack class.
	 * @param text the string to check
	 * @return true if the string is a palindrome
	 */
	public boolean isPalindrome(String text) {
		
		String reversed = "";
		
		// Make text lowercase, and get rid of any non-alphabet characters
		String lowercase = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
		int length = lowercase.length();
		
		if (length <= 1) {
			return true;
		}
		else {
			// Push each letter into the stack
			for (int i = 0; i < lowercase.length(); i++) {
				if (Character.isLetter(lowercase.charAt(i))) {
					stack.push(lowercase.charAt(i));
					currentSize++;
				}
			}
			// Pop the stack into the reversed string
			while(!stack.empty()) {
				reversed += stack.pop();
				currentSize--;
			}
		}
		return reversed.equals(lowercase);
	}
	
	// Test the palindrome checker program
	public static void main(String[] args) {
		PalindromeChecker test = new PalindromeChecker();
		if (test.isPalindrome("Madam I'm Adam.")) {
			System.out.println("This is a palindrome.");
		}
		else {
			System.out.println("Not a palindrome.");
		}
	}
}
