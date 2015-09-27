/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 26, 2015
 * Time: 7:56:09 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Contractor
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.util.Date;

/**
 *
 * @author Dunni Adenuga
 */
public class Contractor implements Payable {
    private int id;
    private String firstName;
    private String lastName;
    private int ssNum;
    private double hourlyRate;

    public Contractor(int id, String firstName, String lastName, int ssNum,
                      double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public void setSsNum(int ssNum) {
        this.ssNum = ssNum;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return String.format(
                "Contractor: " + id + "," + lastName + "," + firstName + "," + ssNum + ",%.2f",
                hourlyRate);

    }

    @Override
    public double calculatePay(double numHrs) {
        return numHrs * hourlyRate;
    }

    @Override
    public String getPayTo() {
        return firstName + " " + lastName;
    }

    @Override
    public String getPayMemo() {
        return "Contractor ID: " + id + ", Pay Date: " + HRUtility.dateToStr(
                new Date());
    }

}
