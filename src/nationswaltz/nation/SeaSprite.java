package nationswaltz.nation;

import nationswaltz.map.Map;
import nationswaltz.map.MapSurface;

import java.awt.Color;

public class SeaSprite extends TerritorySprite {

    private static final Color _color = new Color(0, 0, 255);

    public SeaSprite(Territory territory, Map map, MapSurface mapSurface) {
        super(territory, map, mapSurface);
        setColor(_color);
    }

}
