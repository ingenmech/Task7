package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PyramidValidatorTest {

    @Test
    public void testIsPyramidShouldReturnTrueWhenDataValid() {
        //given
        PyramidValidator validator = new PyramidValidator();
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isPyramid(points);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenBaseEdgeNotInOnePlane() {
        //given
        PyramidValidator validator = new PyramidValidator();
        Point pointA = new Point(0, 0, 1);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isPyramid(points);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenBaseIsNotSquare() {
        //given
        PyramidValidator validator = new PyramidValidator();
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(2, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isPyramid(points);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenIsRectangle() {
        //given
        PyramidValidator validator = new PyramidValidator();
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(2, 0, 0);
        Point pointC = new Point(2, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(0.5, 0.5, 1);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isPyramid(points);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenHeightNotNormalToBase() {
        //given
        PyramidValidator validator = new PyramidValidator();
        Point pointA = new Point(0, 0, 0);
        Point pointB = new Point(1, 0, 0);
        Point pointC = new Point(1, 1, 0);
        Point pointD = new Point(0, 1, 0);
        Point apex = new Point(1, 0.5, 1);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, apex);
        //when
        boolean actual = validator.isPyramid(points);
        //then
        Assert.assertFalse(actual);
    }


    @Test
    public void testIsBaseOnOrdinateSurfaceShouldReturnTrueWhenDataIsTrue() {
        //given
        PyramidValidator validator = new PyramidValidator();
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
        PyramidValidator validator = new PyramidValidator();
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
