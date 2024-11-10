//207829763 Matan Jack
package hit.collision;

import biuoop.KeyboardSensor;

import java.awt.Color;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import sprite.Sprite;
import movement.Velocity;
import game.Game;
import hit.Ball;

/**
 * The hit.hit.collision.Paddle class represents a paddle in the game,
 * which is controlled by the player using the keyboard.
 * The paddle can move left and right and can collide with other objects in the game.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-06-10
 */
public class Paddle implements Sprite, Collidable {
    //filled
    private final biuoop.KeyboardSensor keyboard;
    private final Rectangle paddle;
    //The screen width is 800 minus the 20 frame at left side.
    private final int maxLeftScreen = 780;
    //The screen width is 0 plus the 20 frame at right side.
    private final int minRightScreen = 20;
    private final int speed = 5;

    /**
     * Constructs a new hit.hit.collision.Paddle object.
     *
     * @param keyboard the keyboard sensor to control the paddle's movements.
     */
    public Paddle(biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.paddle = new Rectangle(new Point(375, 560), 100, 20, Color.PINK);
    }

    /**
     * Returns the hit.collision rectangle of the paddle.
     *
     * @return the hit.collision rectangle of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * Moves the paddle to the left.
     * The paddle will not move beyond the left edge of the screen.
     */
    public void moveLeft() {
        if (paddle.getUpperLeft().getX() - speed > minRightScreen) {
            paddle.getUpperLeft().setX(paddle.getUpperLeft().getX() - speed);
        }
        if (paddle.getUpperLeft().getX() - speed == minRightScreen) {
            paddle.getUpperLeft().setX(maxLeftScreen - this.paddle.getWidth());
        }
    }

    /**
     * Moves the paddle to the right.
     * The paddle will not move beyond the right edge of the screen.
     */
    public void moveRight() {
        if (paddle.getUpperLeft().getX() + speed < maxLeftScreen - this.paddle.getWidth()) {
            paddle.getUpperLeft().setX(paddle.getUpperLeft().getX() + speed);
        }
        if (paddle.getUpperLeft().getX() + speed == (maxLeftScreen - this.paddle.getWidth())) {
            paddle.getUpperLeft().setX(minRightScreen);
        }
    }

    /**
     * Notifies the paddle that time has passed.
     * Checks if the left or right keys are pressed and moves the paddle accordingly.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * Draws the paddle on the given DrawSurface.
     *
     * @param d the DrawSurface on which to draw the paddle.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(getCollisionRectangle().getColor());
        d.fillRectangle((int) paddle.getUpperLeft().getX(), (int) paddle.getUpperLeft().getY(),
                (int) paddle.getWidth(), (int) paddle.getHeight());
    }

    /**
     * Handles the hit.collision of the paddle with another object.
     * Changes the velocity of the colliding object based on the hit.collision point on the paddle.
     *
     * @param collisionPoint  the point at which the hit.collision occurs.
     * @param currentVelocity the current velocity of the colliding object.
     * @param hitter the hit.Ball
     * @return the new velocity after the hit.collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int location = hitLocation(collisionPoint);
        //hits first fifth of the paddle
        if (location == 1) {
            Velocity newV = Velocity.fromAngleAndSpeed(300, speedVelocity(currentVelocity));
            currentVelocity.setVelocity(newV.getDx(), newV.getDy());
        } else if (location == 2) {
            //hits second fifth of the paddle
            Velocity newV = Velocity.fromAngleAndSpeed(330, speedVelocity(currentVelocity));
            currentVelocity.setVelocity(newV.getDx(), newV.getDy());
        } else if (location == 3) {
            //hits third fifth of the paddle
            currentVelocity.setVelocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (location == 4) {
            //hits fourth fifth of the paddle
            Velocity newV = Velocity.fromAngleAndSpeed(30, speedVelocity(currentVelocity));
            currentVelocity.setVelocity(newV.getDx(), newV.getDy());
        } else if (location == 5) {
            //hits last fifth of the paddle
            Velocity newV = Velocity.fromAngleAndSpeed(60, speedVelocity(currentVelocity));
            currentVelocity.setVelocity(newV.getDx(), newV.getDy());
        }
        return currentVelocity;
    }

    /**
     * Calculates the speed (magnitude) of a given velocity.
     *
     * @param currentVelocity the current velocity for which the speed is to be calculated.
     * @return the speed (magnitude) of the current velocity.
     */
    private double speedVelocity(Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Determines the location on the paddle where the hit.collision occurred.
     *
     * @param collisionPoint the point at which the hit.collision occurs.
     * @return an integer representing the fifth of the paddle that was hit.
     */
    public int hitLocation(Point collisionPoint) {
        /*
        Divide the paddle into 5 parts to determine the behavior of the ball's
        bounce (depends on where it hits the paddle)
        */
        double fifthWidth = paddle.getWidth() / 5;
        double upperLeftX = paddle.getUpperLeft().getX();
        //first part
        if (collisionPoint.getX() >= upperLeftX && collisionPoint.getX() <= upperLeftX + fifthWidth) {
            return 1;
        }
        //second part
        if (collisionPoint.getX() > upperLeftX + fifthWidth && collisionPoint.getX() <= upperLeftX + 2 * fifthWidth) {
            return 2;
        }
        //third part
        if (collisionPoint.getX() > upperLeftX + 2 * fifthWidth && collisionPoint.getX() <= upperLeftX + 3
                * fifthWidth) {
            return 3;
        }
        //fourth part
        if (collisionPoint.getX() > upperLeftX + 3 * fifthWidth && collisionPoint.getX() <= upperLeftX
                + 4 * fifthWidth) {
            return 4;
        }
        //fifth part
        if (collisionPoint.getX() > upperLeftX + 4 * fifthWidth && collisionPoint.getX() <= upperLeftX
                + paddle.getWidth()) {
            return 5;
        }
        return -1;
    }

    /**
     * Adds this paddle to the game as both a sprite and a collidable object.
     *
     * @param g the game to which the paddle should be added.
     */
    @Override
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);

    }
}

