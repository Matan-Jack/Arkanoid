//207829763 Matan Jack
package listener;

import game.Counter;
import hit.Ball;
import hit.collision.Block;

/**
 * The HundredScoreListener class implements the HitListener interface and is responsible for
 * increasing the score by 100 points when a certain number of hits (lines) have been reached.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */

public class HundredScoreListener implements HitListener {
    private int line;
    private final Counter lineScore;
    /**
     * Constructs a new HundredScoreListener with the specified Counter and number of lines.
     *
     * @param lineScore the counter that keeps track of the score
     * @param line      the number of lines (hits) required to increase the score
     */
    public HundredScoreListener(Counter lineScore, int line) {
        this.line = line;
        this.lineScore = lineScore;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * This method decreases the line count and increases the score by 100 when the line count reaches zero.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        line--;
        if (line <= 0) {
            lineScore.increase(100);
        }
    }

}
