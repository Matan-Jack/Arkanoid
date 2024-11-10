//207829763 Matan Jack
import game.Game;
/**
 * The game.Ass3Game class serves as the entry point for the game application.
 * It initializes and starts the game.
 * * @author Matan Jack
 * * @version 1
 * * @since 2024-06-11
 */
public class Ass5Game {

        /**
         * The main method that serves as the entry point for the game application.
         * It creates an instance of the game.Game class, initializes it, and starts the game.
         *
         * @param args command-line arguments (not used).
         */
        public static void main(String[] args) {
            Game game = new Game();
            game.initialize();
            game.run();
        }
    }


