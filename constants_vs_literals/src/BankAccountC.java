/**
 * Provide basic API for operations on a bank account
 *
 * @author falcon
 * @version 2017-12-05
 */
public class BankAccountC {

    private static final double MONTHLY_MAX_WITHDRAWALS = 3000.0;
    private static final double MONTHLY_INTEREST_RATE = 0.002;
    private static final double ANNUAL_ACCOUNT_COST = 25.0;

    // instance variables
    private double totalAmount;
    private double withdrawalsThisMonth;
    private Util.Person owner;

    /**
     * Constructor for objects of class BankAccountC
     */
    public BankAccountC(String ownerName, double initialAmount) {
        this.owner = new Util.Person(ownerName);
        this.totalAmount = initialAmount;
    }

    /**
     * Given an amount to withdraw, check if it is possible and
     * if yes perform the withdrawal and return true if successful,
     * otherwise return false
     *
     * @param amount the amount to withdraw
     * @return if the withdrawal was successful
     */
    public boolean withdraw(double amount) {
        // if monthly amount available and enough money in account
        if ((withdrawalsThisMonth < MONTHLY_MAX_WITHDRAWALS) && (totalAmount - amount > 0)) {
            totalAmount -= amount;
            withdrawalsThisMonth += amount;
            return true;
        }
        else return false;
    }
}
