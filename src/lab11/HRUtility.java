/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 24, 2015
 * Time: 3:46:24 PM
 *
 * Project: csci205
 * Package: lab11
 * File: HRUtility
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dunni Adenuga
 */
public final class HRUtility {
    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    public static void displayEmployee(Employee emp) {
        if (emp instanceof Manager) {
            System.out.println(
                    emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + " [MANAGER]");
        } else {
            System.out.println(
                    emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName());
        }
    }

    public static void displayEmployees(List<Employee> listOfEmps) {

        for (int i = 0; i < listOfEmps.size(); i++) {
            displayEmployee(listOfEmps.get(i));
        }

    }

    public static void displayManager(Manager m) {
        System.out.println(
                "Manager: " + m.getFirstName() + " " + m.getLastName());
        System.out.println("Department: " + m.getDeptName());
        System.out.println("# Employees: " + m.getEmpList().size());
        displayEmployees(m.getEmpList());
    }

    /**
     * Helper method to parse a date string into a date object. This is really
     * here just to show how to deal with an exception that may be thrown in a
     * method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     * Convert a Date object to a string using
     * empDateFormat{@link SimmpleDateFormat}
     *
     * @param date the value of date
     * @return a String representing the Date
     */
    public static String dateToStr(Date date) {
        return empDateFormat.format(date);
    }

}
