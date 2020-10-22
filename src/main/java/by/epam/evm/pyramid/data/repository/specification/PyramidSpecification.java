package by.epam.evm.pyramid.data.repository.specification;

import by.epam.evm.pyramid.model.Pyramid;

public interface PyramidSpecification {
    boolean specified(Pyramid pyramid);
}
