package by.epam.kickstart.util.data;

import by.epam.kickstart.exceptions.DataLoadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileLoader {

    public List<String> loadDataFromFile(String fileName) throws DataLoadException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Check file name.");
        }

        List<String> data = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String dataFromFile = fileReader.readLine();
                dataFromFile = dataFromFile.replaceAll("\r\n", "");
                dataFromFile = dataFromFile.trim();
                data.add(dataFromFile);
            }
        } catch (IOException exception) {
            throw new DataLoadException(exception);
        }
        return data;
    }

}

