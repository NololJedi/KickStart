package by.epam.kickstart.action;

import by.epam.kickstart.action.calculators.VectorCalculator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.MatrixUtil;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class PyramidValidator {

    private static final int REGULAR_PYRAMID_COUNT_OF_POINTS = 5;

    private boolean checkPointsCount(Pyramid pyramid) {
        List<Point> points = getParameters(pyramid).getPoints();
        return points.size() == REGULAR_PYRAMID_COUNT_OF_POINTS;
    }

    public boolean isFigureRegularPyramid(Pyramid pyramid) {
        if (!checkPointsCount(pyramid)) {
            return false;
        }
        if (!isApexLayOutBaseSpace(pyramid)) {
            return false;
        }
        if (!isBaseLayOnOneCoordinatePlane(pyramid)) {
            return false;
        }
        if (!isBaseRegularPolygon(pyramid)) {
            return false;
        }
        if (!isEdgesIsoscelesTriangles(pyramid)) {
            return false;
        }
        return true;
    }

    public boolean isBaseLayOnOneCoordinatePlane(Pyramid pyramid) {
        boolean isValid = true;
        double[][] matrix = MatrixUtil.fillMatrix(getParameters(pyramid).getBaseVectors());
        double matrixDeterminant = MatrixUtil.matrixDeterminant(matrix);

        if (matrixDeterminant != 0) {
            isValid = false;
        }

        return isValid;
    }

    private boolean isApexLayOutBaseSpace(Pyramid pyramid) {
        boolean isValid = true;
        int firstBasePointIndex = 0;
        int lastPointArgument = 1;
        List<Point> points = new ArrayList<>(pyramid.getPoints());
        points.remove(firstBasePointIndex);
        List<Vector3D> vectors = new ArrayList<>();

        for (int listIndex = 0; listIndex < points.size(); listIndex++) {
            if (listIndex == points.size() - lastPointArgument) {
                Point start = points.get(listIndex);
                Point end = points.get(0);
                Vector3D vector = Vector3DCreator.createVector(start, end);
                vectors.add(vector);
                break;
            } else {
                Point start = points.get(listIndex);
                Point end = points.get(listIndex + 1);
                Vector3D vector = Vector3DCreator.createVector(start, end);
                vectors.add(vector);
            }
        }

        double[][] matrix = MatrixUtil.fillMatrix(vectors);
        double matrixDeterminant = MatrixUtil.matrixDeterminant(matrix);

        if (matrixDeterminant == 0) {
            isValid = false;
        }

        return isValid;

    }

    private boolean isBaseRegularPolygon(Pyramid pyramid) {
        List<Vector3D> baseVectors = getParameters(pyramid).getBaseVectors();
        boolean isValid = false;
        if (checkVectorsLength(baseVectors) && checkAngleBetweenVectors(baseVectors)) {
            isValid = true;
        }

        return isValid;
    }

    private boolean isEdgesIsoscelesTriangles(Pyramid pyramid) {
        List<Vector3D> edgesVectors = getParameters(pyramid).getEdgesVectors();

        return checkVectorsLength(edgesVectors);
    }

    private boolean checkVectorsLength(List<Vector3D> vectors) {
        boolean isValid = true;

        for (int listIndex = 0; listIndex < vectors.size() - 1; listIndex++) {
            Vector3D firstVector = vectors.get(listIndex);
            Vector3D secondVector = vectors.get(listIndex + 1);

            double firstVectorLength = firstVector.getNorm();
            double secondVectorLength = secondVector.getNorm();

            if (firstVectorLength != secondVectorLength) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private boolean checkAngleBetweenVectors(List<Vector3D> vectors) {
        boolean isValid = true;
        VectorCalculator calculator = new VectorCalculator();
        List<Double> anglesBetweenVectors = calculator.calculateAnglesBetweenVectorsInList(vectors);

        for (int listIndex = 0; listIndex < anglesBetweenVectors.size() - 1; listIndex++) {
            double checkingAngle = anglesBetweenVectors.get(listIndex);
            for (int innerListIndex = listIndex + 1; innerListIndex < anglesBetweenVectors.size(); innerListIndex++) {
                double angleInner = anglesBetweenVectors.get(innerListIndex);
                if (checkingAngle != angleInner) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid;
    }

    private RegularPyramidParameters getParameters(Pyramid pyramid) {
        RegularPyramidParameters regularPyramidParameters = RegularPyramidParameters.getInstance(pyramid);

        return regularPyramidParameters;
    }

}
