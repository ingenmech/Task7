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

    private final VectorCalculator calculator = new VectorCalculator();

    public double calculateArea(Pyramid pyramid) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();

        Point vectorAH = calculator.calculateVector(baseA, apexH);
        Point vectorAD = calculator.calculateVector(baseA, baseD);

        double baseArea = calculateBaseArea(baseA, baseB, baseC, baseD);
        double sideArea = calculator.calculateAreaByVectors(vectorAH, vectorAD) * 2; // function for four side

        return baseArea + sideArea;
    }

    private double calculateBaseArea(Point baseA, Point baseB, Point baseC, Point baseD) {
        Point vectorAC = calculator.calculateVector(baseA, baseC);
        Point vectorBD = calculator.calculateVector(baseB, baseD);
        double baseArea = calculator.calculateAreaByVectors(vectorAC, vectorBD);

        return baseArea;
    }

    public double calculateVolume(Pyramid pyramid) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();

        Point middleBasePoint = calculator.calculateMiddlePoint(baseA, baseC);
        double pyramidHeight = calculator.calculateLengthBetweenPoints(middleBasePoint, apexH);
        double baseArea = calculateBaseArea(baseA, baseB, baseC, baseD);

        return baseArea * pyramidHeight / 3; // function for volume
    }

    public double calculateVolumeRatio(Pyramid pyramid, CartesianPlane plane) {
        Point baseA = pyramid.getPointA();
        Point baseB = pyramid.getPointB();
        Point baseC = pyramid.getPointC();
        Point baseD = pyramid.getPointD();
        Point apexH = pyramid.getApexPoint();
        Point vectorHA = calculator.calculateVector(apexH, baseA);
        Point vectorHB = calculator.calculateVector(apexH, baseB);
        Point vectorHC = calculator.calculateVector(apexH, baseC);
        Point vectorHD = calculator.calculateVector(apexH, baseD);
        Point vectorAD = calculator.calculateVector(baseA, baseD);
        Point vectorBC = calculator.calculateVector(baseB, baseC);
        Point vectorAB = calculator.calculateVector(baseA, baseB);
        Point vectorCD = calculator.calculateVector(baseC, baseD);

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

        secondLengthEdge = calculator.calculateLengthBetweenPoints(firstPoint, secondPoint);
        firstLengthEdge = calculator.calculateLengthBetweenPoints(vector, ZERO_POINT);
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
                resultPoint = new Point(resultX, resultY, 0);
                break;
            case ZOY:
                temp = -pointX / vectorX;
                resultZ = pointZ + vectorZ * temp;
                resultY = pointY + vectorY * temp;
                resultPoint = new Point(0, resultY, resultZ);
                break;
            case XOZ:
                temp = -pointY / vectorY;
                resultX = pointX + vectorX * temp;
                resultZ = pointZ + vectorZ * temp;
                resultPoint = new Point(resultX, 0, resultZ);
                break;
            default:
                throw new LogicException(String.format("Not exist cartesian plane %s", plane));
        }
        return Optional.of(resultPoint);
    }

    private boolean isIntersection(Point vector, CartesianPlane plane) {

        double vectorProduct;

        if (plane == CartesianPlane.XOY) {
            vectorProduct = this.calculator.scalarMultiplyVectors(vector, PLANE_VECTOR_XOY);
        } else if (plane == CartesianPlane.ZOY) {
            vectorProduct = this.calculator.scalarMultiplyVectors(vector, PLANE_VECTOR_ZOY);
        } else {
            vectorProduct = this.calculator.scalarMultiplyVectors(vector, PLANE_VECTOR_XOZ);
        }
        return vectorProduct != 0;
    }
}
