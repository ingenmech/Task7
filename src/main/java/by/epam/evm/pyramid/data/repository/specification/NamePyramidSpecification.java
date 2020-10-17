package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.model.Pyramid;

public class NamePyramidSpecification implements PyramidSpecification {

    private String pyramidName;

    public NamePyramidSpecification(String pyramidName) {
        this.pyramidName = pyramidName;
    }


    @Override
    public boolean specified(Pyramid pyramid) {
        String name = pyramid.getName();
        return pyramidName.equalsIgnoreCase(pyramidName);
    }
}
