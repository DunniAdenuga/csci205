/***************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 05/09/2015
 *
 *Lab/Assignment: Lab 04
 *
 *Description:Arrays, Switch.
 *
 ****************************************************************************************************/
package lab04;
import java.util.*;

public class ArrayChallenge 
{
public static void main(String[] args) 
{
 double[] array1 = { 2, 3, 5, 7, 11 };
 double[] array2 = { 1, 4, 6, 8, 0 };
 System.out.printf("array1: %s\n", Arrays.toString(array1));
 System.out.printf("array2: %s\n", Arrays.toString(array2));
 System.out.printf("concat test: %s\n",
Arrays.toString(concat(array1,array2)));
 System.out.printf("reverse test: %s\n",
Arrays.toString(reverse(array1)));
 System.out.printf("altSum test: %.1f\n", altSum(concat(array1,
array2)));
 System.out.printf("sorted test 1: %b\n", isSorted(array1));
 System.out.printf("sorted test 2: %b\n", isSorted(array2));
}

/**************************************************************/

public static double[] concat(double[] a1, double[] a2)
{
/**
 *This method should take two arrays of double a1 and a2, and returns a single arr
 *array that represents a concatenation of both a1 and a2.
 *
 *@param a1 & a2 -the 2 arrays to be concatenated
 *@return a double array containing both arrays
 */
double[] answer = new double[a1.length + a2.length];
int x = 0;
answer = Arrays.copyOf(a1, a1.length + a2.length);
for(int i = a1.length; i < a1.length + a2.length; i++)
	{
	answer[i] = a2[x];
	x++;
	}
return answer;
}
/***************************************************************/

static int i =0;
static int counter = 1;
static double[] answer;
public static double[] reverse(double[] a)
{/**
   * This method returns the reverse of an array using recursion
   * 
   * @param a array to be reversed
   * @return reverse of <code>s</code>
   */ 
if (counter == 1)
	answer = new double[a.length]; 
answer[i] = a[a.length-(i+1)];
i++;
counter++;
if(i < a.length)
	reverse(a);
return answer;
}
/******************************************************************/
public static double altSum(double[] a)
{
/**
 * This method calculates the alternate sum of elements in a.
 *
 *@param a array to be summed
 *@return returns alternate sum of <code>a</code>
 */
int i=0;
int counter=1;
double answer = 0.0;
while(i < a.length)
{
if (counter%2 != 0)
	answer = answer + a[i];
else
	answer = answer - a[i];
i++;
counter++;
}
return answer;
}
/******************************************************************/

public static boolean isSorted(double[] a)
{
/**
  * This method checks if an array is sorted
  *
  * @param a array to be checked
  * @return true if <code>a</code> is sorted or false if otherwise
  */
int i = 0;
boolean answer = true;
while((answer == true) && (i < a.length-1))
{
if (a[i+1] < a[i])
	answer = false;
i++;
}
return answer;
}

}


