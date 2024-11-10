//207829763 Matan Jack
package hit.collision;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.Game;
import hit.Ball;
import sprite.Sprite;
import movement.Velocity;
import listener.HitNotifier;
import listener.HitListener;

/**
 * This class represents a hit.hit.collision.Block object in the Arkanoid game.
 * A hit.hit.collision.Block implements the hit.collision.Collidable interface,
 * meaning it can be collided with by the ball.
 *
 * @author Matan Jack
 * @version 2
 * @since 2024-07-04
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //filled
    private final Rectangle block;
    private final List<HitListener> hitListeners;

    //methods

    /**
     * Constructs a new hit.hit.collision.Block object with the specified rectangle.
     * The provided rectangle defines the hit.hit.collision.Block's location and size,
     * which will be used for hit.collision detection with the ball.
     *
     * @param block the rectangle representing the hit.hit.collision.Block's location and size
     */
    public Block(Rectangle block) {
        this.block = block;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Returns the rectangle representing the hit.collision shape of the hit.hit.collision.Block.
     * This rectangle is used to determine if the ball has collided with the hit.hit.collision.Block.
     *
     * @return the geometry.Rectangle representing the hit.hit.collision.Block's hit.collision shape.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * Updates the ball's velocity based on the hit.collision point with the hit.hit.collision.Block.
     * This method checks the hit.collision point against the four edges of the hit.
     * hit.collision.Block's hit.collision rectangle
     * (represented by lines). Based on the hit.collision edge (top, bottom, left, or right),
     * the ball's velocity is updated by inverting the appropriate direction (horizontal or vertical).
     *
     * @param collisionPoint  the point where the ball collided with the hit.hit.collision.Block
     * @param currentVelocity the ball's velocity before the hit.collision
     * @param hitter          the hit.Ball
     * @return the updated ball velocity after the hit.collision
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = block.getUpperLeft().getX();
        double y = block.getUpperLeft().getY();
        Point upperLeft = new Point(x, y);
        Point leftDown = new Point(x, y + block.getHeight());
        Point rightUp = new Point(x + block.getWidth(), y);
        Point rightDown = new Point(x + block.getWidth(), y + block.getHeight());
        Line lDown = new Line(upperLeft, rightUp);
        Line lUp = new Line(leftDown, rightDown);
        Line lLeft = new Line(upperLeft, leftDown);
        Line lRight = new Line(rightDown, rightUp);
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (lDown.pOnLineSegment(collisionPoint) || lUp.pOnLineSegment(collisionPoint)) {
            dy = -dy;
        }
        if (lLeft.pOnLineSegment(collisionPoint) || lRight.pOnLineSegment(collisionPoint)) {
            dx = -dx;
        }
        currentVelocity.setVelocity(dx, dy);
        if (!ballColorMatch(hitter)) {
            this.notifyHit(hitter);
        }
        return currentVelocity;
    }

    /**
     * Draws the block on the given DrawSurface.
     *
     * @param d the DrawSurface on which to draw the block.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(block.getColor());
        d.fillRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());

    }

    /**
     * Notifies the block that time has passed.
     * Currently, this method does nothing.
     */
    @Override
    public void timePassed() {
    }

    /**
     * Adds this block to the game as both a sprite and a collidable object.
     *
     * @param g the game to which the block should be added.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * Checks if the ball color matches the block color.
     *
     * @param ball the ball to check color match with
     * @return true if the ball color matches the block color, false otherwise
     */
    public boolean ballColorMatch(Ball ball) {
        return ball.getColor() == this.block.getColor();
    }
    /**
     * Removes this block from the game.
     *
     * @param game the game from which the block should be removed
     */
    public void removeFromGame(Game game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * Notifies all listeners about a hit event.
     *
     * @param hitter the ball that hit the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}

