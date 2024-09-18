import nationswaltz.game.Game;
import nationswaltz.game.GameScreen;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(() -> new GameScreen(new Game()).start());
    }

}