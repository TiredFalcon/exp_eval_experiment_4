/**
 * Provide basic API for operations on a bank account
 *
 * USING LITERALS
 *
 * @author falcon
 * @version 2017-12-05
 */
public class BankAccountL {

    // instance variables
    private double totalAmount;
    private double withdrawalsThisMonth;
    private Util.Person owner;



    /**
     * Constructor for objects of class BankAccountL
     */
    public BankAccountL(String ownerName, double initialAmount) {
        this.owner = new Util.Person(ownerName);
        this.totalAmount = initialAmount;
    }



    /**
     * Given an amount to withdraw, check if it is possible and
     * if yes perform the withdrawal and return true,
     * otherwise return false
     *
     * @param amount the amount to withdraw
     * @return if the withdrawal was successful
     */
    public boolean withdraw(double amount) {
        if ((withdrawalsThisMonth < 3000.0) && (totalAmount - amount > 0)) {
            totalAmount -= amount;
            withdrawalsThisMonth += amount;
            return true;
        }
        else return false;
    }



    /**
     * Given an amount to deposit, check if it is possible and
     * if yes deposit the amount and return true,
     * otherwise return false
     *
     * @param amount the amount to deposit
     * @return if the deposit was successful
     */
    public boolean deposit(double amount) {
        if (this.totalAmount + amount <= 100000.0) {
            totalAmount += amount;
            return true;
        }
        else return false;
    }



    /**
     * Performs end of year computations to add interest
     * and send yearly account cost to owner
     */
    public void annualUpdate() {
        double interest = this.totalAmount * 0.015;
        this.totalAmount += interest;

        String message = "Total amount at end of year: " + this.totalAmount + "\n" +
                "Interest at end of year: " + interest + "\n" +
                "Account cost: " + 25.0 + "\n";
        this.owner.sendDocument(message);
    }
}
