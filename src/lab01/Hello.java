/***************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 25/08/2015
 *
 *Lab/Assignment: Lab 01
 *
 *Description:"Hello World" program in java
 *
 ****************************************************************************************************/

package lab01;

public class Hello
{
	public static void main(String[] args)
	{
		double initialTime = System.nanoTime();
		System.out.println("Programming is not a spectator sport!!");
		double finalTime = System.nanoTime();
		System.out.println("Time to execute: " + (finalTime - initialTime)/1000000 + " ms");
	}

}
