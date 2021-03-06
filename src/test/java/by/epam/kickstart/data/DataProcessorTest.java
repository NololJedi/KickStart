package by.epam.kickstart.data;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.data.DataProcessor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataProcessorTest {

    private static List<String> testingData;
    private static String validCoordinates;
    private static List<Pyramid> validPyramids;
    private static DataProcessor dataProcessor;

    @BeforeClass
    public static void setDataProcessor() {
        dataProcessor = new DataProcessor();
    }

    @BeforeClass
    public static void setValidLine() {
        validCoordinates = "0.0 0.0 0.0!10.0 0.0 0.0!10.0 10.0 0.0!0.0 10.0 0.0!5.0 5.0 7.1";
    }

    @BeforeClass
    public static void setValidPyramids() {
        validPyramids = new ArrayList<>();

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

        Pyramid validPyramid = new Pyramid(validPoints);
        validPyramids.add(validPyramid);
    }

    @BeforeClass
    public static void setTestingData() {
        String notValidSyntaxCoordinates = "2.2 2.2 2.2!3.3 3.3 3z.3";
        String notValidArgumentCoordinates = "0.0 0.0!10.0 0.0 0.0!10.0 10.0 0.0!0.0 10.0 0.0!5.5 5.5 7.1";
        String validAllCoordinates = "0.0 0.0 0.0!10.0 0.0 0.0!10.0 10.0 0.0!0.0 10.0 0.0!5.0 5.0 7.1";

        testingData = new ArrayList<>();

        testingData.add(validAllCoordinates);
        testingData.add(notValidArgumentCoordinates);
        testingData.add(notValidSyntaxCoordinates);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyLineCauseException() {
        String line = "";

        dataProcessor.getPyramidFromLine(line);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullLineCauseException() {
        String line = null;

        dataProcessor.getPyramidFromLine(line);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyDataCauseException() {
        List<String> data = new ArrayList<>();

        dataProcessor.getPyramidsFromList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullDataCauseException() {
        List<String> data = null;

        dataProcessor.getPyramidsFromList(data);
    }

    @Test
    public void shouldGetPyramidFromLineBeSuccessful() {
        Pyramid validPyramid = validPyramids.get(0);
        Pyramid testingPyramid = dataProcessor.getPyramidFromLine(validCoordinates);

        Assert.assertEquals(validPyramid, testingPyramid);
    }

    @Test
    public void shouldGetPyramidsFromListBeSuccessful() {
        List<Pyramid> pyramids = dataProcessor.getPyramidsFromList(testingData);

        Assert.assertArrayEquals(new List[]{validPyramids}, new List[]{pyramids});
    }
}
