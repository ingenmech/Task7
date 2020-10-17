package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import by.epam.evm.pyramid.model.Pyramid;

public class VolumeRangePyramidSpecification implements PyramidSpecification{

    private final PyramidCalculator calculator = new PyramidCalculator();
    private double minVolume;
    private double maxVolume;

    public VolumeRangePyramidSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        double searchVolume = calculator.calculateVolume(pyramid);
        return minVolume < searchVolume && searchVolume < maxVolume;
    }
}
