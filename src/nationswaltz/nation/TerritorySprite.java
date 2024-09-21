package nationswaltz.nation;

import nationswaltz.map.Cell;
import wgame.sprite.Sprite;

import java.awt.*;	
import java.util.Random;

public class TerritorySprite extends Sprite {
	
	protected static final Color BORDER_COLOR = Color.black;
	protected final Cell _cell;
    private final Territory _territory;

    public TerritorySprite(Territory territory) {
        super();
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

