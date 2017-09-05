/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchapp;
// Using file input/output
import java.io.*;
// Using scanner and collection
import java.util.*;

/**
 *
 * @author Van Do
 */

public class File 
{
    // Allows user to input to enter file name to find and display
    private Scanner scan;
    // Use BufferedReader to read texts and buffer character
    private BufferedReader input;
    // Use string to set for one line at a time
    private String currentLine;
    // Set arraylist to store the line and calculate the number of elements in arraylist
    private List<Menu> list;
    // Set menu as array full of dishs
    private Menu[] menu;
    // Enter and check file
    public Menu[] readFile()
    {
        // Initialise new ArrayList
        list = new ArrayList<>();
        // Set input to null to avoid null-exception error
        input = null;
        // Set new Scanner object and using delimiter when using spaces
        scan = new Scanner(System.in).useDelimiter("[\r\n]");
        // Set fileExist to false as not yet enter the file's name
        boolean fileExist = false;
        // Set hasSucceed to false as started this function
        boolean hasSucceed = false;
        // Continue this loop while it has not been successful
        do
        {
            // Continue this loop while file is not existed
            do
            {
                // Try and catch when file is not existed
                try 
                {
                    // Display message to enter file's name or press 0 to exit application
                    System.out.println("Enter file to read menu. Enter 0 only to exit.");
                    // Enter file's name
                    String file = scan.next();
                    // If user is not exiting
                    if(!file.equals("0"))
                    {
                        // Read from this file, using the try and catch, hasSucceed remains false
                        // If file is not existed, repeat this process again, else read file
                        input = new BufferedReader(new FileReader(file));
                        // Set fileExist to true if file is existed
                        fileExist = true;
                        // Try and catch IOException and ArrayIndexOutOfBoundsException
                        // If catch, this shows it is not successful and must check the file manually
                        try
                        {
                            // Set hasReadLine to false as did not start to read file yet
                            boolean hasReadLine = false;
                            // Continue this loop while the next line is not empty
                            while((currentLine = input.readLine()) != null)
                            {
                                // Split all strings from "," and separate into elements of array
                                String[] splits = currentLine.split(",");
                                // Set item to integer when converting string to integer
                                int item = Integer.parseInt(splits[0]);
                                // Set cost to float when converting string to float
                                float cost = Float.parseFloat(splits[3]);
                                // Set new object using data between commas
                                Menu dish = new Menu(item, splits[1], splits[2], cost, splits[4]);
                                // Add dish to ArrayList
                                list.add(dish);
                                // Set hasReadLine to true since read line
                                hasReadLine = true;
                            }
                            // If hasReadLine is true
                            if(hasReadLine)
                            {
                                // Set hasSucceed to true to acknowledge that this is successful
                                hasSucceed = true;
                                // Convert list into array and set menu
                                menu = list.toArray(new Menu[list.size()]);
                            }
                        }
                        // If line is short or input from line is incorrect, catch and set hasSucceed to false
                        catch(IOException | ArrayIndexOutOfBoundsException ex)
                        {
                            hasSucceed = false;
                        }
                    }
                    // If scan is enter 0, exit application
                    else
                    {
                        System.exit(0);
                    }
                }
                // If file is not exist, display message
                catch (FileNotFoundException ex) 
                {
                    System.out.println("File is not existed.");
                }
            }
            while(!fileExist);
            // If it is not successful, display message to check file
            if(!hasSucceed)
            {
                System.out.println("You need to check the lines from the file.");
            }
        }
        while(!hasSucceed);
        // Return menu as array of Menu objects
        return menu;
    }
}
