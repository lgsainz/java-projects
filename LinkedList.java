/**
 * Implements a generic version of the LinkedList class from Ch.16.
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */
import java.util.NoSuchElementException;

public class LinkedList<T> {
		
	    private Node<T> first;
	    
	    /**
	     * Constructs an empty linked list.
	     */
	    public LinkedList() {
	    	first = null;
	    }
	    
	    /**
	     * Returns the first element in the linked list.
	     * @return the first element in the linked list
	     */
	    public T getFirst() {
	    	if (first == null) {
	    		throw new NoSuchElementException();
	    	}
	    	return first.data;
	    }
	    
	    /**
	     * Removes the first element in the linked list.
	     * @return the removed element
	     */
	    public T removeFirst() {
	    	if (first == null) {
	    		throw new NoSuchElementException();
	    	}
	    	T element = first.data;
	    	first = first.next;
	    	return element;
	    }
	    
	    /**
	     * Adds an element to the front of the linked list.
	     * @param element the element to add
	     */
	    public void addFirst(T element) {
	    	Node<T> newNode = new Node<T>();
	    	newNode.data = element;
	    	newNode.next = first;
	    	first = newNode;
	    }
	    
	    /**
	     * A linked list node, holding the data and a pointer to
	     * the next node in the list.
	     */
	    @SuppressWarnings("hiding")
		class Node<T> {
	        public T data;
	        public Node<T> next;
	    }	
}
