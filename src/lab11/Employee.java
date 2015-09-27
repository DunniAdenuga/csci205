/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * TODO - Enter the details below!
 * Name: Dunni Adenuga
 * Date: 23/9/2015
 * Time: 8:19 AM
 *
 * Project: csci205
 * Package: lab11
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab11;

/**
 * A basic representation for an Employee.
 *
 * @author Brian King
 */
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
enum SortType {
    SORT_BY_LASTNAME,
    SORT_BY_ID;
}

public class Employee implements Payable, Comparable<Employee> {

    private static HashSet<Integer> setOfIDs = new HashSet<Integer>();
    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;
    private static SortType sortType = SortType.SORT_BY_ID;

    /**
     * Explicit construct to create new employee
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        if (setOfIDs.add(empID) == false || empID <= 0) {
            this.empID = generateID();
        } else {
            this.empID = empID;
            setOfIDs.add(empID);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Generate IDs
     */
    private static Integer generateID() {
        int i = 1;

        while (setOfIDs.add(i) == false) {
            i++;
        }
        return i;
    }

    /**
     * Set Sort Type: ID or last name
     *
     * @param x - choice
     */
    public static void setSortType(SortType x) {
        sortType = x;
    }

    /**
     * Compare
     *
     * @param comp
     * @return
     */
    @Override
    public int compareTo(Employee comp) {
        int i = 0;
        if (sortType == SortType.SORT_BY_ID) {
            if (this.empID < comp.getEmpID()) {
                i = -1;
            } else if (this.empID > comp.getEmpID()) {
                i = 1;
            } else if (this.empID == comp.getEmpID()) {
                i = 0;
            }
        } else if (sortType == SortType.SORT_BY_LASTNAME) {
            if (this.lastName.compareTo(comp.getLastName()) < 0) {
                i = -1;
            } else if (this.lastName.compareTo(comp.getLastName()) > 0) {
                i = 1;
            } else if (this.lastName.compareTo(comp.getLastName()) == 0) {
                i = 0;
            }
        }
        return i;
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRUtility.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssNum != other.ssNum) {
            return false;
        }
        return true;
    }

    @Override
    public double calculatePay(double numHrs) {
        double rate = salary / 52 / 40;
        double pay = 0;
        if (numHrs >= 40) {
            pay = (rate * 40) + (1.5 * rate * (numHrs - 40));
        } else {
            pay = rate * numHrs;
        }
        return pay;
    }

    @Override
    public String getPayTo() {
        return firstName + " " + lastName;
    }

    @Override
    public String getPayMemo() {
        return "Employee ID: " + empID + ", Pay Date: " + HRUtility.dateToStr(
                new Date());
    }

}
