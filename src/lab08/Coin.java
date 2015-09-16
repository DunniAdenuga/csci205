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
 * Description:Enum Type
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
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25),
    DOLLAR(1.00);

    /**
     * Value of each enumerated type
     */
    private double valueCoin;

    /**
     * initialize property(value of coin)
     *
     * @param coin - value of each coin
     */
    Coin(double coin) {
        valueCoin = coin;
    }

    /**
     * Return value of coin
     *
     * @return value of coin
     */
    double getValue() {
        return valueCoin;
    }
}
