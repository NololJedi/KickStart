package by.epam.kickstart.util;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.List;

public class MatrixUtil {

    private static final int COLUMN_SIZE = 3;

    public static double matrixDeterminant(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty.");
        }

        double temporary[][];
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }
        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow(-1, (double) i) * matrixDeterminant(temporary);
        }
        return (result);
    }

    public static double[][] fillMatrix(List<Vector3D> vectors) {
        if (vectors == null || vectors.isEmpty()) {
            throw new IllegalArgumentException("Matrix arguments is not valid.");
        }
        int lineSize = vectors.size();

        double[][] matrix = new double[COLUMN_SIZE][lineSize];
        double[] lineX = new double[lineSize];
        double[] lineY = new double[lineSize];
        double[] lineZ = new double[lineSize];

        for (int listIndex = 0; listIndex < lineSize; listIndex++) {
            Vector3D vector = vectors.get(listIndex);
            lineX[listIndex] = vector.getX();
            lineY[listIndex] = vector.getY();
            lineZ[listIndex] = vector.getZ();
        }

        matrix[0] = lineX;
        matrix[1] = lineY;
        matrix[2] = lineZ;

        return matrix;
    }

}
