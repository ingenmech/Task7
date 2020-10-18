package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PointComparatorTest {

    private final static List<Pyramid> PYRAMIDS;
    private final static Pyramid FIRST_PYRAMID;
    private final static Pyramid SECOND_PYRAMID;
    private final static Pyramid THIRD_PYRAMID;

    static {
        Point point = new Point(1, -3.5, 2);
        Point firstApex = new Point(1, -3.5, 2);
        Point secondApex = new Point(2, -3.5, 2);
        Point thirdApex = new Point(3, -3.5, 2);
        FIRST_PYRAMID = new Pyramid(1, point, point, point, point, firstApex);
        SECOND_PYRAMID = new Pyramid(2, point, point, point, point, secondApex);
        THIRD_PYRAMID = new Pyramid(3, point, point, point, point, thirdApex);
        PYRAMIDS = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID, THIRD_PYRAMID);
    }

    @Test
    public void testCompareShouldSortByApexPointXCoordinateWhenDataISCorrect() {

        List<Pyramid> actualSorted = Arrays.asList(SECOND_PYRAMID, THIRD_PYRAMID, FIRST_PYRAMID);
        PointComparator comparator = new PointComparator();

        actualSorted.sort(comparator);

        Assert.assertEquals(PYRAMIDS, actualSorted);
    }
}
