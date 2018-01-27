package by.epam.kickstart.pyramid.calculators;

import by.epam.kickstart.action.calculators.PyramidCalculator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidCalculatorTest {

    private static Pyramid validPyramid;
    private static PyramidCalculator pyramidCalculator;
    private static List<Point> notValidCoordinatePlaneEmpty;
    private static List<Point> notValidCoordinatePlanePoints;
    private static List<Point> notValidCoordinatePlaneNull;
    private static List<Point> coordinatePlane;

    @BeforeClass
    public static void setValidPyramid() {
        Point pointA = new Point(0.0, 0.0, 0.0);
        Point pointB = new Point(10.0, 0.0, 0.0);
        Point pointC = new Point(10.0, 10.0, 0.0);
        Point pointD = new Point(0.0, 10.0, 0.0);
        Point pointH = new Point(5.0, 5.0, 7.1);

        List<Point> validPoints = new ArrayList<>();

        validPoints.add(pointA);
        validPoints.add(pointB);
        validPoints.add(pointC);
        validPoints.add(pointD);
        validPoints.add(pointH);

        validPyramid = new Pyramid(validPoints);
        notValidCoordinatePlaneEmpty = new ArrayList<>();
        notValidCoordinatePlanePoints = new ArrayList<>();
        notValidCoordinatePlaneNull = null;

        notValidCoordinatePlanePoints.add(pointA);
        notValidCoordinatePlanePoints.add(pointB);
        notValidCoordinatePlanePoints.add(pointC);

        coordinatePlane = new ArrayList<>();

        pointA = new Point(2.5, 2.5, 3.5);
        pointB = new Point(7.5, 2.5, 3.5);
        pointC = new Point(7.5, 7.5, 3.5);
        pointD = new Point(2.5, 7.5, 3.5);

        coordinatePlane.add(pointA);
        coordinatePlane.add(pointB);
        coordinatePlane.add(pointC);
        coordinatePlane.add(pointD);

    }

    @BeforeClass
    public static void setPyramidCalculator() {
        pyramidCalculator = new PyramidCalculator();
    }

    @Test
    public void shouldPyramidVolumeBeCalculatedSuccessful() {
        double expectedVolume = 236.666;
        double testingVolume = pyramidCalculator.calculateVolume(validPyramid);

        Assert.assertEquals(expectedVolume, testingVolume, 0.001);
    }

    @Test
    public void shouldPyramidVolumeBeNotCalculatedSuccessful() {
        double incorrectVolume = 300.000;
        double testingVolume = pyramidCalculator.calculateVolume(validPyramid);

        Assert.assertNotEquals(incorrectVolume, testingVolume, 0.001);
    }

    @Test
    public void shouldPyramidBaseAreaBeCalculatedSuccessful() {
        double expectedBaseArea = 100.0;
        double testingBaseArea = pyramidCalculator.calculateBaseArea(validPyramid);

        Assert.assertEquals(expectedBaseArea, testingBaseArea, 0.001);
    }

    @Test
    public void shouldPyramidBaseAreaBeNotCalculatedSuccessful() {
        double incorrectBaseArea = 200.0;
        double testingBaseArea = pyramidCalculator.calculateBaseArea(validPyramid);

        Assert.assertNotEquals(incorrectBaseArea, testingBaseArea, 0.001);
    }

    @Test
    public void shouldPyramidSideSurfaceAreaBeCalculatedSuccessful() {
        double expectedSideSurfaceArea = 173.677;
        double testingSideSurfaceArea = pyramidCalculator.calculateSideSurfaceArea(validPyramid);

        Assert.assertEquals(expectedSideSurfaceArea, testingSideSurfaceArea, 0.001);
    }

    @Test
    public void shouldPyramidSideSurfaceAreaBeNotCalculatedSuccessful() {
        double incorrectSideSurfaceArea = 123.677;
        double testingSideSurfaceArea = pyramidCalculator.calculateSideSurfaceArea(validPyramid);

        Assert.assertNotEquals(incorrectSideSurfaceArea, testingSideSurfaceArea, 0.001);
    }

    @Test
    public void shouldPyramidApexHeightBeCalculatedSuccessful() {
        double expectedApexHeight = 7.099;
        double testingApexHeight = pyramidCalculator.calculateApexHeight(validPyramid);

        Assert.assertEquals(expectedApexHeight, testingApexHeight, 0.001);
    }

    @Test
    public void shouldPyramidApexHeightBeNotCalculatedSuccessful() {
        double incorrectApexHeight = 28.108;
        double testingApexHeight = pyramidCalculator.calculateApexHeight(validPyramid);

        Assert.assertNotEquals(incorrectApexHeight, testingApexHeight, 0.001);
    }

    @Test
    public void shouldPyramidEdgeAreaBeCalculatedSuccessful() {
        double expectedEdgeArea = 43.419;
        double testingEdgeArea = pyramidCalculator.calculateEdgeArea(validPyramid);

        Assert.assertEquals(expectedEdgeArea, testingEdgeArea, 0.001);
    }

    @Test
    public void shouldPyramidEdgeAreaBeNotCalculatedSuccessful() {
        double incorrectEdgeArea = 423.419;
        double testingEdgeArea = pyramidCalculator.calculateEdgeArea(validPyramid);

        Assert.assertNotEquals(incorrectEdgeArea, testingEdgeArea, 0.001);
    }

    @Test
    public void shouldPyramidAreaBeCalculatedSuccessful() {
        double expectedArea = 273.677;
        double testingArea = pyramidCalculator.calculateArea(validPyramid);

        Assert.assertEquals(expectedArea, testingArea, 0.001);
    }

    @Test
    public void shouldPyramidAreaBeNotCalculatedSuccessful() {
        double incorrectArea = 223.677;
        double testingArea = pyramidCalculator.calculateArea(validPyramid);

        Assert.assertNotEquals(incorrectArea, testingArea, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldVolumeRatioCalculatingBeNotSuccessfulEmpty() {
        pyramidCalculator.calculateVolumeRatioCutPyramid(validPyramid, notValidCoordinatePlaneEmpty);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldVolumeRatioCalculatingBeNotSuccessfulNull() {
        pyramidCalculator.calculateVolumeRatioCutPyramid(validPyramid, notValidCoordinatePlaneNull);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldVolumeRatioCalculatingBeNotSuccessfulPoints() {
        pyramidCalculator.calculateVolumeRatioCutPyramid(validPyramid, notValidCoordinatePlanePoints);
    }

    @Test
    public void shouldVolumeRationCalculatingBeSuccessful() {
        double expectedVolumeRatio = 6.888;
        double testingRatio = pyramidCalculator.calculateVolumeRatioCutPyramid(validPyramid, coordinatePlane);

        Assert.assertEquals(expectedVolumeRatio, testingRatio, 0.001);
    }

    @Test
    public void shouldVolumeRationCalculatingBeIncorrect() {
        double incorrectVolumeRatio = 5;
        double testingRatio = pyramidCalculator.calculateVolumeRatioCutPyramid(validPyramid, coordinatePlane);

        Assert.assertNotEquals(incorrectVolumeRatio, testingRatio, 0.001);
    }
}
