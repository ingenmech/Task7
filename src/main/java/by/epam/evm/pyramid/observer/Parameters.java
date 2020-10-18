package by.epam.evm.pyramid.observer;

public final class Parameters {

    private final double pyramidArea;
    private final double pyramidVolume;

    public Parameters(double pyramidArea, double pyramidVolume) {
        this.pyramidArea = pyramidArea;
        this.pyramidVolume = pyramidVolume;
    }

    public double getPyramidArea() {
        return pyramidArea;
    }

    public double getPyramidVolume() {
        return pyramidVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameters that = (Parameters) o;

        if (Double.compare(that.pyramidArea, pyramidArea) != 0) {
            return false;
        }
        return Double.compare(that.pyramidVolume, pyramidVolume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pyramidArea);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pyramidVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "pyramidArea=" + pyramidArea +
                ", pyramidVolume=" + pyramidVolume +
                '}';
    }
}
