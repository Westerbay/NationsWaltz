package wgame.surface;

import wgame.sprite.Sprite;
import wgame.sprite.SpriteGroup;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class Surface extends JPanel {

    private final SpriteGroup _spriteGroup;
    private final SurfaceGroup _surfaceGroup;

    public Surface(int x, int y, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        setBounds(x, y, width, height);
        _spriteGroup = new SpriteGroup(this);
        _surfaceGroup = new SurfaceGroup();
    }

    public Surface(int width, int height) {
        this(0, 0, width, height);
    }

    public void addSurface(Surface... surfaces) {
        for (Surface surface : surfaces) {
            add(surface);
            _surfaceGroup.addSurface(surface);
        }
    }

    public void addSprite(Sprite... sprites) {
        _spriteGroup.addSprite(sprites);
    }

    public void addSprite(SpriteGroup spriteGroup) {
        for (Sprite sprite : spriteGroup) {
            addSprite(sprite);
        }
    }

    public void removeSprite(Sprite... sprites) {
        _spriteGroup.removeSprite(sprites);
    }

    public void update(){
        _spriteGroup.update();
        _surfaceGroup.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        _spriteGroup.draw(g);
    }

}
