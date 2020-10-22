package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PointComparatorTest {

    private final static Point POINT = new Point(1, -3.5, 2);
    private final static Point FIRST_APEX = new Point(1, -3.5, 2);
    private final static Point SECOND_APEX = new Point(2, -3.5, 2);
    private final static Point THIRD_APEX = new Point(3, -3.5, 2);

    @Test
    public void testCompareShouldSortByApexPointXCoordinateWhenDataISCorrect() {

        Pyramid FIRST_PYRAMID = new Pyramid(1, POINT, POINT, POINT, POINT, FIRST_APEX);
        Pyramid SECOND_PYRAMID = new Pyramid(2, POINT, POINT, POINT, POINT, SECOND_APEX);
        Pyramid THIRD_PYRAMID = new Pyramid(3, POINT, POINT, POINT, POINT, THIRD_APEX);
        List<Pyramid> expected = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID, THIRD_PYRAMID);
        List<Pyramid> actualSorted = Arrays.asList(SECOND_PYRAMID, THIRD_PYRAMID, FIRST_PYRAMID);
        PointComparator comparator = new PointComparator();

        actualSorted.sort(comparator);

        Assert.assertEquals(expected, actualSorted);
    }
}
