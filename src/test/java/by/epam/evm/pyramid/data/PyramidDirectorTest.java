package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class PyramidDirectorTest {

    private final static Point pointA = new Point(2.3, -3.5, 2);
    private final static Point pointB = new Point(2, -3.5, 5);
    private final static Point pointC = new Point(-2, -3, 2);
    private final static Point pointD = new Point(2.3, -3.5, 2);
    private final static Point pointH = new Point(2.3, -3.5, 2);

    private final static List<Point> POINTS = Arrays.asList(pointA, pointB, pointC, pointD, pointH);
    private final static Pyramid PYRAMID = new Pyramid(pointA, pointB, pointC, pointD, pointH);
    private final static List<String> DATA = Arrays.asList("A<2.3;-3.5;2>B<2;-3.5;5>C<-2;-3;2>D<2.3;-3.5;2>H<2.3;-3.5;2>");
    private final static String FILE_NAME = "src/test/resources/inputTest.txt";

    @Test
    public void testCompleteShouldReturnListPyramidsWhenDataAndPyramidValid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn(DATA);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        when(dataValidator.isValid(anyString())).thenReturn(true);
        PointParser parser = Mockito.mock(PointParser.class);
        when(parser.parse(anyString())).thenReturn(POINTS);
        PyramidCreator creator = Mockito.mock(PyramidCreator.class);
        Optional<Pyramid> optional = Optional.of(PYRAMID);
        when(creator.create(anyList())).thenReturn(optional);

        PyramidDirector director = new PyramidDirector(reader, dataValidator, parser, creator);
        List<Pyramid> expected = Arrays.asList(PYRAMID);

        //when
        List<Pyramid> actual = director.complete(FILE_NAME);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompleteShouldReturnEmptyListPyramidsWhenDataInvalid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn(DATA);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        when(dataValidator.isValid(anyString())).thenReturn(false);
        PointParser parser = Mockito.mock(PointParser.class);
        PyramidCreator creator = Mockito.mock(PyramidCreator.class);

        PyramidDirector director = new PyramidDirector(reader, dataValidator, parser, creator);
        List<Pyramid> expected = new ArrayList<>();

        //when
        List<Pyramid> actual = director.complete(FILE_NAME);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompleteShouldReturnEmptyListPyramidsWhenPyramidInvalid() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn(DATA);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        when(dataValidator.isValid(anyString())).thenReturn(true);
        PointParser parser = Mockito.mock(PointParser.class);
        when(parser.parse(anyString())).thenReturn(POINTS);
        PyramidCreator creator = Mockito.mock(PyramidCreator.class);
        Optional<Pyramid> optional = Optional.empty();
        when(creator.create(anyList())).thenReturn(optional);

        PyramidDirector director = new PyramidDirector(reader, dataValidator, parser, creator);
        List<Pyramid> expected = new ArrayList<>();

        //when
        List<Pyramid> actual = director.complete(FILE_NAME);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class) //then
    public void testCompleteShouldThrowExceptionWhenFileNotFound() throws DataException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenThrow(DataException.class);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);
        PointParser parser = Mockito.mock(PointParser.class);
        PyramidCreator creator = Mockito.mock(PyramidCreator.class);

        PyramidDirector director = new PyramidDirector(reader, dataValidator, parser, creator);
        //when
        director.complete(FILE_NAME);
    }


}
