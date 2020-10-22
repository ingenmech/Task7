package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PyramidCalculator {

    private final static Logger LOGGER = LogManager.getLogger(PyramidCalculator.class);

    private final static Point ZERO_POINT = new Point(0, 0, 0);
    private final static Point PLANE_VECTOR_XOY = new Point(0, 0, 1);
    private final static Point PLANE_VECTOR_ZOY = new Point(1, 0, 0);
    private final static Point PLANE_VECTOR_XOZ = new Point(0, 1, 0);
    private final static double COORDINATE_ZERO = 0;

    public double calculateArea(Pyramid pyramid) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();

        Point vectorAH = calculateVector(baseA, apexH);
        Point vectorAD = calculateVector(baseA, baseD);

        double baseArea = calculateBaseArea(baseA, baseB, baseC, baseD);
        double sideArea = calculateAreaByVectors(vectorAH, vectorAD) * 2; // function for four side

        return baseArea + sideArea;
    }

    private double calculateBaseArea(Point baseA, Point baseB, Point baseC, Point baseD) {
        Point vectorAC = calculateVector(baseA, baseC);
        Point vectorBD = calculateVector(baseB, baseD);

        return calculateAreaByVectors(vectorAC, vectorBD);
    }

    private double calculateAreaByVectors(Point vectorA, Point vectorB) {

        Point multiplyABCD = multiplyVectors(vectorA, vectorB);

        return calculateLengthBetweenPoints(ZERO_POINT, multiplyABCD);
    }

    public double calculateVolume(Pyramid pyramid) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();

        Point middleBasePoint = calculateMiddlePoint(baseA, baseC);
        double pyramidHeight = calculateLengthBetweenPoints(middleBasePoint, apexH);
        double baseArea = calculateBaseArea(baseA, baseB, baseC, baseD);

        return baseArea * pyramidHeight / 3; // function for volume
    }

    public double calculateVolumeRatio(Pyramid pyramid, CartesianPlane plane) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();
        Point vectorHA = calculateVector(apexH, baseA);
        Point vectorHB = calculateVector(apexH, baseB);
        Point vectorHC = calculateVector(apexH, baseC);
        Point vectorHD = calculateVector(apexH, baseD);
        Point vectorAD = calculateVector(baseA, baseD);
        Point vectorBC = calculateVector(baseB, baseC);
        Point vectorAB = calculateVector(baseA, baseB);
        Point vectorCD = calculateVector(baseC, baseD);

        List<Point> vectors = Arrays.asList(vectorHA, vectorHB, vectorHC, vectorHD,
                vectorAD, vectorBC, vectorAB, vectorCD);
        List<Point> vectorPoints = Arrays.asList(apexH, apexH, apexH, apexH, baseA, baseB, baseA, baseC);

        Optional<Point> calculatedPoint;
        double resultRatio = 1;
        Point vector;
        Point point;
        Point tempPoint;

        for (int i = 0; i < vectors.size(); i++) {
            vector = vectors.get(i);
            point = vectorPoints.get(i);
            calculatedPoint = calculateIntersection(point, vector, plane);

            if (calculatedPoint.isPresent()) {
                tempPoint = calculatedPoint.get();
                resultRatio *= calculateEdgeRatio(point, tempPoint, vector);
            }
        }
        return resultRatio;
    }

    private double calculateEdgeRatio(Point firstPoint, Point secondPoint, Point vector) {
        double firstLengthEdge;
        double secondLengthEdge;

        secondLengthEdge = calculateLengthBetweenPoints(firstPoint, secondPoint);
        firstLengthEdge = calculateLengthBetweenPoints(vector, ZERO_POINT);
        return secondLengthEdge / firstLengthEdge;
    }

    private Optional<Point> calculateIntersection(Point vectorPoint, Point vector, CartesianPlane plane) {
        if (!isIntersection(vector, plane)) {
            LOGGER.warn(String.format("Plane %s and vector %s do not intersect", plane, vector));
            return Optional.empty();
        }

        double vectorX = vector.getCoordinateX();
        double vectorY = vector.getCoordinateY();
        double vectorZ = vector.getCoordinateZ();
        double pointX = vectorPoint.getCoordinateX();
        double pointY = vectorPoint.getCoordinateY();
        double pointZ = vectorPoint.getCoordinateZ();

        Point resultPoint;
        double resultX;
        double resultY;
        double resultZ;
        double temp;


        switch (plane) {
            case XOY:
                temp = -pointZ / vectorZ;
                resultX = pointX + vectorX * temp;
                resultY = pointY + vectorY * temp;
                resultPoint = new Point(resultX, resultY, COORDINATE_ZERO);
                break;
            case ZOY:
                temp = -pointX / vectorX;
                resultZ = pointZ + vectorZ * temp;
                resultY = pointY + vectorY * temp;
                resultPoint = new Point(COORDINATE_ZERO, resultY, resultZ);
                break;
            case XOZ:
                temp = -pointY / vectorY;
                resultX = pointX + vectorX * temp;
                resultZ = pointZ + vectorZ * temp;
                resultPoint = new Point(resultX, COORDINATE_ZERO, resultZ);
                break;
            default:
                throw new IllegalArgumentException(String.format("Not exist cartesian plane %s", plane));
        }
        return Optional.of(resultPoint);
    }

    private boolean isIntersection(Point vector, CartesianPlane plane) {

        double vectorProduct;

        if (plane == CartesianPlane.XOY) {
            vectorProduct = scalarMultiplyVectors(vector, PLANE_VECTOR_XOY);
        } else if (plane == CartesianPlane.ZOY) {
            vectorProduct = scalarMultiplyVectors(vector, PLANE_VECTOR_ZOY);
        } else {
            vectorProduct = scalarMultiplyVectors(vector, PLANE_VECTOR_XOZ);
        }
        return vectorProduct != 0;
    }

    public Point calculateMiddlePoint(Point firstPoint, Point secondPoint) {

        double firstX = firstPoint.getCoordinateX();
        double firstY = firstPoint.getCoordinateY();
        double firstZ = firstPoint.getCoordinateZ();
        double secondX = secondPoint.getCoordinateX();
        double secondY = secondPoint.getCoordinateY();
        double secondZ = secondPoint.getCoordinateZ();
        double middleX = (firstX + secondX) / 2;
        double middleY = (firstY + secondY) / 2;
        double middleZ = (firstZ + secondZ) / 2;

        return new Point(middleX, middleY, middleZ);
    }

    public double calculateLengthBetweenPoints(Point firstPoint, Point secondPoint) {

        double firstX = firstPoint.getCoordinateX();
        double firstY = firstPoint.getCoordinateY();
        double firstZ = firstPoint.getCoordinateZ();
        double secondX = secondPoint.getCoordinateX();
        double secondY = secondPoint.getCoordinateY();
        double secondZ = secondPoint.getCoordinateZ();

        return Math.sqrt((secondX - firstX) * (secondX - firstX) + (secondY - firstY) *
                (secondY - firstY) + (secondZ - firstZ) * (secondZ - firstZ));
    }

    public Point calculateVector(Point firstPoint, Point secondPoint) {

        double firstX = firstPoint.getCoordinateX();
        double firstY = firstPoint.getCoordinateY();
        double firstZ = firstPoint.getCoordinateZ();
        double secondX = secondPoint.getCoordinateX();
        double secondY = secondPoint.getCoordinateY();
        double secondZ = secondPoint.getCoordinateZ();
        double vectorX = secondX - firstX;
        double vectorY = secondY - firstY;
        double vectorZ = secondZ - firstZ;

        return new Point(vectorX, vectorY, vectorZ);
    }

    public double scalarMultiplyVectors(Point firstVector, Point secondVector) {

        double firstX = firstVector.getCoordinateX();
        double firstY = firstVector.getCoordinateY();
        double firstZ = firstVector.getCoordinateZ();
        double secondX = secondVector.getCoordinateX();
        double secondY = secondVector.getCoordinateY();
        double secondZ = secondVector.getCoordinateZ();

        return firstX * secondX + firstY * secondY + firstZ * secondZ;
    }

    public Point multiplyVectors(Point firstVector, Point secondVector) {

        double firstX = firstVector.getCoordinateX();
        double firstY = firstVector.getCoordinateY();
        double firstZ = firstVector.getCoordinateZ();
        double secondX = secondVector.getCoordinateX();
        double secondY = secondVector.getCoordinateY();
        double secondZ = secondVector.getCoordinateZ();

        double resultX = (firstY * secondZ - firstZ * secondY);
        double resultY = (firstZ * secondX - firstX * secondZ);
        double resultZ = (firstX * secondY - firstY * secondX);

        return new Point(resultX, resultY, resultZ);
    }


}
