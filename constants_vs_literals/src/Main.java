/**
 * Created by falcon on 05.12.17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Started");
        System.out.println();

        System.out.println("Running BankAccount");
        System.out.println("create new account with 1000.0");
        BankAccountC account = new BankAccountC("falcon", 1000.0);
        System.out.println("withdraw 100: " + account.withdraw(100.0));
        System.out.println("withdraw 1000: " + account.withdraw(1000.0));
        System.out.println("deposit 700: " + account.deposit(700.0));
        account.annualUpdate();
        System.out.println();


        System.out.println("Running Approximation");
        System.out.println("sin(pi/4) = " + ApproximationC.sin(ApproximationC.PI / 4.0));
        System.out.println("e = " + ApproximationC.e());
        System.out.println();
    }
}
