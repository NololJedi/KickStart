package by.epam.kickstart.jnit;

import by.epam.kickstart.action.PyramidValidator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class PyramidValidatorTest {

    private static PyramidValidator pyramidValidator;
    private static Pyramid validPyramid;
    private static Pyramid notValidPyramidApex;
    private static Pyramid notValidPyramidBase;
    private static Pyramid notValidPyramidPoints;

    @DataProvider
    public static Object[][] dataProviderAdd() {
        return new Object[][] {
                {notValidPyramidPoints, false},
                {notValidPyramidBase, false},
                {notValidPyramidApex, false}
        };
    }

    @BeforeClass
    public static void setNotValidPyramidPoints() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,2.0);

        List<Point> notValidPoints = new ArrayList<>();

        notValidPoints.add(pointA);
        notValidPoints.add(pointB);
        notValidPoints.add(pointC);

        notValidPyramidPoints = new Pyramid(notValidPoints);
    }

    @BeforeClass
    public static void setNotValidPyramidBase() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,2.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(5.0,5.0,7.1);

        List<Point> notValidPoints = new ArrayList<>();

        notValidPoints.add(pointA);
        notValidPoints.add(pointB);
        notValidPoints.add(pointC);
        notValidPoints.add(pointD);
        notValidPoints.add(pointH);

        notValidPyramidBase = new Pyramid(notValidPoints);
    }

    @BeforeClass
    public static void setPyramidValidator() {
        pyramidValidator = new PyramidValidator();
    }

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
    public static void setNotValidPyramid() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(1.0,5.0,0.0);

        List<Point> points = new ArrayList<>();

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        points.add(pointD);
        points.add(pointH);

        notValidPyramidApex = new Pyramid(points);
    }

    @Test
    public void shouldFigureBeRegularPyramid() {
        Assert.assertTrue(pyramidValidator.isFigureRegularPyramid(validPyramid));
    }

    @Test
    @UseDataProvider("dataProviderAdd")
    public void shouldFigureBeNotRegularPyramid(Pyramid pyramid, boolean expected) {
        boolean currentChecking = pyramidValidator.isFigureRegularPyramid(pyramid);

        Assert.assertEquals(expected, currentChecking);
    }

    @Test
    public void shouldBaseLayOnOneCoordinatePlane() {
        Assert.assertTrue(pyramidValidator.isBaseLayOnOneCoordinatePlane(validPyramid));
    }

    @Test
    public void shouldBaseLayNotOnOneCoordinatePlane() {
        Assert.assertFalse(pyramidValidator.isBaseLayOnOneCoordinatePlane(notValidPyramidBase));
    }


}
