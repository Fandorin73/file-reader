package dto.comparator;

import dto.Point;
import java.util.Comparator;

/**
 * Компоратор для точки(Point) сравнивает их расстоянию от начала координат
 *
 * @author Andrey
 */
public class PointDistanceFromOriginComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double p1 = Math.sqrt(o1.getX() * o1.getX() + o1.getY() * o1.getY());
        double p2 = Math.sqrt(o2.getX() * o2.getX() + o2.getY() * o2.getY());
        return Double.compare(p1, p2);
    }

}

