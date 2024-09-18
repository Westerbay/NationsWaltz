package nationswaltz.map;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

public class MapController implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {

    private final MapSurface _mapView;
    private Point _initialClick;

    public MapController(MapSurface mapView) {
        _mapView = mapView;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int deltaX = e.getX() - _initialClick.x;
        int deltaY = e.getY() - _initialClick.y;
        int newX = _mapView.getX() + deltaX;
        int newY = _mapView.getY() + deltaY;

        Dimension parentSize = _mapView.getParent().getSize();
        Dimension size = _mapView.getSize();
        newX = Math.max(newX, parentSize.width - size.width);
        newX = Math.min(newX, 0);
        newY = Math.max(newY, parentSize.height - size.height);
        newY = Math.min(newY, 0);

        _mapView.setLocation(newX, newY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                _mapView.scale(0.5);
                break;
            case KeyEvent.VK_S:
                _mapView.scale(-0.5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        _initialClick = e.getPoint();
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
    public void mouseWheelMoved(MouseWheelEvent e) {
        _mapView.scale(0.1 * -e.getWheelRotation());
    }
}
