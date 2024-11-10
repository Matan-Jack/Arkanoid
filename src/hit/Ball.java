//207829763 Matan Jack
package hit;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import hit.collision.CollisionInfo;
import sprite.Sprite;
import movement.Velocity;
import game.GameEnvironment;
import game.Game;


//import java.util.Random;

/**
 * The hit.Ball class represents a ball with a center point, radius, color, velocity, and a bounding rectangle.
 * The ball can move and bounce off the walls of the rectangle.
 *
 * @author Matan Jack
 * @version 2
 * @since 2024-06-04
 */
public class Ball implements Sprite {
    // Fields
    //The filled 'PI' is not used yet
    //private static final double PI = 3.1415;
    private final int radius;
    private java.awt.Color color;
    private Point center;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * Constructs a new hit.Ball object with the specified center point, radius, color and initialize velocity.
     *
     * @param center          the center point of the ball
     * @param r               the radius of the ball
     * @param color           the color of the ball
     * @param gameEnvironment game environment
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }
    //Method 'hit.Ball' is not used
//    /**
//     * Constructs a new hit.Ball with a center point, radius, and color.
//     *
//     * @param center the center point of the ball
//     * @param r      the radius of the ball
//     * @param color  the color of the ball
//     */
//    public hit.Ball(geometry.Point center, int r, java.awt.Color color) {
//        this.radius = r;
//        this.center = center;
//        this.color = color;
//    }
    //Method 'hit.Ball' is not used yet
//    /**
//     * Constructs a new hit.Ball with center coordinates, radius, and color.
//     *
//     * @param x     the x-coordinate of the center point
//     * @param y     the y-coordinate of the center point
//     * @param r     the radius of the ball
//     * @param color the color of the ball
//     */
//    public hit.Ball(int x, int y, int r, java.awt.Color color) {
//        this.center = new geometry.Point(x, y);
//        this.radius = r;
//        this.color = color;
//    }
    // methods

    /**
     * Gets the x-coordinate of the ball's center.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * Gets the y-coordinate of the ball's center.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return (int) center.getY();
    }
    //Method 'getCenter' is not used yet
//    /**
//     * Gets the center point of the ball.
//     *
//     * @return the center point
//     */
//    public geometry.Point getCenter() {
//        return center;
//    }
    //Method 'getSize' is not used
//    /**
//     * Gets the radius of the ball.
//     *
//     * @return the radius
//     */
//    public int getSize() {
//        return radius;
//    }

    /**
     * Gets the color of the ball.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return color;
    }
//Method 'getRectangle' is not used yet
//    /**
//     * Gets the rectangle (bounding box) of the ball.
//     *
//     * @return the rectangle
//     */
//    public geometry.Rectangle getRectangle() {
//        return rectangle;
//    }

    /**
     * Gets the velocity of the ball.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return v;
    }
    //Method 'SetX' is not used yet
//    /**
//     * Sets the x-coordinate of the ball's center.
//     *
//     * @param x the x-coordinate
//     */
//    public void setX(int x) {
//        this.center.setX(x);
//    }
    //Method 'setY' is not used yet
//    /**
//     * Sets the y-coordinate of the ball's center.
//     *
//     * @param y the y-coordinate
//     */
//    public void setY(int y) {
//        this.center.setY(y);
//    }
    //Method 'setCenter' is not used yet
//    /**
//     * Sets the center point of the ball.
//     *
//     * @param center the center point
//     */
//    public void setCenter(geometry.Point center) {
//        this.center = center;
//    }
    //Method 'setSize' is not used yet
//    /**
//     * Sets the radius of the ball.
//     *
//     * @param r the radius
//     */
//    public void setSize(int r) {
//        this.radius = r;
//    }

    /**
     * Sets the color of the ball.
     *
     * @param color the color
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    //Method 'setRectangle' is not used yet
//    /**
//     * Sets the rectangle (bounding box) of the ball.
//     *
//     * @param r the rectangle to set
//     */
//    public void setRectangle(geometry.Rectangle r) {
//        geometry.Rectangle rectangle = new geometry.Rectangle(r.getUpperLeft(), r.getWidth(), r.getHeight());
//    }
    //Method 'setVelocity' is not used
//    /**
//     * Sets the velocity of the ball.
//     *
//     * @param dx the change in x-direction
//     * @param dy the change in y-direction
//     */
//    public void setVelocity(double dx, double dy) {
//        this.v = new movement.Velocity(dx, dy);
//    }

    /**
     * Sets the velocity of the ball.
     *
     * @param v the velocity to set
     */
    public void setVelocity(Velocity v) {
        this.v = new Velocity(v);
    }

    /**
     * Sets the game.GameEnvironment of the ball.
     *
     * @param g the game.GameEnvironment to set
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }
    //Method 'circleArea' is not used yet
//    /**
//     * Calculates the area of the ball.
//     *
//     * @return the area of the ball
//     */
//    public double circleArea() {
//        return PI * this.radius * this.radius;
//    }
    //Method 'circleCircumference' is not used yet
//    /**
//     * Calculates the circumference of the ball.
//     *
//     * @return the circumference of the ball
//     */
//    public double circleCircumference() {
//        return 2 * PI * this.radius;
//    }

    /**
     * Draws the ball on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int xCoordinate = this.getX();
        int yCoordinate = this.getY();
        d.fillCircle(xCoordinate, yCoordinate, radius);
    }
    //Method 'speed' is not used yet
//    /**
//     * Sets the speed of the ball based on its radius. Smaller balls move faster.
//     *
//     * @param radius the radius of the ball
//     */
//    public void speed(int radius) {
//        Random rand = new Random();
//        if (radius < 50) {
//            /*
//            For each ball whose radius is less than 50, the speed is chosen according to the size of the radius.
//            (we wanted it to be faster than a ball with a radius of 50 or more)
//            */
//            int speed = 150 / radius;
//            this.setVelocity(movement.Velocity.fromAngleAndSpeed(rand.nextInt(360), speed));
//        } else {
//            this.setVelocity(movement.Velocity.fromAngleAndSpeed(rand.nextInt(360), 2));
//        }
//    }
    //Method 'corner' is not used yet
//    /**
//     * Checks if the ball collides with any corner of the given rectangle.
//     * If a hit.collision is detected, the ball's velocity is updated to reflect the bounce.
//     *
//     * @param rectangle the rectangle to check for corner collisions
//     * @return true if the ball collides with any corner of the rectangle, false otherwise
//     */
//    public boolean corner(geometry.Rectangle rectangle) {
//        // Get coordinates of the rectangle's corners
//        double x = rectangle.getUpperLeft().getX();
//        double y = rectangle.getUpperLeft().getY();
//        geometry.Point upperLeft = new geometry.Point(x, y);
//        y = rectangle.getUpperLeft().getY() + rectangle.getHeight();
//        geometry.Point leftUp = new geometry.Point(x, y);
//        x = rectangle.getUpperLeft().getX() + rectangle.getWidth();
//        geometry.Point rightUp = new geometry.Point(x, y);
//        y = rectangle.getUpperLeft().getY();
//        geometry.Point rightDown = new geometry.Point(x, y);
//        /*
//         Check if the ball collides with any of the corners
//         I divided each corner into 3 parts so that the display of hitting the corner would be as clean as possible.
//         */
//        if (methods.Methods.smallerEqual(this.center.distance(upperLeft), this.radius)) {
//            if (this.centerf.getX() < upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//            }
//            if (this.center.getX() < upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), -v.getDy());
//
//            }
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//            return true;
//        }
//        if (methods.Methods.smallerEqual(this.center.distance(leftUp), this.radius)) {
//            if (this.center.getX() < upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), -v.getDy());
//            }
//            if (this.center.getX() < upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//
//            }
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//            return true;
//        }
//        if (methods.Methods.smallerEqual(this.center.distance(rightDown), this.radius)) {
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), -v.getDy());
//            }
//            if (this.center.getX() < upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//
//            }
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//            }
//            return true;
//        }
//        if (methods.Methods.smallerEqual(this.center.distance(rightUp), this.radius)) {
//            if (this.center.getX() < upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() < upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//
//            }
//            if (this.center.getX() > upperLeft.getX() && this.center.getY() > upperLeft.getY()) {
//                this.v = new movement.Velocity(-v.getDx(), -v.getDy());
//            }
//            return true;
//        }
//        return false;
//    }
    //Method 'frame' is not used yet
//    /**
//     * Updates the ball's velocity based on its interactions with the given rectangle.
//     * The ball's velocity is updated to reflect bounces off the sides or corners of the rectangle.
//     *
//     * @param rectangle the rectangle to check for interactions
//     */
//    public void frame(geometry.Rectangle rectangle) {
//        if (!corner(rectangle)) {
//            double x = rectangle.getX();
//            double y = rectangle.getY();
//            geometry.Point upperLeft = new geometry.Point(x, y);
//            y = rectangle.getUpperLeft().getY() + rectangle.getHeight();
//            geometry.Point leftUp = new geometry.Point(x, y);
//            x = rectangle.getUpperLeft().getX() + rectangle.getWidth();
//            geometry.Point rightUp = new geometry.Point(x, y);
//            y = rectangle.getUpperLeft().getY();
//            geometry.Point rightDown = new geometry.Point(x, y);
//            //Creates 4 lines which correspond to 4 different radius in the ball (four winds).
//            geometry.Line down = new geometry.Line(this.center.getX(), this.center.getY()
//            - this.radius, this.center.getX(),
//                    this.center.getY());
//            geometry.Line up = new geometry.Line(this.center.getX(), this.center.getY()
//            + this.radius, this.center.getX(),
//                    this.center.getY());
//            geometry.Line left = new geometry.Line(this.center.getX()
//            - this.radius, this.center.getY(), this.center.getX(),
//                    this.center.getY());
//            geometry.Line right = new geometry.Line(this.center.getX()
//            + this.radius, this.center.getY(), this.center.getX(),
//                    this.center.getY());
//            // Create lines representing the sides of the rectangle which blocks the balls from entering it.
//            geometry.Line lDown = new geometry.Line(upperLeft, rightDown);
//            geometry.Line lUp = new geometry.Line(leftUp, rightUp);
//            geometry.Line lLeft = new geometry.Line(upperLeft, leftUp);
//            geometry.Line lRight = new geometry.Line(rightDown, rightUp);
//            // Check for intersections and update velocity accordingly.
//            if (lDown.isIntersecting(up)) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//            if (lUp.isIntersecting(down)) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//            if (lLeft.isIntersecting(right)) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//            }
//            if (lRight.isIntersecting(left)) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//            }
//            /*
//            If the balls are too fast, the previous part is not enough to check if
//             there is a cut between the radius and the rectangle edge, therefore
//             Check if the ball is inside the rectangle and adjust velocity if necessary.
//             */
//            double dx = this.getVelocity().getDx();
//            double dy = this.getVelocity().getDy();
//            geometry.Point px = new geometry.Point(this.center.getX() + dx, this.center.getY());
//            geometry.Point py = new geometry.Point(this.center.getX(), this.center.getY() + dy);
//            if (px.inQuadrange(rectangle)) {
//                this.v = new movement.Velocity(-v.getDx(), v.getDy());
//            }
//            if (py.inQuadrange(rectangle)) {
//                this.v = new movement.Velocity(v.getDx(), -v.getDy());
//            }
//        }
//    }

    /**
     * Moves the object one step based on its current velocity and checks for collisions.
     * This method calculates the trajectory of the object for its next step,
     * determines if there is a hit.collision with any collidable objects in the game environment,
     * and updates the object's velocity and position based on the hit.collision.
     */
    public void moveOneStep() {
        Line trajectory = getTrajectory();
        CollisionInfo closestCollision = this.gameEnvironment.getClosestCollision(trajectory);
        if (closestCollision != null) {
            Rectangle hitRec = closestCollision.collisionObject().getCollisionRectangle();
            //Collision from down
            if (hitRec.lowerLine().pOnLineSegment(closestCollision.collisionPoint())) {
                center.setY(closestCollision.collisionPoint().getY() + this.radius);
                center.setX(closestCollision.collisionPoint().getX());
            }
            //Collision from up
            if (hitRec.upperLine().pOnLineSegment(closestCollision.collisionPoint())) {
                center.setY(closestCollision.collisionPoint().getY() - this.radius);
                center.setX(closestCollision.collisionPoint().getX());
            }

            //Collision from right
            if (hitRec.rightLine().pOnLineSegment(closestCollision.collisionPoint())) {
                center.setX(closestCollision.collisionPoint().getX() + this.radius);
                center.setY(closestCollision.collisionPoint().getY());

            }
            //Collision from left
            if (hitRec.leftLine().pOnLineSegment(closestCollision.collisionPoint())) {
                center.setX(closestCollision.collisionPoint().getX() - this.radius);
                center.setY(closestCollision.collisionPoint().getY());

            }
            //Update the velocity
            this.v = closestCollision.collisionObject().hit(this, closestCollision.collisionPoint(), this.v);
        }
        center = this.getVelocity().applyToPoint(center);
        //check that the center is not out of borders
        if (center.getX() > 780) {
            this.v = new Velocity(-this.v.getDx(), this.v.getDy());
        }
//        if (center.getY() > 580) {
//            this.v = new Velocity(this.v.getDx(), -this.v.getDy());
//        }

        if (center.getX() < 20) {
            this.v = new Velocity(-this.v.getDx(), this.v.getDy());
        }
        if (center.getY() < 20) {
            this.v = new Velocity(this.v.getDx(), -this.v.getDy());
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        moveOneStep();

    }

    /**
     * Adds this object to the game as a sprite.
     *
     * @param g the game to which the sprite should be added.
     */
    public void addToGame(Game g) {
        g.addSprite(this);
    }

    /**
     * Calculates and returns the trajectory of this object.
     * The trajectory is the path that the object will follow based on its current velocity.
     *
     * @return a geometry.Line representing the trajectory of this object.
     */
    public Line getTrajectory() {
        double endLineX = center.getX() + this.v.getDx();
        double endLiney = center.getY() + this.v.getDy();
        return new Line(center.getX(), center.getY(), endLineX, endLiney);
    }
    /**
     * Removes this ball from the game.
     *
     * @param g the game from which the ball should be removed.
     */
    public void removeFromGame(Game g) {
        g.removeSprite(this);
        g.getCounterballs().decrease(1);
    }
}

