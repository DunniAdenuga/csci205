/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 7, 2015
 * Time: 8:45:09 AM
 *
 * Project: csci205
 * Package: lab05
 * File: Hello
 * Description:
 *
 * ****************************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple program to aid in understanding NetBeans
 *
 * @author Dunni Adenuga
 * @version 0.1
 */
public class Hello {

    private static final int NUM_INTS = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        greetUser();

        getArrayOfRandomNums();
    }

    private static void getArrayOfRandomNums() {
        //Some simple code to test the debugger

        int[] x = new int[NUM_INTS];
        Random rand = new Random();
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(x));
    }

    private static void greetUser() {
        System.out.print("Hello! What is your name ? ");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.println(name + ", becoming a good programmer takes practice.");
    }

}
