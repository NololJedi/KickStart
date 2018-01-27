package by.epam.kickstart.jnit.testcalculator;

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

    @BeforeClass
    public static void setValidPyramid() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(5.0,5.0,7.1);

        List<Point> validPoints = new ArrayList<>();

        validPoints.add(pointA);
        validPoints.add(pointB);
        validPoints.add(pointC);
        validPoints.add(pointD);
        validPoints.add(pointH);

        validPyramid = new Pyramid(validPoints);
    }

    @BeforeClass
    public static void setPyramidCalculator() {
        pyramidCalculator = new PyramidCalculator();
    }

    @Test
    public void shouldPyramidVolumeBeCalculatedSuccessful() {
        double volume = 270.266;

        Assert.assertEquals(volume, pyramidCalculator.calculateVolume(validPyramid),0.001);
    }

    @Test
    public void shouldPyramidBaseAreaBeCalculatedSuccessful() {
        double baseArea = 100.0;

        Assert.assertEquals(baseArea, pyramidCalculator.calculateBaseArea(validPyramid),0.001);
    }

    @Test
    public void shouldPyramidSideSurfaceAreaBeCalculatedSuccessful() {
        double sideSurfaceArea = 173.677;

        Assert.assertEquals(sideSurfaceArea, pyramidCalculator.calculateSideSurfaceArea(validPyramid),0.001);
    }

    @Test
    public void shouldPyramidApexHeightBeCalculatedSuccessful() {
        double apexHeight = 8.108;

        Assert.assertEquals(apexHeight, pyramidCalculator.calculateApexHeight(validPyramid), 0.001);
    }

    @Test
    public void shouldPyramidEdgeAreaBeCalculatedSuccessful() {
        double edgeArea = 43.419;

        Assert.assertEquals(edgeArea, pyramidCalculator.calculateEdgeArea(validPyramid),0.001);
    }

    @Test
    public void shouldPyramidAreaBeCalculatedSuccessful() {
        double area = 273.677;

        Assert.assertEquals(area, pyramidCalculator.calculateArea(validPyramid),0.001);
    }
}
