import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This program opens a binary file and prints
 * all ASCII characters from that file (bytes
 * with values between 32 and 126).
 * 
 * @author Leticia Garcia-Sainz
 * @version 11-7-2015
 */

public class ASCIIPrinter {

	public static void main(String[] args) {
		
		// Ask user to input file name
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the filename: ");
		String file = in.next();
		
		// Initialize variables and input/output stream
		InputStream inStream = null;
		PrintStream out = null;
		// Reads the data from the byte
		int data = 0;
		// Keeps track of byte data count
		int count = 0;
		
		try {
			inStream = new FileInputStream(file);
			out = new PrintStream(new FileOutputStream("ascii.txt"));
			
			// Read file
			while ((data = inStream.read()) != -1) {
				
				// Print ASCII characters
				if (data >= 32 && data <= 126) {
					System.out.print((char) data);
					
					out.print((char) data);
					count++;
				}
				// Print new line after 64 characters
				if (count % 64 == 0) {
					System.out.println();
					count = 0;
				}
			}
		} catch (FileNotFoundException notFound) {
			notFound.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
            		if(inStream != null){
                		try {
                			// Close InputStream
	                		inStream.close();
		                } catch (IOException ex) {
                			ex.printStackTrace();	
                		}
            		}
	            	// Close PrintStream
        	    	out.close();
		}
	}
}	
