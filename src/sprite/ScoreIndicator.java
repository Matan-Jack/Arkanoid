//207829763 Matan Jack
package sprite;

import biuoop.DrawSurface;
import game.Counter;
import game.Game;

import java.awt.Color;

/**
 * The ScoreIndicator class implements the Sprite interface and represents a graphical indicator
 * displaying the current score on the screen.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;

    /**
     * Constructs a new ScoreIndicator with the specified score counter.
     *
     * @param score the counter representing the score to display
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(330, 15, "Score: " + score.getValue(), 17);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(Game g) {
        g.getSprites().addSprite(this);
    }
}
