//207829763 Matan Jack
package geometry;
import methods.Methods;

/**
 * This class represents a two-dimensional point in space.
 * A point is defined by its x and y coordinates.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-05-30
 */
public class Point {
    // Fields
    private double x;
    private double y;

    /**
     * Constructs a new point with the given coordinates.
     *
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // methods.Methods

    /**
     * Returns the x coordinate of this point.
     *
     * @return The x coordinate of this point.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this point.
     *
     * @return The y coordinate of this point.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the x coordinate of this point.
     *
     * @param x The new x coordinate of this point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of this point.
     *
     * @param y The new y coordinate of this point.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calculates the distance between this point and another point.
     * Uses the distance formula to calculate the distance.
     *
     * @param other The other point.
     * @return The distance between this point and the other point.
     */
    public double distance(Point other) {
        return Math.sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y));
    }

    /**
     * Checks if this point is equal to another point.
     * Two points are considered equal if their x and y coordinates are equal.
     *
     * @param other The other point to compare with.
     * @return True if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (Methods.areDoublesEqual(other.x, this.x) && Methods.areDoublesEqual(other.y, this.y));
    }

//    /**
//     * Checks if the current point is inside the given rectangle.
//     * This method checks whether the x and y coordinates of the current point
//     * fall within the boundaries defined by the specified rectangle.
//     *
//     * @param rectangle the rectangle to check against
//     * @return true if the point is inside the rectangle, false otherwise
//     */
//    public boolean inQuadrange(Rectangle rectangle) {
//        return (this.getX() > rectangle.getX())
//                && (this.getX() < rectangle.getX() + rectangle.getWidth())
//                && (this.getY() > rectangle.getY())
//                && (this.getY() < rectangle.getY() + rectangle.getHeight());
//    }
}
