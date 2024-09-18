package nationswaltz.nation;

import nationswaltz.map.Map;
import nationswaltz.map.MapSurface;

import java.awt.Color;
import java.awt.Graphics;

public class SeaSprite extends TerritorySprite {

    private static final Color _color = new Color(0, 0, 255);

    public SeaSprite(Territory territory, Map map, MapSurface mapSurface) {
        super(territory, map, mapSurface);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(_color);
        g.fillPolygon(_cell.getScaledPolygon());
        g.setColor(BORDER_COLOR);
        g.drawPolygon(_cell.getScaledPolygon());
    }

}
