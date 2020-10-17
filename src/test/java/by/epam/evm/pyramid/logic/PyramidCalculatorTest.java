package by.epam.evm.pyramid.logic;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {

    private final static Pyramid PYRAMID;

    static {
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 0.7);
        PYRAMID = new Pyramid(pointA, pointB, pointC, pointD, apex);
    }

    @Test
    public void testCalculateAreaShouldReturnFullPyramidAreaWhenDataIsCorrect() {
        //given
        PyramidCalculator calculator = new PyramidCalculator();
        double expected = 3.72;
        //when
        double actual = calculator.calculateArea(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculateVolumeShouldReturnPyramidVolumeWhenDataIsCorrect() {
        //given
        PyramidCalculator calculator = new PyramidCalculator();
        double expected = 0.47;
        //when
        double actual = calculator.calculateVolume(PYRAMID);
        //then
        Assert.assertEquals(expected, actual, 0.01);
    }
}
