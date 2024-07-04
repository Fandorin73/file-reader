package parse;

import constants.ConstForPoint;
import constants.Message;
import dto.Point;

import java.util.ArrayList;
/**
 * Парсинг из строки объектов Point.
 *
 * @author Andrey
 */
public class PointParse implements Parse {
    @Override
    public ArrayList<Point> parseToObj(StringBuilder sb) {
        var points = new ArrayList<Point>();
        int count = 0;
        try {
            while (!sb.isEmpty()) {
                Point point = new Point();
                switch (count) {
                    case 0: {
                        sb.delete(0, ConstForPoint.LINE_NAME.length());
                        point.setName((sb.substring(0, sb.indexOf(ConstForPoint.LINE_X) - 2)));
                        sb.delete(0, sb.indexOf(ConstForPoint.LINE_X));
                        count++;
                    }
                    case 1: {
                        sb.delete(0, ConstForPoint.LINE_X.length());
                        point.setX(Integer.parseInt(sb.substring(0, sb.indexOf(ConstForPoint.LINE_Y) - 2)));
                        sb.delete(0, sb.indexOf(ConstForPoint.LINE_Y));
                        count++;
                    }
                    case 2: {
                        if (sb.indexOf(ConstForPoint.LINE_X) != -1) {
                            sb.delete(0, ConstForPoint.LINE_Y.length());
                            point.setY(Integer.parseInt((sb.substring(0, sb.indexOf(ConstForPoint.LINE_NAME) - 2))));
                            sb.delete(0, sb.indexOf(ConstForPoint.LINE_NAME));
                            count = 0;
                        } else {
                            sb.delete(0, ConstForPoint.LINE_Y.length());
                            point.setY(Integer.parseInt(sb.toString().replaceAll("(\\r|\\n)", "")));
                            sb.delete(0, sb.length());
                            count = 0;
                        }
                    }
                }
                points.add(point);
            }
        }
        catch (NumberFormatException e){
            System.out.println(Message.FILE_DATA_ERROR.format());
        }
        return points;
    }
}