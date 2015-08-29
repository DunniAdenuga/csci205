/*****************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 27/08/2015
 *
 *Lab/Assignment: Lab 02
 *
 *Description:
 * This is a simple program to compute a proper amount of change given some
 * number of pennies.
 * 
 * @author BRK 2012-fall
 * 
 */

package lab02;

import java.util.Scanner;

public class Change {

	final static int PENNIES_PER_DOLLAR = 100;
	final static int PENNIES_PER_QUARTER = 25;
	final static int PENNIES_PER_DIME = 10;
	final static int PENNIES_PER_NICKEL = 5;
	

	public static void main(String[] args) 
{
		String tryAgain = "y";
		Scanner in = new Scanner(System.in);		

		while((tryAgain.equalsIgnoreCase("y")) == true)
		{

		System.out.print("Enter the number of pennies: ");

		int pennies = in.nextInt();
		int temp = pennies;

		// Compute number of dollars
		int dollars = pennies / PENNIES_PER_DOLLAR;
		pennies = pennies % PENNIES_PER_DOLLAR;

		// Compute number of quarters
		int quarters = pennies / PENNIES_PER_QUARTER;
		pennies = pennies % PENNIES_PER_QUARTER;	

		// Compute number of dimes
		int dimes = pennies / PENNIES_PER_DIME;
		pennies = pennies % PENNIES_PER_DIME;

		// Compute number of nickels
		int nickels = pennies / PENNIES_PER_NICKEL;
		pennies = pennies % PENNIES_PER_NICKEL;
		//pennies = pennies - (quarters * PENNIES_PER_NICKEL);//pennies left

		// Output the results
		System.out.println(temp + " pennies breaks down to:");
		System.out.format("%4d dollars  =  $%6.2f", dollars, dollars * PENNIES_PER_DOLLAR / 100.0);
		System.out.println();
		System.out.format("%4d quarters =  $%6.2f", quarters, quarters * PENNIES_PER_QUARTER / 100.0);
		System.out.println();
		System.out.format("%4d dimes    =  $%6.2f", dimes, dimes * PENNIES_PER_DIME / 100.0);
		System.out.println();
		System.out.format("%4d nickels  =  $%6.2f", nickels, nickels * PENNIES_PER_NICKEL / 100.0);
		System.out.println();
		System.out.format("%4d pennies  =  $%6.2f", pennies, pennies/ 100.0);
		System.out.println();
		System.out.print("Try again? [y | n]: ");
		tryAgain = in.next();
	}
		System.out.println("Goodbye !");
}
}
