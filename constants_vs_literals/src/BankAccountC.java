/**
 * Provide basic API for operations on a bank account
 *
 * USING CLASS CONSTANTS
 *
 * @author falcon
 * @version 2017-12-05
 */
public class BankAccountC {

    // class constants
    private static final double MONTHLY_MAX_WITHDRAWALS = 3000.0;
    private static final double ANNUAL_INTEREST_RATE    = 0.015;
    private static final double ANNUAL_ACCOUNT_COST     = 25.0;
    private static final double ACCOUNT_MAX_AMOUNT      = 100000.0;

    private static final boolean SUCCESS                = true;
    private static final boolean FAILURE                = false;

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
     * if yes perform the withdrawal and return true,
     * otherwise return false
     *
     * @param amount the amount to withdraw
     * @return if the withdrawal was successful
     */
    public boolean withdraw(double amount) {
        if ((this.withdrawalsThisMonth + amount <= MONTHLY_MAX_WITHDRAWALS) && (this.totalAmount - amount >=0)) {
            this.totalAmount -= amount;
            this.withdrawalsThisMonth += amount;
            return SUCCESS;
        }
        else return FAILURE;
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
        if (this.totalAmount + amount <= ACCOUNT_MAX_AMOUNT) {
            this.totalAmount += amount;
            return SUCCESS;
        }
        else return FAILURE;
    }



    /**
     * Performs end of year computations to add interest
     * and send yearly account cost to owner
     */
    public void annualUpdate() {
        double interest = this.totalAmount * ANNUAL_INTEREST_RATE;
        this.totalAmount += interest;

        String message = "Total amount at end of year: " + this.totalAmount + "\n" +
                         "Interest at end of year: " + interest + "\n" +
                         "Account cost: " + ANNUAL_ACCOUNT_COST + "\n";
        this.owner.sendDocument(message);
    }
}
