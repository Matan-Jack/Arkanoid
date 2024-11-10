//207829763 Matan Jack
package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import geometry.Point;
import geometry.Rectangle;
import hit.Ball;
import hit.collision.Block;
import hit.collision.Collidable;
import hit.collision.Paddle;

import java.awt.Color;

import listener.BallRemover;
import listener.BlockRemover;
import listener.HundredScoreListener;
import listener.ScoreTrackingListener;
import sprite.ScoreIndicator;
import sprite.SpriteCollection;
import sprite.Sprite;
import movement.Velocity;

/**
 * The game.Game class represents the main game logic and handles the initialization and running of the game.
 * * @author Matan Jack
 * * @version 2
 * * @since 2024-07-04
 */
public class Game {
    //filled
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private GUI gui;
    private final Counter counterblocks;
    private final Counter counterballs;
    private final Counter score;

    /**
     * constructor for game.Game.
     * Initializes the sprites and environment fields.
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterblocks = new Counter();
        this.counterballs = new Counter();
        this.score = new Counter();
    }
//    /**
//     * Returns the counter for blocks.
//     *
//     * @return the counter for blocks
//     */
//    public Counter getCounterblocks() {
//        return this.counterblocks;
//    }

    /**
     * Returns the counter for balls.
     *
     * @return the counter for balls
     */
    public Counter getCounterballs() {
        return this.counterballs;
    }

    /**
     * Returns the collection of sprites.
     *
     * @return the collection of sprites
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }

    /**
     * Adds a collidable object to the game environment.
     *
     * @param c the collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adds a sprite to the game.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initializes a new game: creates the blocks, balls, and paddle, and adds them to the game.
     */
    public void initialize() {
        Block background = new Block(new Rectangle(new Point(0, 0), 800, 600, Color.WHITE));
        background.addToGame(this);
        Ball ball1 = new Ball(new Point(250, 500), 5, Color.black, this.environment);
        Ball ball2 = new Ball(new Point(250, 500), 5, Color.black, this.environment);
        Ball ball3 = new Ball(new Point(250, 500), 5, Color.black, this.environment);
        Velocity v1 = new Velocity(2, -3);
        Velocity v2 = new Velocity(4, -3);
        Velocity v3 = new Velocity(3, -3);
        ball1.setVelocity(v1);
        ball1.addToGame(this);
        counterballs.increase(1);
        ball2.setVelocity(v2);
        ball2.addToGame(this);
        counterballs.increase(1);
        ball3.setVelocity(v3);
        ball3.addToGame(this);
        counterballs.increase(1);
        //borders
        Block left = new Block(new Rectangle(new Point(0, 0), 20, 600,
                Color.GRAY));
        left.addToGame(this);
        Block right = new Block(new Rectangle(new Point(780, 0), 20,
                600, Color.GRAY));
        right.addToGame(this);
        Block up = new Block(new Rectangle(new Point(0, 0), 800, 20,
                Color.GRAY));
        up.addToGame(this);
        Block deathRegion = new Block(new Rectangle(new Point(0, 600), 800, 20,
                Color.BLACK));
        deathRegion.addToGame(this);
        BallRemover ballRemover = new BallRemover(this);
        deathRegion.addHitListener(ballRemover);
        //num of blocks at the first line.
        int numBlocks = 12;
        int x = 720;
        int y = 150;
        Color[] colorArr = {Color.yellow, Color.MAGENTA, Color.cyan, Color.LIGHT_GRAY, Color.orange, Color.PINK};
        BlockRemover blockRemover = new BlockRemover(this, this.counterblocks);
        //num of lines of blocks (6).
        for (int i = 0; i < 6; i++) {
            ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
            HundredScoreListener hundredScoreListener = new HundredScoreListener(score, numBlocks);
            for (int j = 0; j < numBlocks; j++) {
                Block block = new Block(new Rectangle(new Point(x, y), 60, 20,
                        colorArr[i]));

                block.addToGame(this);
                this.counterblocks.increase(1);
                x = x - 60;
                block.addHitListener(blockRemover);
                block.addHitListener(scoreTrackingListener);
                block.addHitListener(hundredScoreListener);
            }
            numBlocks = numBlocks - 1;
            x = 720;
            y = y + 20;
        }
        this.gui = new GUI("game.Game", 800, 600);
        //initialize the paddle
        Paddle paddle = new Paddle(gui.getKeyboardSensor());
        paddle.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        scoreIndicator.addToGame(this);
    }

    /**
     * Runs the game, starting the animation loop.
     */
    public void run() {
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (this.counterblocks.getValue() > 0 && this.counterballs.getValue() > 0) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            this.sprites.drawAllOn(d);
            gui.show(d);
            this.sprites.notifyAllTimePassed();
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        gui.close();
    }

    /**
     * Removes a collidable object from the game environment.
     *
     * @param c the collidable object to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.getColidable().remove(c);
    }

    /**
     * Removes a sprite from the game.
     *
     * @param s the sprite to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprite().remove(s);
    }

    /**
     * The main method, starts the game.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.run();
    }
}
