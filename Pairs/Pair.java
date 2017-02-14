/**
 * This class collects a pair of elements of the 
 * same type.
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */

public class Pair<T> {

	private T first;
	private T second;
	
	/**
	 * Constructs a pair containing two given elements.
	 * @param first the first element
	 * @param second the second element
	 */
	public Pair(T firstElement, T secondElement) {
		first = firstElement;
		second = secondElement;
	}
	
	/**
	 * Gets the first element of this pair.
	 * @return the first element
	 */
	public T getFirst() {
		return first;
	}
	
	/**
	 * Gets the second element of this pair.
	 * @return the second element
	 */
	public T getSecond() {
		return second;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	
	/**
	 * Swaps the first and second elements in the pair.
	 * @return the swapped pair
	 */
	public Pair<T> swap() {
		T temp = first;
		first = second;
		second = temp;
		
		return new Pair<T>(first, second);
	}
	
}
