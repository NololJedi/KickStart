package by.epam.kickstart.util.data;

import by.epam.kickstart.action.PyramidValidator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.exceptions.DataLoadException;
import by.epam.kickstart.util.LineParser;
import by.epam.kickstart.util.creators.PointCreator;
import by.epam.kickstart.util.creators.PyramidCreator;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    public List<Pyramid> getPyramidsFromFile(String fileName) throws DataLoadException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Check file name.");
        }

        DataFileLoader dataFileLoader = new DataFileLoader();
        List<String> data = dataFileLoader.loadDataFromFile(fileName);
        List<Pyramid> pyramids = getPyramidsFromList(data);

        return pyramids;
    }

    public Pyramid getPyramidFromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Empty line.");
        }

        String[] parsedData = LineParser.parseLine(line,LineParser.DATA_PARSER_INDICATOR);
        List<Point> points = new ArrayList<>();
        DataValidator dataValidator = new DataValidator();

        if (dataValidator.checkCoordinatesForUniqueness(parsedData)) {
            for (String coordinates : parsedData) {
                String[] parsedCoordinates = LineParser.parseLine(coordinates,LineParser.COORDINATES_PARSER_INDICATOR);
                if (dataValidator.checkArguments(parsedCoordinates)){
                    Point point = PointCreator.createPoint(parsedCoordinates);
                    points.add(point);
                }
            }
        }
        Pyramid pyramid = PyramidCreator.createPyramid(points);
        PyramidValidator pyramidValidator = new PyramidValidator();
        if (pyramidValidator.isFigureRegularPyramid(pyramid)) {
            return pyramid;
        }

        return null;
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
            }
        }

        return pyramids;

    }

}
