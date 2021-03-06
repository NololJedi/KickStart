package by.epam.kickstart.action;

import by.epam.kickstart.action.calculators.PyramidCalculator;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.exceptions.DataLoadException;
import by.epam.kickstart.util.data.DataProcessor;
import org.apache.log4j.Logger;

import java.util.List;

public class PyramidProcessor {

    public static final String FILE_NAME = "./src/main/resources/data.txt";

    private static final Logger LOGGER = Logger.getLogger(PyramidProcessor.class);

    public void execute() {
        LOGGER.info("Start program.");
        LOGGER.info("Try to get pyramids from file.");
        DataProcessor dataProcessor = new DataProcessor();
        List<Pyramid> pyramids = null;

        try {
            pyramids = dataProcessor.getPyramidsFromFile(FILE_NAME);
        } catch (DataLoadException e) {
            LOGGER.warn("Can't load pyramids, check file.", e);
        }

        if (pyramids != null || pyramids.size() != 0) {
            LOGGER.info("Pyramids were loaded from file successfully.");
            LOGGER.info("Getting information about pyramids : ");

            for (Pyramid pyramid : pyramids) {
                LOGGER.info(pyramid.toString());
                PyramidCalculator pyramidCalculator = new PyramidCalculator();
                double pyramidArea = pyramidCalculator.calculateArea(pyramid);
                double pyramidVolume = pyramidCalculator.calculateVolume(pyramid);
                LOGGER.info("Pyramid area = " + pyramidArea);
                LOGGER.info("Pyramid volume = " + pyramidVolume);
            }

        }

    }

}
