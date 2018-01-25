package by.epam.kickstart.entities;

import java.util.List;

public class Pyramid {

    private final List<Point> points;

    public Pyramid(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) object;

        List<Point> pointsOfObject = pyramid.points;
        for (int listIndex = 0; listIndex < points.size(); listIndex++) {
            Point current = points.get(listIndex);
            Point objectPoint = pointsOfObject.get(listIndex);

            if (!current.equals(objectPoint)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        for (Point point : points) {
            hashCode += 31 * point.hashCode();
        }

        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Pyramid = ");
        stringBuilder.append("points : ");
        for (Point point : points) {
            stringBuilder.append(point.toString() + " ");
        }

        return stringBuilder.toString();
    }
}
