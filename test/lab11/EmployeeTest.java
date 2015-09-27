/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 24, 2015
 * Time: 2:53:43 PM
 *
 * Project: csci205
 * Package: lab11
 * File: EmployeeTest
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
public class EmployeeTest {

    private Employee emp;

    public EmployeeTest() {

    }

    @Before
    public void setUp() throws ParseException {
        emp = new Employee(0, "Bae", "Bro", 9635956,
                           HRUtility.strToDate("2007-12-20"),
                           100000);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of changeName method, of class Employee.
     */
    @Test
    public void testChangeName() {
        System.out.println("changeName");
        String first = "Dotun";
        String last = "John";
        emp.changeName(first, last);
        assertEquals(emp.getFirstName(), first);
        assertEquals(emp.getLastName(), last);
    }

    /**
     * Test of calculate Pay method, of class Employee
     */
    @Test
    public void testCalculatePay() {
        System.out.println("calculatePay");
        double expResult = (emp.getSalary() / 52 / 40) * 30;
        double result = emp.calculatePay(30);
        assertEquals(expResult, result, 1E-12);
        expResult = ((emp.getSalary() / 52 / 40) * 40) + ((emp.getSalary() / 52 / 40) * 20 * 1.5);
        result = emp.calculatePay(60);
        assertEquals(expResult, result, 1E-12);
    }

    /**
     * Test of raiseSalary method, of class Employee.
     */
    @Test
    public void testRaiseSalary() {
        System.out.println("raiseSalary");
        double salaryAdj = 100000;
        double expResult = 200000;
        double result = emp.raiseSalary(salaryAdj);
        assertEquals(expResult, result, 1E-12);

    }

    /**
     * Test of equals method, of class Employee.
     */
    @Test
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = emp.equals(obj);
        assertEquals(expResult, result);

        Employee e2 = new Employee(0, "Bae", "Bro", 9635956,
                                   HRUtility.strToDate("2007-12-20"),
                                   100000);
        expResult = true;
        result = emp.equals(e2);
        assertEquals(expResult, result);

        Employee e3 = new Employee(0, "Bae", "Bro", 6395956,
                                   HRUtility.strToDate("2007-12-20"),
                                   100000);
        expResult = false;
        result = emp.equals(e3);
        assertEquals(expResult, result);
    }

}
