package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

public class PyramidCreatorTest {

    @Test
    public void testCreateShouldReturnPyramidWhenDataIsValid() {
        //given
        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        when(validator.isPyramid(anyList())).thenReturn(true);
        Point pointA = new Point(2.3, -3.5, 2);
        Point pointB = new Point(2, -3.5, 5);
        Point pointC = new Point(-2, -3, 2);
        Point pointD = new Point(2.3, -3.5, 2);
        Point pointH = new Point(2.3, -3.5, 2);
        Pyramid pyramid = new Pyramid(pointA, pointB, pointC, pointD, pointH);
        Optional<Pyramid> expected = Optional.of(pyramid);

        PyramidCreator creator = new PyramidCreator(validator);
        List<Point> points = new ArrayList<>();
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        points.add(pointD);
        points.add(pointH);

        //when
        Optional<Pyramid> actual = creator.create(points);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateShouldReturnPyramidWhenDataInvalid() {
        //given
        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        when(validator.isPyramid(anyList())).thenReturn(false);
        Optional<Pyramid> expected = Optional.empty();

        PyramidCreator creator = new PyramidCreator(validator);
        List<Point> points = new ArrayList<>();

        //when
        Optional<Pyramid> actual = creator.create(points);
        //then
        Assert.assertEquals(expected, actual);
    }
}
