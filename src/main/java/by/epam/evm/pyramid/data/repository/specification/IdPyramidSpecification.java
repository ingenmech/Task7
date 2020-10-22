package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.model.Pyramid;

public class IdPyramidSpecification implements PyramidSpecification {

    private int id;

    public IdPyramidSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        return id == pyramid.getId();
    }
}
