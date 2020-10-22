package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IdComparatorTest {

    private final static Point POINT = new Point(2.3, -3.5, 2);
    private final static Pyramid FIRST_PYRAMID = new Pyramid(1, POINT, POINT, POINT, POINT, POINT);
    private final static Pyramid SECOND_PYRAMID = new Pyramid(2, POINT, POINT, POINT, POINT, POINT);
    private final static Pyramid THIRD_PYRAMID = new Pyramid(3, POINT, POINT, POINT, POINT, POINT);
    private final static List<Pyramid> EXPECTED = Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID, THIRD_PYRAMID);

    @Test
    public void testCompareShouldSortByIdWhenDataIsCorrect() {

        List<Pyramid> actualSorted = Arrays.asList(SECOND_PYRAMID, THIRD_PYRAMID, FIRST_PYRAMID);
        IdComparator comparator = new IdComparator();

        actualSorted.sort(comparator);

        Assert.assertEquals(EXPECTED, actualSorted);
    }

}
