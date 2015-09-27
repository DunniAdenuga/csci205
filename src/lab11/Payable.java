/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 26, 2015
 * Time: 6:55:14 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Payable
 * Description:
 *
 * ****************************************
 */
package lab11;

/**
 *
 * @author Dunni Adenuga
 */
public interface Payable {

    /**
     * given	a	parameter	representing	the	number	of	hours	to	pay	for,	this
     * should return	a	double	representing the	amount	of	money	that	should	be
     * paid.	This	represents	the amount	of	money	that	the	check	will	be	written
     * for
     *
     * @param numHrs - number of hours
     * @return amount to be written on check
     */
    public double calculatePay(double numHrs);

    /**
     * @return a	string	that	should	be	placed	in	the	"Pay	To:"	field on	the
     * check	to	be printed
     */
    public String getPayTo();

    /**
     * @return	a	string	that	should	be	placed	in	the	memo field	of	the	check
     */
    public String getPayMemo();
}
