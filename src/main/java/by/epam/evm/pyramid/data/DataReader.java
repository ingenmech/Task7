package by.epam.evm.pyramid.data;

import java.util.List;

public interface DataReader {
    List<String> read() throws DataException;
}
