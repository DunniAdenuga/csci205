/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 17, 2015
 * Time: 6:52:53 PM
 *
 * Project: csci205
 * Package: lab09
 * File: CashRegisterTest
 * Description:
 *
 * ****************************************
 */
package lab09;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ia005
 */
public class CashRegisterTest {

    static final double EPSILON = 1.0E-12;

    public CashRegisterTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    @Test
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");
        CashRegister instance = new CashRegister();
        //Test the initial state = should have NO items
        assertEquals(0, instance.getPurchaseCount());

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);

        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    @Test
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");
        CashRegister instance = new CashRegister();
        List<Double> expResult = new LinkedList<Double>();
        //Test the initial state = should have NO items
        assertEquals(expResult, instance.getListOfPurchases());

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);

        expResult.add(0.55);
        expResult.add(1.27);
        List<Double> result = instance.getListOfPurchases();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    @Test
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        CashRegister instance = new CashRegister();
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);

    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    @Test
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        CashRegister instance = new CashRegister();

        instance.collectPayment(Money.DOLLAR, 5);
        instance.collectPayment(Money.QUARTER, 5);
        instance.collectPayment(Money.DIME, 5);
        instance.collectPayment(Money.NICKEL, 5);
        instance.collectPayment(Money.PENNY, 5);
        double expResult = 7.05;
        double result = instance.getPaymentCollected();
        assertEquals(expResult, result, EPSILON);

    }

    /**
     * Test of collectPayment's Exception, of class CashRegister.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCollectPaymentException() {

        CashRegister instance = new CashRegister();
        instance.collectPayment(Money.QUARTER, -3);

    }

    /**
     * Test of giveChange method, of class CashRegister.
     */
    @Test
    public void testGiveChange() throws Exception {
        System.out.println("giveChange");
        CashRegister instance = new CashRegister();

        instance.scanItem(2.00);
        instance.collectPayment(Money.DOLLAR, 3);
        double expResult = 1.0;
        double result = instance.giveChange();
        assertEquals(expResult, result, EPSILON);

    }

    /**
     * Test of giveChange's Exception, of class CashRegister.
     */
    @Test(expected = ChangeException.class)
    public void testGiveChangeException() throws Exception {

        CashRegister instance = new CashRegister();

        instance.scanItem(2.00);
        instance.collectPayment(Money.DOLLAR, 1);
        double result = instance.giveChange();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanItemLowException() {
        CashRegister instance = new CashRegister();
        instance.scanItem(-0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanItemHighException() {
        CashRegister instance = new CashRegister();
        instance.scanItem(1E6);
    }

}
