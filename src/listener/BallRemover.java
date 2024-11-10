//207829763 Matan Jack
package listener;

import game.Game;
import hit.Ball;
import hit.collision.Block;

/**
 * The BallRemover class is responsible for removing balls from the game when they hit a specific block.
 * It implements the HitListener interface to respond to hit events.
 * When a ball hits the block, it is removed from the game.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public class BallRemover implements HitListener {

    private final Game game;
    /**
     * Constructs a BallRemover object with the specified game.
     *
     * @param game the game from which balls will be removed
     */
    public BallRemover(Game game) {
        this.game = game;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * Removes the hitter ball from the game.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
    }
}
