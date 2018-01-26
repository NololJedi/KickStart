package by.epam.kickstart.action;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class RegularPyramidParameters {

    private static final int APEX_INDEX = 1;

    private Pyramid pyramid;

    private RegularPyramidParameters(Pyramid pyramid) {
        this.pyramid = pyramid;
    }

    public static RegularPyramidParameters getInstance(Pyramid pyramid) {

        if (pyramid == null) {
            throw new IllegalArgumentException("Check pyramid.");
        }

        RegularPyramidParameters regularPyramidParameters = new RegularPyramidParameters(pyramid);

        return regularPyramidParameters;
    }

    public double getBaseSideLength() {
        Vector3D baseSideVector = getBaseVectors().get(0);
        double baseSideLength = baseSideVector.getNorm();

        return baseSideLength;
    }

    public double getEdgeSideLength() {
        Vector3D edgeSideVector = getEdgesVectors().get(0);
        double edgeSideLength = edgeSideVector.getNorm();

        return edgeSideLength;
    }

    public Point getApex() {
        List<Point> points = pyramid.getPoints();
        Point apex = points.get(points.size()-1);

        return apex;
    }

    public List<Point> getPoints() {
        return pyramid.getPoints();
    }

    public List<Vector3D> getBaseVectors() {
        List<Vector3D> baseVectors = new ArrayList<>();
        List<Point> basePoints = new ArrayList<>(getPoints());
        basePoints.remove(basePoints.size() - APEX_INDEX);

        for (int listIndex = 0; listIndex < basePoints.size(); listIndex++) {
            if (listIndex + 1 == basePoints.size()) {
                Point start = basePoints.get(listIndex);
                Point end = basePoints.get(0);
                Vector3D vector = Vector3DCreator.createVector(start,end);
                baseVectors.add(vector);
                break;
            }

            Point start = basePoints.get(listIndex);
            Point end = basePoints.get(listIndex + 1);
            Vector3D vector = Vector3DCreator.createVector(start,end);
            baseVectors.add(vector);
        }

        return baseVectors;
    }

    public List<Vector3D> getEdgesVectors() {
        List<Vector3D> edgeVectors = new ArrayList<>();

        for (int listIndex = 0; listIndex < getPoints().size() - APEX_INDEX; listIndex++) {
            Point start = getPoints().get(listIndex);
            Vector3D vector = Vector3DCreator.createVector(start, getApex());
            edgeVectors.add(vector);
        }

        return edgeVectors;
    }



}
