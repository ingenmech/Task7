package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {

    private final static Point FIRST_VALUE = new Point(2, -2, 4);
    private final static Point SECOND_VALUE = new Point(-4, 4, 4);
    private final static Pyramid PYRAMID = new Pyramid(
            new Point(0, 0, 0),
            new Point(1, 0, 0),
            new Point(1, 1, 0),
            new Point(0, 1, 0),
            new Point(0.5, 0.5, 0.7));

    private final PyramidCalculator calculator = new PyramidCalculator();

    @Test
    public void testCalculateAreaShouldReturnFullPyramidAreaWhenDataIsValid() {
        //given
        double expected = 3.72;
        //when
        double actual = calculator.calculateArea(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVolumeShouldReturnPyramidVolumeWhenDataIsValid() {
        //given
        double expected = 0.47;
        //when
        double actual = calculator.calculateVolume(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateMiddlePointShouldReturnMiddlePointWhenDataIsValid() {
        //given
        Point expected = new Point(-1, 1, 4);
        //when
        Point actual = calculator.calculateMiddlePoint(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateLengthBetweenPointsShouldReturnLengthWhenDataIsValid() {
        //given
        double expected = 8.49;
        //when
        double actual = calculator.calculateLengthBetweenPoints(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVectorShouldReturnVectorPointWhenDataIsValid() {
        //given
        Point expected = new Point(-6, 6, 0);
        //when
        Point actual = calculator.calculateVector(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testScalarMultiplyVectorsShouldReturnScalarResultDoubleTypeWhenDataIsValid() {
        //given
        double expected = 0;
        //when
        double actual = calculator.scalarMultiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testMultiplyVectorsShouldReturnVectorCoordinatesTypePointWhenDataIsValid() {
        //given
        Point expected = new Point(-24, -24, 0);
        //when
        Point actual = calculator.multiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

}
