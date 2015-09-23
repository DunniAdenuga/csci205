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

import java.util.Date;

/**
 *
 * @author ia005
 */
public class HRDBSystem {

    public static void main(String[] args) {
        Employee emp = new Employee(0, "Dunni", "Adenuga", 753159, new Date(),
                                    1000000);
        Manager man = new Manager(1, "Bayo", "Bello", 582964, new Date(),
                                  1000000, "ADMIN");

        System.out.println(emp);
        System.out.println(man);
    }

}
