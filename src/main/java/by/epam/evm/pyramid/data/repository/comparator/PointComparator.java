package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;

import java.util.Comparator;

public class PointComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid firstPyramid, Pyramid secondPyramid) {

        Point firstApex = firstPyramid.getApexPoint();
        Point secondApex = secondPyramid.getApexPoint();
        double firstApexX = firstApex.getCoordinateX();
        double secondApexX = secondApex.getCoordinateX();
        int result = 0;

        if (firstApexX > secondApexX) {
            result = 1;
        }
        if (firstApexX < secondApexX) {
            result = -1;
        }
        return result;
    }
}
