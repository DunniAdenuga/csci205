
package lab04;
import java.util.*;
public class Calculator
{
public static void main(String[] args)
{
String repeat = "y";
double first = 0.0;
double second = 0.0;
double answer = 0.0;
String operator;
boolean check1;
boolean check2;
String stuff1;
String stuff2;
System.out.println("Welcome to the Calculator\nEnter expressions with two numeric operands and a single operator from +, -, *, /, %, or ^");
while(repeat.equalsIgnoreCase("y") == true)
{
Scanner in = new Scanner(System.in);
System.out.print("Please Enter a mathematical Expression: ");
check1 = in.hasNextDouble();
if (check1 == false)
	{
	System.out.println("Error! Enter a floating point number");
	stuff1 = in.next();
	}
else
	first = in.nextDouble();

operator = in.next();

check2 = in.hasNextDouble();
if (check2 == false)
	{
	System.out.println("Error! Enter a floating point number");
	stuff2 = in.next();	
	}
else
	second = in.nextDouble();
if ((check1 == true) && (check2 == true))
{
switch(operator)
{
case "+":
	answer = first + second;
	System.out.println("The sum is " + answer);
	break;
case "-":
	answer = first - second;
	System.out.println("The difference is " + answer);
	break;
case "/":
	answer = first/second;
	System.out.println("The division gives a value of " + answer);
	break;
case "%":
	answer = first%second;
	System.out.println("The remainder is " + answer);
	break;
case "*":
	answer = first*second;
	System.out.println("The product is " + answer);
	break;
case "^":
	answer = Math.pow(first, second);
	System.out.println("Your answer is " + answer);
	break;
default:
	System.out.println("Error! Enter appropriate operator.");
	System.out.println("No answer.");
	break;
}
	
}

System.out.print("Do you want to try again ? Enter y for yes, n for no: ");
repeat = in.next();
}
}
}
