package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class VectorCalculatorTest {

    private final static VectorCalculator VECTOR = new VectorCalculator();
    private final static Point FIRST_VALUE = new Point(2, -2, 4);
    private final static Point SECOND_VALUE = new Point(-4, 4, 4);

    @Test
    public void testCalculateMiddlePointShouldReturnMiddlePointWhenDataIsCorrect() {
        //given
        Point expected = new Point(-1, 1, 4);
        //when
        Point actual = VECTOR.calculateMiddlePoint(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateLengthBetweenPointsShouldReturnLengthWhenDataIsCorrect() {
        //given
        double expected = 8.49;
        //when
        double actual = VECTOR.calculateLengthBetweenPoints(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVectorShouldReturnVectorPointWhenDataIsCorrect() {
        //given
        Point expected = new Point(-6, 6, 0);
        //when
        Point actual = VECTOR.calculateVector(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testScalarMultiplyVectorsShouldReturnScalarResultDoubleTypeWhenDataIsCorrect() {
        //given
        double expected = 0;
        //when
        double actual = VECTOR.scalarMultiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testMultiplyVectorsShouldReturnVectorCoordinatesTypePointWhenDataIsCorrect(){
        //given
        Point expected = new Point(-24, -24, 0);
        //when
        Point actual = VECTOR.multiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateAreaByVectorsShouldReturnAreaWhenDataIsTwoVector(){
        //given
        double expected = 33.94;
        //when
        double actual = VECTOR.calculateAreaByVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }
}
