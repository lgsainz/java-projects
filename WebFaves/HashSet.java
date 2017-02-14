/**
 * This class implements a hash set using separate chaining
 * This class is used in WebFavorites class.
 * @author Leticia Garcia-Sainz
 * @version 10-11-2015
 */

public class HashSet
{
    private Node[] buckets;
    private int currentSize;
    private double loadFactor = currentSize / buckets.length;
    
    /**
     * Constructs a hash table
     * @param bucketsLength the length of the buckets array
     */
    public HashSet(int bucketsLength)
    {
        buckets = new Node[bucketsLength];
        currentSize = 0;
        this.loadFactor = loadFactor;
    }
    
    /**
     * Increases the set size by doubling it.
     */
    public void increaseSetSize() {
    	int setSize = 2 * buckets.length;
    	Node[] oldSet = buckets;
    	buckets = new Node[setSize];
    	currentSize = 0;
    	for (int i = 0; i < oldSet.length; i++) {
    		if (oldSet[i] != null) {
    			add(oldSet[i].data);
    		}
    	}
    }
    
    /**
     *  Decreases the set size by half.
     */
    public void decreaseSetSize() {
    	int setSize = buckets.length / 2;
    	Node[] oldSet = buckets;
    	buckets = new Node[setSize];
    	currentSize = 0;
    	for (int i = 0; i < oldSet.length; i++) {
    		if (oldSet[i] != null) {
    			add(oldSet[i].data);
    		}
    	}
    }
    
    /**
     * Tests for set membership.
     * @param x the object to look up
     * @return true if x is in the table
     */
    public boolean contains(Object x)
    {
        int h = x.hashCode();
        if (h < 0) 
        { 
            h = -h;
        }
        h = h % buckets.length;
        
        Node current = buckets[h];
        while (current != null)
        {
            if (current.data.equals(x))
            {
            	System.out.println("Web Page: " + current.data);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Adds an element to the hashtable.
     * @param x the element to add
     * @return true if x was successfully added, false
     * if x already exists in the set.
     */
    public boolean add(Object x)
    {
        int h = x.hashCode();
        if (h < 0)
        {
            h = -h;
        }
        h = h % buckets.length;
        
        Node current = buckets[h];
        while (current != null)
        {
            if (current.data.equals(x))
            {
                return false;
            }
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = x;
        newNode.next = buckets[h];
        buckets[h] = newNode;
        currentSize++;
        
        // Increase size if load factor exceeds 1.0
        if (loadFactor > 1.0) {
        	increaseSetSize();
        }
        return true;
    
    }
    
    /**
     * Removes an object from the set.
     * @param x the object to remove
     * @return true if the object was removed, false if x
     * is not in the set
     */
    public boolean remove(Object x)
    {
        int h = x.hashCode();
        if (h < 0) { h = -h; }
        h = h % buckets.length;
        
        Node current = buckets[h];
        Node previous = null;
        while (current != null)
        {
            if (current.data.equals(x))
            {
                if (previous == null)
                {
                    buckets[h] = current.next;
                }
                else
                {
                    previous.next = current.next;
                }
                currentSize--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        
        // Decrease set size if load factor less than 0.5
        if (loadFactor < 0.5) {
        	decreaseSetSize();
        }
        return false;
    }
    
    /**
     * Finds a web page by url.
     * @param obj the url to find
     */
    public void find(Object obj) {
    	int i = 0;
    	Node current = buckets[i];
    	while (current != null) {
    		if (((WebPage) current.data).getUrl().equals((String) obj)) {
    			System.out.println(current.data);
    		}
    		else {
    			current = current.next;
    		}
    	}
    }
    
    /**
     * Gets the number of elements in the set.
     * @return the number of elements
     */
    public int size()
    {
        return currentSize;
    }
    
    class Node
    {
        public Object data;
        public Node next;
    }
}
