package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Pyramid;

import java.util.Comparator;

public class NameComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid firstPyramid, Pyramid secondPyramid) {
        String firstName = firstPyramid.getName();
        String secondName = secondPyramid.getName();

        return firstName.compareToIgnoreCase(secondName);
    }
}
