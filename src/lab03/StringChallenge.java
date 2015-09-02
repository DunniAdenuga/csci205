 /***************************************************************************************************
 *CSCI205 - Software Engineering and Design
 *Fall 2015
 *Instructor: Evan Peck
 *Section: 8am
 *
 *Name: Dunni Adenuga
 *Date: 02/09/2015
 *
 *Lab/Assignment: Lab 03
 *
 *Description: Methods, and the String Class
 *
 ****************************************************************************************************/

package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) 
	{
	int i = 0;
	int counter = 0;
        while(i < s.length())
		{
		char a = Character.toLowerCase(s.charAt(i));
		if (a =='a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			counter++;
		i++;
		}
        return counter;
    	}

    /**
     * Count the number of vowels in a string. This method uses recursion
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */

	static int i = 0;
	static int counter = 0;
    public static int countVowelsRec(String s) 
	{
			char a = Character.toLowerCase(s.charAt(i));
			if (a =='a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			{
			counter++;
			}
			i++;
			if (i < s.length())
				countVowelsRec(s);
			
		return counter;
    	}
	static int x = 0;
	static int num = 1;
    public static boolean isPalindrome(String s)
{
	if (s.charAt(x) == s.charAt(s.length() - num))
	{
		//System.out.println(s.charAt(x));
		//System.out.println(s.charAt(s.length() - num));
		x++;
		num++;
		//return true;
		if (x < s.length())
			isPalindrome(s);
	}
	else
	{
		//System.out.println(s.charAt(x));
		//System.out.println(s.charAt(s.length() - num));
		return false;
	}
	return true;
}
	public static String swapFirstAndLastLetter(String s)
	{
	if (Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(s.length()- 1)))
		s = s.charAt(s.length()- 1) + s.substring(1 , s.length()-1) + s.charAt(0);
	return s;
	}
	public static String withoutString(String s, String sRemove)
{
	while(s.contains(sRemove))
	{
	int i;
	i = s.indexOf(sRemove);
	s = s.substring(0, i) + s.substring((i + sRemove.length()), s.length());
	}
	return s;	
}
/**********************************************************************/
	public static int sumNumbersInString(String s)
{
	int i = 0;
	int answer = 0;
	String a = "";
	String b = " ";
	int x = 0;
	int temp;
	while(i+1 < s.length())
{
	if (Character.isDigit(s.charAt(i)))
		{
		a = Character.toString(s.charAt(i));
		temp = i;
		while (Character.isDigit(s.charAt(i+1)))
		{
		b = Character.toString(s.charAt(i+1));
		a = a + b;
		i++;
		 }
		answer = answer + Integer.parseInt(a);
		if ((Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i+1))) == false)
			i++;
		}
	else
		i++;
}
	return answer;
}

    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {
        String sTest = "Mississippi River";
        System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
        System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));

        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
       sTest = "amanapanama";
      System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));

       sTest = "Testing";
       System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));
       sTest = "Testing123";
        System.out.printf("swapFirstAndLastLetter(\"%s\") = \"%s\"\n", sTest, swapFirstAndLastLetter(sTest));

        sTest = "Testing Running Walking Jumping";
       System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
       System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));

       sTest = "a1b2c3";
      System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
      sTest = "aa12bb34cc56dd78";
       System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
    }
}
