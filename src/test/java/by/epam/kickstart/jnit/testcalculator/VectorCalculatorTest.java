package by.epam.kickstart.jnit.testcalculator;

import by.epam.kickstart.action.calculators.VectorCalculator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VectorCalculatorTest {

    private static Vector3D validVectorFirst;
    private static Vector3D validVectorSecond;
    private static List<Vector3D> validVectors;
    private static VectorCalculator vectorCalculator;

    @BeforeClass
    public static void setVectorCalculator() {
        vectorCalculator = new VectorCalculator();
    }

    @BeforeClass
    public static void setUpTestingVectors() {

        Point pointA = new Point(0.0, 0.0, 0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0, 10.0, 0.0);
        Point pointD = new Point(0.0,10.0,0.0);

        Vector3D vectorAB = Vector3DCreator.createVector(pointA,pointB);
        Vector3D vectorBC = Vector3DCreator.createVector(pointB,pointC);
        Vector3D vectorCD = Vector3DCreator.createVector(pointC,pointD);
        Vector3D vectorDA = Vector3DCreator.createVector(pointD,pointA);
        validVectorFirst = vectorAB;
        validVectorSecond = vectorBC;

        validVectors = new ArrayList<>();

        validVectors.add(vectorAB);
        validVectors.add(vectorBC);
        validVectors.add(vectorCD);
        validVectors.add(vectorDA);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullVectorCauseException() {
        Vector3D first = null;

        vectorCalculator.calculatePyramidBaseAngleBetweenTwoVectors(first,validVectorSecond);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullVectorsListCauseException() {
        List<Vector3D> list = null;

        vectorCalculator.calculateAnglesBetweenVectorsInList(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyVectorsListCauseException() {
        List<Vector3D> list = new ArrayList<>();

        vectorCalculator.calculateAnglesBetweenVectorsInList(list);
    }

    @Test
    public void shouldAngleCalculatingBetweenTwoVectorsBeSuccessful() {
        double angle = 90.0;

        Assert.assertEquals(angle,vectorCalculator.calculatePyramidBaseAngleBetweenTwoVectors(validVectorFirst,validVectorSecond), 1.0);
    }

    @Test
    public void shouldAngleCalculatingBetweenVectorsInListBeSuccessful() {
        List<Double> validAngles = new ArrayList<>();

        validAngles.add(90.0);
        validAngles.add(90.0);
        validAngles.add(90.0);
        validAngles.add(90.0);

        Assert.assertEquals(validAngles,vectorCalculator.calculateAnglesBetweenVectorsInList(validVectors));
    }
}
