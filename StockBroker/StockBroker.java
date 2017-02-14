/**
 * This program calculates the total gains from 
 * buying and selling stock.
 * Uses class Block.java
 *
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class StockBroker {
	
	// Create queue
	private static Queue<Block> shares = new LinkedList<Block>();
	static double totalGains = 0;
	
	/**
	 * Purchases a number of shares for a certain price, 
	 * adding the block to the queue.
	 * 
	 * @param quantity the number of shares to buy
	 * @param buyPrice the price to pay
	 */
	public static void buy(int quantity, double buyPrice) {
		Block newBlock = new Block(quantity, buyPrice);
		shares.add(newBlock);
	}
	
	/**
	 * Sells a number of shares for a certain price.
	 * 
	 * @param quantity the number of shares to sell
	 * @param sellPrice the price sold at
	 */
	public static void sell(int quantity, double sellPrice) {
		do {
			Block block = shares.peek();
			// If the amount we wish to sell is greater than the amount in the first block, then...
			if (quantity > block.getQuantity()) {
				totalGains = totalGains + (block.getQuantity() * sellPrice - block.getQuantity() *
						block.getPrice());
				shares.remove();
				quantity = quantity - block.getQuantity();
			}
			
			// If the amount we wish to sell is less than or equal to the amount in the first block...
			else {
				totalGains = totalGains + (quantity * sellPrice - quantity * block.getPrice());
				quantity = quantity - block.getQuantity();
			}
		} while (quantity >= 0);
		System.out.println("Total Gains: " + totalGains);
	}
	
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		String answer = "";
		do {
			System.out.print("Do you want to buy (B), sell (S), or quit (Q)? ");
			answer = in.next();
		
		
			if (answer.equalsIgnoreCase("b")) {
				System.out.println("How many shares do you want to buy? ");
				int quantity = in.nextInt();
				System.out.println("At what price? ");
				double price = in.nextDouble();
			
				buy(quantity, price);
			}
			else if (answer.equalsIgnoreCase("s")) {
				System.out.println("How many shares do you wish to sell? ");
				int qSell = in.nextInt();
				System.out.println("At what price? ");
				double qPrice = in.nextDouble();
				sell(qSell, qPrice);
			}
			else if (answer.equalsIgnoreCase("q")) {
				System.out.println("Goodbye.");
			}
			else {
				System.out.println("Please enter the correct option.");
			}
		} while (!answer.equalsIgnoreCase("q"));
	}
	
}
