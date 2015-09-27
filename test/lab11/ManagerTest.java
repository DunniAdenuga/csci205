/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 24, 2015
 * Time: 7:19:19 PM
 *
 * Project: csci205
 * Package: lab10
 * File: ManagerTest
 * Description:
 *Test Manager Class
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ia005
 */
public class ManagerTest {
    private ArrayList<Employee> listOfEmps;
    private Manager mgr;

    public ManagerTest() {

    }

    @Before
    public void setUp() throws ParseException, ManagerException {

        mgr = new Manager(1, "Wale", "Adenuga", 582964263,
                          HRUtility.strToDate("2014-07-2"),
                          2000000, "ENGINEERING");
        Employee e1 = new Employee(1, "Dunni", "Adenuga", 75315956,
                                   HRUtility.strToDate("2015-01-20"),
                                   1000000);
        Employee e2 = new Employee(2, "Ebun", "Adenuga", 2569856,
                                   HRUtility.strToDate("2005-11-20"),
                                   1000000);
        Employee e3 = new Employee(201, "Bolawa", "Adenuga", 52753156,
                                   HRUtility.strToDate("2012-01-20"),
                                   1000000);
        Employee e4 = new Employee(4, "Oyinkan", "Quadri", 89325956,
                                   HRUtility.strToDate("2015-01-27"),
                                   1000000);
        Employee e5 = new Employee(0, "Bae", "Bro", 9635956,
                                   HRUtility.strToDate("2007-12-20"),
                                   1000000);
        Employee e6 = new Employee(200, "Ruckus", "Jumper", 41555956,
                                   HRUtility.strToDate("2000-01-12"),
                                   1000000);
        listOfEmps = new ArrayList<>();
        listOfEmps.add(e1);
        listOfEmps.add(e2);
        listOfEmps.add(e3);
        listOfEmps.add(e4);
        listOfEmps.add(e5);
        listOfEmps.add(e6);
        mgr.addEmployee(listOfEmps.get(0));
        mgr.addEmployee(listOfEmps.get(1));
        mgr.addEmployee(listOfEmps.get(2));

    }

    @After
    public void tearDown() {
        listOfEmps.clear();
    }

    /**
     * Test of addEmployee method, of class Manager.
     */
    @Test
    public void testAddEmployee() throws Exception {
        System.out.println("addEmployee");
        mgr.addEmployee(listOfEmps.get(3));
        assertTrue(mgr.getEmpList().contains(listOfEmps.get(3)));
    }

    /**
     * Test Exception
     *
     * @throws Exception
     */
    @Test(expected = ManagerException.class)
    public void testAddEmployeeException() throws Exception {
        mgr.addEmployee(listOfEmps.get(0));
    }

    /**
     * Test of getEmpList method, of class Manager.
     */
    @Test
    public void testGetEmpList() {
        System.out.println("getEmpList");
        List<Employee> expResult = new ArrayList<Employee>();
        expResult.add(listOfEmps.get(0));
        expResult.add(listOfEmps.get(1));
        expResult.add(listOfEmps.get(2));
        List<Employee> result = mgr.getEmpList();
        assertEquals(expResult, result);

    }

    /**
     * Test of removeEmployee method, of class Manager.
     */
    @Test
    public void testRemoveEmployee() throws Exception {
        System.out.println("removeEmployee");
        mgr.removeEmployee(listOfEmps.get(2));
        assertFalse(mgr.getEmpList().contains(listOfEmps.get(2)));

    }

    /**
     * Test Exception
     *
     * @throws Exception
     */
    @Test(expected = ManagerException.class)
    public void testRemoveEmployeeException() throws Exception {
        mgr.removeEmployee(listOfEmps.get(5));
    }

}
