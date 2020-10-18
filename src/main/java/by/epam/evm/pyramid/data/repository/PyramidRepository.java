package by.epam.evm.pyramid.data.repository;

import by.epam.evm.pyramid.data.repository.comparator.ComparatorType;
import by.epam.evm.pyramid.data.repository.specification.PyramidSpecification;
import by.epam.evm.pyramid.model.Pyramid;

import java.util.List;

public interface PyramidRepository {
    void addPyramid(Pyramid pyramid);

    void removePyramid(Pyramid pyramid);

    void updatePyramid(Pyramid pyramid);

    List<Pyramid> query(PyramidSpecification specification);

    List<Pyramid> sortPyramid(ComparatorType type);
}
