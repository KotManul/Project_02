package project_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageMode {

	public void createSaleItem(String itemName) {

		System.out.println("User has entered item: " + itemName);

		// Create File

	}

	public void addPrice(double price) {
		System.out.println("Item price: " + price);
	}

	public void doIt() {

		Scanner keyboard = new Scanner(System.in);
		String input = "";

		while (!input.equalsIgnoreCase("QUIT")) {
			System.out.println("Please enter the name of item or QUIT to stop");
			input = keyboard.nextLine();
			if (!input.equalsIgnoreCase("QUIT")) {

				String fileName = "c:\\test\\" + input + ".txt";

				System.out.println("File name is " + fileName);

				File myObj = new File(fileName);
				try {
					if (myObj.createNewFile()) {
						System.out.println("File created: " + myObj.getName());

						try {
							Double price = null;
							PrintWriter fw = new PrintWriter(new File(fileName));
							System.out.println("Enter sale price: ");
							while (true) {
								try {
									price = keyboard.nextDouble();
									break;
								} catch (InputMismatchException ex) {
									System.out.println(ex.getMessage());
									System.out.println("Please enter a numerical price value.");
									keyboard.nextLine();
								}

							}

							fw.println(price);
							fw.close();
							System.out.println("Successfully wrote to the file.");
							keyboard.nextLine();
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					} else {
						System.out.println("File already exists.");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
