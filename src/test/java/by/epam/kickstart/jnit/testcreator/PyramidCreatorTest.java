package by.epam.kickstart.jnit.testcreator;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.creators.PyramidCreator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreatorTest {

    private static List<Point> validPoints;
    private static Pyramid validPyramid;

    @BeforeClass
    public static void setUpTestingObjects() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(5.0,5.0,7.1);

        validPoints = new ArrayList<>();

        validPoints.add(pointA);
        validPoints.add(pointB);
        validPoints.add(pointC);
        validPoints.add(pointD);
        validPoints.add(pointH);

        validPyramid = new Pyramid(validPoints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullPointsCauseException() {
        List<Point> notValidPoints = null;

        Pyramid pyramid = PyramidCreator.createPyramid(notValidPoints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyPointsCauseException() {
        List<Point> notValidPoints = new ArrayList<>();

        Pyramid pyramid = PyramidCreator.createPyramid(notValidPoints);
    }

    @Test
    public void shouldPyramidBeCreatedSuccessful() {
        Pyramid testingPyramid = PyramidCreator.createPyramid(validPoints);

        Assert.assertEquals(validPyramid,testingPyramid);
    }

}
