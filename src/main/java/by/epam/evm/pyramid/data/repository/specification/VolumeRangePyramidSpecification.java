package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import by.epam.evm.pyramid.model.Pyramid;

public class VolumeRangePyramidSpecification implements PyramidSpecification {

    private PyramidCalculator calculator;
    private double minVolume;
    private double maxVolume;

    public VolumeRangePyramidSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        calculator = new PyramidCalculator();
    }

    // package-private for test
    VolumeRangePyramidSpecification(PyramidCalculator calculator, double minVolume, double maxVolume) {
        this(minVolume, maxVolume);
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        double searchVolume = calculator.calculateVolume(pyramid);
        return minVolume < searchVolume && searchVolume < maxVolume;
    }
}
