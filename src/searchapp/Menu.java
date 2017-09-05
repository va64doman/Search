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

import java.text.*;

public class Menu 
{
    // Menu item (Dish number)
    private final int item;
    // Dish's initial or short name
    private final String initial;
    // Dish's name
    private final String name;
    // Dish's cost
    private final float cost;
    // Dish's course, appertizers, entrees, desserts, drinks
    private final String course;
    // Parameterised constructor to set menu's object with details
    public Menu(int mItem, String mInit, String mName, float mCost, String mCourse)
    {
        item = mItem;
        initial = mInit;
        name = mName;
        cost = mCost;
        course = mCourse;
    }
    // Get dish number
    public int getDishItem()
    {
        return item;
    }
    // Get dish's initial
    public String getDishInitial()
    {
        return initial;
    }
    // Get dish's name
    public String getDishName()
    {
        return name;
    }
    // Get dish's cost
    public float getDishCost()
    {
        return cost;
    }
    // Get dish's course
    public String getDishCourse()
    {
        return course;
    }
    // Print dish's details
    public void printMenuDish()
    {
        // Set cost to 2 decimal places
        DecimalFormat decimal = new DecimalFormat("###.00");
        System.out.println("Dish number: " + item);
        System.out.println("Dish initial: " + initial);
        System.out.println("Dish name: " + name);
        System.out.println("Dish cost: $" + decimal.format(cost));
        System.out.println("Dish course: " + course);
    }
}
