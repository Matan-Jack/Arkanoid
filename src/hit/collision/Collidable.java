//207829763 Matan Jack
package hit.collision;

import geometry.Point;
import geometry.Rectangle;
import movement.Velocity;
import hit.Ball;
/**
 * The hit.collision.Collidable interface represents objects that can be collided with.
 * Implementing classes should define the shape of the object and behavior upon hit.collision.
 * * @author Matan Jack
 * * @version 1
 * * @since 2024-06-04
 */
public interface Collidable {
    /**
     * Returns the "hit.collision shape" of the object.
     *
     * @return the geometry.Rectangle representing the hit.collision shape of the object
     */
    Rectangle getCollisionRectangle();

    /**
     * Notifies the object that it has collided with another object at a given point with a specified velocity.
     * Calculates and returns the new velocity expected after the hit.collision, based on the force the object
     * inflicts during the hit.collision.
     *
     * @param collisionPoint  the geometry.Point at which the hit.collision occurred
     * @param currentVelocity the movement.Velocity of the object before the hit.collision
     * @param hitter the hit.Ball
     * @return the new movement.Velocity expected after the hit.collision
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

