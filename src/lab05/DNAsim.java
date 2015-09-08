/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 7, 2015
 * Time: 9:45:39 AM
 *
 * Project: csci205
 * Package: lab05
 * File: DNAsim
 * Description: Generating a simulated DNA sequence
 *
 * ****************************************
 */
package lab05;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dunni Adenuga
 * @version 0.1
 */
public class DNAsim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello. Welcome to the DNA simulator. How long? ");
        int length = in.nextInt();
        System.out.print("What %GC-content? ");
        double content = in.nextDouble();
        char[] dnaSequence = generateDNA(length, content);
        printDNAStats(dnaSequence);
        printLongestRepeat(dnaSequence);
    }

    public static char[] generateDNA(int length, double gcContentPct) {
        /**
         * This method generates a character sequence of specified length
         *
         * @param gcContentPct - percentage of G or C in DNA sequence
         * @param length - length of char array containing A, C G or T
         * @return char[] - a character array containing length of DNA sequence
         */
        int i = 0;
        gcContentPct = gcContentPct / 100;
        Random rand = new Random();
        double gContent = (gcContentPct / (rand.nextInt(2) + 2));
        //System.out.println(gContent);
        double cContent = gcContentPct - gContent;
        //System.out.println(cContent);
        double aContent = (1 - gcContentPct) / (rand.nextInt(3) + 2);
        //System.out.println(aContent);
        double tContent = 1 - gcContentPct - aContent;
        //System.out.println(tContent);
        double x;
        System.out.println("Generating...");
        char[] answer = new char[length];
        while (i < length) {
            x = rand.nextDouble();
            if (x <= gContent) {
                answer[i] = 'G';
            } else if ((x > gContent) && (x <= (gContent + cContent))) {
                answer[i] = 'C';
            } else if ((x > (gContent + cContent)) && (x <= (gContent + cContent + aContent))) {
                answer[i] = 'A';
            } else if ((x > (gContent + cContent + aContent)) && (x <= 1)) {
                answer[i] = 'T';
            }
            i++;
        }
        System.out.println("Complete!");
        return answer;
    }

    public static void printDNAStats(char[] dna) {
        /**
         * This method prints out the A, C, G, T frequencies and percentages
         *
         * @param dna character array to be analyzed
         */
        double countA = 0;
        double countC = 0;
        double countG = 0;
        double countT = 0;
        int i = 0;
        while (i < dna.length) {
            if (dna[i] == 'A') {
                countA++;
            }
            if (dna[i] == 'C') {
                countC++;
            }
            if (dna[i] == 'G') {
                countG++;
            }
            if (dna[i] == 'T') {
                countT++;
            }
            i++;
        }
        System.out.println("Actual content of DNA sequence");
        System.out.println(
                "A:  " + countA + "  (" + (countA / dna.length) * 100 + "%)");
        System.out.println(
                "C:  " + countC + "  (" + (countC / dna.length) * 100 + "%)");
        System.out.println(
                "G:  " + countG + "  (" + (countG / dna.length) * 100 + "%)");
        System.out.println(
                "T:  " + countT + "  (" + (countT / dna.length) * 100 + "%)");
    }

    public static void printLongestRepeat(char[] dna) {
        /**
         * This method prints the length and index position of the longest
         * repeating nucleotide.
         *
         * @param dna -char array to be analysed
         */
        int i = 0;
        //int check = 0;
        int count = 0;
        int longest = 0;
        char stuff = 'j';
        int y = 0;
        while (i < dna.length - 1) {
            if (dna[i] == dna[i + 1]) {
                count++;
                if (count > longest) {
                    longest = count;
                    stuff = dna[i];
                    y = i;
                }
            } else {
                count = 0;
            }
            i++;
        }
        System.out.println(
                "Longest repeated nucleotide: " + longest + stuff + "'s [index: " + (y - longest) + "]");
        /**
         * while (check < longest) { System.out.println(dna[y - check]);
         * check++;
        }*
         */

    }
}
