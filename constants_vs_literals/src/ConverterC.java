/**
 * Created by val on 05.12.17.
 */


public class ConverterC {

    /* CONSTANTS */

    // currencies
    final private double CHF_TO_EURO_FACTOR 0.86;
    final private double EURO_TO_CHF_FACTOR 1.17;
    final private double CHF_TO_POUND_FACTOR 0.75;
    final private double POUND_TO_CHF_FACTOR 1.33;
    final private double EURO_TO_POUND_FACTOR 0.88;
    final private double POUND_TO_EURO_FACTOR 1.14;

    final private int CHF_TO_EURO 0;
    final private int EURO_TO_CHF 1;
    final private int CHF_TO_POUND 2;
    final private int POUND_TO_CHF 3;
    final private int EURO_TO_POUND 4;
    final private int POUND_TO_EURO 5;

    // time
    final private double S_TO_Y 0.000000031709;
    final private double S_TO_D 0.0000115741;
    final private double S_TO_H 0,000277778;
    final private double S_TO_M 0.0166667;

    // temperature
    final private double K_TO_DEG_AMOUNT -273,15;
    final private double DEG_TO_K_AMOUNT 273,15;

    final private int K_TO_DEG 0;
    final private int DEG_TO_K 1;

    // light years <-> astronomical units
    final private double LY_TO_AU_FACTOR 63241.1;
    final private double AU_TO_LY_FACTOR 0.000015813;

    final private int LY_TO_AU 0;
    final private int AU_TO_LY 1;


    /**
     * Converts a given amount of currency to another amount of currency.
     * The algorithm currently works with pounds and euros.
     *
     * @param amount the amount of the current currency
     * @return Returns the new amount after the currency has been converted.
     */
    public double convert_currency(double amount, int from_to) {
        // Distinguish between different conversions using from_to value
        if (from_to == CHF_TO_EURO) {
            return amount * CHF_TO_EURO_FACTOR;
        }
        else if (from_to == EURO_TO_CHF) {
            return amount * EURO_TO_CHF_FACTOR;
        }
        else if (from_to == CHF_TO_POUND) {
            return amount * CHF_TO_POUND_FACTOR;
        }
        else if (from_to == POUND_TO_CHF) {
            return amount * POUND_TO_CHF_FACTOR;
        }
        else if (from_to == EURO_TO_POUND) {
            return amount * EURO_TO_POUND_FACTOR;
        }
        else if (from_to == POUND_TO_EURO) {
            return amount * POUND_TO_EURO_FACTOR;
        }
        else return -1;
    }

    /**
     * Converts seconds to a string of years days hours, minutes and seconds.
     *
     * @param amount the number of seconds
     * @return Returns a string in the format y::d::h::m::s
     */
    public String convert_seconds(double amount) {
        String result = "";

        double years = Math.floor(amount * S_TO_Y);
        amount -= years;
        result += years + "::";

        double days = Math.floor(amount * S_TO_D);
        amount -= days;
        result += days + "::";

        double hours = Math.floor(amount * S_TO_H);
        amount -= hours;
        result += hours + "::";

        double minutes = Math.floor(amount * S_TO_M);
        amount -= minutes;
        result += minutes + "::";

        result += amount;

        return result;
    }

    /**
     * Converts Degrees to Kelvin and vice-versa.
     *
     * @param amount the amount of the current unit
     * @return Returns the amount of the new unit.
     */
    public double convert_temperature(double amount, int from_to) {
        if (from_to == DEG_TO_K) return amount + DEG_TO_K_AMOUNT;
        else if (from_to == K_TO_DEG) return amount + K_TO_DEG_AMOUNT;
        else return - 1;
    }

    /**
     * Converts light years to astronomical units and vice-versa.
     *
     * @param amount the amount of the current unit
     * @return Returns the amount of the new unit.
     */
    public double convert_light_years(double amount, int from_to) {
        if (from_to == LY_TO_AU) return amount * LY_TO_AU_FACTOR;
        else if (from_to == AU_TO_LY) return amount * AU_TO_LY_FACTOR;
        else return - 1;
    }

}
