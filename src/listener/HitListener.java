//207829763 Matan Jack
package listener;

import hit.collision.Block;
import hit.Ball;

/**
 * The HitListener interface should be implemented by any class that wants to be notified of hit events.
 * Implementing classes must define the hitEvent method to specify what actions should be taken when a hit occurs.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}
