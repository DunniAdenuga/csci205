/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 14, 2015
 * Time: 8:45:00 AM
 *
 * Project: csci205
 * Package: lab08
 * File: Coin
 * Description:
 *
 * ****************************************
 */
package lab08;

/**
 * Coin - A simple enumerated type to represent the different types of coins
 *
 * @author Dunni Adenuga
 */
public enum Coin {
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25);

    private double valueCoin;

    Coin(double coin) {
        valueCoin = coin;
    }

    double getValue() {
        return valueCoin;
    }
}
