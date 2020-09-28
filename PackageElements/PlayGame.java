package PackageElements;

/**
 * PlayGame This is the function for the chronological order of the game. Due to
 * it being the start of the game, it also has the only main method that is
 * present in the game.
 */
public class PlayGame {

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
        System.out.println("Changed something!");
    }
}