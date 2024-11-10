//207829763 Matan Jack
package sprite;

import java.util.Collection;
import java.util.LinkedList;

import biuoop.DrawSurface;

/**
 * The sprite.SpriteCollection class manages a collection of sprite.Sprite objects.
 * It provides methods to add sprites, notify them of time passing, and draw them on a given surface.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-06-04
 */
public class SpriteCollection {
    //filled
    // List of sprite objects in the environment
    private final java.util.Collection<Sprite> sprites;

    /**
     * Returns the collection of sprites managed by this SpriteCollection.
     *
     * @return the collection of sprites
     */
    public Collection<Sprite> getSprite() {
        return sprites;
    }

    /**
     * Constructs a new sprite.SpriteCollection.
     * Initializes the collection to hold sprite.Sprite objects.
     */
    public SpriteCollection() {
        this.sprites = new LinkedList<>();
    }

    /**
     * Adds a sprite to the collection.
     *
     * @param s the sprite.Sprite to be added
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Notifies all sprites that time has passed.
     * Calls the timePassed() method on each sprite in the collection.
     */
    public void notifyAllTimePassed() {
        java.util.Collection<Sprite> sprites1 = new LinkedList<>(sprites);
        for (Sprite s : sprites1) {
            s.timePassed();
        }
    }

    /**
     * Draws all sprites on the given DrawSurface.
     * Calls the drawOn(DrawSurface) method on each sprite in the collection.
     *
     * @param d the DrawSurface on which to draw the sprites
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }
}