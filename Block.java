/**
 * This class contains the quantity and price
 * of a block of shares.
 * This class is used in StockBroker.java
 *
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */

public class Block {

	private int quantity;
	private double price;
	
	/**
	 * Constructor for block of shares
	 * @param q the quantity
	 * @param p the price per share
	 */
	public Block(int q, double p) {
		this.quantity = q;
		this.price = p;
	}
	
	/**
	 * Returns the total quantity of a block of shares
	 * @return quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Returns the price of a block of shares
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}
}
