package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PointParserTest {

    @Test
    public void testParseShouldReturnListPointWhenDataIsValid() {
        //given
        PointParser parser = new PointParser();
        List<Point> expected = Arrays.asList(
                new Point(2.3, -3.5, 2),
                new Point(2, -3.5, 5),
                new Point(-2, -3, 2),
                new Point(2.3, -3.5, 2),
                new Point(2.3, -3.5, 2));
        //when
        List<Point> actual = parser.parse("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        //then
        Assert.assertEquals(expected, actual);

    }
}
