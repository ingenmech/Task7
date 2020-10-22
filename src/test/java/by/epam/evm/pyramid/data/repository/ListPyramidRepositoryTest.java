package by.epam.evm.pyramid.data.repository;

import by.epam.evm.pyramid.data.repository.specification.IdPyramidSpecification;
import by.epam.evm.pyramid.data.repository.specification.VolumeRangePyramidSpecification;
import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ListPyramidRepositoryTest {

    private final static Point point = new Point(1, -3.5, 2);
    private final static Pyramid firstPyramid = new Pyramid(1, point, point, point, point, point);
    private final static Pyramid secondPyramid = new Pyramid(2, point, point, point, point, point);
    private final static List<Pyramid> PYRAMIDS = Arrays.asList(firstPyramid, secondPyramid, firstPyramid);
    private final static List<Pyramid> EXPECTED = Arrays.asList(secondPyramid);

    @Test
    public void testQueryShouldReturnPyramidListByIdWhenDataIsValid() {

        IdPyramidSpecification specification = Mockito.mock(IdPyramidSpecification.class);
        when(specification.specified(any())).thenReturn(false).thenReturn(true).thenReturn(false);
        PyramidRepository repository = new ListPyramidRepository(PYRAMIDS);

        List<Pyramid> actual = repository.query(specification);

        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testQueryShouldReturnPyramidListByVolumeWhenDataIsValid() {

        VolumeRangePyramidSpecification specification = Mockito.mock(VolumeRangePyramidSpecification.class);
        when(specification.specified(any())).thenReturn(false).thenReturn(true).thenReturn(false);
        PyramidRepository repository = new ListPyramidRepository(PYRAMIDS);

        List<Pyramid> actual = repository.query(specification);

        Assert.assertEquals(EXPECTED, actual);
    }
}
