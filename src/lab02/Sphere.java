/*****************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 28/08/2015
 *
 *Lab/Assignment: Lab 02
 *
 *Description:
 * 
 * This program finds the volume of a sphere given radius.
 * 
 * 
 */
package lab02;
import java.util.*;
import java.lang.*;

public class Sphere
{
	public static void main(String[] args)
	{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the radius of a sphere: ");
	double radius = in.nextDouble();
	
	double volume = (4* Math.PI * Math.pow(radius, 3))/3;
	System.out.printf("The volume is: %.2f", volume);
	System.out.println();
	System.out.println("Rounded to the nearest integer: " + Math.round(volume));
	}

}
