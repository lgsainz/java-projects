/**
 * This program tests the Pair class.
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */

public class PairTester {

	public static void main(String[] args) {
		
		// Create a pair of elements of the same type
		Pair<Integer> test = new Pair<Integer>(12, 10);
		// Print the original pair
		System.out.println("The original pair is: " + test.getFirst() + 
				", " + test.getSecond());
		
		// Call the swap method on the original pair
		test.swap();
		// Print the swapped pair
		System.out.println("The swapped pair is: " + test.getFirst() +
				", " + test.getSecond());
	}
}
