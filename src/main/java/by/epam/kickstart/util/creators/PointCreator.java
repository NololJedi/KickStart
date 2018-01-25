package by.epam.kickstart.util.creators;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.util.LineParser;

public class PointCreator {

    public static Point createPoint (String[] parsedCoordinates) {
        if (parsedCoordinates == null || parsedCoordinates.length == 0) {
            throw new IllegalArgumentException("Coordinates not found.");
        }

        double xCoordinate = Double.parseDouble(parsedCoordinates[0]);
        double yCoordinate = Double.parseDouble(parsedCoordinates[1]);
        double zCoordinate = Double.parseDouble(parsedCoordinates[2]);

        Point point = new Point(xCoordinate,yCoordinate,zCoordinate);

        return point;
    }

}
