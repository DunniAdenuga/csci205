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
 * A simple program to ask the user for a temperature in F, and converts it to
 * Celsius.
 * 
 * @author: BRK 2012-fall
 */
package lab02;

import java.util.Scanner;

public class FtoC {
	public static void main(String[] args) {
		double fahTemp;
		double celTemp;
		// Prompt user for a Fahrenheit temp
		System.out.print("Enter a temperature in Fahrenheit: ");

		// Create the Scanner object, attached to console input
		Scanner in = new Scanner(System.in);

		// Read and store the Fahrenheit temp
		fahTemp = in.nextDouble();

		// Convert the temp to Celsius
		celTemp = ((fahTemp - 32)* 5)/9;
		//System.out.println(celTemp);

		// Output the results with correct formatting
		System.out.printf("%.0f F" + " = " + "%.1f C", fahTemp, celTemp);

	}
}

