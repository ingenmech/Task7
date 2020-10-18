package by.epam.evm.pyramid.observer;

import by.epam.evm.pyramid.logic.PyramidCalculator;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private final static Observer INSTANCE = new PyramidObserver();
    private Map<Integer, Parameters> map = new HashMap<>();
    private PyramidCalculator calculator;

    private PyramidObserver() {
        calculator = new PyramidCalculator();
    }

    // package private
    PyramidObserver(PyramidCalculator calculator) {
        this.calculator = calculator;
    }

    public static Observer getInstance() {
        return INSTANCE;
    }

    @Override
    public void notify(PyramidObservable pyramid) {

        double pyramidArea = calculator.calculateArea(pyramid);
        double pyramidVolume = calculator.calculateVolume(pyramid);
        Parameters parameters = new Parameters(pyramidArea, pyramidVolume);
        int id = pyramid.getId();
        map.put(id, parameters);
    }
}
