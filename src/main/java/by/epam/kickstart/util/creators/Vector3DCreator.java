package by.epam.kickstart.util.creators;

import by.epam.kickstart.entities.Point;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Vector3DCreator {

    public static Vector3D createVector(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Coordinates not found.");
        }
        if (start.equals(end)) {
            throw new IllegalArgumentException("Zero vector.");
        }

        double xStart = start.getXCoordinate();
        double yStart = start.getYCoordinate();
        double zStart = start.getZCoordinate();

        double xEnd = end.getXCoordinate();
        double yEnd = end.getYCoordinate();
        double zEnd = end.getZCoordinate();

        double xCoordinate = xEnd - xStart;
        double yCoordinate = yEnd - yStart;
        double zCoordinate = zEnd - zStart;

        double[] coordinates = {xCoordinate, yCoordinate, zCoordinate};

        Vector3D vector = new Vector3D(coordinates);

        return vector;
    }

}
