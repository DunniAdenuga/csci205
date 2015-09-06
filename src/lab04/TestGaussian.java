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

public class TestGaussian
{
/**
 * This class tests the nextGaussian method in the Random class
 */
static final int MAX_NUMS = 10000;

public static double calcStDev(double nums[])
{
/**
 * This method calculates standard deviation using the normal formula.
 *
 *@param nums- array to be used in computation
 *@return returns standard deviation
 */
int i = 0;
int x = 0;
double average = 0.0;
//double avg;
double stdev = 0.0;
//double st;
while(i < nums.length)
{
average = average + nums[i];
i++;
}
average = average/nums.length;
while(x < nums.length)
{
stdev = stdev + Math.pow((nums[x]-average), 2);
x++;
}
stdev = Math.sqrt(stdev/nums.length);
return stdev;
}
/*******************************************************/
public static double calcAltStDev(double nums[])
{
/**
 * This method calculates standard deviation using an alternative formula.
 *
 *@param nums- array to be used in computation
 *@return returns standard deviation
 */
double average = 0.0;
double stdev = 0.0;

for(int i = 0; i < nums.length; i++)
{
average = average + nums[i];
stdev = stdev + Math.pow(nums[i], 2);
}
average = average/nums.length;
//stdev = Math.sqrt(stdev - (Math.pow(average, 2)/nums.length));
//stdev = Math.sqrt(stdev/nums.length - average*average);
stdev = Math.sqrt((stdev- Math.pow(average, 2))/nums.length);
return stdev;
}

public static void main(String[] args)
{
double sd1;
double sd2;
long startTime1;
double endTime1;
long startTime2;
double endTime2;
System.out.println("Generating " + MAX_NUMS + " numbers...");
double[] num = new double[MAX_NUMS];
Random rand = new Random();
for(int i = 0; i < MAX_NUMS; i++)
{
num[i] = rand.nextGaussian();
}
startTime1 = System.nanoTime(); 
sd1 =  calcStDev(num);
endTime1 = (double)(System.nanoTime() - startTime1)/1000000;
//System.out.println(endTime1);

startTime2 = System.nanoTime();
sd2 = calcAltStDev(num);
endTime2 = (double)(System.nanoTime() - startTime2)/1000000;
//System.out.println(endTime2);

System.out.format("sd: %14.8f\n", sd1);
System.out.println("TIME:    " + endTime1+ " usec");
System.out.format("alt_sd: %9.8f\n",sd2);
System.out.println("TIME:    " + endTime2 + " usec");
//System.out.println(endTime2/endTime1);
double ans = (double)(endTime2/endTime1);
//System.out.println(ans);
System.out.format("alt_sd computed in %.2f percent of the time of sd\n", ans*100);
}
}



