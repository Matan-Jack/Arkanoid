//207829763 Matan Jack
package sprite;

import biuoop.DrawSurface;
import game.Game;

/**
 * The sprite.Sprite interface represents a game object that can be drawn on the screen
 * and notified when time has passed.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-06-07
 */
public interface Sprite {
    /**
     * Draws the sprite to the screen.
     *
     * @param d the DrawSurface on which the sprite should be drawn
     */
    void drawOn(DrawSurface d);

    /**
     * Notifies the sprite that time has passed.
     */
    void timePassed();

    /**
     * Adds the sprite to the game.
     *
     * @param g the game to which the sprite should be added
     */
    void addToGame(Game g);
}
