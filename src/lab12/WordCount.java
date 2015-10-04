/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 1, 2015
 * Time: 9:12:41 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCount
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Return Number of Words/Lines/Characters
 *
 * @author Dunni Adenuga
 */
public class WordCount {
    private File fileName;
    private BufferedInputStream input;
    private int lineCount;
    private int wordCount;
    private int charCount;

    public WordCount(File fileName) {
        this.fileName = fileName;
    }

    public WordCount(String stringFile) {
        fileName = new File(stringFile);
    }

    /**
     * Sets lineCount, wordCount and charCount properties by calling class
     * methods
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void doIt() throws FileNotFoundException, IOException {
        try {
            lineCount = lineCounter();

            wordCount = wordCounter();

            charCount = charCounter();

        } catch (IOException e) {
            System.out.println();
        } finally {
            input.close();
        }
    }

    /**
     * Count number of lines in file
     *
     * @return number
     * @throws FileNotFoundException- if file does not exist
     * @throws IOException
     */
    public int lineCounter() throws FileNotFoundException, IOException {
        input = new BufferedInputStream(new FileInputStream(fileName));
        Scanner instance = new Scanner(input);
        String smatch;
        int count = 0;
        Pattern p = Pattern.compile("\\n");
        while ((smatch = instance.findWithinHorizon(p, 0)) != null) {

            count++;
        }
        instance.close();
        input.close();
        return count;
    }

    /**
     * Count number of words in fileName
     *
     * @return Number
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int wordCounter() throws FileNotFoundException, IOException {
        input = new BufferedInputStream(new FileInputStream(fileName));
        Scanner instance = new Scanner(input);
        String smatch;
        int count = 0;
        Pattern p = Pattern.compile("\\S+(\\s)");
        //Pattern q = Pattern.compile("\\n");
        while ((smatch = instance.findWithinHorizon(p, 0)) != null) {

            count++;
        }
        instance.close();
        input.close();
        return count;
    }

    /**
     * Count number of characters
     *
     * @return Number
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int charCounter() throws FileNotFoundException, IOException {
        input = new BufferedInputStream(new FileInputStream(fileName));
        BufferedInputStream input2 = new BufferedInputStream(
                new FileInputStream(fileName));
        Scanner instance = new Scanner(input);
        Scanner instance2 = new Scanner(input2);
        String smatch;
        Pattern p = Pattern.compile(".");
        Pattern q = Pattern.compile("\\n");
        int count = 0;
        while (((smatch = instance.findWithinHorizon(p, 0)) != null) || ((smatch = instance2.findWithinHorizon(
                                                                          q, 0)) != null)) {// count line characters.
            count++;
        }
        instance.close();
        instance2.close();
        input.close();
        return count;
    }

    /**
     * State of Object
     *
     * @return String representation
     */
    @Override
    public String toString() {
        String info = "For file: " + fileName + "\n"
                      + "Number of characters is: " + charCount + "\n"
                      + "Number of words is: " + wordCount + "\n"
                      + "Number of lines is: " + lineCount + "\n";
        return info;
    }
}
