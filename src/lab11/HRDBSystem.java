/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 23, 2015
 * Time: 8:18:49 AM
 *
 * Project: csci205
 * Package: lab11
 * File: HRDBSystem
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ia005
 */
public class HRDBSystem {

    public static void main(String[] args) throws ParseException, ManagerException {

        Manager m1 = new Manager(0, "Bayo", "Adenuga", 582964000,
                                 HRUtility.strToDate("2013-07-2"),
                                 1000000, "ADMIN");
        Manager m2 = new Manager(1, "Wale", "Adenuga", 582964263,
                                 HRUtility.strToDate("2014-07-2"),
                                 2000000, "ENGINEERING");
        Employee e1 = new Employee(1, "Dunni", "Adenuga", 75315956,
                                   HRUtility.strToDate("2015-01-20"),
                                   50000);
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
        /*e1.raiseSalary(50000);
         System.out.println(e1);
         e2.changeName("Bob", "Joe");//commenting out code not needed for this lab
         System.out.println(e2);*/
        Contractor cont1 = new Contractor(73, "Builder", "Bob", 342942039, 30.00);
        System.out.println(cont1);

        Contractor cont2 = new Contractor(1, "Odin", "Thor", 692942839, 3000.00);
        System.out.println(cont2);
        /*m1.addEmployee(e1);
         m1.addEmployee(e2);
         m1.addEmployee(e3);//commenting out code not needed for this lab
         m2.addEmployee(e4);
         m2.addEmployee(e5);
         m2.addEmployee(e6);*/
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);
        /*HRUtility.displayEmployee(m1);
         HRUtility.displayEmployee(m2);
         HRUtility.displayEmployees(empList);//commenting out code not needed for this lab
         HRUtility.displayManager(m1);
         System.out.println();
         HRUtility.displayManager(m2);*/
        System.out.println();

        //Exercise 8
        // Create an account
        Account acc = new Account(2000.0);
        System.out.println(acc);
        // Test out a couple of payments, intentionally throwing an exception
        // with the second payment
        try {
            System.out.println("TEST: Printing a check to employee id: "
                               + empList.get(0).getEmpID());
            acc.processCheck(empList.get(0), 50); // 40 hrs + 10 hrs overtime
            System.out.println("TEST: Printing a check to contractor id: "
                               + cont1.getId());
            acc.processCheck(cont1, 35);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        // Verify that funds were debited from the account
        System.out.println(acc);

        System.out.println();
        //Exercise 10 Test
        System.out.println("*** Employees BEFORE SORT ***");
        HRUtility.displayEmployees(empList);
        System.out.println("*** Employees AFTER SORT_BY_LASTNAME ***");
        Employee.setSortType(SortType.SORT_BY_LASTNAME);
        Collections.sort(empList);
        HRUtility.displayEmployees(empList);
        System.out.println("*** Employees AFTER SORT_BY_ID ***");
        Employee.setSortType(SortType.SORT_BY_ID);
        Collections.sort(empList);
        HRUtility.displayEmployees(empList);
    }

}
