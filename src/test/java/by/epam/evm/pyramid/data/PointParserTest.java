package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PointParserTest {

    @Test
    public void testParseShouldReturnListPointWhenDataIsCorrect() {
        //given
        PointParser parser = new PointParser();
        List<Point> expected = new ArrayList<>();
        Point pointA = new Point(2.3, -3.5, 2);
        Point pointB = new Point(2, -3.5, 5);
        Point pointC = new Point(-2, -3, 2);
        Point pointD = new Point(2.3, -3.5, 2);
        Point pointH = new Point(2.3, -3.5, 2);
        expected.add(pointA);
        expected.add(pointB);
        expected.add(pointC);
        expected.add(pointD);
        expected.add(pointH);
        //when
        List<Point> actual = parser.parse("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        //then
        Assert.assertEquals(expected, actual);

    }
}
