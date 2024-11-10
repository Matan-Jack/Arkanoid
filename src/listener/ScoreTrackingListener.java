//207829763 Matan Jack
package listener;

import game.Counter;
import hit.collision.Block;
import hit.Ball;

/**
 * The ScoreTrackingListener class implements the HitListener interface and is responsible for
 * updating the current score whenever a block is hit.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;
    /**
     * Constructs a new ScoreTrackingListener with the specified Counter.
     *
     * @param scoreCounter the counter that keeps track of the current score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * This method increases the current score by 5 points each time a block is hit.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        currentScore.increase(5);
    }
}
