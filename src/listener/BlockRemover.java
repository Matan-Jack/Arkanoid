//207829763 Matan Jack
package listener;

import game.Counter;
import game.Game;
import hit.collision.Block;
import hit.Ball;
/**
 * The BlockRemover class is responsible for removing blocks from the game and keeping count
 * of the remaining blocks. It implements the HitListener interface to respond to hit events.
 * When a block is hit, it is removed from the game, and the count of remaining blocks is decremented.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public class BlockRemover implements HitListener {
    // a BlockRemover is in charge of removing blocks from the game, as well as keeping count
    // of the number of blocks that remain.
    private final Game game;
    private final Counter remainingBlocks;
    /**
     * Constructs a BlockRemover object with the specified game and counter for remaining blocks.
     *
     * @param game            the game from which blocks will be removed
     * @param remainingBlocks the counter for the remaining blocks in the game
     */
    public BlockRemover(Game game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * It removes the block from the game, removes this listener from the block,
     * and decrements the remaining blocks counter.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.setColor(beingHit.getCollisionRectangle().getColor());
        this.game.removeCollidable(beingHit);
        this.game.removeSprite(beingHit);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}

