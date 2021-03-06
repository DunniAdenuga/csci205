/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 1, 2015
 * Time: 10:49:54 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCountClient
 * Description: Test WordCount
 *
 * ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Test Word Count and display results using JOptionPane
 *
 * @author ia005
 */
public class WordCountClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean check;
        do {
            check = true;
            JFileChooser chooser;
            WordCount wc;
            try {
                chooser = new JFileChooser(".");
                int stuff = chooser.showOpenDialog(null);
                if (stuff == JFileChooser.CANCEL_OPTION) {
                    break;
                }
                wc = new WordCount(chooser.getSelectedFile());
                wc.doIt();
                //System.out.println("i'm here 1");
                int choice = JOptionPane.showConfirmDialog(null,
                                                           wc.toString() + "\n Try Again ?",
                                                           "Word Count Results",
                                                           JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    check = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File Not Found.",
                                              "Error Message",
                                              JOptionPane.ERROR_MESSAGE);
                check = false;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                                              "IO issue. Program Terminated!",
                                              "Error Message",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } while (check == false);
    }

}
