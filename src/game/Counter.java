//207829763 Matan Jack
package game;

/**
 * The Counter class is used to keep track of a count.
 * It allows increasing, decreasing, and retrieving the current count value.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public class Counter {
    private int value = 0;

    /**
     * Adds a specified number to the current count.
     *
     * @param number the number to add to the current count
     */
    public void increase(int number) {
        this.value = value + number;
    }

    /**
     * Subtracts a specified number from the current count.
     *
     * @param number the number to subtract from the current count
     */
    public void decrease(int number) {
        this.value = value - number;
    }

    /**
     * Returns the current count value.
     *
     * @return the current count
     */
    public int getValue() {
        return this.value;
    }
}
