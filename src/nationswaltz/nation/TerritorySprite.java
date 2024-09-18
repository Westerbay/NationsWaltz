package nationswaltz.nation;

import nationswaltz.map.Cell;
import nationswaltz.map.Map;
import nationswaltz.map.MapSurface;
import wgame.sprite.Sprite;

import java.awt.*;	
import java.util.Random;

public class TerritorySprite extends Sprite {
	
	protected static final Color BORDER_COLOR = Color.black;
	protected final Cell _cell;
    private final Territory _territory;
    private final MapSurface _mapSurface;

    public TerritorySprite(Territory territory, Map map, MapSurface mapSurface) {
        super(0, 0, 0, 0);
        _mapSurface = mapSurface;
        _cell = territory.getCell();
        _territory = territory;
    }

    @Override
    public void addEvents() {
        TerritoryController territoryController = new TerritoryController(_territory, this);
        addMouseListener(territoryController);
        addMouseMotionListener(territoryController);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(_territory.getNation().getColor());
        g.fillPolygon(_cell.getScaledPolygon());
        g.setColor(BORDER_COLOR);
        g.drawPolygon(_cell.getScaledPolygon());
    }

}

