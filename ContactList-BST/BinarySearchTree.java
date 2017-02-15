/**
 * Implements a binary search tree (textbook).
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-10-2015
 */

public class BinarySearchTree
{
   private Node root;
   private int currentSize;
   
   /**
    * Constructs an empty tree.
    */
   public BinarySearchTree()
   {
       root = null;
    }
    
    /**
     * Inserts a new node into the tree.
     * @param obj the object to insert
     */
    public void add(Comparable obj)
    {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) { root = newNode; }
        else { root.addNode(newNode); }
        currentSize++;
    }
    
    /**
     * Tries to find an object in the tree.
     * @param obj the object to look for
     * @return true if the object is in the tree
     */
    public boolean find(Comparable obj)
    {
        Node current = root;
        while (current != null)
        {
            int d = current.data.compareTo(obj);
            if (d == 0) { return true; }
            else if (d > 0) { current = current.left; }
            else { current = current.right; }
        }
        return false;
    }
    
    /**
     * Finds contact and prints info.
     * @param obj 
     */
    public void findDummyContact(Comparable obj) {
    	Node current = root;
    	while (current != null) {
    		int d = (((Contact) current.data).getName()).compareTo((String) obj);
    		if (d == 0) {
    			System.out.println(current.data);
    			break;
    		}
    		else if (d > 0) {
    			current = current.left;
    		}
    		else {
    			current = current.right;
    		}
    	}
    }
    
    /**
     * Tries to remove an object from the tree.
     * @param obj the object to remove
     */
    public void remove(Comparable obj)
    {
        Node toRemove = root;
        Node parent = null;
        boolean found = false;
        while (!found && toRemove != null)
        {
            int d = ((Contact) toRemove.data).getName().compareTo((String) obj);
            if (d == 0) { found = true; }
            else
            {
                parent = toRemove;
                if (d > 0) { toRemove = toRemove.left; }
                else { toRemove = toRemove.right; }
            }
        }
        
        if (!found) { return; }
        
        // One child
        if (toRemove.left == null || toRemove.right == null)
        {
            Node newChild;
            if (toRemove.left == null)
            {
                newChild = toRemove.right;
            }
            else
            {
                newChild = toRemove.left;
            }
            
            if (parent == null) // Removing the root
            {
                root = newChild;
            }
            else if (parent.left == toRemove)
            {
                parent.left = newChild;
            }
            else
            {
                parent.right = newChild;
            }
            currentSize--;
            return;
        }
        
        // Two children
        Node smallestParent = toRemove;
        Node smallest = toRemove.right;
        while (smallest.left != null)
        {
            smallestParent = smallest;
            smallest = smallest.left;
        }
        
        toRemove.data = smallest.data;
        if (smallestParent == toRemove)
        {
            smallestParent.right = smallest.right;
        }
        else
        {
            smallestParent.left = smallest.right;
        }
    }

    /**
     * Prints the tree in sorted order.
     */
    public void print()
    {
        print(root);
        System.out.println();
    }
    
    private static void print(Node parent)
    {
        if (parent == null) { return; }
        print(parent.left);
        System.out.print(parent.data + " ");
        print(parent.right);
    }
    
    /**
     * Return the size of the list.
     * @return currentSize
     */
    public int size() {
		return currentSize;
	}
    
    /**
     * Return the list in order.
     */
    public void inOrder() {
    	inOrderHelper(root);
    	System.out.println();
    }
    
    /**
     * Helper method to sort list in order.
     * @param current the current node
     */
    public void inOrderHelper(Node current) {
    	if (current == null) {
    		return;
    	}
    	inOrderHelper(current.left);
    	System.out.println(current.data);
    	inOrderHelper(current.right);
    }
    
    class Node
    {
        public Comparable data;
        public Node left;
        public Node right;
        
        /**
         * Inserts a new node as a descendant of this node
         * @param newNode the node to insert
         */
        public void addNode(Node newNode)
        {
            int comp = newNode.data.compareTo(data);
            if (comp < 0)
            {
                if (left == null) { left = newNode; }
                else { left.addNode(newNode); }
            }
            else if (comp > 0)
            {
                if (right == null) { right = newNode; }
                else { right.addNode(newNode); }
            }
        }
    }
}
