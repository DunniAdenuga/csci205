/***************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 01/09/2015
 *
 *Lab/Assignment: Lab 03
 *
 *Description: Methods, and the String Class
 *
 ****************************************************************************************************/

package lab03;

import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) 
	{
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;
        
       	else
		return recFib(n-1) + recFib(n-2);
  	  	
	}
    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) 
	{
	int i = 2;
	int previous = 1;
	int answer = 1;
	int beforeChange = 0;
	if(n == 0)
		return 0;
	if(n == 1)
		return 1;
	else
	{
        while(i <= n)
	{
	beforeChange = answer;
	answer = answer + previous;
	previous = beforeChange;
	i++;
	}
	return beforeChange;
	}
	//System.out.println(beforeChange + " " + answer+ " " + previous);
	//return answer;
    	}

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("What fibonacci number do you want?");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println("Recursive fib: " + recFib(n));
        System.out.println("Non-recursive fib: " + nonRecFib(n));
    }

}
