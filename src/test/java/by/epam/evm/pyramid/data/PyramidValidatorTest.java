package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PyramidValidatorTest {

    private final static List<Point> POINTS;

    static {
        Point pointA = new Point(2.3, -3.5, 2);
        Point pointB = new Point(2, -3.5, 5);
        Point pointC = new Point(-2, -3, 2);
        Point pointD = new Point(2.3, -3.5, 2);
        Point pointH = new Point(2.3, -3.5, 2);
        POINTS = Arrays.asList(pointA, pointB, pointC, pointD, pointH);
    }

    @Test
    public void testIsPyramidShouldReturnTrueWhenDataValid() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateLengthBetweenPoints(any(), any())).thenReturn(5.0);
        Point point = new Point(2.3, 3.5, 2);
        when(calculator.calculateMiddlePoint(any(), any())).thenReturn(point);
        when(calculator.calculateVector(any(), any())).thenReturn(point);
        when(calculator.scalarMultiplyVectors(any(), any())).thenReturn(0.0);

        PyramidValidator validator = new PyramidValidator(calculator);
        //when
        boolean actual = validator.isPyramid(POINTS);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenScalarMultiplyNotZero() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateLengthBetweenPoints(any(), any())).thenReturn(5.0);
        Point point = new Point(2.3, 3.5, 2);
        when(calculator.calculateMiddlePoint(any(), any())).thenReturn(point);
        when(calculator.calculateVector(any(), any())).thenReturn(point);
        when(calculator.scalarMultiplyVectors(any(), any())).thenReturn(1.0);

        PyramidValidator validator = new PyramidValidator(calculator);
        //when
        boolean actual = validator.isPyramid(POINTS);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsBaseOnOrdinateSurfaceShouldReturnTrueWhenDataIsTrue() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        PyramidValidator validator = new PyramidValidator(calculator);
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        Pyramid pyramid = new Pyramid(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isBaseOnOrdinateSurface(pyramid);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseOnOrdinateSurfaceShouldReturnFalseWhenBaseNotOnSurface() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        PyramidValidator validator = new PyramidValidator(calculator);
        Point pointA = new Point(0, 0, 2);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        Pyramid pyramid = new Pyramid(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isBaseOnOrdinateSurface(pyramid);
        //then
        Assert.assertFalse(actual);
    }
}
