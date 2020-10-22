package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Pyramid;

import java.util.Comparator;

public class IdComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid firstPyramid, Pyramid secondPyramid) {

        int firstId = firstPyramid.getId();
        int secondId = secondPyramid.getId();
        int result = 0;

        if (firstId > secondId) {
            result = 1;
        }
        if (firstId < secondId) {
            result = -1;
        }
        return result;
    }
}
