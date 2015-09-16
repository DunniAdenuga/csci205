/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 15, 2015
 * Time: 1:48:46 PM
 *
 * Project: csci205
 * Package: lab08
 * File: AddRemoveChoices
 * Description:
 *
 * ****************************************
 */
package lab08;

/**
 *
 * @author ia005
 */
public enum AddRemoveChoices {
    ADD("Add Coins"),
    REMOVE("Remove Coins"),
    DONE("Done");

    private String label;

    /**
     * Constructor
     */
    AddRemoveChoices(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }
}
