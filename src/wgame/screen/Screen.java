package wgame.screen;


import wgame.surface.Surface;
import wgame.surface.SurfaceGroup;

import javax.swing.JFrame;


public class Screen extends JFrame implements Runnable {

    private final SurfaceGroup _surfaceGroup = new SurfaceGroup();
    private int _FPS = 60;
    private boolean _running = false;

    public Screen(String title) {
        super(title);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getFPS() {
        return _FPS;
    }

    public void setFPS(int fps) {
        _FPS = fps;
    }

    public boolean isRunning() {
        return _running;
    }

    public void setRunning(boolean running) {
        _running = running;
    }

    public void addSurface(Surface... surfaces) {
        for (Surface surface : surfaces) {
            add(surface);
            _surfaceGroup.add(surface);
        }
    }

    public void removeSurface(Surface... surfaces) {
        for (Surface surface : surfaces) {
            remove(surface);
            _surfaceGroup.remove(surface);
        }
    }

    public void start() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        _running = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / (double) _FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (_running) {
            _surfaceGroup.update();
            repaint();
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime /= 1000000;
            if (remainingTime < 0) {
                remainingTime = 0;
            }
            sleep((long) remainingTime);
            nextDrawTime += drawInterval;
        }
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

}