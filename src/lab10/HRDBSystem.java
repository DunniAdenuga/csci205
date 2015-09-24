/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 23, 2015
 * Time: 8:18:49 AM
 *
 * Project: csci205
 * Package: lab10
 * File: HRDBSystem
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author ia005
 */
public class HRDBSystem {

    public static void main(String[] args) throws ParseException {

        Manager m1 = new Manager(0, "Bayo", "Adenuga", 582964000,
                                 HRUtility.strToDate("2013-07-2"),
                                 1000000, "ADMIN");
        Manager m2 = new Manager(1, "Wale", "Adenuga", 582964263,
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

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);
        HRUtility.displayEmployee(m1);
        HRUtility.displayEmployee(m2);
        HRUtility.displayEmployees(empList);
    }

}
