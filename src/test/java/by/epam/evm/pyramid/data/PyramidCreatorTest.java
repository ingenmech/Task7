package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

public class PyramidCreatorTest {

    private final static Point pointA = new Point(2.3, -3.5, 2);
    private final static Point pointB = new Point(2, -3.5, 5);
    private final static Point pointC = new Point(-2, -3, 2);
    private final static Point pointD = new Point(2.3, -3.5, 2);
    private final static Point pointH = new Point(2.3, -3.5, 2);

    @Test
    public void testCreateShouldReturnPyramidWhenDataIsValid() {
        //given
        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        when(validator.isPyramid(anyList())).thenReturn(true);
        Pyramid pyramid = new Pyramid(pointA, pointB, pointC, pointD, pointH);
        Optional<Pyramid> expected = Optional.of(pyramid);
        PyramidCreator creator = new PyramidCreator(validator);
        List<Point> points = Arrays.asList(pointA, pointB, pointC, pointD, pointH);

        //when
        Optional<Pyramid> actual = creator.create(points);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateShouldEmptyOptionalWhenDataInvalid() {
        //given
        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        when(validator.isPyramid(anyList())).thenReturn(false);
        Optional<Pyramid> expected = Optional.empty();
        PyramidCreator creator = new PyramidCreator(validator);

        //when
        Optional<Pyramid> actual = creator.create(anyList());
        //then
        Assert.assertEquals(expected, actual);
    }
}
