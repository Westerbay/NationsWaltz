package nationswaltz.map;

import java.awt.Polygon;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Voronoi {

    private final Set<Cell> _cells = new HashSet<>();
    private final int _width;
    private final int _height;

    public Voronoi(int nbCells, int width, int height) {
        _width = width;
        _height = height;
        generatePoints(nbCells, width, height);
    }

    private Point generatePoint(Map<Point, Set<Point>> points, Random random) {
        Point point;
        do {
            int x = random.nextInt(_width);
            int y = random.nextInt(_height);
            point = new Point(x, y);
        } while (points.containsKey(point));
        return point;
    }

    private void generatePoints(int nbPoint, int width, int height) {
        Map<Point, Set<Point>> points = new HashMap<>();
        Random random = new Random();
        Map<Point, Point> startLimits = new HashMap<>();
        for (int i = 0; i < nbPoint; i++) {
            points.put(generatePoint(points, random), new HashSet<>());
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Point point = new Point(x, y);
                Point closestPoint = point;
                int closestDistance = Integer.MAX_VALUE;
                for (Point site : points.keySet()) {
                    int distancePoint = distance(point, site);
                    if (distancePoint < closestDistance) {
                        closestPoint = site;
                        closestDistance = distancePoint;
                    }
                }
                if (!startLimits.containsKey(closestPoint)) {
                    startLimits.put(closestPoint, point);
                }
                points.get(closestPoint).add(point);
            }
        }

        for (Point site : points.keySet()) {
            Point firstPoint = startLimits.get(site);
            Set<Point> limits = new HashSet<>();
            for (Point point : points.get(site)) {
                if (neighbour(point, points.get(site)).size() != 4) {
                    limits.add(point);
                    firstPoint = point;
                }
            }
            Polygon polygon = new Polygon();
            polygon.addPoint(firstPoint.x, firstPoint.y);
            limits.remove(firstPoint);
            while (!limits.isEmpty()) {
                int minDistance = Integer.MAX_VALUE;
                Point closestPoint = firstPoint;
                for (Point point : limits) {
                    int distancePoint = distance(point, firstPoint);
                    if (distancePoint < minDistance) {
                        minDistance = distancePoint;
                        closestPoint = point;
                    }
                }
                if (minDistance > 50) {
                    break;
                }
                polygon.addPoint(closestPoint.x, closestPoint.y);
                limits.remove(closestPoint);
                firstPoint = closestPoint;
            }
            _cells.add(new Cell(site, polygon));
        }
    }

    private List<Point> neighbour(Point point, Set<Point> points) {
        Point[] neighbours = {
                new Point(point.x, point.y - 1),
                new Point(point.x - 1, point.y),
                new Point(point.x + 1, point.y),
                new Point(point.x, point.y + 1)
        };
        List<Point> neighbourList = new ArrayList<>();
        for (Point neighbour : neighbours) {
            if (points.contains(neighbour)) {
                neighbourList.add(neighbour);
            }
        }
        return neighbourList;
    }

    private int distance(Point A, Point B) {
        int dx = B.x - A.x;
        int dy = B.y - A.y;
        return dx * dx + dy * dy;
    }

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public Set<Cell> getCells() {
        return _cells;
    }

}

