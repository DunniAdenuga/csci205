/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 15, 2015
 * Time: 1:20:38 PM
 *
 * Project: csci205
 * Package: lab08
 * File: CoinCollectionClient
 * Description: Using Graphics:- JOptionPane
 *
 * ****************************************
 */
package lab08;

import javax.swing.JOptionPane;

/**
 * @author Dunni Adenuga
 */
public class CoinCollectionClient {

    /**
     * Test CoinCollection Class using graphical interface
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean quit = false;
        CoinCollection myCoins = new CoinCollection();

        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        while (quit == false) {
            String stuff = new String(myCoins.toString());
            stuff = stuff + "\n" + "Select an action: ";

            AddRemoveChoices[] options = new AddRemoveChoices[AddRemoveChoices.values().length];
            options = AddRemoveChoices.values();

            int choice = JOptionPane.showOptionDialog(null, stuff,
                                                      "Add or Remove ?",
                                                      JOptionPane.YES_NO_CANCEL_OPTION,
                                                      JOptionPane.INFORMATION_MESSAGE,
                                                      null,
                                                      options, null);

            if ((choice == JOptionPane.CLOSED_OPTION) || (choice == AddRemoveChoices.DONE.ordinal())) {
                quit = true;
            } else if (choice == AddRemoveChoices.ADD.ordinal()) {
                Coin[] selectionValues = new Coin[Coin.values().length];
                selectionValues = Coin.values();
                Coin answer;
                answer = (Coin) JOptionPane.showInputDialog(null,
                                                            "Select coin type:",
                                                            "Coin Selection",
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            selectionValues,
                                                            null);
                if (answer == null) {
                    quit = true;
                } else {
                    String coinNum2 = JOptionPane.showInputDialog(
                            null,
                            "How many do you want to add ?",
                            "Add Coins",
                            JOptionPane.OK_CANCEL_OPTION);//how do i know if they choose cancel ?
                    if (coinNum2 == null) {
                        quit = true;
                    } else {
                        int coinNum3 = Integer.parseInt(coinNum2);
                        myCoins.addCoins(answer, coinNum3);

                    }
                }
            } else if (choice == AddRemoveChoices.REMOVE.ordinal()) {
                Coin[] selectionValues = new Coin[Coin.values().length];
                selectionValues = Coin.values();
                Coin answer;
                answer = (Coin) JOptionPane.showInputDialog(null,
                                                            "Select coin type:",
                                                            "Coin Selection",
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            selectionValues,
                                                            null);
                if (answer == null) {
                    quit = true;
                } else {
                    String coinNum2 = JOptionPane.showInputDialog(
                            null,
                            "How many do you want to remove ? Max =" + myCoins.getCount(
                                    answer),
                            "Remove Coins",
                            JOptionPane.OK_CANCEL_OPTION);//how do i know if they choose cancel ?
                    if (coinNum2 == null) {
                        quit = true;
                    } else {
                        int coinNum3 = Integer.parseInt(coinNum2);
                        myCoins.removeCoins(answer, coinNum3);

                    }
                }
            }
        }

        String finish = new String("You have:");
        finish = finish + "\n" + myCoins.toString();
        finish = finish + "\n" + "Goodbye!";

        JOptionPane.showMessageDialog(null, finish,
                                      "Goodbye!",
                                      JOptionPane.INFORMATION_MESSAGE
        );
    }
}
