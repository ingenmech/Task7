package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IdComparatorTest {

    private final static List<Pyramid> PYRAMIDS;
    private final static Pyramid FIRST_PYRAMID;
    private final static Pyramid SECOND_PYRAMID;
    private final static Pyramid THIRD_PYRAMID;

    static {
        Point point = new Point(2.3, -3.5, 2);
        FIRST_PYRAMID = new Pyramid(1, point, point, point, point, point);
        SECOND_PYRAMID = new Pyramid(2, point, point, point, point, point);
        THIRD_PYRAMID = new Pyramid(3, point, point, point, point, point);
        PYRAMIDS = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID, THIRD_PYRAMID);
    }

    @Test
    public void testCompareShouldSortByIdWhenDataIsCorrect() {

        List<Pyramid> actualSorted = Arrays.asList(SECOND_PYRAMID, THIRD_PYRAMID, FIRST_PYRAMID);
        IdComparator comparator = new IdComparator();

        actualSorted.sort(comparator);

        Assert.assertEquals(PYRAMIDS, actualSorted);
    }

}
