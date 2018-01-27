package by.epam.kickstart;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.util.MatrixUtil;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtilTest {

    private static double[][] validMatrix;
    private static List<Vector3D> vectors;
    private static double[][] notValidMatrix;

    @BeforeClass
    public static void setNotValidMatrix() {
        notValidMatrix = new double[3][4];

        notValidMatrix[0] = new double[]{-2.0, -3.0, -1.0, 6.0};
        notValidMatrix[1] = new double[]{6.0, -3.0, -5.0, 2.0};
        notValidMatrix[2] = new double[]{-2.0, 1.0, 2.0, -1.0};
    }

    @BeforeClass
    public static void setVectors() {
        Point pointA = new Point(1.0, -2.0, 2.0);
        Point pointB = new Point(-1.0,4.0,0.0);
        Point pointC = new Point(-4.0, 1.0, 1.0);
        Point pointD = new Point(-5.0,-5.0,3.0);

        Vector3D vectorAB = Vector3DCreator.createVector(pointA,pointB);
        Vector3D vectorBC = Vector3DCreator.createVector(pointB,pointC);
        Vector3D vectorCD = Vector3DCreator.createVector(pointC,pointD);
        Vector3D vectorDA = Vector3DCreator.createVector(pointD,pointA);

        vectors = new ArrayList<>();

        vectors.add(vectorAB);
        vectors.add(vectorBC);
        vectors.add(vectorCD);
        vectors.add(vectorDA);
    }

    @BeforeClass
    public static void setValidMatrix() {
        validMatrix = new double[3][4];

        validMatrix[0] = new double[]{-2.0, -3.0, -1.0, 6.0};
        validMatrix[1] = new double[]{6.0, -3.0, -6.0, 3.0};
        validMatrix[2] = new double[]{-2.0, 1.0, 2.0, -1.0};
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyMatrixCauseException() {
        double[][] notValidMatrix = new double[][]{};

        MatrixUtil.matrixDeterminant(notValidMatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullMatrixCauseException() {
        double[][] notValidMatrix = null;

        MatrixUtil.matrixDeterminant(notValidMatrix);
    }

    @Test
    public void shouldMatrixFillBeSuccessful() {
        double[][] testingMatrix = MatrixUtil.fillMatrix(vectors);

        Assert.assertArrayEquals(validMatrix,testingMatrix);
    }

    @Test
    public void shouldMatrixDeterminantBeZero() {
        double determinant = 0.0;

        Assert.assertEquals(determinant, MatrixUtil.matrixDeterminant(validMatrix),1.0);
    }

    @Test
    public void shouldMatrixDeterminantBeNotZero() {
        double determinant = 0.0;

        Assert.assertNotEquals(determinant, MatrixUtil.matrixDeterminant(notValidMatrix),1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullVectorListCauseException() {
        List<Vector3D> notValidList = null;

        MatrixUtil.fillMatrix(notValidList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyVectorListCauseException() {
        List<Vector3D> notValidList = new ArrayList<>();

        MatrixUtil.fillMatrix(notValidList);
    }

}
