package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;

public class VectorCalculator {

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

    public double calculateAreaByVectors(Point vectorA, Point vectorB) {

        Point multiplyABCD = multiplyVectors(vectorA, vectorB);
        Point zeroVector = new Point(0, 0, 0);

        return calculateLengthBetweenPoints(zeroVector, multiplyABCD);
    }

}
