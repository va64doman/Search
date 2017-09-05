/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchapp;

// Using scanner and collection
import java.util.*;

/**
 *
 * @author Van Do
 */

// This class will be using binary search
public class Search 
{
    // Allows user to input to search for dish and enter file name to display
    private Scanner scan;
    // Set choice as integer to select options to search by
    private int choice;
    // Access file method
    private File file;
    // Allows access to QuickSort class
    private QuickSort sort;
    // Set menu as array to fill up the menu
    private Menu[] menu;
    // This is for handling integer input error
    private int input;
    // Handle application's function
    public void usingApp()
    {
        scan = new Scanner(System.in);
        file = new File();
        sort = new QuickSort();
        menu = file.readFile();
        do
        {
            // Print out all options
            System.out.println(displayOption());
            // User choosing an option
            int option = handleInt();
            // Using switch case to decide multiple options
            switch(option)
            {
                // If 1, find dish by search for dish item (number)
                case 1:
                    // Quick sort by number in ascending order
                    sort.sortByNumber(menu, 0, menu.length - 1);
                    // Enter the number you wanted to search for
                    System.out.println("Enter the number you wanted to search.");
                    int search = handleInt();
                    // Search for this number using binary search
                    int index = binarySearchForNumber(search, menu);
                    // Print if found, otherwise display other message
                    printIfFound(index, menu);
                    break;
                // If 2, find dish by search for dish initial
                case 2:
                    // Quick sort by initial in alphabetical order
                    sort.sortByInitial(menu, 0, menu.length - 1);
                    // Enter initial or short name
                    System.out.println("Enter the initial or short name of dish you wanted to search.");
                    String name = scan.next();
                    // Compare short name for all dishes and set index when found or not
                    index = binarySearchForShortName(name, menu);
                    // Print if found, otherwise display other message
                    printIfFound(index, menu);
                    break;
                // If 3, display help
                case 3:
                    System.out.println("Number: Dish Number From Menu (eg. 5)");
                    System.out.println("Initial: Dish Initial From Menu (eg. BF or BeFi)");
                    break;
                // If none of the above, display this message
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            // Display this message if wanted to continue this app
            System.out.println("Do you want to continue? Yes (1) or No (Any number)");
            choice = handleInt();
        }
        while(choice == 1);
    }
    // Display all options
    private String displayOption()
    {
        // Build up the option easily without typing string in lengthy line
        StringBuilder option = new StringBuilder();
        // Append all string into one
        option.append("Select options.").append("\n");
        option.append("1. Search By Dish Number").append("\n");
        option.append("2. Search By Dish Initial").append("\n");
        option.append("3. Help");
        // Display options
        return option.toString();
    }
    // Handle integer inputs
    private int handleInt()
    {
        // Assuming this continue in a loop until the user has entered the integer
        boolean loop = true;
        // Continue this loop until the user has entered the input correctly
        while(loop)
        {
            // Try and catch error if the user has not entered the integer
            try
            {
                input = scan.nextInt();
                System.out.println();
                loop = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Try again. Wrong input.");
                scan.nextLine();
            }
        }
        return input;
    }
    // Binary search for dish number
    private int binarySearchForNumber(int item, Menu[] menu)
    {
        // Initialise index to -1 when not found yet
        int index = -1;
        // Set low to 0
        int low = 0;
        // Set high to the length of menu - 1
        int high = menu.length - 1;
        // Initialise mid as integer
        int mid;
        // Continue this loop while high is greater or equal to low
        while(high >= low)
        {
            // Set mid by adding high and low and then half it
            mid = (high + low) / 2;
            // If search item is less than the middle node's dish number
            if(item < menu[mid].getDishItem())
            {
                // Set high by deducting mid by 1
                high = mid - 1;
            }
            // If search item is greater than middle node's dish number
            else if(item > menu[mid].getDishItem())
            {
                // Set low by adding mid by 1
                low = mid + 1;
            }
            // If search item is equals to middle node's dish number
            else
            {
                // Set index by mid
                index = mid;
                // Break loop because it has been found
                break;
            }
        }
        // Return index either array index or -1
        return index;
    }
    // Binary search for dish's short name or initial
    private int binarySearchForShortName(String initial, Menu[] menu)
    {
        // Similar to binarySearchForNumber
        int index = -1;
        int low = 0;
        int high = menu.length - 1;
        int mid;
        while(high >= low)
        {
            mid = (high + low) / 2;
            // Check if initial is before the middle node's initial
            if(initial.compareToIgnoreCase(menu[mid].getDishInitial()) < 0)
            {
                high = mid - 1;
            }
            // Check if initial is after the middle node's initial
            else if(initial.compareToIgnoreCase(menu[mid].getDishInitial()) > 0)
            {
                low = mid + 1;
            }
            // Check if initial is equals to middle node's initial
            else
            {
                index = mid;
                break;
            }
        }
        return index;
    }
    // Check if found and print
    private void printIfFound(int index, Menu[] menu)
    {
        // If index is -1, display dish is not found, else display dish's details
        if(index == -1)
        {
            System.out.println("Dish is not found.");
        }
        else
        {
            System.out.println("Printing dish");
            menu[index].printMenuDish();
        }
    }
}
