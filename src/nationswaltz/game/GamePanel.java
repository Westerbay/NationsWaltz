package nationswaltz.game;

import nationswaltz.map.MapSurface;
import wgame.surface.Surface;

public class GamePanel extends Surface {

    public GamePanel(Game game, int width, int height) {
        super(width, height);
        MapSurface mapSurface = new MapSurface(this, game.getMap());
        addSurface(mapSurface);
    }

}
