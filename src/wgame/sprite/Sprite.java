package wgame.sprite;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Sprite extends Rectangle {

    private SpriteGroup _spriteGroup = null;
    private BufferedImage _image = null;

    public Sprite(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Sprite(BufferedImage image, int x, int y) {
        this(x, y, image.getWidth(null), image.getHeight(null));
        _image = image;
    }

    public Sprite(String path, int x, int y) {
        _image = createImage(path);
        if (_image != null) {
            setBounds(x, y, _image.getWidth(null), _image.getHeight(null));
        }
        else {
            setBounds(x, y, 0, 0);
        }
    }
    
    public Sprite() {
    	this(0, 0, 0, 0);
    }

    private BufferedImage createImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    public SpriteGroup getGroup() {
        return _spriteGroup;
    }

    public BufferedImage getImage() {
        return _image;
    }

    public void scale(int width, int height) {

        if (_image == null) {
            return;
        }

        Image tmp = _image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = _image.createGraphics();
        g.drawImage(tmp, 0, 0, null);
        g.dispose();
        setSize(width, height);

    }

    public void translateX(int dx) {
        translate(dx, 0);
    }

    public void translateY(int dy) {
        translate(0, dy);
    }

    public SpriteGroup getSpriteGroup() {
        return _spriteGroup;
    }

    public void setSpriteGroup(SpriteGroup spriteGroup) {
        _spriteGroup = spriteGroup;
        addEvents();
    }

    public void kill() {
        if (_spriteGroup != null) {
            _spriteGroup.remove(this);
        }
    }

    private void checkSurfaceAssigned() {
        if (_spriteGroup == null) {
            throw new SurfaceNotAssignedException();
        }
    }

    public void addKeyListener(KeyListener keyListener) {
        checkSurfaceAssigned();
        _spriteGroup.addKeyListener(keyListener);
    }

    public void removeKeyListener(KeyListener keyListener) {
        checkSurfaceAssigned();
        _spriteGroup.removeKeyListener(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener) {
        checkSurfaceAssigned();
        _spriteGroup.addMouseListener(mouseListener);
    }

    public void removeMouseListener(MouseListener mouseListener) {
        checkSurfaceAssigned();
        _spriteGroup.removeMouseListener(mouseListener);
    }

    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        checkSurfaceAssigned();
        _spriteGroup.addMouseMotionListener(mouseMotionListener);
    }

    public void removeMouseMotionListener(MouseMotionListener mouseMotionListener) {
        checkSurfaceAssigned();
        _spriteGroup.removeMouseMotionListener(mouseMotionListener);
    }

    public void drawImage(Graphics g, Image image) {
        if (_image != null) {
            g.drawImage(image, (int) getX(), (int) getY(), null);
        }
    }

    public void drawImage(Graphics g) {
        drawImage(g, _image);
    }

    public void drawRect(Graphics g) {
        g.drawRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    public void fillRect(Graphics g) {
        g.drawRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    public abstract void addEvents();

    public abstract void update();

    public abstract void draw(Graphics g);

}
