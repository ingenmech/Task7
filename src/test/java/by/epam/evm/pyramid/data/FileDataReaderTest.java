package by.epam.evm.pyramid.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FileDataReaderTest {

    private final static String FILE_NAME = "src/test/resources/inputTest.txt";

    @Test
    public void testReadShouldReadAllStringAndReturnListWhenFileDoesExist() throws DataException {
        //given
        FileDataReader reader = new FileDataReader(FILE_NAME);
        List<String> expected = new ArrayList<>();
        expected.add("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        expected.add("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
        //when
        List<String> actual = reader.read();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = DataException.class)//then
    public void testReadShouldThrowExceptionWhenFileDoesNotExist() throws DataException {
        //given
        FileDataReader reader = new FileDataReader("src/test/resources/i.txt");
        //when
        List<String> actual = reader.read();
    }
}
