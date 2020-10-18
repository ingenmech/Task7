package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;

import java.util.List;

public class PyramidValidator {

    private final static int POINT_A = 0;
    private final static int POINT_B = 1;
    private final static int POINT_C = 2;
    private final static int POINT_D = 3;
    private final static int POINT_H = 4;

    private final PyramidCalculator calculator;

    public PyramidValidator(PyramidCalculator calculator) {
        this.calculator = calculator;
    }

    public boolean isPyramid(List<Point> points) {
        Point pointA = points.get(POINT_A);
        Point pointB = points.get(POINT_B);
        Point pointC = points.get(POINT_C);
        Point pointD = points.get(POINT_D);
        Point apexH = points.get(POINT_H);

        Point middleAC = calculator.calculateMiddlePoint(pointA, pointC);
        Point middleBD = calculator.calculateMiddlePoint(pointB, pointD);
        boolean key = middleAC.equals(middleBD);

        if (key) {
            double lengthAC = calculator.calculateLengthBetweenPoints(pointA, pointC);
            double lengthBD = calculator.calculateLengthBetweenPoints(pointB, pointD);
            key = lengthAC == lengthBD;
        }

        Point vectorAC = null;
        Point vectorBD = null;
        if (key) {
            vectorAC = calculator.calculateVector(pointA, pointC);
            vectorBD = calculator.calculateVector(pointB, pointD);
            key = calculator.scalarMultiplyVectors(vectorAC, vectorBD) == 0;
        }

        if (key) {
            Point vectorApex = calculator.calculateVector(middleAC, apexH);
            boolean isNormalToAC = calculator.scalarMultiplyVectors(vectorAC, vectorApex) == 0;
            boolean isNormalToBD = calculator.scalarMultiplyVectors(vectorBD, vectorApex) == 0;
            key = isNormalToAC && isNormalToBD;
        }
        return key;
    }

    public boolean isBaseOnOrdinateSurface(Pyramid pyramid) {
        Point pointA = pyramid.getPointA();
        Point pointB = pyramid.getPointB();
        Point pointC = pyramid.getPointC();
        Point pointD = pyramid.getPointD();
        double xPointA = pointA.getCoordinateX();
        double yPointA = pointA.getCoordinateY();
        double zPointA = pointA.getCoordinateZ();
        double xPointB = pointB.getCoordinateX();
        double yPointB = pointB.getCoordinateY();
        double zPointB = pointB.getCoordinateZ();
        double xPointC = pointC.getCoordinateX();
        double yPointC = pointC.getCoordinateY();
        double zPointC = pointC.getCoordinateZ();
        double xPointD = pointD.getCoordinateX();
        double yPointD = pointD.getCoordinateY();
        double zPointD = pointD.getCoordinateZ();

        boolean result = false;

        if (xPointA == 0 && xPointB == 0 && xPointC == 0 && xPointD == 0 ||
                yPointA == 0 && yPointB == 0 && yPointC == 0 && yPointD == 0 ||
                zPointA == 0 && zPointB == 0 && zPointC == 0 && zPointD == 0) {
            result = true;
        }
        return result;
    }
}
