package project_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class project_02 {

    public static void main(String[] args) throws IOException {
    	
    	ManageMode mm = new ManageMode();
    	ShopMode sm = new ShopMode();
    	
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        
        while (!input.equalsIgnoreCase("QUIT")) {
            System.out.println("Please enter \"m\" for Managed Mode, \"s\" for Shopping Mode or \"q\" to Quit.");
            input = keyboard.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
            	System.exit(0);
            }
            
            if (input.equalsIgnoreCase("m")) {
            	mm.doIt();    	 
            }

            if (input.equalsIgnoreCase("s")) {
            	sm.doIt();    	 
            }
            
        }
    }
    
    
    
}