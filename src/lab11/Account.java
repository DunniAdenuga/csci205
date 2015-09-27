/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Sep 26, 2015
 * Time: 9:59:15 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Account
 * Description:
 *
 * ****************************************
 */
package lab11;

/**
 *
 * @author ia005
 */
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

public class Account {
    /**
     * store cash balance in account
     */
    private double balance;

    public Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Add amount money to the balance
     *
     * @param amount
     */
    public void credit(double amount) {
        balance = balance + amount;
    }

    /**
     * Remove Amount money from the balance
     *
     * @param amount
     * @throws lab11.InsufficientFundsException
     */
    public void debit(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            throw new InsufficientFundsException(String.format(
                    "INSUFFICIENT FUNDS! Required: $ %.2f Available: $ %.2f ",
                    amount, balance));
        }
    }

    /**
     * Print check made to payee
     *
     * @param payee
     * @param hoursBilled
     * @throws InsufficientFundsException
     */
    public void processCheck(Payable payee, double hoursBilled) throws InsufficientFundsException {
        double pay = payee.calculatePay(hoursBilled);
        debit(pay);
        System.out.println("Pay to:   " + payee.getPayTo());
        System.out.println(String.format("Pay amount: $ %.2f", pay));
        System.out.println("Pay memo: " + payee.getPayMemo());
    }

    @Override
    public String toString() {
        return String.format("Account balance: $ %.2f", balance);
    }

}
