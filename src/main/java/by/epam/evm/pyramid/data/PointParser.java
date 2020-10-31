package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointParser implements Parser {

    private final static String PYRAMID_PATTERN = "\\w<(-?\\d+.?\\d*);(-?\\d+.?\\d*);(-?\\d+.?\\d*)>";
    private final static int X_COORDINATE = 1;
    private final static int Y_COORDINATE = 2;
    private final static int Z_COORDINATE = 3;

    public List<Point> parse(String dataPoints) {

        List<Point> points = new ArrayList<>();
        Pattern pattern = Pattern.compile(PYRAMID_PATTERN);
        Matcher matcher = pattern.matcher(dataPoints);

        while (matcher.find()) {
            String dataX = matcher.group(X_COORDINATE);
            double coordinateX = Double.parseDouble(dataX);
            String dataY = matcher.group(Y_COORDINATE);
            double coordinateY = Double.parseDouble(dataY);
            String dataZ = matcher.group(Z_COORDINATE);
            double coordinateZ = Double.parseDouble(dataZ);
            Point point = new Point(coordinateX, coordinateY, coordinateZ);
            points.add(point);
        }
        return points;
    }
}
