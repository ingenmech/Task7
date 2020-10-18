package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class VolumeRangeSpecificationTest {

    @Test
    public void testSpecifiedShouldReturnTrueWhenDataInRange() {

        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateVolume(any())).thenReturn(2.2);
        VolumeRangePyramidSpecification specification = new VolumeRangePyramidSpecification(calculator, 1, 3);

        boolean actual = specification.specified(any());

        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenDataOutRange() {

        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateVolume(any())).thenReturn(4.0);
        VolumeRangePyramidSpecification specification = new VolumeRangePyramidSpecification(calculator, 1, 3);

        boolean actual = specification.specified(any());

        Assert.assertFalse(actual);
    }
}
