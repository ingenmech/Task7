package by.epam.evm.pyramid.data;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {

    private final static Logger LOGGER = LogManager.getLogger(FileDataReader.class);
    private final String fileName;

    public FileDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> read() throws DataException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            List<String> data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            return data;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
