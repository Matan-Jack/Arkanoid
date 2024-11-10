//207829763 Matan Jack
package movement;

import geometry.Point;

/**
 * The movement.Velocity class specifies the change in position on the `x` and `y` axes.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-05-30
 */
public class Velocity {
    //filed
    private double dx;
    private double dy;

    /**
     * Constructs a movement.Velocity with the given change in x and y.
     *
     * @param dx the change in x direction
     * @param dy the change in y direction
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Constructs a new movement.Velocity object by copying the values from another movement.Velocity object.
     * This constructor initializes the new movement.Velocity object with the same dx and dy values
     * as the provided movement.Velocity object.
     *
     * @param v the movement.Velocity object to copy the values from
     */
    public Velocity(Velocity v) {
        this.dx = v.dx;
        this.dy = v.dy;
    }

    /**
     * Returns the change in x direction.
     *
     * @return the change in x direction
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Returns the change in y direction.
     *
     * @return the change in y direction
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Sets the velocity of an object.
     *
     * @param newDx the new velocity in the x direction
     * @param newDy the new velocity in the y direction
     */
    public void setVelocity(double newDx, double newDy) {
        this.dx = newDx;
        this.dy = newDy;
    }

    /**
     * Creates a movement.Velocity instance from an angle and a speed.
     *
     * @param angle the angle of the velocity in degrees
     * @param speed the speed
     * @return a new movement.Velocity instance
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Applies this velocity to a given point, moving it by (dx, dy).
     *
     * @param p the point to apply the velocity to
     * @return a new geometry.Point after applying the velocity
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        p.setX(newX);
        p.setY(newY);
        return p;
    }
}

