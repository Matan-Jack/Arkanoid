//207829763 Matan Jack
package hit.collision;

import geometry.Point;

/**
 * This class represents information about a hit.collision between a ball and a hit.collision.Collidable object.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-06-04
 */
public class CollisionInfo {
    //filled
    private final Point collisionPoint;
    private final Collidable collisionObjectgs;

    /**
     * Constructs a new hit.hit.collision.CollisionInfo object with the point of hit.
     * collision and the hit.collision.Collidable object involved.
     *
     * @param collisionPoint    the point where the hit.collision occurred
     * @param collisionObjectgs the hit.collision.Collidable object that the ball collided with
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObjectgs) {
        this.collisionPoint = collisionPoint;
        this.collisionObjectgs = collisionObjectgs;
    }

    /**
     * Returns the point where the hit.collision between the ball and the hit.collision.Collidable object occurred.
     *
     * @return the point of hit.collision
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * Returns the hit.collision.Collidable object that the ball collided with.
     *
     * @return the hit.collision.Collidable object involved in the hit.collision
     */
    public Collidable collisionObject() {
        return collisionObjectgs;


    }

}

