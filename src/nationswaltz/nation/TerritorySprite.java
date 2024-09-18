package nationswaltz.nation;

import nationswaltz.map.Cell;
import nationswaltz.map.Map;
import nationswaltz.map.MapSurface;
import wgame.sprite.Sprite;

import java.awt.*;
import java.util.Random;

public class TerritorySprite extends Sprite {

    private Color _color;
    private static final Color WILDERNESS = new Color(0, 255, 0);
    private final Random _random = new Random();
    private final Territory _territory;
    private final Cell _cell;
    private final MapSurface _mapSurface;

    public TerritorySprite(Territory territory, Map map, MapSurface mapSurface) {
        super(0, 0, 0, 0);
        _mapSurface = mapSurface;
        _cell = territory.getCell();
        _color = getRandomColor();
        _territory = territory;
        if (territory.getNation() == map.getWilderness()) {
            _color = WILDERNESS;
        }
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        _color = color;
    }

    public Color getRandomColor() {
        int red = _random.nextInt(255);
        int green = _random.nextInt(255);
        int blue = _random.nextInt(255);
        return new Color(red, green, blue);
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
        g.setColor(_color);
        g.fillPolygon(_cell.getScaledPolygon());
        g.setColor(Color.black);
        g.drawPolygon(_cell.getScaledPolygon());
    }

}
