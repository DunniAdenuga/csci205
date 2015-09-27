/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 26, 2015
 * Time: 10:57:01 PM
 *
 * Project: csci205
 * Package: lab11
 * File: AccountTest
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ia005
 */
public class AccountTest {
    private Account acc;
    private Employee e1;

    public AccountTest() {
    }

    @Before
    public void setUp() throws ParseException {
        acc = new Account(500000);
        e1 = new Employee(20, "Bro", "Pope", 852369147, HRUtility.strToDate(
                          "2013-12-29"), 52600);
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of credit method, of class Account.
     */
    @Test
    public void testCredit() {
        System.out.println("credit");
        double expected = 600000;
        acc.credit(100000);
        assertEquals(expected, acc.getBalance(), 1.0E-10);
    }

    /**
     * Test of debit method, of class Account.
     *
     * @throws lab11.InsufficientFundsException
     */
    @Test
    public void testDebit() throws InsufficientFundsException {
        System.out.println("debit");
        double expected = 400000;
        acc.debit(100000);
        assertEquals(expected, acc.getBalance(), 1.0E-10);

    }

    /**
     * Test of processCheck method, of class Account.
     *
     * @throws lab11.InsufficientFundsException
     */
    @Test
    public void testProcessCheck() throws InsufficientFundsException {
        System.out.println("processCheck");
        double expected = acc.getBalance() - e1.calculatePay(200);
        acc.processCheck(e1, 200);
        assertEquals(expected, acc.getBalance(), 1.0E-10);//check if balance is updated
    }

    /**
     * Test InsufficientFundsException
     *
     * @throws lab11.InsufficientFundsException
     */
    @Test(expected = InsufficientFundsException.class)
    public void testProcessCheckInsufficientFundsException() throws InsufficientFundsException {
        System.out.println("processCheckInsufficientFundsException");
        acc.debit(499000);
        acc.processCheck(e1, 5000);
    }
}
