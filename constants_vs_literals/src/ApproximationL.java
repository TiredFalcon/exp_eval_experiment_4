/**
 * Provides function that approximate values of functions
 *
 * USING CLASS CONSTANTS
 *
 * @author falcon
 * @version 2017-12-05
 */
public class ApproximationL {

    // class constants
    public static final double PI                  = 3.1415926536;



    /**
     * Given a number x, computes an approximation of sin(x)
     * using a Maclaurin series (Taylor expansion about x0 = 0)
     *
     * @param x the number for which the value of sin is sought
     * @return the result of sin evaluated at x
     */
    public static double sin(double x) {

        double sumNew, sumOld, term;
        int i = 1;
        term = sumNew = x;

        for (int iteration = 1; iteration < 100; ++iteration) {

            // compute new term of series: (-1)^k * (x^(2k + 1))/((2k + 1)!)
            sumOld = sumNew;
            term = term * x * x;
            i++;
            term = term / i;
            i++;
            term = term / i;

            // invert sign because it's an alternating series, then add to total
            term = -term;
            sumNew = sumOld + term;

            // check if series is converging
            double error = sumNew - sumOld;
            if (error < 1e-10 && -error < 1e-10) break;
        }

        return sumNew;
    }



    /**
     * Compute an approximated value of e (Euler's number)
     * using an infinite series up to a set number of terms
     *
     * @return the value of e
     */
    public static double e() {
        double factor = 1.0;
        double e = 1.0;

        // e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ...
        for (int i = 1; i <= 20; i++) {
            factor = factor * i;
            e += 1.0/factor;
        }

        return e;
    }
}
