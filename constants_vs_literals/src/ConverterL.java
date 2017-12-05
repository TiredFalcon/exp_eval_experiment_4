/**
 * Created by val on 05.12.17.
 */


public class ConverterL {

    /**
     * Converts a given amount of currency to another amount of currency.
     * The algorithm currently works with pounds and euros.
     *
     * @param amount the amount of the current currency
     * @return Returns the new amount after the currency has been converted.
     */
    public double convert_currency(double amount, int from_to) {
        // Distinguish between different conversions using from_to value
        if (from_to == 0) {
            return amount * 0.86;
        }
        else if (from_to == 1) {
            return amount * 1.17;
        }
        else if (from_to == 2) {
            return amount * 0.75;
        }
        else if (from_to == 3) {
            return amount * 1.33;
        }
        else if (from_to == 4) {
            return amount * 0.88;
        }
        else if (from_to == 5) {
            return amount * 1.14;
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

        double years = Math.floor(amount * 0.000000031709);
        amount -= years;
        result += years + "::";

        double days = Math.floor(amount * 0.0000115741);
        amount -= days;
        result += days + "::";

        double hours = Math.floor(amount * 0.000277778);
        amount -= hours;
        result += hours + "::";

        double minutes = Math.floor(amount * 0.0166667);
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
        if (from_to == 1) return amount + 273.15;
        else if (from_to == 0) return amount - 273.15;
        else return - 1;
    }

    /**
     * Converts light years to astronomical units and vice-versa.
     *
     * @param amount the amount of the current unit
     * @return Returns the amount of the new unit.
     */
    public double convert_light_years(double amount, int from_to) {
        if (from_to == 0) return amount * 63241.1;
        else if (from_to == 1) return amount * 0.000015813;
        else return - 1;
    }

}
