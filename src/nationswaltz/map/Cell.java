package nationswaltz.map;

import java.awt.*;
import java.util.*;

/**
 * @author Wester
 */
public class Cell {

    private final Polygon _polygon;
    private Polygon _scaledPolygon;
    private final Point _site;
    private final HashSet<Point> _neighboorSite = new HashSet<>();

    public Cell(Point site, Polygon polygon) {
        _site = site;
        _polygon = polygon;
        _scaledPolygon = new Polygon(_polygon.xpoints, _polygon.ypoints, _polygon.npoints);
    }

    public Point getSite() {
        return _site;
    }

    public Polygon getPolygon() {
        return _polygon;
    }

    public Polygon getScaledPolygon() {
        return _scaledPolygon;
    }
    
    public HashSet<Point> getNeighboorSite() {
    	return _neighboorSite;
    }

    public void scalePolygon(double scale) {
        _scaledPolygon = new Polygon();
        for (int i = 0; i < _polygon.npoints; i++) {
            _scaledPolygon.addPoint((int) (_polygon.xpoints[i] * scale),
                    (int) (_polygon.ypoints[i] * scale));
        }
    }

}
