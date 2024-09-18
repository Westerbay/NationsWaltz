package wgame.sprite;

import wgame.surface.Surface;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class SpriteGroup extends ArrayList<Sprite> {

    public Surface _surface;

    public SpriteGroup(Surface surface, Sprite... sprites) {
        _surface = surface;
        addSprite(sprites);
    }

    public SpriteGroup(Sprite... sprites) {
        this(null, sprites);
    }

    public SpriteGroup(Surface surface) {
        _surface = surface;
    }

    public Surface getSurface() {
        return _surface;
    }

    public void addSprite(Sprite... sprites) {
        for (Sprite sprite : sprites) {
            add(sprite);
            sprite.setSpriteGroup(this);
        }
    }

    public void removeSprite(Sprite... sprites) {
        for (Sprite sprite : sprites) {
            remove(sprite);
        }
    }

    private void checkSurfaceAssigned() {
        if (_surface == null) {
            throw new SurfaceNotAssignedException();
        }
        _surface.setFocusable(true);
    }

    public void addKeyListener(KeyListener keyListener) {
        checkSurfaceAssigned();
        _surface.addKeyListener(keyListener);
    }

    public void removeKeyListener(KeyListener keyListener) {
        checkSurfaceAssigned();
        _surface.removeKeyListener(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener) {
        checkSurfaceAssigned();
        _surface.addMouseListener(mouseListener);
    }

    public void removeMouseListener(MouseListener mouseListener) {
        checkSurfaceAssigned();
        _surface.removeMouseListener(mouseListener);
    }

    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        checkSurfaceAssigned();
        _surface.addMouseMotionListener(mouseMotionListener);
    }

    public void removeMouseMotionListener(MouseMotionListener mouseMotionListener) {
        checkSurfaceAssigned();
        _surface.removeMouseMotionListener(mouseMotionListener);
    }

    public void update() {
        for (Sprite sprite : this) {
            sprite.update();
        }
    }

    public void draw(Graphics g) {
        for (Sprite sprite : this) {
            sprite.draw(g);
        }
    }

}
