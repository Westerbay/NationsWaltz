package nationswaltz.territory;

import nationswaltz.map.Cell;
import wgame.sprite.Sprite;

import java.awt.*;	
import java.util.Random;


/**
 * @author Wester
 */
public class TerritorySprite extends Sprite {
	
	private static final Color SEA_COLOR = Color.blue;
	private static final Color BORDER_COLOR = Color.black;
	
	private final Cell _cell;
    private final Territory _territory;

    public TerritorySprite(Territory territory) {
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
        if (_territory.isLand()) {
        	g.setColor(_territory.getNation().getColor());
        } else {
        	g.setColor(SEA_COLOR);
        }
        g.fillPolygon(_cell.getScaledPolygon());
        g.setColor(BORDER_COLOR);
        g.drawPolygon(_cell.getScaledPolygon());
    }

}

