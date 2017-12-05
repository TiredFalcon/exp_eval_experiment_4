/**
 * Created by falcon on 05.12.17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Started");
        System.out.println();



        System.out.println("Running BankAccountC");
        System.out.println("create new account with 1000.0");
        BankAccountC accountC = new BankAccountC("falcon", 1000.0);
        System.out.println("withdraw 100: " + accountC.withdraw(100.0) + " (should be true)");
        System.out.println("withdraw 1000: " + accountC.withdraw(1000.0) + " (should be false)");
        System.out.println("deposit 700: " + accountC.deposit(700.0) + " (should be true)");
        accountC.annualUpdate();
        System.out.println();



        System.out.println("Running BankAccountL");
        System.out.println("create new account with 1000.0");
        BankAccountL accountL = new BankAccountL("falcon", 1000.0);
        System.out.println("withdraw 100: " + accountL.withdraw(100.0) + " (should be true)");
        System.out.println("withdraw 1000: " + accountL.withdraw(1000.0) + " (should be false)");
        System.out.println("deposit 700: " + accountL.deposit(700.0) + " (should be true)");
        accountL.annualUpdate();
        System.out.println();



        System.out.println("Running ApproximationC");
        System.out.println("sin(pi/4) = " + ApproximationC.sin(ApproximationC.PI / 4.0) + " (should be 0.7071067811883722)");
        System.out.println("e = " + ApproximationC.e() + " (should be 2.7182818284590455)");
        System.out.println();



        System.out.println("Running ApproximationL");
        System.out.println("sin(pi/4) = " + ApproximationL.sin(ApproximationL.PI / 4.0) + " (should be 0.7071067811883722)");
        System.out.println("e = " + ApproximationL.e() + " (should be 2.7182818284590455)");
        System.out.println();
    }
}
