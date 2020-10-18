package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {

    private final static Point FIRST_VALUE = new Point(2, -2, 4);
    private final static Point SECOND_VALUE = new Point(-4, 4, 4);
    private final static Pyramid PYRAMID;

    static {
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 0.7);
        PYRAMID = new Pyramid(pointA, pointB, pointC, pointD, apex);
    }

    private final PyramidCalculator calculator = new PyramidCalculator();

    @Test
    public void testCalculateAreaShouldReturnFullPyramidAreaWhenDataIsCorrect() {
        //given
        double expected = 3.72;
        //when
        double actual = calculator.calculateArea(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVolumeShouldReturnPyramidVolumeWhenDataIsCorrect() {
        //given
        double expected = 0.47;
        //when
        double actual = calculator.calculateVolume(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateMiddlePointShouldReturnMiddlePointWhenDataIsCorrect() {
        //given
        Point expected = new Point(-1, 1, 4);
        //when
        Point actual = calculator.calculateMiddlePoint(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateLengthBetweenPointsShouldReturnLengthWhenDataIsCorrect() {
        //given
        double expected = 8.49;
        //when
        double actual = calculator.calculateLengthBetweenPoints(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVectorShouldReturnVectorPointWhenDataIsCorrect() {
        //given
        Point expected = new Point(-6, 6, 0);
        //when
        Point actual = calculator.calculateVector(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testScalarMultiplyVectorsShouldReturnScalarResultDoubleTypeWhenDataIsCorrect() {
        //given
        double expected = 0;
        //when
        double actual = calculator.scalarMultiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testMultiplyVectorsShouldReturnVectorCoordinatesTypePointWhenDataIsCorrect() {
        //given
        Point expected = new Point(-24, -24, 0);
        //when
        Point actual = calculator.multiplyVectors(FIRST_VALUE, SECOND_VALUE);
        //then
        Assert.assertEquals(expected, actual);
    }

}
