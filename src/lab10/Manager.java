/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 23, 2015
 * Time: 8:11:12 AM
 *
 * Project: csci205
 * Package: lab10
 * File: Manager
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.util.Date;

enum DeptType {
    ENGINEERING,
    HR,
    ADMIN,
    STAFF,
    OTHER;
}

public class Manager extends Employee {
    /**
     * Department Name
     */
    private DeptType deptName;

    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        try {
            this.deptName = DeptType.valueOf(deptName);
        } catch (IllegalArgumentException e) {
            this.deptName = DeptType.valueOf("OTHER");//Add to Other Department

        }
    }

    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, DeptType deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);

        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName.name();
    }

    public DeptType getDept() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = DeptType.valueOf(deptName);
    }

    public void setDept(DeptType deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName();

    }

}
