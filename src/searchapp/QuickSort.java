/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchapp;

/**
 *
 * @author Van Do
 */

public class QuickSort 
{
    // Sorting part of the array by number
    private int partitionByNumber(Menu[] menu, int low, int high)
    {
        // Set the pivot value by the right dish number from the partition
        int pivot = menu[high].getDishItem();
        // Set small by deducting low by 1
        int small = low - 1;
        // Iterate until count is less than high, set count to low
        for(int count = low; count < high; count++)
        {
            // If this dish number is less than pivot
            if(menu[count].getDishItem() <= pivot)
            {
                // Increment small by 1
                small++;
                // Swap menu[small] and menu[count]
                swap(menu, small, count);
            }
        }
        // Swap menu[small + 1] and menu[high]
        swap(menu, small + 1, high);
        // Return small + 1 as integer
        return small + 1;
    }
    // Sort part of array by initial
    private int partitionByInitial(Menu[] menu, int low, int high)
    {
        // Set pivot by the right dish's name from partition
        String pivot = menu[high].getDishInitial();
        // Identical to partitionByNumber
        int small = low - 1;
        // Identical iteration
        for(int count = low; count < high; count++)
        {
            // Check if the order if the selected dish's name is first or equal to pivot
            if(menu[count].getDishInitial().compareToIgnoreCase(pivot) <= 0)
            {
                // Increment small by 1 and swap menu[small] and menu[count]
                small++;
                swap(menu, small, count);
            }
        }
        // Swap menu[small + 1] and menu[high]
        swap(menu, small + 1, high);
        // Return small + 1 as integer
        return small + 1;
    }
    // Swap two values
    private void swap(Menu[] menu, int left, int right)
    {
        // Set temp as menu[temp] to avoid losing this data
        Menu temp = menu[left];
        // Set menu[left] as menu[right]
        menu[left] = menu[right];
        // Set menu[right] as temp
        menu[right] = temp;
    }
    // Sort number
    public void sortByNumber(Menu[] menu, int low, int high)
    {
        // If low is less than high, start sorting
        if(low < high)
        {
            // Set middle value from partition
            int mid = partitionByNumber(menu, low, high);
            // Sort again between low and middle - 1
            sortByNumber(menu, low, mid - 1);
            // Sort again between middle + 1 and high
            sortByNumber(menu, mid + 1, high);
        }
    }
    // Sort initial
    public void sortByInitial(Menu[] menu, int low, int high)
    {
        // Same to sortByNumber
        if(low < high)
        {
            int mid = partitionByInitial(menu, low, high);
            sortByInitial(menu, low, mid - 1);
            sortByInitial(menu, mid + 1, high);
        }

    }
}
