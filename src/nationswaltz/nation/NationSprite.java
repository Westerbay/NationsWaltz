package nationswaltz.nation;

import wgame.sprite.Sprite;
import nationswaltz.map.Map;

import java.awt.Graphics;

public class NationSprite extends Sprite {

	private final Map _map;
	private Nation _nation;

    public NationSprite(Map map) {
    	super();
		_map = map;
    }
    
    @Override
    public void addEvents() {
    }

    @Override
    public void update() {
    	_nation = _map.getSelectedNation();
    }

    @Override
    public void draw(Graphics g) {
    	if (_nation == null) {
    		return;
    	}
    	g.setColor(_nation.getColor());
    	g.fillRect(0, 0, 1280 - 720, 720);
    }
    
}

