package by.epam.evm.pyramid.data;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    @Test
    public void testIsValidShouldReturnTrueWhenDataValid() {
        //given
        DataValidator validator = new DataValidator();
        //Boolean expected = true;
        //when
        Boolean actual = validator.isValid("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenDataInvalid() {
        //given
        DataValidator validator = new DataValidator();
        //Boolean expected = true;
        //when
        Boolean actual = validator.isValid("A<2.3;-.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        //then
        Assert.assertFalse(actual);
    }

}
