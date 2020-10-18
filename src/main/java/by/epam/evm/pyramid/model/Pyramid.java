package by.epam.evm.pyramid.model;

public class Pyramid {

    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Point apexPoint;

    public Pyramid() {

    }

    public Pyramid(Point pointA, Point pointB, Point pointC, Point pointD, Point apexPoint) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.apexPoint = apexPoint;
    }

    public Pyramid(int id, Point pointA, Point pointB, Point pointC, Point pointD, Point apexPoint) {
        this(pointA, pointB, pointC, pointD, apexPoint);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    public Point getApexPoint() {
        return apexPoint;
    }

    public void setApexPoint(Point apexPoint) {
        this.apexPoint = apexPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) o;
        if (pointA != null ? !pointA.equals(pyramid.pointA) : pyramid.pointA != null) {
            return false;
        }
        if (pointB != null ? !pointB.equals(pyramid.pointB) : pyramid.pointB != null) {
            return false;
        }
        if (pointC != null ? !pointC.equals(pyramid.pointC) : pyramid.pointC != null) {
            return false;
        }
        if (pointD != null ? !pointD.equals(pyramid.pointD) : pyramid.pointD != null) {
            return false;
        }
        return apexPoint != null ? apexPoint.equals(pyramid.apexPoint) : pyramid.apexPoint == null;
    }

    @Override
    public int hashCode() {
        int result = pointA != null ? pointA.hashCode() : 0;
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        result = 31 * result + (pointC != null ? pointC.hashCode() : 0);
        result = 31 * result + (pointD != null ? pointD.hashCode() : 0);
        result = 31 * result + (apexPoint != null ? apexPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                ", apexPoint=" + apexPoint +
                '}';
    }
}
