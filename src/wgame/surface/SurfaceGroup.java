package wgame.surface;

import java.util.ArrayList;
import java.util.Arrays;

public class SurfaceGroup extends ArrayList<Surface> {

    public SurfaceGroup(Surface... surfaces) {
        addSurface(surfaces);
    }

    public void addSurface(Surface... surfaces) {
        this.addAll(Arrays.asList(surfaces));
    }

    public void removeSurface(Surface... surfaces) {
        for (Surface surface : surfaces) {
            remove(surface);
        }
    }

    public void update() {
        for (Surface surface : this) {
            surface.update();
        }
    }

}
