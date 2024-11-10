//207829763 Matan Jack
package methods;

/**
 * This class provides service methods to perform various operations.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-05-30
 */
public class Methods {
    //filed
    /**
     * Threshold value used for considering two double values to be equal.
     * Due to limitations of floating-point arithmetic, exact comparisons might not be reliable.
     * This threshold specifies the maximum allowed absolute difference between two double values
     * to be considered equal.
     */
    public static final double THRESHOLD = 1e-5;
    //methods

    /**
     * This method compares the absolute difference between the two provided double values (`a` and `b`)
     * with a predefined threshold (`THRESHOLD`). If the absolute difference is less than the threshold,
     * the method considers the values to be equal and returns true. Otherwise, it returns false.
     *
     * @param a The first double value to compare.
     * @param b The second double value to compare.
     * @return True if the absolute difference between `a` and `b` is less than the `THRESHOLD`, false otherwise.
     */
    public static boolean areDoublesEqual(double a, double b) {
        return Math.abs(a - b) <= THRESHOLD;
    }

    /**
     * Checks if the first double is greater than or equal to the second double.
     * This method takes into account potential precision issues by using the
     * {@link #areDoublesEqual(double, double)} method to check for equality.
     *
     * @param a the first double value
     * @param b the second double value
     * @return true if a is greater than or equal to b, false otherwise
     */
    public static boolean biggerEqual(double a, double b) {
        return (a > b || areDoublesEqual(a, b));
    }

    /**
     * Checks if the first double is smaller than or equal to the second double.
     * This method takes into account potential precision issues by using the
     * {@link #areDoublesEqual(double, double)} method to check for equality.
     *
     * @param a the first double value
     * @param b the second double value
     * @return true if a is smaller than or equal to b, false otherwise
     */
    public static boolean smallerEqual(double a, double b) {
        return (a < b || areDoublesEqual(a, b));
    }
}


