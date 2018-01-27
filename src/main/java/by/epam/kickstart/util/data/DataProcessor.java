package by.epam.kickstart.util.data;

import by.epam.kickstart.action.PyramidValidator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.exceptions.DataLoadException;
import by.epam.kickstart.util.LineParser;
import by.epam.kickstart.util.creators.PointCreator;
import by.epam.kickstart.util.creators.PyramidCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private final static Logger LOGGER = Logger.getLogger(DataProcessor.class);

    public List<Pyramid> getPyramidsFromFile(String fileName) throws DataLoadException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Check file name.");
        }

        DataFileLoader dataFileLoader = new DataFileLoader();
        List<String> data = dataFileLoader.loadDataFromFile(fileName);
        LOGGER.info("Data was loaded successfully.");
        List<Pyramid> pyramids = getPyramidsFromList(data);

        return pyramids;
    }

    public Pyramid getPyramidFromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Empty line.");
        }

        LOGGER.info("Try to create pyramid from line = " + line + ".");
        String[] parsedData = LineParser.parseLine(line, LineParser.DATA_PARSER_INDICATOR);
        List<Point> points = new ArrayList<>();
        DataValidator dataValidator = new DataValidator();
        Pyramid pyramid = null;

        if (dataValidator.checkCoordinatesForUniqueness(parsedData)) {
            for (String coordinates : parsedData) {
                String[] parsedCoordinates = LineParser.parseLine(coordinates, LineParser.COORDINATES_PARSER_INDICATOR);
                if (dataValidator.checkArguments(parsedCoordinates)) {
                    Point point = PointCreator.createPoint(parsedCoordinates);
                    LOGGER.info("Point was created successfully - " + point.toString() + ".");
                    points.add(point);
                } else {
                    LOGGER.info("Incorrect coordinates detected - " + coordinates + ".");
                    break;
                }
            }
        } else {
            LOGGER.info("Similar coordinates detected.");
        }

        if (points.size() == 0) {
            LOGGER.info("No points were created. Check data.");
            return pyramid;
        }

        Pyramid createdPyramid = PyramidCreator.createPyramid(points);
        PyramidValidator pyramidValidator = new PyramidValidator();
        if (pyramidValidator.isFigureRegularPyramid(createdPyramid)) {
            LOGGER.info("Pyramid was created successfully.");
            pyramid = createdPyramid;
        }

        return pyramid;
    }

    public List<Pyramid> getPyramidsFromList(List<String> data) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException("Empty data");
        }

        List<Pyramid> pyramids = new ArrayList<>();

        for (String line : data) {
            Pyramid pyramid = getPyramidFromLine(line);

            if (pyramid != null) {
                pyramids.add(pyramid);
            } else {
                LOGGER.info("Pyramid can't be created from such coordinates - " + line + ".");
            }
        }

        return pyramids;

    }

}
