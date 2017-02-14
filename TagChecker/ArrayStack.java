/**
 * This class is an implementation of a stack as an array.
 * It is used to implement the TagChecker.java class.
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */
import java.util.Arrays;

public class ArrayStack {

	private String stack[];
	private int currentSize;
	
	/**
	 * Constructs a new stack.
	 * @param size the size of the stack
	 */
	public ArrayStack(int size) {
		stack = new String[size];
		currentSize = 0;
	}
	
	/**
	 * Returns the current size of the stack (how full it is).
	 * @return currentSize the size of the stack
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * Adds an element to the top(end) of the stack.
	 * @param str the element to be added
	 */
	public void push(String str) {
		if (currentSize == stack.length) {
			increaseStackSize();
		}
		
		stack[currentSize] = str;
		currentSize++;
	}
	
	/**
	 * Removes the element from the end(top) of stack. 
	 * @return the removed element
	 */
	public String pop() {
		if (empty()) {
			System.out.print("The stack is empty");
			return null;
		}
		else {
			currentSize--;
		}
		return stack[currentSize];
	}
	
	/**
	 * Increases the size of the stack by 1.
	 */
	public void increaseStackSize() {
		stack = Arrays.copyOf(stack, currentSize + 1);
	}
	
	/**
	 * Checks whether the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean empty() {
		return currentSize == 0;
	}
	
}
