package nationswaltz.game;

import wgame.screen.Screen;

import java.awt.*;

public class GameScreen extends Screen {

    private static final String TITLE = "Nation's Waltz";

    public GameScreen(Game game) {
        super(TITLE);
        GamePanel gamePanel = new GamePanel(game, 1280, 720);
        addSurface(gamePanel);
    }

}
