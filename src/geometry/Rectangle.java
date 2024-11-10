//207829763 Matan Jack
package geometry;

import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * The geometry.Rectangle class represents a quadrilateral shape defined by an upper left point,
 * a width, and a height.
 *
 * @author Matan Jack
 * @version 2
 * @since 2024-06-04
 */
public class Rectangle {
    //filed
    private final Point upperLeft;
    private final double width;
    private final double height;
    private java.awt.Color color;

    /**
     * Constructs a new geometry.Rectangle with an upper left point, width, and height.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs a new geometry.Rectangle with an upper left point, width, height and color.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     * @param color     the color of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height, java.awt.Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    //Method 'geometry.Rectangle' is not used yet
//    /**
//     * Constructs a new geometry.Rectangle with the upper left coordinates, width, and height.
//     *
//     * @param x     the x-coordinate of the upper left point
//     * @param y     the y-coordinate of the upper left point
//     * @param width the width of the rectangle
//     * @param height the height of the rectangle
//     */
//    public geometry.Rectangle(double x, double y, double width, double height) {
//        this.upperLeft = new geometry.Point(x, y);
//        this.width = width;
//        this.height = height;
//    }
    // methods

    /**
     * Gets the x-coordinate of the upper left point of the rectangle.
     *
     * @return the x-coordinate
     */
    public double getX() {
        return upperLeft.getX();
    }

    /**
     * Gets the y-coordinate of the upper left point of the rectangle.
     *
     * @return the y-coordinate
     */
    public double getY() {
        return upperLeft.getY();
    }

    /**
     * Gets the upper left point of the rectangle.
     *
     * @return the upper left point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the color of the rectangle.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return color;
    }
    //Method 'setX' is not used yet
//    /**
//     * Sets the x-coordinate of the upper left point of the rectangle.
//     *
//     * @param x the x-coordinate to set
//     */
//    public void setX(int x) {
//        this.upperLeft.setX(x);
//    }
    //Method 'setY' is not used yet
//    /**
//     * Sets the y-coordinate of the upper left point of the rectangle.
//     *
//     * @param y the y-coordinate to set
//     */
//    public void setY(int y) {
//        this.upperLeft.setY(y);
//    }
    //Method 'setUpperLeft' is not used yet
//    /**
//     * Sets the upper left point of the rectangle.
//     *
//     * @param upperLeft the upper left point to set
//     */
//    public void setUpperLeft(geometry.Point upperLeft) {
//        this.upperLeft = upperLeft;
//    }
    //Method 'setWidth' is not used yet
//    /**
//     * Sets the width of the rectangle.
//     *
//     * @param width the width to set
//     */
//    public void setWidth(double width) {
//        this.width = width;
//    }
    //Method 'setHeight' is not used yet
//    /**
//     * Sets the height of the rectangle.
//     *
//     * @param height the height to set
//     */
//    public void setHeight(double height) {
//        this.height = height;
//    }
    //Method 'setColor' is not used yet
//    /**
//     * Sets the color of the rectangle.
//     *
//     * @param color the color to set
//     */
//    public void setColor(java.awt.Color color) {
//        this.color = color;
//    }

    /**
     * Returns the upper line of the rectangle.
     *
     * @return The upper line of the rectangle.
     */
    public Line upperLine() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        return new Line(upperLeft, upperRight);
    }

    /**
     * Returns the lower line of the rectangle.
     *
     * @return The lower line of the rectangle.
     */
    public Line lowerLine() {
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        return new Line(lowerLeft, lowerRight);
    }

    /**
     * Returns the right line of the rectangle.
     *
     * @return The right line of the rectangle.
     */
    public Line rightLine() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        return new Line(upperRight, lowerRight);
    }

    /**
     * Returns the left line of the rectangle.
     *
     * @return The left line of the rectangle.
     */
    public Line leftLine() {
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        return new Line(upperLeft, lowerLeft);

    }

    /**
     * Draws the rectangle on the given drawing surface.
     * This method sets the color of the drawing surface to the color of the rectangle
     * and then fills a rectangle at the rectangle's position with its specified width and height.
     *
     * @param surface the drawing surface to draw the rectangle on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.getX(), (int) this.getY(), (int) this.width, (int) this.height);
    }

    /**
     * Calculates the intersection points between a given line and the sides of a rectangle.
     *
     * @param line the line to check for intersections with the rectangle
     * @return an ArrayList of Points representing the intersection points
     **/
    public java.util.List<Point> intersectionPoints(Line line) {
        // Initialize an empty list to store intersection points
        ArrayList<Point> intersectionPoints = new ArrayList<>();
        if (lowerLine().intersectionWith(line) != null) {
            intersectionPoints.add(lowerLine().intersectionWith(line));
        }
        if (upperLine().intersectionWith(line) != null) {
            intersectionPoints.add(upperLine().intersectionWith(line));
        }
        if (leftLine().intersectionWith(line) != null) {
            intersectionPoints.add(leftLine().intersectionWith(line));
        }
        if (rightLine().intersectionWith(line) != null) {
            intersectionPoints.add(rightLine().intersectionWith(line));
        }
        return intersectionPoints;
    }
}

