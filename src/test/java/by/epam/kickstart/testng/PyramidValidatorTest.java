package by.epam.kickstart.testng;

import by.epam.kickstart.action.PyramidValidator;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidValidatorTest {

    private static PyramidValidator pyramidValidator;
    private static Pyramid notValidPyramid;
    private static Pyramid apexOnBaseSpace;
    private static Pyramid threePointsPyramid;

    @BeforeTest
    public static void setThreePointsPyramid() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);

        List<Point> points = new ArrayList<>();

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        threePointsPyramid = new Pyramid(points);
    }

    @BeforeTest
    public static void setApexOnBaseSpace() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(5.0,5.0,0.0);

        List<Point> points = new ArrayList<>();

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        points.add(pointD);
        points.add(pointH);

        apexOnBaseSpace = new Pyramid(points);
    }

    @BeforeTest
    public static void setPyramidValidator() {
        pyramidValidator = new PyramidValidator();
    }

    @BeforeTest
    public static void setNotValidPyramid() {
        Point pointA = new Point(0.0,0.0,0.0);
        Point pointB = new Point(10.0,0.0,0.0);
        Point pointC = new Point(10.0,10.0,0.0);
        Point pointD = new Point(0.0,10.0,0.0);
        Point pointH = new Point(0.0,5.0,0.0);

        List<Point> points = new ArrayList<>();

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        points.add(pointD);
        points.add(pointH);

        notValidPyramid = new Pyramid(points);
    }

    @DataProvider(name ="notValidPyramids")
    public static Object[][] dataProvider() {
        return new Object[][] {
                {notValidPyramid, false},
                {apexOnBaseSpace, false},
                {threePointsPyramid, false}
        };
    }

    @Test(dataProvider = "notValidPyramids")
    public void shouldFiguresBeNotRegularPyramids(Pyramid pyramid, boolean expected) {
        Assert.assertEquals(pyramidValidator.isFigureRegularPyramid(pyramid),expected);
    }

}
