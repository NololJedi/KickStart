package by.epam.kickstart.jnit.testcreator;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.util.creators.PointCreator;
import org.junit.Assert;
import org.junit.Test;

public class PointCreatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyCoordinatesCauseException() {
        String[] notValidCoordinates = {};

        Point point = PointCreator.createPoint(notValidCoordinates);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullCoordinatesCauseException() {
        String[] notValidCoordinates = null;

        Point point = PointCreator.createPoint(notValidCoordinates);
    }

    @Test
    public void shouldPointCreationBeSuccessful() {
        Point validPoint = new Point(1.1,2.2,3.3);
        String[] validCoordinates = {"1.1", "2.2", "3.3"};
        Point testingPoint = PointCreator.createPoint(validCoordinates);

        Assert.assertEquals(validPoint,testingPoint);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldPointCreationByWrongArgumentsCauseException() {
        String[] inValidCoordinates = {"1.x2", "2.2", "3.3"};

        Point testingPoint = PointCreator.createPoint(inValidCoordinates);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldPointCreationByNotFullArgumentsCauseException() {
        String[] inValidCoordinates = {"2.2" ,"3.3"};

        Point testingPoint = PointCreator.createPoint(inValidCoordinates);
    }
}
