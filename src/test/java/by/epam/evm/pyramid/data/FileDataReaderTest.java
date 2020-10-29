package by.epam.evm.pyramid.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private final static String FILE_NAME = "src/test/resources/inputTest.txt";

    @Test
    public void testReadShouldReadAllStringAndReturnListWhenFileDoesExist() throws DataException {
        //given
        List<String> expected = Arrays.asList(
                "A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>",
                "A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        FileDataReader reader = new FileDataReader();
        //when
        List<String> actual = reader.read(FILE_NAME);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)//then
    public void testReadShouldThrowExceptionWhenFileDoesNotExist() throws DataException {
        //given
        FileDataReader reader = new FileDataReader();
        //when
        List<String> actual = reader.read("src/test/resources/i.txt");
    }
}
