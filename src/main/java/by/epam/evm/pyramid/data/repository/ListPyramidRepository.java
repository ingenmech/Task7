package by.epam.evm.pyramid.data.repository;

import by.epam.evm.pyramid.data.repository.comparator.ComparatorFactory;
import by.epam.evm.pyramid.data.repository.comparator.ComparatorType;
import by.epam.evm.pyramid.data.repository.specification.PyramidSpecification;
import by.epam.evm.pyramid.model.Pyramid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListPyramidRepository implements PyramidRepository {

    private List<Pyramid> pyramids;

    public ListPyramidRepository(List<Pyramid> pyramids) {
        this.pyramids = pyramids;
    }

    @Override
    public void addPyramid(Pyramid pyramid) {
        pyramids.add(pyramid);
    }

    @Override
    public void removePyramid(Pyramid pyramid) {
        pyramids.remove(pyramid);
    }

    @Override
    public void updatePyramid(Pyramid pyramid) {

        int id = pyramid.getId();
        Pyramid searchPyramid;

        for (int i = 0; i < pyramids.size(); i++) {
            searchPyramid = pyramids.get(i);
            if (id == searchPyramid.getId()) {
                pyramids.set(i, pyramid);
            }
        }
    }

    @Override
    public List<Pyramid> query(PyramidSpecification specification) {

        List<Pyramid> validPyramid = new ArrayList<>();

        for (Pyramid pyramid : pyramids) {
            if (specification.specified(pyramid)) {
                validPyramid.add(pyramid);
            }
        }
        return validPyramid;
    }

    @Override
    public List<Pyramid> sortPyramid(ComparatorType type) {

        ComparatorFactory factory = new ComparatorFactory();
        Comparator comparator = factory.create(type);
        List<Pyramid> sortedList = new ArrayList<>(pyramids);
        sortedList.sort(comparator);

        return sortedList;
    }
}
