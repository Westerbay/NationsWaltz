package nationswaltz.map;

import wgame.surface.Surface;

import java.awt.Rectangle;
import java.awt.Color;

import nationswaltz.nation.*;
import nationswaltz.territory.*;

/**
 * @author Wester
 */
public class MapSurface extends Surface {

    private final Map _map;
    private final Surface _parent;
    private double _zoom = 1;

    public MapSurface(Surface parent, Map map) {
        super(map.getWidth(), map.getHeight());
        _parent = parent;
        _map = map;
        for (Territory territory: _map.getTerritories()) {
        	addSprite(new TerritorySprite(territory));
        }
        MapController controller = new MapController(this);
        addMouseMotionListener(controller);
        addMouseListener(controller);
        addKeyListener(controller);
        addMouseWheelListener(controller);
        setBackground(Color.BLACK);
    }

    public Surface getParent() {
        return _parent;
    }

    public Rectangle getCamera() {
        return new Rectangle(-getX(), -getY(), _parent.getWidth(), _parent.getHeight());
    }

    public void scale(double scaleFactor) {
        _zoom += scaleFactor;
        double maxZoom = 4;
        double minZoom = 1;
        if (_zoom > maxZoom) {
            _zoom = maxZoom;
        }
        else if (_zoom < minZoom) {
            _zoom = minZoom;
        }
        else {
            setSize((int) (_map.getWidth() * _zoom), (int) (_map.getHeight() * _zoom));
            for (Cell cell: _map.getCells()) {
                cell.scalePolygon(_zoom);
            }
            int x = Math.max(getX(), _parent.getWidth() - getWidth());
            x = Math.min(x, 0);
            int y = Math.max(getY(), _parent.getHeight() - getHeight());
            y = Math.min(y, 0);
            setLocation(x, y);
        }
    }

}
