/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 22, 2015
 * Time: 9:09:49 PM
 *
 * Project: csci205
 * Package: lab13
 * File: KelvinConvertUtility
 * Description:
 *
 * ****************************************
 */
package lab13;

/**
 * Utility class for Kelvin Converter
 *
 * @author ia005
 */
public class KelvinConvertUtility {
    /**
     * Convert Celsius temperature to Kelvin
     *
     * @param celTemp - Celsius temp to convert
     * @return temp in Kelvin
     */
    public static double convertCtoK(double celTemp) {
        return 273.15 + celTemp;
    }

    /**
     * Convert Celsius temp in String to Kelvin
     *
     * @param celTemp - Celsius temp to convert
     * @return temp in Kelvin as String
     */
    public static String strConvertCtoK(String celTemp) {
        return Double.toString(convertCtoK(Double.valueOf(celTemp)));
    }

    /**
     * Convert Fahrenheit temperature to Kelvin
     *
     * @param fahTemp - Fahrenheit temp to convert
     * @return temp in Kelvin
     */
    public static double convertFtoK(double fahTemp) {
        return 273.15 + convertFtoC(fahTemp);
    }

    /**
     * Convert Fahrenheit temp. in String to Kelvin
     *
     * @param fahTemp - Fahrenheit temp to convert
     * @return temp in Kelvin as String
     */
    public static String strConvertFtoK(String fahTemp) {
        return Double.toString(convertFtoK(Double.valueOf(fahTemp)));
    }

    /**
     * Convert temperature in Fahrenheit to Celsius
     *
     * @param fahTemp - Fahrenheit temp to convert
     * @return temp in Celsius
     */
    public static double convertFtoC(double fahTemp) {
        double cel = (fahTemp - 32) * 0.555556;
        return cel;
    }

    /**
     * Convert temperature in Fahrenheit as String to Celsius
     *
     * @param fahTemp - Fahrenheit temp to convert
     * @return temp in Celsius as String
     */
    public static String strConvertFtoC(String fahTemp) {
        return Double.toString(convertFtoC(Double.valueOf(fahTemp)));
    }

    /**
     * Convert Celsius temperature to Fahrenheit
     *
     * @param celTemp - Celsius temp to convert
     * @return temp in Fahrenheit
     */
    public static double convertCtoF(double celTemp) {
        double fah = (1.8 * celTemp) + 32;
        return fah;
    }

    /**
     * Convert Celsius temperature as String to Fahrenheit
     *
     * @param celTemp - Celsius temp to convert
     * @return temp in Fahrenheit inString
     */
    public static String strConvertCtoF(String celTemp) {
        return Double.toString(convertCtoF(Double.valueOf(celTemp)));
    }

}
