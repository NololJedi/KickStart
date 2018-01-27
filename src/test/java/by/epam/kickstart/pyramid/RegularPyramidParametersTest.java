package by.epam.kickstart.pyramid;

import by.epam.kickstart.action.RegularPyramidParameters;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RegularPyramidParametersTest {

    private static double validBaseLength;
    private static double validSideLength;
    private static Point validApex;
    private static Point notValidApex;
    private static List<Point> validPoints;
    private static List<Vector3D> baseVectors;
    private static List<Vector3D> edgeVectors;
    private static Pyramid validPyramid;
    private static RegularPyramidParameters pyramidParameters;

    @BeforeClass
    public static void setUpTestingObjects() {
        Point pointA = new Point(0.0, 0.0, 0.0);
        Point pointB = new Point(10.0, 0.0, 0.0);
        Point pointC = new Point(10.0, 10.0, 0.0);
        Point pointD = new Point(0.0, 10.0, 0.0);
        Point pointH = new Point(5.0, 5.0, 7.1);

        validPoints = new ArrayList<>();

        validPoints.add(pointA);
        validPoints.add(pointB);
        validPoints.add(pointC);
        validPoints.add(pointD);
        validPoints.add(pointH);

        validPyramid = new Pyramid(validPoints);
        validApex = pointH;
        notValidApex = pointA;

        Vector3D vectorAB = Vector3DCreator.createVector(pointA, pointB);
        Vector3D vectorBC = Vector3DCreator.createVector(pointB, pointC);
        Vector3D vectorCD = Vector3DCreator.createVector(pointC, pointD);
        Vector3D vectorDA = Vector3DCreator.createVector(pointD, pointA);

        baseVectors = new ArrayList<>();

        baseVectors.add(vectorAB);
        baseVectors.add(vectorBC);
        baseVectors.add(vectorCD);
        baseVectors.add(vectorDA);

        validBaseLength = 10.0;

        Vector3D vectorAH = Vector3DCreator.createVector(pointA, pointH);
        Vector3D vectorBH = Vector3DCreator.createVector(pointB, pointH);
        Vector3D vectorCH = Vector3DCreator.createVector(pointC, pointH);
        Vector3D vectorDH = Vector3DCreator.createVector(pointD, pointH);

        edgeVectors = new ArrayList<>();

        edgeVectors.add(vectorAH);
        edgeVectors.add(vectorBH);
        edgeVectors.add(vectorCH);
        edgeVectors.add(vectorDH);

        validSideLength = 10.020;

        pyramidParameters = RegularPyramidParameters.getInstance(validPyramid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldMethodsWorkWithNullArgument() {
        Pyramid pyramid = null;

        pyramidParameters = RegularPyramidParameters.getInstance(pyramid);
    }

    @Test
    public void shouldGetApexWorksSuccessful() {
        Point testingApex = pyramidParameters.getApex();

        Assert.assertEquals(validApex, testingApex);
    }

    @Test
    public void shouldGetApexWorksIncorrect() {
        Point testingApex = pyramidParameters.getApex();

        Assert.assertNotEquals(notValidApex, testingApex);
    }

    @Test
    public void shouldGetBaseLengthWorksSuccessful() {
        double testingBaseLength = pyramidParameters.getBaseSideLength();

        Assert.assertEquals(validBaseLength, testingBaseLength, 0.0001);
    }

    @Test
    public void shouldGetBaseLengthWorksIncorrect() {
        double testingBaseLength = pyramidParameters.getBaseSideLength();
        double notValid = 12.0;

        Assert.assertNotEquals(notValid, testingBaseLength, 0.0001);
    }

    @Test
    public void shouldGetEdgeLengthWorksSuccessful() {
        double testingEdgeSideLength = pyramidParameters.getEdgeSideLength();

        Assert.assertEquals(validSideLength, testingEdgeSideLength, 0.001);
    }

    @Test
    public void shouldGetEdgeLengthWorksIncorrect() {
        double testingEdgeSideLength = pyramidParameters.getEdgeSideLength();
        double notValid = 20.00;

        Assert.assertNotEquals(notValid, testingEdgeSideLength, 0.0001);
    }

    @Test
    public void shouldGetPointsWorksSuccessful() {
        List<Point> testingPoints = pyramidParameters.getPoints();

        Assert.assertEquals(validPoints, testingPoints);
    }

    @Test
    public void shouldGetPointsWorksIncorrect() {
        List<Point> testingPoints = pyramidParameters.getPoints();
        List<Point> notValidPoints = new ArrayList<>();

        Point pointA = new Point(2.2, 3.3, 4.4);
        Point pointB = new Point(2.2, 3.3, 4.4);

        notValidPoints.add(pointA);
        notValidPoints.add(pointB);

        Assert.assertNotEquals(notValidPoints, testingPoints);
    }

    @Test
    public void shouldGetBaseVectorsWorksSuccessful() {
        List<Vector3D> testingVectors = pyramidParameters.getBaseVectors();

        Assert.assertEquals(baseVectors, testingVectors);
    }

    @Test
    public void shouldGetBaseVectorsWorksIncorrect() {
        List<Vector3D> testingVectors = pyramidParameters.getBaseVectors();
        List<Vector3D> notValid = new ArrayList<>(edgeVectors);

        Assert.assertNotEquals(notValid, testingVectors);
    }

    @Test
    public void shouldGetEdgesVectorsWorksSuccessful() {
        List<Vector3D> testingVectors = pyramidParameters.getEdgesVectors();

        Assert.assertEquals(edgeVectors, testingVectors);
    }

    @Test
    public void shouldGetEdgesVectorsWorksIcorrect() {
        List<Vector3D> testingVectors = pyramidParameters.getEdgesVectors();
        List<Vector3D> notValidVectors = new ArrayList<>(baseVectors);

        Assert.assertNotEquals(notValidVectors, testingVectors);
    }

}
