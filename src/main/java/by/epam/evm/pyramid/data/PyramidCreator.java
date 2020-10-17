package by.epam.evm.pyramid.data;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PyramidCreator {

    private final static Logger LOGGER = LogManager.getLogger(PyramidCreator.class);
    private final static int POINT_A = 0;
    private final static int POINT_B = 1;
    private final static int POINT_C = 2;
    private final static int POINT_D = 3;
    private final static int POINT_H = 4;
    private final PyramidValidator pyramidValidator;


    public PyramidCreator(PyramidValidator PYRAMID_VALIDATOR) {
        this.pyramidValidator = PYRAMID_VALIDATOR;
    }

    public Optional<Pyramid> create(List<Point> points) {

        Optional<Pyramid> optional;

        if (pyramidValidator.isPyramid(points)) {
            Point pointA = points.get(POINT_A);
            Point pointB = points.get(POINT_B);
            Point pointC = points.get(POINT_C);
            Point pointD = points.get(POINT_D);
            Point pointH = points.get(POINT_H);
            Pyramid pyramid = new Pyramid(pointA, pointB, pointC, pointD, pointH);
            optional = Optional.of(pyramid);
        } else {
            optional = Optional.empty();
            LOGGER.warn(String.format("Points %s is not create pyramid", points));
        }
        return optional;
    }
}
