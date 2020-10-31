package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PyramidDirector {

    private final static Logger LOGGER = LogManager.getLogger(PyramidDirector.class);

    private final DataReader reader;
    private final DataValidator dataValidator;
    private final PointParser parser;
    private final PyramidCreator pyramidCreator;

    public PyramidDirector(DataReader reader, DataValidator dataValidator,
                           PointParser parser, PyramidCreator creator) {
        this.reader = reader;
        this.dataValidator = dataValidator;
        this.parser = parser;
        this.pyramidCreator = creator;
    }

    public List<Pyramid> complete(String fileName) throws DataException {

        List<Pyramid> validPyramids = new ArrayList<>();
        List<String> data = reader.read(fileName);

        for (String line : data) {
            if (dataValidator.isValid(line)) {
                List<Point> points = parser.parse(line);
                Optional<Pyramid> pyramid = pyramidCreator.create(points);
                if (pyramid.isPresent()) {
                    Pyramid validPyramid = pyramid.get();
                    validPyramids.add(validPyramid);
                }
            } else {
                LOGGER.warn(String.format("Data %s line is not valid", line));
            }
        }
        return validPyramids;
    }
}
