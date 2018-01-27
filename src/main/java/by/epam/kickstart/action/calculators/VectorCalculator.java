package by.epam.kickstart.action.calculators;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class VectorCalculator {

    public double calculatePyramidBaseAngleBetweenTwoVectors(Vector3D first, Vector3D second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Vector is empty.");
        }
        double angle = Math.toDegrees(Vector3D.angle(first, second));

        return angle;
    }

    public List<Double> calculateAnglesBetweenVectorsInList(List<Vector3D> vectors) {
        if (vectors == null || vectors.size() == 0) {
            throw new IllegalArgumentException("Vectors list is empty.");
        }

        List<Double> anglesBetweenVectors = new ArrayList<>();

        int lastPointIndex = 1;
        int countOfAvailablePoints = 2;

        for (int listIndex = 0; listIndex < vectors.size() - lastPointIndex; listIndex++) {
            Vector3D first = vectors.get(listIndex);
            Vector3D second = vectors.get(listIndex + 1);
            double angle = calculatePyramidBaseAngleBetweenTwoVectors(first, second);
            anglesBetweenVectors.add(angle);

            if (listIndex + countOfAvailablePoints == vectors.size()) {
                int lastPoint = listIndex + 1;
                int firstPoint = 0;
                first = vectors.get(lastPoint);
                second = vectors.get(firstPoint);
                angle = calculatePyramidBaseAngleBetweenTwoVectors(first, second);
                anglesBetweenVectors.add(angle);
            }
        }

        return anglesBetweenVectors;
    }

}
