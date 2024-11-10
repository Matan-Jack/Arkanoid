//207829763 Matan Jack
package game;

import geometry.Line;
import geometry.Point;
import hit.collision.Collidable;
import hit.collision.CollisionInfo;

import java.util.ArrayList;

/**
 * The game.GameEnvironment class manages a collection of hit.collision.Collidable objects.
 * It provides methods to add collidables and determine the closest hit.collision
 * with a given trajectory.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-06-04
 */
public class GameEnvironment {
    //filled
    // List of collidable objects in the environment
    private final java.util.ArrayList<Collidable> arr;
    //Method 'game.GameEnvironment' is not used yet
//    game.GameEnvironment(ArrayList<hit.collision.Collidable> blocks) {
//        this.arr = blocks;
//    }

    GameEnvironment() {
        this.arr = new ArrayList<>();
    }

    /**
     * Returns the list of collidable objects in the environment.
     *
     * @return a List of hit.collision.Collidable objects
     */
    public ArrayList<hit.collision.Collidable> getColidable() {
        return arr;
    }

    /**
     * Adds the given collidable to the environment.
     *
     * @param c the hit.collision.Collidable to be added
     */
    public void addCollidable(Collidable c) {
        this.arr.add(c);
    }

    /**
     * Determines the closest hit.collision that will occur given an object's trajectory.
     * Assume an object moving from line.start() to line.end(). If this object will not
     * collide with any of the collidables in this collection, returns null. Otherwise,
     * returns the information about the closest hit.collision that is going to occur.
     *
     * @param trajectory the geometry.Line representing the object's trajectory
     * @return the hit.hit.collision.CollisionInfo of the closest hit.collision, or null if no hit.collision occurs
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.arr.isEmpty()) {
            return null;
        }
        Collidable c = null;
        Point smallestPoint = null;
        double distance = Double.POSITIVE_INFINITY;
        for (Collidable a : this.arr) {
            //creates a list of intersection points of the collidable object and line trajectory
            java.util.List<Point> intersectionPoints = a.getCollisionRectangle().intersectionPoints(trajectory);
            Point check = trajectory.closestIntersectionToStartOfLine(a.getCollisionRectangle());
            if (intersectionPoints.isEmpty()) {
                continue;
            }
            if (trajectory.start().distance(check) < distance) {
                distance = trajectory.start().distance(check);
                smallestPoint = check;
                c = a;
            }
        }
        if (smallestPoint == null) {
            return null;
        }
        return new CollisionInfo(smallestPoint, c);
    }
}
