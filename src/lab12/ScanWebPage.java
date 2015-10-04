/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 1, 2015
 * Time: 1:45:49 PM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPage
 * Description: Exception handling in Java
 *              Learning how to	read and write files
 * ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Scan WebPages from users and read specified tags into a text file , record
 * number of tags too
 *
 * @author Dunni Adenuga
 */
public class ScanWebPage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner url = new Scanner(System.in);
        BufferedInputStream[] in = new BufferedInputStream[2];
        do {
            System.out.print("Enter the url to scan: ");
            String address = url.next();
            try {
                in = getStream(address);
            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Invalid URL syntax specified");

            } catch (MalformedURLException e) {

                System.out.println(
                        "Incomplete or \"malformed\" URL");

            } catch (UnknownHostException e) {

                System.out.println(
                        "Valid URL, but host does not exist");

            } catch (FileNotFoundException e) {

                System.out.println(
                        "Valid URL, and a valid host, but page specified in the URL does not exist.");

            }
        } while (in[0] == null);
        System.out.print("Connection Established. Please Enter tag: ");
        String tag = url.next();
        System.out.print("Enter the file name: ");
        String file = url.next();
        File outfile = new File(file);
        PrintWriter outWrite = new PrintWriter(outfile);//write to outer files
        Scanner scanner = new Scanner(in[0]);
        Scanner scanner2 = new Scanner(in[1]);
        Pattern p = Pattern.compile("<" + tag + ">");//pattern for empty tags
        Pattern q = Pattern.compile("<" + tag
                                    + "\\s+(\\w+)=\"[^\"]+\">");//pattern for filled tags
        String smatch;

        int counter = 0;
        while (((smatch = scanner.findWithinHorizon(p, 0)) != null) || ((smatch = scanner2.findWithinHorizon(
                                                                         q, 0)) != null)) {

            outWrite.println(smatch);
            counter++;

        }
        in[0].close();
        in[1].close();
        scanner.close();
        outWrite.close();
        System.out.println("Wrote " + counter + " <" + tag + "> tags to " + file);
        System.out.print("Goodbye!");
    }

    /**
     * Get input streams from a url
     *
     * @param address:- represents url
     * @return BufferedInputStreams[] for empty and filled tag
     * @throws IOException
     */
    public static BufferedInputStream[] getStream(String address) throws IOException {
        BufferedInputStream[] in = new BufferedInputStream[2];
        in[0] = null;
        in[1] = null;

        URL locator = new URL(address);
        in[0] = new BufferedInputStream(locator.openStream());
        in[1] = new BufferedInputStream(locator.openStream());

        return in;

    }
}
