package me.Kesims.Bank.test;

import java.util.ArrayList;
import java.util.List;

public class PointService {
    List<Point> storage;
    PointFactory pointFactory;

    public PointService(PointFactory pointFactory) {
        this.storage = new ArrayList<>();
        this.pointFactory = pointFactory;
    }

    public void createPoint(int x, int y) {
        Point p = pointFactory.createPoint(x, y);
        storage.add(p);
    }

    public void addPoint(Point p) {
        storage.add(p);
    }

    public void removePoint(Point p) {
        storage.remove(p);
    }

    public Point[] getAllPoints() {
        return (Point[]) storage.toArray();
    }
}
