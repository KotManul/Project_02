package project_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopMode {
	public void doIt() {

		Scanner keyboard = new Scanner(System.in);
		String input = "";

		Double total = 0.0;

		while (!input.equalsIgnoreCase("QUIT")) {
			System.out.println("What item you want to buy or QUIT to stop?");
			input = keyboard.nextLine();
			if (!input.equalsIgnoreCase("QUIT")) {
				// Check for file name
				File fn = new File("c:\\test\\" + input + ".txt");
				if (!fn.exists()) {
					System.out.println("Item " + input + " is not for sale. Enter another item name.");
					continue;
				}
				System.out.println("YES, item is for SALE " + input);

				FileReader fr;
				try {
					fr = new FileReader(fn);
					BufferedReader br = new BufferedReader(fr);
					Double price;
					while ( (price = Double.parseDouble(br.readLine()) ) != null) {
						total = total + price;
						System.out.println("Your cart total price is " + total);
						break;
					}
					br.close();
					fr.close(); // closes the stream and release the resources
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}			
		}

		// Ask for credit card
		if (total != 0.0) {
			System.out.println("Your total purchase price is " + total + ". Please enter the credit card number:");
			input = keyboard.nextLine();
			System.out.println("Your credit card " + input + " was charged with ampount of " + total);
		}

	}

}
