package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IdPyramidSpecificationTest {

    @Test
    public void testSpecifiedShouldReturnTrueWhenDataIsValid() {

        Pyramid pyramid = Mockito.mock(Pyramid.class);
        when(pyramid.getId()).thenReturn(5);
        IdPyramidSpecification specification = new IdPyramidSpecification(5);

        boolean actual = specification.specified(pyramid);

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenDataIsNotValid() {

        Pyramid pyramid = Mockito.mock(Pyramid.class);
        when(pyramid.getId()).thenReturn(3);
        IdPyramidSpecification specification = new IdPyramidSpecification(5);

        boolean actual = specification.specified(pyramid);

        Assert.assertFalse(actual);
    }
}
