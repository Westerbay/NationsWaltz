package nationswaltz.game;

import nationswaltz.nation.NationSprite;
import nationswaltz.map.MapSurface;
import wgame.surface.Surface;
import java.awt.Color;

public class GamePanel extends Surface {

	private static final int MAP_SIZE = 720;
	
    public GamePanel(Game game, int width, int height) {
        super(width, height);
        Surface encapsulateMap = new Surface(MAP_SIZE, MAP_SIZE);
        MapSurface mapSurface = new MapSurface(encapsulateMap, game.getMap());
        Surface nationSurface = new Surface(MAP_SIZE, 0, width - MAP_SIZE, height);
        nationSurface.addSprite(new NationSprite(game.getMap()));
        encapsulateMap.addSurface(mapSurface);
        addSurface(encapsulateMap);
        addSurface(nationSurface);
    }

}

