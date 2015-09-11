/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 9, 2015
 * Time: 9:07:17 PM
 *
 * Project: csci205
 * Package: lab06
 * File: CashRegister
 * Description:
 *
 * ****************************************
 */
package lab06;

/**
 *
 * This cash register stores cash. It also keeps track of the number of
 * transactions.
 *
 * @author Dunni Adenuga
 * @version 0.1
 */
public class CashRegister {
    /**
     * The name of the cash drawer
     */
    private String drawerName;

    /**
     * The amount of cash in the drawer
     */
    private double cashDrawer;

    /**
     * Are we currently in a transaction ?
     */
    private boolean registerState;

    /**
     * The total amount of the transaction
     */
    private double transTotal;

    /**
     * The total number of items purchased in this transaction so far
     */
    private int numItemsInTrans;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * Default constructor
     */
    public CashRegister() {
        this.drawerName = "Default";
        this.amountPaid = 0;
        this.cashDrawer = 0;
        this.numItemsInTrans = 0;
        this.transTotal = 0;
        this.registerState = false;
    }

    /**
     * Initialize an empty cash register with a specified name
     *
     * @param sName -the name of the register
     */
    public CashRegister(String sName) {
        this();
        drawerName = sName;
    }

    /**
     * This method initializes the amount of cash to be placed in drawer.
     *
     * @param initCash - amount of cash in drawer
     */
    public void startDay(double initCash) {
        cashDrawer = initCash;
    }

    /**
     * This method returns the amount of cash in the drawer and empties the cash
     * out of the drawer
     *
     * @return the amount of cash in the drawer
     */
    public double finishDay() {
        double cashLeft = cashDrawer;
        cashDrawer = 0;
        amountPaid = 0;
        transTotal = 0;
        numItemsInTrans = 0;
        return cashLeft;
    }

    /**
     * This method helps to check if a transaction can start
     *
     * @return true if can start and false if not
     */
    public boolean startTransaction() {
        boolean check;
        if ((cashDrawer != 0) && (isInTransaction() != true)) {
            check = true;
        } else {
            check = false;
        }
        amountPaid = 0;
        transTotal = 0;
        numItemsInTrans = 0;
        return check;
    }

    /**
     * This method checks if user is in middle of transaction.
     *
     * @return true or false
     */
    public boolean finishTransaction() {
        boolean check = true;
        if ((transTotal - amountPaid) != 0) {
            check = false;
        } else if (isInTransaction() == true) {
            check = false;
        }

        return check;
    }

    /**
     * This method adds amount of item being purchased to the transaction total
     * and increases number of items
     *
     * @param amountItem - amount of item being purchased
     */
    public void scanItem(double amountItem) {
        transTotal = transTotal + amountItem;
        registerState = true;
        numItemsInTrans++;
    }

    /**
     * This method returns the value of the total amount of the transaction
     *
     * @return total amount of transaction
     */
    public double getTransactionTotal() {
        return transTotal;
    }

    /**
     * This method returns the number of items in a transaction
     *
     * @return number of items
     */
    public int getNumItemsInTrans() {
        return numItemsInTrans;
    }

    /**
     * This method returns the total amount of the current transaction
     *
     * @return total amount of current transaction
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * This method returns the name of the register
     *
     * @return name of register
     */
    public String getName() {
        return drawerName;
    }

    /**
     * This method checks if the register is currently in a transaction
     *
     * @return the register state
     */
    public boolean isInTransaction() {
        return registerState;
    }

    /**
     * This method returns the amount that is owed for the current transaction
     *
     * @return the amount owed
     */
    public double getAmountOwed() {
        return (transTotal - amountPaid);
    }

    /**
     * This method changes the name of the register
     *
     * @param sName- new register name
     */
    public void setName(String sName) {
        drawerName = sName;
    }

    /**
     * This method calculates amount owed for transaction and adds amount paid
     * to the drawer
     *
     * @param customerPay - amount customers pays for a transaction
     * @return change, if +, change is due,if 0, exact amount is paid, if -,
     * customer pays
     */
    public double collectPayment(double customerPay) {

        double change = (customerPay - transTotal + amountPaid);
        if ((change >= 0) && (amountPaid == 0)) {
            cashDrawer = cashDrawer + transTotal;
            registerState = false;//transaction done
        } else if ((change >= 0) && (amountPaid != 0)) {
            cashDrawer = cashDrawer + customerPay - change;
            registerState = false;//transaction done
        }
        if (change < 0) {
            cashDrawer = cashDrawer + customerPay;
            registerState = true;
            //transTotal = transTotal - customerPay;
        }
        if (change >= 0) {
            amountPaid = transTotal;
            //registerState = false;//register done
        } else {
            amountPaid = amountPaid + customerPay;
        }
        return change;
    }

    /**
     * This method tells the state of all variables in the object
     *
     * @return current state of object
     */
    public String toString() {
        String answer;
        if (registerState == true) {
            answer = "Name of Drawer: " + drawerName + "\n"
                     + "Amount Paid: $" + amountPaid + "\n"
                     + "Cash In Drawer: $" + cashDrawer + "\n"
                     + "Num of Items in Current Transaction: " + numItemsInTrans + "\n"
                     + "Total amount of transaction: $" + transTotal + "\n";
        } else {
            answer = "Name of Drawer: " + drawerName + "\n"
                     + "Amount Paid: $" + amountPaid + "\n"
                     + "Cash In Drawer: $" + cashDrawer + "\n"
                     + "Num of Items in Current Transaction: " + numItemsInTrans + "\n"
                     + "Register NOT In Transaction " + "\n"
                     + "Total amount of transaction: $" + transTotal + "\n";
        }
        return answer;
    }
}
