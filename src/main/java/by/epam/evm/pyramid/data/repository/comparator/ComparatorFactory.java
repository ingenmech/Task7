package by.epam.evm.pyramid.data.repository.comparator;

import by.epam.evm.pyramid.model.Pyramid;

import java.util.Comparator;

public class ComparatorFactory {

    public Comparator<Pyramid> create(ComparatorType type) {

        Comparator<Pyramid> comparator;

        switch (type) {
            case ID:
                comparator = new IdComparator();
                break;
            case NAME:
                comparator = new NameComparator();
                break;
            case POINT:
                comparator = new PointComparator();
                break;
            default:
                throw new InputTypeException(String.format("Input type %s is not exist", type));
        }
        return comparator;
    }
}
