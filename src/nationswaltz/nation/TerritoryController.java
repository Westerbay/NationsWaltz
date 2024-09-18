package nationswaltz.nation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TerritoryController implements MouseListener, MouseMotionListener {

    private final Territory _territory;
    private final TerritorySprite _territorySprite;

    public TerritoryController(Territory territory, TerritorySprite territorySprite) {
        _territory = territory;
        _territorySprite = territorySprite;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (_territory.getCell().getScaledPolygon().contains(e.getPoint())) {
        
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
