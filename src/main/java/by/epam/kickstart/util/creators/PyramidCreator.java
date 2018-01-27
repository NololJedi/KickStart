package by.epam.kickstart.util.creators;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;

import java.util.List;

public class PyramidCreator {

    public static Pyramid createPyramid(List<Point> points) {
        if (points == null || points.size() == 0) {
            throw new IllegalArgumentException("Coordinates not found.");
        }

        Pyramid pyramid = new Pyramid(points);

        return pyramid;
    }

}
